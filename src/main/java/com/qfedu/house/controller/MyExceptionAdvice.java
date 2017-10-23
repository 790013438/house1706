package com.qfedu.house.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice
public class MyExceptionAdvice {

	@ExceptionHandler({ Exception.class })
	public String toException(Model model) {
		return "error/hint";
	}
}
