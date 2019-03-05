package com.capgemini.corso.webrestservice.CrudRestExample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.corso.webrestservice.CrudRestExample.entity.Product;
import com.capgemini.corso.webrestservice.CrudRestExample.entity.User;
import com.capgemini.corso.webrestservice.CrudRestExample.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
    @Qualifier("productService")
    private ProductService productService;
	
	
	@PostMapping("createprodotto")
    public void createNewProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
    }
	
	@GetMapping("viewallproduct")
	public List<Product> viewAllProduct() {
		return productService.getAllProduct();
	 }
	
	@GetMapping("printUser/{id}")
	public List<User> printUserByProduct(@PathVariable(value = "id") long productId){
		
		Product p = productService.getProductById(productId);
		
		return p.getUsers();
	}
	
}
