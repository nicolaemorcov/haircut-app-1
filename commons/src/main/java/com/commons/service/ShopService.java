package com.commons.service;

import java.util.ArrayList;
import java.util.List;

import com.commons.entities.Beard;
import com.commons.entities.Haircut;

public class ShopService {
	
	public List<ServiceEntity> getAllServices() {
		List<ServiceEntity> allServices = new ArrayList<ServiceEntity>();
		
		allServices.add(new Haircut(22, "Women Haircut", 25.0, "women haircut"));
		allServices.add(new Haircut(22, "Male Haircut", 15.0, "male haircut"));
		allServices.add(new Beard(22, "Shave", 20.0, "beard shave"));
		
		return allServices;
	}
}
