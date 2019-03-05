package com.capgemini.corso.webrestservice.CrudRestExample.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "user_table")
public class User implements  Serializable {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "user_id")
	    private long userId;
	 	
	 	@Column(name = "user_name")
	    private String userName;
	 
	    @Column(name = "user_email")
	    private String userEmail;
	 
	    @Column(name = "user_phoneNo")
	    private long userPhoneNo;
	
	    @Column(name = "user_dob")
	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private Date userDob;
	 
	    public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		
		public long getUserPhoneNo() {
			return userPhoneNo;
		}

		public void setUserPhoneNo(long userPhoneNo) {
			this.userPhoneNo = userPhoneNo;
		}

		public Date getUserDob() {
			return userDob;
		}

		public void setUserDob(Date userDob) {
			this.userDob = userDob;
		}
		
		@ManyToMany(mappedBy = "users")
		@JsonBackReference
		private List<Product> products;

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}
		

		

		

		
		

}
