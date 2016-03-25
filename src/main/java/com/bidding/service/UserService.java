package com.bidding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bidding.domain.User;
import com.bidding.repository.UserRepository;

/**
 * 
 * @author krishna karki User service class dealing with business logic
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Method to save user
	 * 
	 * @param user
	 *            - user
	 */
	public void save(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		userRepository.save(user);
	}

	/**
	 * Method to return all users
	 * 
	 * @return list of users
	 */
	public Object findAll() {
		return userRepository.findAll();
	}
/**
 * Method to delete user based on the id
 * @param id - id 
 */
	public void deleteUser(int id) {
		userRepository.delete((long) id);

	}
/**
 * Method to get  user based on the id
 * @param uId - user id
 * @return return user
 */
	public User getUser(Long uId) {
		return userRepository.findOne(uId);
	}
/**
 * Method to get user by name
 * @param name - user name
 * @return returns user
 */
	public User getUserByUsername(String name) {
		return userRepository.getUserByuserName(name);
	}
/**
 * Method to check if the user exist according to the given username
 * @param username - username
 * @return whether user exist or not
 */
	public boolean isExisted(String username) {
		User user = userRepository.getUserByuserName(username);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

}
