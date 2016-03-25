package com.bidding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bidding.domain.User;
/**
 * 
 * @author Krishna Karki
 * User Repository interface
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User getUserByuserName(String user);

	
}
