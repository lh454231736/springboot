package com.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ExceptionHandler {
   
	@org.springframework.web.bind.annotation.ExceptionHandler(MultipartException.class)
	public String handleError(MultipartException e,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
		System.out.println("被捕获了!!!");
		return "redirect:/fileUploadResult";
	}
}
