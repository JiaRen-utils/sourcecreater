package com.sourcecreater.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")

public class DaoImplController {

	@RequestMapping("/getDaoImpl")
	public String getDao(Map<String, Object> model, Config config, HttpServletRequest request, HttpServletResponse response) {
		model.put("daoPackage", config.getDaoPackage());
		model.put("modelPackage", config.getModelPackage());
		model.put("modelName", config.getModelName());
		model.put("utilsPackage", config.getUtilsPackage());
		
		updateById(model, config);
		whereSql(model, config);
		setSql(model, config);
		getListSql(model, config);
		
		response.setContentType("text/plain");
		response.addHeader("Content-Disposition", "attachment;filename=" + config.getModelName() + "DaoImpl.java");
		return "/daoimpl";
	}

	public void updateById(Map<String, Object> model, Config config) {
//		List<Map<String, Object>> maps = RefelctTool.getAttribute(config.getModelPackage() + "." +config.getModelName());
		List<Map<String, Object>> maps = CreateModel.getAttribute(config.getTableName());
		model.put("itemGetIdMethod", maps.get(0).get("methodName"));
		model.put("itemIdName", maps.get(0).get("name"));
	}

	/**
	 * Map<String, Object> contains three values, the first is isString, the
	 * second is methodName, the last is name;
	 * 
	 * @param map
	 */
	public void whereSql(Map<String, Object> model, Config config) {
//		model.put("sequenceWhere", RefelctTool.getAttribute(config.getModelPackage() + "." +config.getModelName()));
		model.put("sequenceWhere", CreateModel.getAttribute(config.getTableName()));
	}

	public void setSql(Map<String, Object> model, Config config) {
//		model.put("sequenceSet", RefelctTool.getAttribute(config.getModelPackage() + "." +config.getModelName()));
		model.put("sequenceSet", CreateModel.getAttribute(config.getTableName()));
	}

	public void getListSql(Map<String, Object> model, Config config) {
		model.put("tableName", config.getTableName());
//		model.put("sequenceGetList", RefelctTool.getAttribute(config.getModelPackage() + "." +config.getModelName()));
		model.put("sequenceGetList", CreateModel.getAttribute(config.getTableName()));
	}
}
