package com.sourcecreater;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.sourcecreater.controller.Config;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SourcecreaterApplicationTests {
	public static Config config = new Config();
	private String serverPath = "http://localhost:8080";
	private String srcPathCommon = "C:/Users/steve/Downloads/";    //dao、service
	private String srcPathCtl = "C:/Users/steve/Downloads/";    //controller
	
	
	@Test
	public void config() {
		config.setTableName("th_notification_all");
		config.setDaoPackage("com.health.dao");
		config.setServicePackage("com.health.service");
		config.setServiceImplPackage("com.health.service.impl");
		config.setModelPackage("com.health.model");
		config.setModelName("ThNotificationAll");
		config.setUtilsPackage("com.health.utils");
		config.setCtlPackage("com.health.controller");
		getDao();
		getDaoImpl();
		getService();
		getServiceImpl();
		getController();
	}
	
	public void getDao() {
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
			java.io.File f = new File(srcPathCommon + tem);
			f.mkdirs();
		    Path path = Paths.get(srcPathCommon + tem + "/" + fileName);
		    Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
		    return null;
		};

		
		String url = serverPath
				+ "/getDao?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName();
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getDaoImpl() {
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
			java.io.File f = new File(srcPathCommon + tem);
			f.mkdirs();
			Path path = Paths.get(srcPathCommon + tem + "/" + fileName);
			Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
			return null;
		};
		
		
		String url = serverPath
				+ "/getDaoImpl?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName();
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getService() {
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
			java.io.File f = new File(srcPathCommon + tem);
			f.mkdirs();
			Path path = Paths.get(srcPathCommon + tem + "/" + fileName);
			Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
			return null;
		};
		
		
		String url = serverPath
				+ "/getService?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName();
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getServiceImpl() {
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
			java.io.File f = new File(srcPathCommon + tem);
			f.mkdirs();
			Path path = Paths.get(srcPathCommon + tem + "/" + fileName);
			Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
			return null;
		};
		
		
		String url = serverPath
				+ "/getServiceImpl?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName();
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getController() {
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
			java.io.File f = new File(srcPathCtl + tem);
			f.mkdirs();
			Path path = Paths.get(srcPathCtl + tem + "/" + fileName);
			Files.copy(response.getBody(), path, StandardCopyOption.REPLACE_EXISTING);
			return null;
		};
		
		
		String url = serverPath
				+ "/getCtl?"
				+ "tableName=" + config.getTableName()
				+ "&daoPackage=" + config.getDaoPackage()
				+ "&servicePackage=" + config.getServicePackage()
				+ "&serviceImplPackage=" + config.getServiceImplPackage()
				+ "&modelPackage=" + config.getModelPackage()
				+ "&utilsPackage=" + config.getUtilsPackage()
				+ "&modelName=" + config.getModelName()
				+ "&ctlPackage=" + config.getCtlPackage()
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}

}
