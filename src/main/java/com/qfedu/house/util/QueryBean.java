package com.qfedu.house.util;

import java.util.List;

/**
 * 查询对象接口 (把查询条件排序条件封装到一个对象中)
 * @author 骆昊
 *
 */
public interface QueryBean {
	
	/**
	 * 添加排序关键字
	 * @param flag 是否需要使用此排序关键字
	 * @param keyword 关键字
	 * @param asc 升序还是降序
	 * @return QueryBean对象
	 */
	QueryBean addOrderBy(boolean flag, String keyword, boolean asc);
	
	default QueryBean addOrderBy(String keyword, boolean asc) {
		return addOrderBy(true, keyword, asc);
	}
	
	default QueryBean addOrderBy(String keyword) {
		return addOrderBy(true, keyword, true);
	}
	
	/**
	 * 添加查询条件
	 * @param flag 是否添加该条件
	 * @param condition 条件
	 * @param value 条件对应的参数值
	 * @return QueryBean对象
	 */
	QueryBean addCondition(boolean flag, String condition, Object value);
	
	default QueryBean addCondition(String condition, Object value) {
		return addCondition(true, condition, value);
	}

	/**
	 * 获得查询语句
	 */
	String getQueryString();
	
	/**
	 * 获得查询记录数的语句
	 */
	String getCountString();
	
	/**
	 * 查询条件所对应的参数
	 * @return 保存参数的列表容器
	 */
	List<Object> getParameters();
}
