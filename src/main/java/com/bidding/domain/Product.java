package com.bidding.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Nikesh Product class to store product information including
 *         id,name,description,image and so on.
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "{message.notempty}")
	@Size(min = 4, message = "{product.message.size}")
	private String productName;

	@NotEmpty(message = "{message.notempty}")
	@Size(min = 20, message = "{product.description.size}")
	private String productDescription;

	@Transient
	private MultipartFile productImage;

	private Date productStartDate;

	@NotNull
	@Future(message = "{message.future}")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date productEndDate;

	@NotNull
	private double productInitialPrice;

	private boolean productStatus;

	@OneToOne
	private User user;

	@OneToMany(mappedBy = "product")
	private List<Bid> bids;

	private String imagePath;

	/**
	 * Product default constructor
	 */
	public Product() {

	}

	/**
	 * Method to return image path
	 * 
	 * @return imagePath - the image path
	 * 
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Method to set image path
	 * 
	 * @param imagePath
	 *            - image path
	 *
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * Method to get product id
	 * 
	 * @return id - product id
	 * 
	 */

	public Long getId() {
		return id;
	}

	/**
	 * Method to set product id
	 * 
	 * @param id
	 *            - product id
	 * 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method to return product name
	 * 
	 * @return productName - product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Method to set product name
	 * 
	 * @param productName
	 *            - product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Method to return product description
	 * 
	 * @return productDescription - product description
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Method to set product description
	 * 
	 * @param productDescription
	 *            - product description
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * Method to return product image
	 * 
	 * @return productImage - product image
	 */
	public MultipartFile getProductImage() {
		return productImage;
	}

	/**
	 * Method to set product image
	 * 
	 * @param productImage
	 *            - product image
	 */
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	/**
	 * Method to return product starting date for bidding process
	 * 
	 * @return productStartDate - product bidding starting date
	 */
	public Date getProductStartDate() {
		return productStartDate;
	}

	/**
	 * Method to set product bidding start date
	 * 
	 * @param productStartDate
	 *            - product bid starting date
	 */
	public void setProductStartDate(Date productStartDate) {
		this.productStartDate = productStartDate;
	}

	/**
	 * Method to get product end date
	 * 
	 * @return productEndDate - product end date
	 */
	public Date getProductEndDate() {
		return productEndDate;
	}

	/**
	 * Method to set product end date
	 * 
	 * @param productEndDate
	 *            - product end date
	 */
	public void setProductEndDate(Date productEndDate) {
		this.productEndDate = productEndDate;
	}

	/**
	 * Method to return product initial price
	 * 
	 * @return productInitialPrice - product initial price
	 */
	public double getProductInitialPrice() {
		return productInitialPrice;
	}

	/**
	 * Method to set product initial price
	 * 
	 * @param productInitialPrice
	 *            - product initial price
	 */
	public void setProductInitialPrice(double productInitialPrice) {
		this.productInitialPrice = productInitialPrice;
	}

	/**
	 * Method to return product status (available for bidding or not )
	 * 
	 * @return productStatus - product status
	 */
	public boolean isProductStatus() {
		return productStatus;
	}

	/**
	 * Method to set product status
	 * 
	 * @param productStatus
	 *            - product status
	 */
	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	/**
	 * Method to return user
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
	 * Method to return list of user bids
	 * 
	 * @return bids - user bids
	 */
	public List<Bid> getBids() {
		return bids;
	}

	/**
	 * Method to set user bids
	 * 
	 * @param bids
	 *            - user bids
	 */
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

}
