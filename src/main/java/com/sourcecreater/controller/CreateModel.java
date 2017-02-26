package com.sourcecreater.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sourcecreater.controller.Config;

public class CreateModel {

	Config config = new Config();

	public void test() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		config.setTableList(new ArrayList<>());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://210.75.252.61/health?user=root&password=zhongkjy");
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("show tables; ");
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("tableName", rs.getString(1));
				config.getTableList().add(map);    //保存数据库表
				System.out.println(rs.getString(1));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
	
	
	@Test
	public void test2() {
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		config.setTableList(new ArrayList<>());
		config.setListInfo(new ArrayList<>());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://210.75.252.61/health?user=root&password=zhongkjy");
//			conn.setAutoCommit(false);
			stmt = (Statement) conn.createStatement();
			stmt1 = (Statement) conn.createStatement();
			rs = stmt.executeQuery("show tables;");
			while (rs.next()) {
				String tableName = rs.getString(1);
				System.out.println(tableName);
				rs1 = stmt1.executeQuery("show columns from " + tableName);
				List<Map<String, Object>> fields = new ArrayList<>();
				while (rs1.next()) {
					Map<String, Object> map = new HashMap<>();
					map.put("table", tableName);
					map.put("Field", rs1.getString(1));
					map.put("Type", rs1.getString(2));
					map.put("Null", rs1.getString(3));
					map.put("Key", rs1.getString(4));
					map.put("Default", rs1.getString(5));
					map.put("Extra", rs1.getString(6));
					fields.add(map);
//				System.out.println(rs.getString(1) +  " " 
//				+ rs.getString(2) +  " " + rs.getString(3) +  " " + rs.getString(4) +  " " + rs.getString(5) +  " " + rs.getString(6)
//				);
				}
				config.getListInfo().add(fields);
			}
//			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	public static List<Map<String, Object>> getAttribute(String tableName) {
		List<Map<String, Object>> maps = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://210.75.252.61/health?user=root&password=zhongkjy");
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("show columns from " + tableName);
			String[] tems = tableName.split("[_]");
			String modelName = "";
			for(int i = 0; i < tems.length; i++) {
				tems[i] = tems[i].substring(0, 1).toUpperCase() + tems[i].substring(1);
				modelName = modelName + tems[i];
			}
			
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				String fieldName = rs.getString(1);
				String type = rs.getString(2);
				if(type.contains("varchar")) {    //数据库字段暂时只支持varchar作为String类的隐射
					map.put("isString", true);		
				} else {
					map.put("isString", false);		
				}
				map.put("isLast", false);
				String upperName = fieldName.substring(0, 1).toUpperCase()  
                        + fieldName.substring(1); 
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
	
	
	@Test
	public void testst() {
		String tem = "th_admin_role_organization";
		String[] tems = tem.split("[_]");
		System.out.println(tem.length());
	}
}
