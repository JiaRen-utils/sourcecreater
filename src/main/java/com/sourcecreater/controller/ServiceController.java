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

public class ServiceController {

	@RequestMapping("/getService")
	public String getservice(Map<String, Object> model, Config config, HttpServletRequest request, HttpServletResponse response) {

		model.put("servicePackage", config.getServicePackage());
		model.put("modelPackage", config.getModelPackage());
		model.put("utilsPackage", config.getUtilsPackage());
		model.put("modelName", config.getModelName());
		
		
		response.setContentType("text/plain");
		response.addHeader("Content-Disposition", "attachment;filename=" + config.getModelName() + "service.java");
		return "/service";
	}
	@RequestMapping("/getServiceImpl")
	public String getserviceImpl(Map<String, Object> model, Config config, HttpServletRequest request, HttpServletResponse response) {

		model.put("daoPackage", config.getDaoPackage());
		model.put("servicePackage", config.getServicePackage());
		model.put("serviceImplPackage", config.getServiceImplPackage());
		model.put("modelPackage", config.getModelPackage());
		model.put("utilsPackage", config.getUtilsPackage());
		model.put("modelName", config.getModelName());
		
		response.setContentType("text/plain");
		response.addHeader("Content-Disposition", "attachment;filename=" + config.getModelName() + "serviceImpl.java");
		return "/serviceImpl";
	}

}
