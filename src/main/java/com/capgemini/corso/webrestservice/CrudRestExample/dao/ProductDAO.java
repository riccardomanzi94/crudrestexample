package com.capgemini.corso.webrestservice.CrudRestExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.corso.webrestservice.CrudRestExample.entity.Product;
import com.capgemini.corso.webrestservice.CrudRestExample.entity.User;

@Repository("productDao")
public class ProductDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
 
    public Product selectProductById(long productId) {
        return entityManager.find(Product.class, productId);
    }
 
    public void insertProduct(Product product) {
        entityManager.merge(product);
    }
 
    public void updateProduct(Product product) {
 
        Product userToUpdate = selectProductById(product.getProductId());
 
        userToUpdate.setProductName(product.getProductName());
        entityManager.flush();
        
    }
 
    public void deleteProduct(long productId) {
        entityManager.remove(selectProductById(productId));
    }
 
    public List<Product> selectAllProduct() {
        Query query = entityManager.createQuery("from Product as prd order by prd.productId");
        List<Product> resultList = (List<Product>) query.getResultList();
		return resultList;
    }

}
