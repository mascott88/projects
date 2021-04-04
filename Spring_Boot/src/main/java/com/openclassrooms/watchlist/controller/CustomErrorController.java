package com.openclassrooms.watchlist.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@GetMapping("/error")
	public ModelAndView handleError(HttpServletRequest request) {
		
		Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status.equals(404)) {
			logger.info("Page not found status code " + status + " happened. Support! Do something about it!");
			return new ModelAndView("pageNotFound");
		}
		
		logger.info("Error with status code " + status + " happened. Support! Do something about it!");
		return new ModelAndView("error");
	}
}