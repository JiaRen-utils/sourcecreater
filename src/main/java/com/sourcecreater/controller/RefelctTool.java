package com.sourcecreater.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class RefelctTool {

	public static void getMethodInfo(String pkgName) {
		try {
			Class clazz = Class.forName(pkgName);
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				String methodName = method.getName();
				System.out.println("方法名称:" + methodName);
				Class<?>[] parameterTypes = method.getParameterTypes();
				for (Class<?> clas : parameterTypes) {
					String parameterName = clas.getName();
					System.out.println("参数名称:" + parameterName);
				}
				System.out.println("*****************************");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, Object>> getAttribute(String pkgName) {
		List<Map<String, Object>> maps = new ArrayList<>();
		try {
			Class clazz = Class.forName(pkgName);
			Field[] fields = clazz.getDeclaredFields();

			for (int i = 0; i <= fields.length - 1 ; i++) {
				Field field = fields[i];
				Map<String, Object> map = new HashMap<>();
				if(field.getGenericType().toString().equals("class java.lang.String")) {
					map.put("isString", true);					
				} else {
					map.put("isString", false);					
				}
				if(i == fields.length - 1) {
					map.put("isLast", true);
				} else {
					map.put("isLast", false);
				}
				String fieldName = field.getName();
				String upperName = fieldName.substring(0, 1).toUpperCase()  
                        + fieldName.substring(1); 
				map.put("methodName", "get" + upperName);
				map.put("name", fieldName);
				map.put("nameNew", fieldName + "New");
				maps.add(map);
			}
			return maps;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			return maps;
		}
	}

	public static void main(String[] args) {
		getMethodInfo("com.sourcecreater.controller.Config");
		getAttribute("com.sourcecreater.controller.Config");
	}
}
