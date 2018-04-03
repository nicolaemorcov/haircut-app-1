package com.commons.manager.objectmanagers;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.commons.manager.ApplicationManager;
import com.commons.manager.ApplicationManagerContext;

public class DataAccessObject implements ObjectManagerContext {

	private static final Logger log = Logger
			.getLogger(DataAccessObject.class.getName());
	
	private DBObjectManager dbObjectManager;
	private ApplicationManagerContext appManager;
	
	// A Session is used to get a physical connection with a database. The Session object is lightweight and designed 
    // to be instantiated each time an interaction is needed with the database. Persistent objects are saved and retrieved through a 
    // Session object. The session objects should not be kept open for a long time because they are not usually thread safe and 
    // they should be created and destroyed them as needed. The main function of the Session is to offer 
    // create, read, and delete operations for instances of mapped entity classes.
    private Session masterSession;
    private Transaction transaction;
	
	public DataAccessObject(ApplicationManagerContext appManager, DBObjectManager dbObjectManager) {
		this.dbObjectManager = dbObjectManager;
		this.appManager = appManager;
	}


	
	private Session getMasterSession() {
		startTransaction();
		return masterSession;
	}
	
	// We need entitymanager to being able to persist the data
	// to the database. The EntityManager creates transaction
	// The EntityManager we can get from the EntityManagerFactory
	private void startTransaction() {
		// if there is no entityManger, create on, otherwise use existing
		if(!appManager.isDatabaseDisabled()
				&& masterSession == null) {
			
			// create a session which is a fisical connection with the database
			masterSession = dbObjectManager
					.getMasterDBFactory()
					.openSession();
			
			//begin a transaction. the beginTransaction() method will create a new transaction if there is none
			transaction = masterSession.beginTransaction();
		}
	}
	
	private void masterCommit() {
		if(masterSession != null) {
			transaction.commit();
			
			masterSession.close();
			
			masterSession = null;
		}
	}

	public ApplicationManager getAppManager() {
		return appManager;
	}


	public void setAppManager(ApplicationManagerContext appManager) {
		this.appManager = appManager;
	}


	public void setMasterSession(Session masterSession) {
		this.masterSession = masterSession;
	}


	public DBObjectManagerInterface getdbObjectManager() {
		return dbObjectManager;
	}



	public void persist(Object o) {
	    getMasterSession().persist(o);
	    getMasterSession().close();
	    System.out.println("successfully saved"); 
	}
	public void delete(Object o) {
	    getMasterSession().delete(o);
	    masterCommit();
	    System.out.println("successfully saved"); 
	}



	public void merge(Object o) {
		// TODO Auto-generated method stub
		
	}



	public <E> E getSingleResult(Class<E> entityClass, String sql, Object... args) {
		startTransaction();
		
		//create the query object
//		TypedQuery<E> query = createQuery(sql, entityClass);
		TypedQuery<E> query = createQuery(sql);//kolia==========================================
		
		//get all the parameters and populate the sql query
		int i = 0;
		while(i < args.length) {
			Object paramName = args[i];
			++i;
			Object value = args[i];
			++i;
			
			try {
				int position = Integer.parseInt((String) paramName);
				
				log.info(position + "=" + value);
				
				query.setParameter(position, value);
			}
			catch(NumberFormatException e) {
				query.setParameter((String) paramName, value);
			}
		}
		
		return query.getSingleResult();
	}

	// check whether it is a named query or just query and return it to the caller
	public <E extends Object> TypedQuery<E> createQuery(String sql, Class<E> entityClass) {
		if(isNamedQuery(sql)) {
			return masterSession.createNamedQuery(sql, entityClass);
		} else {
			return masterSession.createQuery(sql, entityClass);
		}
	}
	
	public <E extends Object> TypedQuery<E> createQuery(String sql) {
		if(isNamedQuery(sql)) {
			return masterSession.createNamedQuery(sql);
		} else {
			return masterSession.createQuery(sql);
		}
	}

	private boolean isNamedQuery(String sql) {
		if(sql.matches("[A-Za-z0-9_]+")) {
			return true;
		}
		
		return false;
	}



	public void executeUpdate(String sql, Object... args) {
		// TODO Auto-generated method stub
		
	}

	
	public <E> List<E> getResultList(Class<E> entityClass, String sql, Object... args) {
		startTransaction();
		
		//create the query object
		TypedQuery<E> query = createQuery(sql);// kolia deleted entityClASS
		
		//get all the parameters and populate the sql query
		int i = 0;
		while(i < args.length) {
			Object paramName = args[i];
			++i;
			Object value = args[i];
			++i;
			
			try {
				int position = Integer.parseInt((String) paramName);
				
				log.info(position + "=" + value);
				
				query.setParameter(position, value);
			}
			catch(NumberFormatException e) {
				query.setParameter((String) paramName, value);
			}
		}
		
		return query.getResultList();
	}
	
	public void executeQuery(Query query) {
		query.executeUpdate();
		getMasterSession().close();
		}

	public Query createNaticeQuery(String sql) {
		return getMasterSession()
				.createNativeQuery(sql);
	}
	
}
