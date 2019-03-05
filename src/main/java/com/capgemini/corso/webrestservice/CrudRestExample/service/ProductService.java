package com.capgemini.corso.webrestservice.CrudRestExample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.capgemini.corso.webrestservice.CrudRestExample.dao.ProductDAO;
import com.capgemini.corso.webrestservice.CrudRestExample.entity.Product;


@Service("productService")
public class ProductService {

	
			@Autowired
		    @Qualifier("productDao")
		    private ProductDAO productDao;
		 
			
			
		    @Transactional
		    public Product getProductById(long productId) {
		 
		        return productDao.selectProductById(productId);
		    }
		 
		    @Transactional
		    public void addProduct(Product product) {
		        productDao.insertProduct(product);
		    }
		 
		    @Transactional
		    public void modifyProduct(Product product) {
		        productDao.updateProduct(product);
		    }
		 
		    @Transactional
		    public List<Product> getAllProduct() {
		        return productDao.selectAllProduct();
		 
		    }
		 
		    @Transactional
		    public void removeProduct(long productId) {
		        productDao.deleteProduct(productId);
		 
		    }
}
