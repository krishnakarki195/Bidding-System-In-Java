package com.bidding.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bidding.domain.Bid;
import com.bidding.domain.Product;
import com.bidding.domain.User;
/**
 * 
 * @author NIYIRORA Marie Claire
 * Bid repository interface
 *
 */
@Repository
public interface BidRepository  extends JpaRepository<Bid, Long>{

	@Query("SELECT b FROM Bid b where user = :user")
	List<Bid> getByUser(@Param("user") User user );

	
	@Query("SELECT b FROM Bid b where user = :user AND product = :product")
	List<Bid> getPreviousBids(@Param("user") User user, @Param("product") Product product);

	

}
