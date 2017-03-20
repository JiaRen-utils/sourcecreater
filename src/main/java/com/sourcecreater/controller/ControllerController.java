package com.sourcecreater.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerController {
	
	@RequestMapping("/getCtl")
	public String getDao(Map<String, Object> model, Config config, HttpServletRequest request, HttpServletResponse response) {
		model.put("modelName", config.getModelName());
		String upperName = config.getModelName().substring(0, 1).toLowerCase()
                + config.getModelName().substring(1); 
		model.put("modelNameLower", upperName);
		
		model.put("daoPackage", config.getDaoPackage());
		model.put("servicePackage", config.getServicePackage());
		model.put("serviceImplPackage", config.getServiceImplPackage());
		model.put("modelPackage", config.getModelPackage());
		model.put("utilsPackage", config.getUtilsPackage());
		model.put("modelName", config.getModelName());
		model.put("ctlPackage", config.getCtlPackage());
		
		response.setContentType("text/plain");
		response.addHeader("Content-Disposition", "attachment;filename=" + config.getModelName() + "Ctl.java");
		return "/controller";
	}
}
