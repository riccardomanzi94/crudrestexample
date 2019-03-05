package com.capgemini.corso.webrestservice.CrudRestExample.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "product_table")
public class Product implements Serializable {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private long productId;
	
	@Column(name = "product_name")
    private String productName;
	
	@Bean
	public long getProductId() {
		return productId;
	}
	
	@Bean
	public void setProductId(long productId) {
		this.productId = productId;
	}
	@Bean
	public String getProductName() {
		return productName;
	}
	@Bean
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    @JsonManagedReference
    private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
	
	
	
	
	
	

}
