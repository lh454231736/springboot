package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Message;
import com.repository.MessageRepository;

/**
    * 测试RESTful应用
 * @author LiHuan
 *
 */
@RestController
@RequestMapping("/")
public class MessageController {
    
	@Autowired
	private MessageRepository messageRepository;
    
	@GetMapping("messages")
    public List<Message> list(){
    	return messageRepository.findAll();
    }
	
	@PostMapping("message")
	public Message createMessage(Message message){
		//System.out.println("接到请求");
		return messageRepository.save(message);
	}
	
	@PutMapping("message")
	public Message modify(Message message) {
		return messageRepository.update(message);
	}
	
	@PatchMapping("message/text")
	public Message patch(Message message) {
		return messageRepository.update(message);
	}
	
	@GetMapping("message/{id}")
	public Message get(@PathVariable("id")Long id) {
		return messageRepository.findMessage(id);
	}
	
	@DeleteMapping("")
	public Message deleteMessage(@PathVariable("id")Long id) {
		return messageRepository.deleteMessage(id);
	}
}
