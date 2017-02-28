package com.sourcecreater.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("/createSourceCode")
	public void createSourceCode(Config config) {
		try {
			config(config);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void config(Config config) throws UnsupportedEncodingException {
		
		config.setSqlConnectUrl(config.getSqlConnectUrl());
		config.setTableName(config.getTableName());
		config.setDaoPackage(config.getDaoPackage());
		config.setServicePackage(config.getServicePackage());
		config.setServiceImplPackage(config.getServiceImplPackage());
		config.setModelPackage(config.getModelPackage());
		config.setUtilsPackage(config.getUtilsPackage());
		config.setCtlPackage(config.getCtlPackage());
		
		
		String[] tems = config.getTableName().split("[_]");
		String modelName = "";
		for(int i = 0;i < tems.length; i++) {
			String tem = tems[i].substring(0, 1).toUpperCase() + tems[i].substring(1);
			modelName = modelName + tem;
		}
		config.setModelName(modelName);
		getDao(config);
		getDaoImpl(config);
		getService(config);
		getServiceImpl(config);
		getController(config);
	}
	
	public void getDao(Config config) throws UnsupportedEncodingException {
		RestTemplate restTemplate = new RestTemplate();

		// Optional Accept header
		RequestCallback requestCallback = request -> request.getHeaders()
		        .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));

		// Streams the response instead of loading it all in memory
		ResponseExtractor<Void> responseExtractor = response -> {
		    // Here I write the response to a file but do what you like
			String tem = config.getDaoPackage().replace(".", "/");
			String fileName = config.getModelName() + "Dao" + ".java";
			HttpHeaders headers = response.getHeaders();
			java.io.File f = new File(config.getSrcPathCommon() + tem);
			f.mkdirs();
		    Path path = Paths.get(config.getSrcPathCommon() + tem + "/" + fileName);
		    Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
		    return null;
		};

		String url = config.getServerPath()
				+ "/getDao?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getDaoImpl(Config config) throws UnsupportedEncodingException {
		RestTemplate restTemplate = new RestTemplate();
		
		// Optional Accept header
		RequestCallback requestCallback = request -> request.getHeaders()
				.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
		
		// Streams the response instead of loading it all in memory
		ResponseExtractor<Void> responseExtractor = response -> {
			// Here I write the response to a file but do what you like
			String tem = config.getDaoPackage().replace(".", "/");
			tem = tem + "/impl";
			String fileName = config.getModelName() + "DaoImpl" + ".java";
			HttpHeaders headers = response.getHeaders();
			java.io.File f = new File(config.getSrcPathCommon() + tem);
			f.mkdirs();
			Path path = Paths.get(config.getSrcPathCommon() + tem + "/" + fileName);
			Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
			return null;
		};
		
		
		String url = config.getServerPath()
				+ "/getDaoImpl?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getService(Config config) throws UnsupportedEncodingException {
		RestTemplate restTemplate = new RestTemplate();
		
		// Optional Accept header
		RequestCallback requestCallback = request -> request.getHeaders()
				.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
		
		// Streams the response instead of loading it all in memory
		ResponseExtractor<Void> responseExtractor = response -> {
			// Here I write the response to a file but do what you like
			String tem = config.getServicePackage().replace(".", "/");
			String fileName = config.getModelName() + "Service" + ".java";
			HttpHeaders headers = response.getHeaders();
			java.io.File f = new File(config.getSrcPathCommon() + tem);
			f.mkdirs();
			Path path = Paths.get(config.getSrcPathCommon() + tem + "/" + fileName);
			Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
			return null;
		};
		
		
		String url = config.getServerPath()
				+ "/getService?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getServiceImpl(Config config) throws UnsupportedEncodingException {
		RestTemplate restTemplate = new RestTemplate();
		
		// Optional Accept header
		RequestCallback requestCallback = request -> request.getHeaders()
				.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
		
		// Streams the response instead of loading it all in memory
		ResponseExtractor<Void> responseExtractor = response -> {
			// Here I write the response to a file but do what you like
			String tem = config.getServiceImplPackage().replace(".", "/");
			String fileName = config.getModelName() + "ServiceImpl" + ".java";
			HttpHeaders headers = response.getHeaders();
			java.io.File f = new File(config.getSrcPathCommon() + tem);
			f.mkdirs();
			Path path = Paths.get(config.getSrcPathCommon() + tem + "/" + fileName);
			Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
			return null;
		};
		
		
		String url = config.getServerPath()
				+ "/getServiceImpl?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getController(Config config) throws UnsupportedEncodingException {
		RestTemplate restTemplate = new RestTemplate();
		
		// Optional Accept header
		RequestCallback requestCallback = request -> request.getHeaders()
				.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
		
		// Streams the response instead of loading it all in memory
		ResponseExtractor<Void> responseExtractor = response -> {
			// Here I write the response to a file but do what you like
			String tem = config.getCtlPackage().replace(".", "/");
			String fileName = config.getModelName() + "Controller" + ".java";
			HttpHeaders headers = response.getHeaders();
			java.io.File f = new File(config.getSrcPathCtl() + tem);
			f.mkdirs();
			Path path = Paths.get(config.getSrcPathCtl() + tem + "/" + fileName);
			Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
			return null;
		};
		
		
		String url = config.getServerPath()
				+ "/getCtl?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName()
				+ "&ctlPackage=" + config.getCtlPackage()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
}
