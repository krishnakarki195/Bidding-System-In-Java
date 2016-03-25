package com.bidding.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.bidding.domain.User;
import com.bidding.service.UserService;

/**
 * 
 * @author Krishna Controller for login and logout related functions
 */
@Controller
@SessionAttributes("userId, userRole")
public class LoginController {

	@Autowired
	private UserService UserService;

	/**
	 * Method to login
	 * 
	 * @return - login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("testlogin");
		return "login";
	}

	/**
	 * Method to logout
	 * 
	 * @param request
	 *            - request
	 * @param response
	 *            - response
	 * @return redirect to logout page
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	/**
	 * Method to login success
	 * 
	 * @param request
	 *            - request
	 * @return login success page
	 */
	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String loginSuccess(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = UserService.getUserByUsername(auth.getName());

		if (user == null) {
			return "redirect:/login";
		}
		request.getSession().setAttribute("userId", user.getId());
		request.getSession().setAttribute("userRole", user.getUserRole());
		String Role = (String) request.getSession().getAttribute("userRole");

		if (Role.equals("ROLE_ADMIN")) {
			return "redirect:/user";
		} else {
			return "redirect:/product";
		}

	}
}
