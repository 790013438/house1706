package com.qfedu.house.converter;

import org.springframework.core.convert.converter.Converter;

import com.qfedu.house.domain.Location;

public class LocationConverter implements Converter<String, Location> {

	@Override
	public Location convert(String str) {
		String[] strings = str.split("[-#,]");
		if (strings.length != 3) {
			throw new RuntimeException("无效的地理信息参数");
		} else {
			Location location = new Location();
			location.setLongitude(Double.parseDouble(strings[0]));
			location.setLatitude(Double.parseDouble(strings[1]));
			location.setAltitude(Double.parseDouble(strings[2]));
			return location;
		}
	}

}
