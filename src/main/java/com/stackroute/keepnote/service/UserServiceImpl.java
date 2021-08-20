package com.stackroute.keepnote.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.keepnote.dao.UserDAO;
import com.stackroute.keepnote.exception.UserAlreadyExistException;
import com.stackroute.keepnote.exception.UserNotFoundException;
import com.stackroute.keepnote.model.User;


@Service
public class UserServiceImpl implements UserService {

	/*
	 * Autowiring should be implemented for the userDAO. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword.
	 */
	private UserDAO userDAO;
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	/*
	 * This method should be used to save a new user.
	 */

	public boolean registerUser(User user) throws UserAlreadyExistException {
		if(userDAO.registerUser(user))
			return true;
		else 
			throw new UserAlreadyExistException("UserAlreadyExistException");

	}

	

	

	/*
	 * This method should be used to update a existing user.
	 */

	public User updateUser(User user, String userId) throws Exception {
//		try {
//			if(getUserById(userId)!=null) {
//				user.setUserMobile("777777777");
//				user.setUserAddedDate(new Date());
//				userDAO.updateUser(user);
//				return user;
//			}
//			else {
//				throw new Exception();
//			}
//		} catch (UserNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//		return null;
		userDAO.updateUser(user);
		User newUser = getUserById(userId);
		if(newUser==null)
			throw new Exception();
		else 
			return user;

	}

	/*
	 * This method should be used to get a user by userId.
	 */

	public User getUserById(String UserId) throws UserNotFoundException {
//		User user = userDAO.getUserById(UserId);
//		if(user!=null) {
//			return user;
//		}else {
//			throw new UserNotFoundException("");
//		}
		User user = userDAO.getUserById(UserId);
		if(user==null) {
			throw new UserNotFoundException("UserNotFoundException");
		}
		else
			return user;
	}

	/*
	 * This method should be used to validate a user using userId and password.
	 */

	public boolean validateUser(String userId, String password) throws UserNotFoundException {
//		return userDAO.validateUser(userId, password);
		boolean validUser = userDAO.validateUser(userId, password);
		if(!validUser)
			throw new UserNotFoundException("UserNotFoundException");
		else 
			return true;

	}

	/* This method should be used to delete an existing user. */
	public boolean deleteUser(String UserId) {
//		return userDAO.deleteUser(UserId);
		boolean deleteUser = userDAO.deleteUser(UserId);
		if(!deleteUser) {
			return false;
		}else {
			return true;
		}	

	}

}
