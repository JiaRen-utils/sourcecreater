package com.sourcecreater.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CreateModel {

	public static List<Map<String, Object>> getAttribute(String tableName, String sqlConnectUrl) {
		List<Map<String, Object>> maps = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection(sqlConnectUrl);
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("show columns from " + tableName);
			String[] tems = tableName.split("[_]");
			String modelName = "";
			for (int i = 0; i < tems.length; i++) {
				tems[i] = tems[i].substring(0, 1).toUpperCase() + tems[i].substring(1);
				modelName = modelName + tems[i];
			}

			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				String fieldName = rs.getString(1);
				String type = rs.getString(2);
				if (type.contains("varchar")) { // 数据库字段暂时只支持varchar作为String类的隐射
					map.put("isString", true);
				} else {
					map.put("isString", false);
				}
				map.put("isLast", false);
				String upperName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				map.put("methodName", "get" + upperName);
				map.put("name", fieldName);
				map.put("nameNew", fieldName + "New");
				maps.add(map);
			}
			maps.get(maps.size() - 1).put("isLast", true);
			return maps;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return maps;
		}

	}

}
