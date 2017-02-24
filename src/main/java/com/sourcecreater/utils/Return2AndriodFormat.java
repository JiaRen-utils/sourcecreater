package com.sourcecreater.utils;

import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Return2AndriodFormat {
	private Return2AndriodFormat() {
	}
	/**
	 * 
	 * @param status
	 *            状态码
	 * @param msg
	 *            状态消息
	 * @param data
	 *            封装了数据的JSONObject
	 * @return
	 */
	public static JSONObject getResult(int status, String msg, Object data) {
		if(data==null){
			data=new JSONObject();
		}
		JSONObject baseJSONOBject = new JSONObject();
		baseJSONOBject.put("status", status);
		baseJSONOBject.put("msg", msg);
		baseJSONOBject.put("data", data);
		return baseJSONOBject;
	}
	public static JSONObject getResult(int status, String msg, JSONObject data) {
		if(data==null){
			data=new JSONObject();
		}
		JSONObject baseJSONOBject = new JSONObject();
		baseJSONOBject.put("status", status);
		baseJSONOBject.put("msg", msg);
		baseJSONOBject.put("data", data);
		return baseJSONOBject;
	}
	public static JSONObject getResult(int status, String msg, Map<String, Object> data) {
		if(data==null){
			data=new JSONObject();
		}
		JSONObject baseJSONOBject = new JSONObject();
		baseJSONOBject.put("status", status);
		baseJSONOBject.put("msg", msg);
		baseJSONOBject.put("data", data);
		return baseJSONOBject;
	}
	
	/**
	 * 返回一个status为200，默认msg为"OK"的JSONObject
	 * 
	 * @param data封装了数据的JSONObject
	 * @return
	 */
	public static JSONObject getDefaultResult(JSONObject data) {
		if(data==null){
			data=new JSONObject();
		}
		JSONObject baseJSONOBject = new JSONObject();
		baseJSONOBject.put("status", 200);
		baseJSONOBject.put("msg", "OK");
		baseJSONOBject.put("data", data);
		return baseJSONOBject;
	}
	/**
	 * 
	 * @param status 状态码
	 * @param msg 状态消息
	 * @param data 封装了数据的JSONArray
	 * @return
	 */
	public static JSONObject getResultArray(int status, String msg,
			JSONArray data) { 
		if(data==null){
			data=new JSONArray();
		}
		JSONObject baseJSONOBject = new JSONObject();
		baseJSONOBject.put("status", status);
		baseJSONOBject.put("msg", msg);
		baseJSONOBject.put("data", data);
		return baseJSONOBject;
	}
	/**
	 * 返回一个status为200，默认msg为"OK"的JSONObject
	 * @param data JSONArray
	 * @return
	 */
	public static JSONObject getDefaultResultArray(JSONArray data) {
		if(data==null){
			data=new JSONArray();
		}
		JSONObject baseJSONOBject = new JSONObject();
		baseJSONOBject.put("status", 200);
		baseJSONOBject.put("msg", "OK");
		baseJSONOBject.put("data", data);
		return baseJSONOBject;
	}
}
