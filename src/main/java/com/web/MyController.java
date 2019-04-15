package com.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.User;

@Controller
public class MyController {
    
	private Logger LOG = LoggerFactory.getLogger(MyController.class);
			
	@RequestMapping(value="/hello")
	public String savHello() {
		return "hello world!";
	}
	
	@RequestMapping(value="/test1")
	public User user() {
		User user = new User();
		user.setUserName("张三");
		user.setPassword("123456");
		user.setAge(25);
		return user;
	}
	
	@RequestMapping("/save")
	public void save(@Valid User user,BindingResult result) {
		System.out.println("use is "+user);
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				System.out.println(error.getCode()+"-"+error.getDefaultMessage());
			}
		}
	}
	
	@RequestMapping(value="/getMessage")
	public String getMessage(Model model) {
		model.addAttribute("time",new Date());
		model.addAttribute("message", "hello world! 亲");
		User user = new User();
		user.setUserName("李大仙");
		user.setPassword("2223333");
		user.setAge(20);
		model.addAttribute(user);
		return "index";
	}
	
	@RequestMapping(value="/get")
	public String hello(Model model) {
		model.addAttribute("message","http://helloworld.html");
		return "hello";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(@RequestParam("file")MultipartFile file,RedirectAttributes redirectAttributes,HttpServletRequest request) {
		String message = null;
		OutputStream out = null;
		if(file.isEmpty()) {
			//redirectAttributes.addFlashAttribute("message", "请选择一个文件进行上传!");
			redirectAttributes.addFlashAttribute("message", "文件上传");
			LOG.info("请选择上传的文件!!!");
			return "redirect:/fileUploadResult";
		}
		try {
			byte[] bytes = file.getBytes();
			String path = request.getServletContext().getRealPath("/WEB-INF/file");
			String fileSave = path+File.separator+file.getOriginalFilename();
			File newFile = new File(fileSave);
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			out = new FileOutputStream(newFile);
			out.write(bytes);
			out.close();
			LOG.info("文件上传成功!");
			//redirectAttributes.addAttribute("message", "文件上传成功了哦!");
			redirectAttributes.addFlashAttribute("message", "文件上传成功了哦!");
			return "redirect:/fileUploadResult";
		} catch (IOException e) {
			e.printStackTrace();
		}catch(MultipartException e) {
			System.out.println("MultipartException被捕获");
			throw e;
		}finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "redirect:/file_upload_result";
	}
	
	@RequestMapping("/fileUpload")
	public String fileUpload() {
		return "file_upload";
	}
	
	@RequestMapping("/fileUploadResult")
	public String fileUploadResult() {
		return "file_upload_result";
	}
}
