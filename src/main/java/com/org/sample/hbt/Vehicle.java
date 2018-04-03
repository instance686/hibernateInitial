package com.org.sample.hbt;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	@ManyToMany(mappedBy="vehicle")//creates only the third table and excludes the fourth table

	private Collection<UserDetails2> userDetails=new ArrayList<UserDetails2>();
	
	
	
	public Collection<UserDetails2> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Collection<UserDetails2> us2) {
		this.userDetails = us2;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
