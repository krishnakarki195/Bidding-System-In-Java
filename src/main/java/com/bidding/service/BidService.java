package com.bidding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.domain.Bid;
import com.bidding.domain.Product;
import com.bidding.domain.User;
import com.bidding.repository.BidRepository;
/**
 * 
 * @author NIYIRORA Marie Claire
 * Bid service class dealing with business logic
 */
@Service
public class BidService {
	
	@Autowired
	private BidRepository bidrepository;
	
	@Autowired
	private UserService userService;
 /**
  * Method to save the bid
  * @param bid - bid
  */
	public void save(Bid bid) {
		bidrepository.save(bid);
		
	}
 /**
  * Method to get bids based on the user id
  * @param uId - user id
  * @return list of bids based user id
  */
	public List<Bid> getbyuserId(Long uId) {
		
		
		return bidrepository.getByUser( userService.getUser(uId));
	}
/**
 * 
 * @param user - user
 * @param product - product
 * @return list of bid based of the user
 */
	public List<Bid> getPrevioudBids(User user, Product product) {
		return bidrepository.getPreviousBids(user, product);
		
	}

	

}
