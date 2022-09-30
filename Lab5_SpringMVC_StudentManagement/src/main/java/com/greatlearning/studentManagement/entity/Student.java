package com.greatlearning.studentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_Id")
	private int id;

	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Department")
	private String department;

	@Column(name = "Country")
	private String country;
	
	public Student() {};

	public Student(String firstName, String lastName, String department, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.country = country;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department
				+ ", country=" + country + "]";
	}

}
