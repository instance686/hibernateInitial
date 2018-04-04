package com.org.sample.hbt;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;


@Entity(name="USER_DETAILS")
@NamedQuery(name="USER_DETAILS.byId",query="from USER_DETAILS where userId = ?")
@NamedNativeQuery(name="USER_DETAILS.byName",query="select * from USER_DETAILS where USER_NAME = ?",
resultClass=UserDetails.class)
public class UserDetails {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName+" from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
