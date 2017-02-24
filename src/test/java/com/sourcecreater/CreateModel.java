package com.sourcecreater;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
		ResultSet rs = null;
		ResultSet rs1 = null;
		config.setTableList(new ArrayList<>());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://210.75.252.61/health?user=root&password=zhongkjy");
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("show columns from th_notification_all");
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("Field", rs.getString(1));
				map.put("Type", rs.getString(2));
				map.put("Null", rs.getString(3));
				map.put("Key", rs.getString(4));
				map.put("Default", rs.getString(5));
				map.put("Extra", rs.getString(6));
				config.getTableList().add(map);    //保存数据库表
				System.out.println(rs.getString(1) +  " " 
				+ rs.getString(2) +  " " + rs.getString(3) +  " " + rs.getString(4) +  " " + rs.getString(5) +  " " + rs.getString(6)
				);
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
	public void testst() {
		String tem = "th_admin_role_organization";
		String[] tems = tem.split("[_]");
		System.out.println(tem.length());
	}
}
