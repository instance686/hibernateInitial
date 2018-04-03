package com.org.sample.hbt;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS2")
public class UserDetails2 {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	@OneToMany(mappedBy="userDetails")//doesn't create a seperate table and includes USER_ID in vehicle table
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
