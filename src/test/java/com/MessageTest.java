package com;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void test1() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    saveMessages();
	}
    
	//@Test
	public void test() {
		System.out.println("only for test");
	};
	//@Test
	public void saveMessage() {
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String,String>();
		params.add("text", "我是text");
		params.add("summary", "我是摘要!!!");
		try {
			String content = mockMvc.perform(MockMvcRequestBuilders.post("/message").params(params)).andReturn().getResponse().getContentAsString();
		    System.out.println("the return value is "+content);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void getAllMessage() {
		try {
			
			String result = mockMvc.perform(MockMvcRequestBuilders.get("/messages")).andReturn().getResponse().getContentAsString();
			System.out.println("result is "+result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testPut() {
		try {
			MultiValueMap<String,String> params = new LinkedMultiValueMap<String,String>();
			params.add("id", "10");
			params.add("text", "本大爷是text");
			params.add("summary", "上天入地就是summary!!!");
			String result = mockMvc.perform(MockMvcRequestBuilders.put("/message").params(params)).andReturn().getResponse().getContentAsString();
			System.out.println("the result is "+result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void getMessageById() {
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String,String>();
		params.add("id", "7");
		String result;
		try {
			result = mockMvc.perform(MockMvcRequestBuilders.get("/message/7")).andReturn().getResponse().getContentAsString();
			System.out.println("the result is "+result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveMessages() {
		for (int i = 1; i < 10; i++) {
			final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("text", "text" + i);
			params.add("summary", "summary" + i);
			try {
				MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/message").params(params))
						.andReturn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
