package com.bidding.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bidding.domain.Bid;
import com.bidding.domain.Product;
import com.bidding.domain.User;
import com.bidding.service.BidService;
import com.bidding.service.ProductService;
import com.bidding.service.UserService;

/**
 * 
 * @author krishna,Claire,Nikesh Front controller
 */
@Controller
public class FrontController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private BidService bidService;

	/**
	 * Method for home page
	 * 
	 * @param model
	 *            - model
	 * @return returns the home page
	 */
	@RequestMapping(value = "/")
	public String frontPage(Model model) {
		model.addAttribute("product", productService.findValid());
		return "frontend/index";
	}

	/**
	 * Method to display product details
	 * 
	 * @param model
	 *            - model
	 * @param id
	 *            - product id
	 * @param bid
	 *            - bid
	 * @param request
	 *            - request
	 * @return returns product details page
	 */
	@RequestMapping(value = "/bid/details/{id}", method = RequestMethod.GET)
	public String productDetails(Model model, @PathVariable int id, @ModelAttribute("bid") Bid bid,
			HttpServletRequest request) {
		model.addAttribute("product", productService.findOne(id));
		return "frontend/productdetails";
	}

	/**
	 * Method to post bid for the product
	 * 
	 * @param bid
	 *            - bid
	 * @param request
	 *            - request
	 * @param id
	 *            - product id
	 * @param redirectAttributes
	 *            - for flashAttribute
	 * @return - redirect to the bid details page
	 */
	@RequestMapping(value = "/bid/details/{id}", method = RequestMethod.POST)
	public String add(@ModelAttribute("bid") Bid bid, HttpServletRequest request, @PathVariable int id,
			RedirectAttributes redirectAttributes) {
		Object userId = request.getSession().getAttribute("userId");
		Long uId = (Long) userId;
		System.out.println(uId);
		User user = userService.getUser(uId);
		bid.setUser(user);

		Product product = productService.getProduct(id);
		bid.setProduct(product);

		bid.setBidStatus(true);

		bid.setBidDate(new Date());

		List<Bid> bids = bidService.getPrevioudBids(user, product);

		if (bids.size() == 0) {
			bidService.save(bid);
			redirectAttributes.addFlashAttribute("save", "Save Sucessfully");
		} else {
			redirectAttributes.addFlashAttribute("save", "You Cannot bid Twice");
		}

		return "redirect:/bid/mybid";
	}

}
