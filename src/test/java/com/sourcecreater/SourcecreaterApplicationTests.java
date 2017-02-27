package com.sourcecreater;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
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
	private static final String serverPath = "http://localhost:8080";
	private static final String srcPathCommon = "C:/Users/steve/Downloads/";    //dao、service
	private static final String srcPathCtl = "C:/Users/steve/Downloads/";    //controller
	private static final String sqlConnectUrl = "jdbc:mysql://210.75.252.61/health?user=root&password=zhongkjy";
	
	@Test
	public void config() throws UnsupportedEncodingException {
		
		config.setSqlConnectUrl(sqlConnectUrl);
		config.setTableName("th_notification_all");
		config.setDaoPackage("com.health.dao");
		config.setServicePackage("com.health.service");
		config.setServiceImplPackage("com.health.service.impl");
		config.setModelPackage("com.health.model");
		config.setUtilsPackage("com.health.utils");
		config.setCtlPackage("com.health.controller");
		
		
		String[] tems = config.getTableName().split("[_]");
		String modelName = "";
		for(int i = 0;i < tems.length; i++) {
			String tem = tems[i].substring(0, 1).toUpperCase() + tems[i].substring(1);
			modelName = modelName + tem;
		}
		config.setModelName(modelName);
		getDao();
		getDaoImpl();
		getService();
		getServiceImpl();
		getController();
	}
	
	public void getDao() throws UnsupportedEncodingException {
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
				+ "&modelName=" + config.getModelName()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getDaoImpl() throws UnsupportedEncodingException {
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
				+ "&modelName=" + config.getModelName()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getService() throws UnsupportedEncodingException {
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
				+ "&modelName=" + config.getModelName()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getServiceImpl() throws UnsupportedEncodingException {
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
				+ "&modelName=" + config.getModelName()
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	public void getController() throws UnsupportedEncodingException {
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
				+ "&sqlConnectUrl=" + URLEncoder.encode(config.getSqlConnectUrl(), "UTF-8")
				;
		
		restTemplate.execute(URI.create(url), HttpMethod.GET, requestCallback, responseExtractor);
	}

}
