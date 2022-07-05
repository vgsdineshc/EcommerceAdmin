package com.ecomm.admin.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int pid;
	private String pname;
	private long price;
	
	@OneToOne
	@JoinColumn(name = "pid_cid")
	Catagery catagery;
	

		
}
