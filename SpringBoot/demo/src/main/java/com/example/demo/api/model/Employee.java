package com.example.demo.api.model;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.util.List;
@SuppressWarnings("unused")
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "empName")
	private String name;
	
	@Column(name = "empDept")
	private String dept;
	
	@Column(name = "empPhono")
	private Long phoNo;
	
	@Column(name = "empAddress")
	private String address;
	
	public String getEmpName() {
		return name;
	}
	public void setEmpName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Long getPhoNo() {
		return phoNo;
	}
	public void setPhoNo(Long phoNo) {
		this.phoNo = phoNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
