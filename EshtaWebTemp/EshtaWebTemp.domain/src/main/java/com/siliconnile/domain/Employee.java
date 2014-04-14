package com.siliconnile.domain;



import javax.persistence.Entity;

import javax.persistence.Table;


import com.pearlox.framework.domain.BasicObject;

@SuppressWarnings("serial")
@Entity
@Table
public class Employee extends BasicObject {

	private String name;


	private long age;
	
	public Employee() {
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

}