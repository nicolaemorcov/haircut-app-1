package com.commons.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.commons.entities.Beard;
import com.commons.entities.Booking;
import com.commons.entities.Haircut;
import com.commons.entities.Service;
import com.commons.entities.User;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;

public class ShopService {
	protected ObjectManagerContext oc;
	protected DataAccessObject dao;
	
	public ShopService() {}
	
	public ShopService(ObjectManagerContext oc) {
		this.oc = oc;
	}
	
	public void createService(Service service) {
		//kolia
		oc.persist(service);
		//===========================================
	}
	
	public void deleteService(Service service) {
		String query = "DELETE FROM Service s WHERE s.id = :idVariable";
		
		Query q = oc.createQuery(query)
				.setParameter("idVariable", service.getServiceId());
		oc.executeQuery(q);
	}
	
//	======================================================================
	
	
	
	public void updateService(Service service) {
		String sql = "UPDATE Service s SET s.service_name = :serviceNameVar WHERE "
				+ "s.id = : idVariable";
		
		Query q = oc.createQuery(sql)
				.setParameter("serviceNameVar", service.getServiceName())
				.setParameter("idVariable", service.getServiceId());
		oc.executeQuery(q);
		
	}
	
	
//	===================================================================
	public Service findServiceById(int id) {
		String query = "FROM Service s WHERE s.serviceId = :idVar";
		
		//create query
		Service service = oc.getSingleResult(Service.class, query, "idVar", id);

		return service;
	}
	
//	======================================================================================================
	
	public List<Service> getAllServices() {
		String query = "FROM Service s";
		
		//Create query
		List<Service> services = oc.getResultList(Service.class, query);
		return services;
	}
	
	
	
}
