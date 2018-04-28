package com.commons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="service")
@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int serviceId;
	@Column(name = "service_name")
	private String serviceName;
	@Column(name = "service_price")
	private double servicePrice;
	@Column(name = "service_description")
	private String serviceDescription;
	
	//constructor
	public Service() {}
	//constructor
		public Service(String serviceName, double servicePrice, String description) {
			this.setServiceName(serviceName);
			this.setServicePrice(servicePrice);
			this.setServiceDescription(description);
		}
	
		//getters
		public int getServiceId() {
			return serviceId;
		}
		public String getServiceName() {
			return serviceName;
		}
		public double getServicePrice() {
			return servicePrice;
		}
		public String getServiceDescription() {
			return serviceDescription;
			}
		
		//setters
		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
			}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
			}
		public void setServicePrice(double servicePrice) {
			this.servicePrice = servicePrice;
			}
		public void setServiceDescription(String description) {
			this.serviceDescription = description;
		}

		
		@Override
	    public String toString() {
	        return ("Service name: " + this.getServiceName() +
	        		"Service price: " + this.getServicePrice() +
	        		"Service description: " + this.getServiceDescription());
	        }
	
	//add services to list
	public void addService(Service newService) {
		System.out.println("Adding to dataBase");
	}
	
	//remove service from list
	public void removeService(Service service) {
		System.out.println("Remove from database");
	}
	
//	System.out.println(Arrays.toString(services.toArray()));
	
	
	
	
	
	
	
	
	
}
	