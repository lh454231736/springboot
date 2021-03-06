package com.repository;

import java.util.List;

import com.model.Message;

public interface MessageRepository {
   
	List<Message> findAll();
	
	Message save(Message message);
	
	Message update(Message message);
	
	Message updateText(Message message);
	
	Message findMessage(Long id);
	
	Message deleteMessage(Long id);
}
