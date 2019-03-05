package com.capgemini.corso.webrestservice.CrudRestExample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.capgemini.corso.webrestservice.CrudRestExample.dao.UserDao;
import com.capgemini.corso.webrestservice.CrudRestExample.entity.User;





@Service("userService")
public class UserService {
	
	
	
		@Autowired
	    @Qualifier("userDao")
	    private UserDao userDao;
	 
		
		
	    @Transactional
	    public User getUserById(long userId) {
	 
	        return userDao.selectUserById(userId);
	    }
	 
	    @Transactional
	    public void addUser(User user) {
	        userDao.insertUser(user);
	    }
	 
	    @Transactional
	    public void modifyUser(User user) {
	        userDao.updateUser(user);
	    }
	 
	    @Transactional
	    public List<User> getAllUser() {
	        return userDao.selectAllUser();
	 
	    }
	 
	    @Transactional
	    public void removeUser(long userId) {
	        userDao.deleteUser(userId);
	 
	    }

}
