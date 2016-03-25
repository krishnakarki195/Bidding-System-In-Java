package com.bidding.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bidding.domain.Product;
import com.bidding.domain.User;
/**
 * 
 * @author Nikesh Maharjan
 * Product respository  interface
 *
 */
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>{

	List<Product> findByuserId(long userId);

	List<Product> findByProductEndDateAfter(Date date);

	

}
