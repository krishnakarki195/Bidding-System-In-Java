package com.bidding.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author NIYIRORA Marie Claire
 * Bid domain class storing all bidding information including  amount,date,status and so on.
 *
 */
@Entity
@Table(name = "bid")
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bidId;

	@NotNull
	private double bidAmount;

	private Date bidDate;

	private Boolean bidStatus;

	@OneToOne
	private User user;

	@OneToOne
	private Product product;

	/**
	 * Bid default constructor
	 */
	public Bid() {

	}

	/**
	 * Method to return bid id
	 * 
	 * @return bidId - bid id
	 */
	public Long getBidId() {
		return bidId;
	}

	/**
	 * Method to set bid id
	 * 
	 * @param bidId
	 *            - bid id
	 */

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	/**
	 * Method to return bid amount
	 * 
	 * @return bidAmount - bid amount
	 */
	public double getBidAmount() {
		return bidAmount;
	}

	/**
	 * Method to set bid amount
	 * 
	 * @param bidAmount
	 *            - bid amount
	 */
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	/**
	 * Method to get bid date
	 * 
	 * @return bidDate - the date user made his/her bid
	 */
	public Date getBidDate() {
		return bidDate;
	}

	/**
	 * Method to set bid date
	 * 
	 * @param bidDate
	 *            - the date user made his/her bid
	 */
	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	/**
	 * Method to get bid status (bid can either cancelled or not)
	 * 
	 * @return bidStatus - bid status
	 */
	public Boolean getBidStatus() {
		return bidStatus;
	}

	/**
	 * Method to set bid status
	 * 
	 * @param bidStatus
	 *            - bid status
	 */
	public void setBidStatus(Boolean bidStatus) {
		this.bidStatus = bidStatus;
	}

	/**
	 * Method to get user
	 * 
	 * @return user - user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Method to set user
	 * 
	 * @param user
	 *            - user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Method to get the product
	 * 
	 * @return product - product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Method to set the product
	 * 
	 * @param product
	 *            - product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

}
