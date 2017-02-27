package com.sourcecreater.controller;

import java.util.List;
import java.util.Map;

public class Config {
	/**
	 * 表名
	 */
	private String tableName;
	
	/**
	 * dao包名，如com.health.dao
	 */
	private String daoPackage;	
	
	
	/**
	 * servce的包名，如com.health.service
	 */
	private String servicePackage;
	
	
	/**
	 * servceImpl的包名，如com.health.service.impl
	 */
	private String serviceImplPackage;
	
	
	/**
	 * 实体的包名，如com.health.model
	 */
	private String modelPackage;
	
	/**
	 * 实体名，如ThDevice
	 */
	private String modelName;
	
	/**
	 * controller 包
	 */
	private String ctlPackage;
	
	/**
	 * utils 包
	 */
	private String utilsPackage;
	
	/**
	 *	mysql数据库连接URL 
	 */
	private String sqlConnectUrl;
	
	
	private List<Map<String, Object>> tableList;
	
	private List<List<Map<String, Object>>> listInfo;
	
	public String getSqlConnectUrl() {
		return sqlConnectUrl;
	}
	public void setSqlConnectUrl(String sqlConnectUrl) {
		this.sqlConnectUrl = sqlConnectUrl;
	}
	public List<List<Map<String, Object>>> getListInfo() {
		return listInfo;
	}
	public void setListInfo(List<List<Map<String, Object>>> listInfo) {
		this.listInfo = listInfo;
	}
	public List<Map<String, Object>> getTableList() {
		return tableList;
	}
	public void setTableList(List<Map<String, Object>> tableList) {
		this.tableList = tableList;
	}
	public String getUtilsPackage() {
		return utilsPackage;
	}
	public void setUtilsPackage(String utilsPackage) {
		this.utilsPackage = utilsPackage;
	}
	public String getCtlPackage() {
		return ctlPackage;
	}
	public void setCtlPackage(String ctlPackage) {
		this.ctlPackage = ctlPackage;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getDaoPackage() {
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	public String getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getServiceImplPackage() {
		return serviceImplPackage;
	}
	public void setServiceImplPackage(String serviceImplPackage) {
		this.serviceImplPackage = serviceImplPackage;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
	
}
