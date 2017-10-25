package com.qfedu.house.util;

import java.util.ArrayList;
import java.util.List;

public class HQLQueryBean implements QueryBean {
	private String fromClouse;
	private String whereClouse;
	private String orderbyClouse;
	
	private List<Object> paramValues = new ArrayList<>();
	
	public HQLQueryBean(Class<?> entityType) {
		fromClouse = " from " + entityType.getSimpleName() + " as o ";
	}
	
	@Override
	public QueryBean addOrderBy(boolean flag, String keyword, boolean asc) {
		if (flag) {
			if (orderbyClouse == null) {
				orderbyClouse = " order by o." + keyword + (asc ? " asc " : " desc ");
			} else {
				orderbyClouse += ", o." + keyword + (asc? " asc " : " desc ");
			}
		}
		return this;
	}

	@Override
	public QueryBean addCondition(boolean flag, String condition, Object value) {
		if (flag) {
			if (whereClouse == null) {
				whereClouse = " where o." + condition;
			} else {
				whereClouse += " and o." + condition;
			}
			paramValues.add(value);
		}
		return this;
	}

	@Override
	public String getQueryString() {
		return fromClouse + " " + whereClouse + " " + orderbyClouse;
	}

	@Override
	public String getCountString() {
		return "select count(o) " + fromClouse + " " + whereClouse;
	}

	@Override
	public List<Object> getParameters() {
		return paramValues;
	}

}
