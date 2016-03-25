package com.bidding.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.domain.Product;
import com.bidding.domain.User;
import com.bidding.repository.ProductRepository;

/**
 * 
 * @author Nikesh Maharjan
 * Product service class dealing with business logic
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Method to save product
	 * 
	 * @param product
	 *            - product
	 */
	public void save(Product product) {
		productRepository.save(product);

	}

	/**
	 * Method to find all product
	 * 
	 * @return all products
	 */
	public Object findAll() {
		return productRepository.findAll();
	}

	/**
	 * Method to return products based on the user id
	 * 
	 * @param userId
	 *            - user id
	 * @return list of the products
	 */
	public List<Product> findByUserId(long userId) {
		return productRepository.findByuserId(userId);
	}

	/**
	 * Method to find product based on id
	 * 
	 * @param id
	 *            - id
	 * @return - return product
	 */
	public Object findOne(int id) {
		return productRepository.findOne((long) id);
	}

	/**
	 * Method to find product based on id
	 * 
	 * @param id
	 *            - id
	 * @return - return product
	 */
	public Product getProduct(int id) {
		return productRepository.findOne((long) id);
	}

	/**
	 * Method to find product available for bidding
	 * 
	 * @return list available products
	 */
	public List<Product> findValid() {
		return productRepository.findByProductEndDateAfter(new Date());
	}

}
