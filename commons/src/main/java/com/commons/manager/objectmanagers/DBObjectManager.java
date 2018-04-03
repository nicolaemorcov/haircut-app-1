package com.commons.manager.objectmanagers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.commons.manager.ApplicationManagerContext;

/**
 * This manager creates Session factory for the database. Here it will get the connection to the db
 **/
public class DBObjectManager implements DBObjectManagerInterface {
	
	// responsible for Hibernate Session factory
	ApplicationManagerContext appManagerContext;
	Configuration cfg;
	
	// session factory is needed to create a session
	SessionFactory masterDBSessionFactory;
	
	public DBObjectManager(ApplicationManagerContext appManagerContext) {
		this.appManagerContext = appManagerContext;
		
		initJPA();
	}
	
	private void initJPA() {
		createAndReadConfigFile();
		createMasterDBFactory();
	}
	
	public void createAndReadConfigFile() {
		// get the configuration from hibernate.cfg.xml and create configuration object 
	    cfg = new Configuration().configure();
	}
	
	//	create create master db factory
	private void createMasterDBFactory() {
		masterDBSessionFactory = cfg.buildSessionFactory();
	}
	
	public SessionFactory getMasterDBFactory() {	
		return masterDBSessionFactory;
	}
}
