package com.employeemanagementsystem.model.employee;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table( name="employees")
@Data
public class Employee implements Serializable {


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ emailid: "+ this.emailId +", firstname: " + this.firstname + ", lastname: "+ this.lastname + ", id: " + this.id + "}";
	}
	private static final long serialVersionUID = 6832006422622219737L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email_id")
	private String emailId;

	@Column(name="age")
	private long age;

	@Column(name="dept_id")
	private int deptId;
	
	public Employee ()
	{
		
	}
	
	public Employee(long id, String firstname, String lastname, String emailId, long age, int deptId) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailId = emailId;
		this.age = age;
		this.deptId = deptId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
