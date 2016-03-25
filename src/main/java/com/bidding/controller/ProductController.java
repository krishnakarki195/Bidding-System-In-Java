package com.bidding.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bidding.domain.Product;
import com.bidding.domain.User;
import com.bidding.service.ProductService;
import com.bidding.service.UserService;

/**
 * 
 * @author Nikesh Maharjan Product controller
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	ServletContext context;

	@ModelAttribute("product")
	public Product construct() {
		return new Product();
	}

	/**
	 * Method to add product
	 * 
	 * @param product
	 *            - product
	 * @return add product form
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct(@ModelAttribute("product") Product product) {
		return "product/addproduct";
	}

	/**
	 * Method to post the add product form
	 * 
	 * @param product
	 *            - product
	 * @param result
	 *            - binding result for validation
	 * @param request
	 *            - request
	 * @param redirectAttributes
	 *            -flash attribute parameter
	 * @return redirects to add page if product is added successfully
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {

		System.out.println("hello produtc post");

		if (result.hasErrors()) {
			System.out.println("hello error produtc post");
			return "product/addproduct";
		}

		Object userId = request.getSession().getAttribute("userId");
		Long uId = (Long) userId;

		System.out.println("User Id is " + uId);
		User user = userService.getUser(uId);
		System.out.println("user Id is" + uId);
		product.setUser(user);
		product.setProductStatus(true);
		product.setProductStartDate(new Date());

		MultipartFile productImage = product.getProductImage();
		String rootDirectory = context.getRealPath("/");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				String fileName = "" + uId + System.currentTimeMillis();
				String imagePath = rootDirectory + "/resources/images/" + fileName + ".png";
				product.setImagePath(imagePath);
				productImage.transferTo(new File(imagePath));

			} catch (Exception e) {

				throw new RuntimeException("Product Image saving failed", e);

			}
		}

		productService.save(product);
		redirectAttributes.addFlashAttribute("save", "Product Added Sucessfully");

		return "redirect:/product/add";
	}

	/**
	 * Method to get all products
	 * 
	 * @param model
	 *            -method
	 * @param request
	 *            -request
	 * @return all user products
	 */
	@RequestMapping(value = "")
	public String allProduct(Model model, HttpServletRequest request) {

		Long userId = (Long) request.getSession().getAttribute("userId");
		String role = (String) request.getSession().getAttribute("userRole");

		if (role.equals("ROLE_ADMIN")) {
			model.addAttribute("product", productService.findAll());
		} else {
			model.addAttribute("product", productService.findByUserId(userId));
		}
		return "product/allproduct";
	}

}
