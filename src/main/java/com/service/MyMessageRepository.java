package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.model.Message;
import com.repository.MessageRepository;

@Service("messageRepository")
public class MyMessageRepository implements MessageRepository{
	
	private static AtomicLong counter = new AtomicLong();
	
	private final ConcurrentMap<Long, Message> messages = new ConcurrentHashMap<>();
	
	@Override
	public List<Message> findAll() {
		List<Message> list = new ArrayList<Message>(messages.values());
		return list;
	}

	@Override
	public Message save(Message message) {
		if(message.getId() == null) {
			message.setId(counter.incrementAndGet()); //以原子的方式,将当前值加1
		}
	    messages.put(message.getId(), message);
	    return message;		
	}

	@Override
	public Message update(Message message) {
		messages.put(message.getId(),message);
		return message;
	}

	@Override
	public Message updateText(Message message) {
		Message m = messages.get(message.getId());
		m.setText(message.getText());
		messages.put(message.getId(), m);
		return message;
	}

	@Override
	public Message findMessage(Long id) {
		
		return messages.get(id);
	}

	@Override
	public Message deleteMessage(Long id) {
	    
		Message m = messages.remove(id);
		return m;
	}

}
