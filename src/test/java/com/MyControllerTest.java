package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.model.DataBase;
import com.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MyControllerTest {
	
	@Autowired
	private DataBase database;
	
	@Autowired
    private MockMvc mockMvc; //只需 autowire
	
//	@Value("${test.userName}")
//	String userName;
//	
//	@Value("${test.password}")
//	String password;
//	
//	@Value("${test.age}")
//	int age;
	
	@Autowired
	private User user;
	
	//@Test
	public void getUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/save")
				.param("userName", user.getUserName())
				.param("age", user.getAge()+"")
				.param("password", user.getPassword()));
	}
	
	@Test
	public void getDateBase() {
		System.out.println(database);
	}
}
