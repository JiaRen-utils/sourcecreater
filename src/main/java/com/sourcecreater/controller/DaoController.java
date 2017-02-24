package com.sourcecreater.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class DaoController {

	@RequestMapping("/getDao")
	public String getDao(Map<String, Object> model, Config config, HttpServletRequest request, HttpServletResponse response) {
		model.put("daoPackage", config.getDaoPackage());
		model.put("modelPackage", config.getModelPackage());
		model.put("modelName", config.getModelName());
		
		response.setContentType("text/plain");
		response.addHeader("Content-Disposition", "attachment;filename=" + config.getModelName() + "Dao.java");
		return "/dao";
	}

}
