package com.example.recipybook;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.recipybook.web.RecipyController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipyBookApplicationTests {

	@Autowired
	private RecipyController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		}
	
}
