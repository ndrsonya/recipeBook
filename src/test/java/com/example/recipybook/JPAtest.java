package com.example.recipybook;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.example.recipybook.domain.*;

import static org.assertj.core.api.Assertions.*;

/**
 * Testing the web layer
 * 
 * Spring application context is started, but without the server
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAtest {
	@Autowired
	private RecipyRepository repository;

	@Test
	public void createNewRecipe() {
		Recipy recipy = new Recipy("Caesar", "1 medium ciabatta loaf (or 4 thick slices crusty white bread), 3 tbsp olive oil, 2 skinless, boneless chicken breasts, 1 large cos or romaine lettuce, leaves separated", 
				"A great Caesar salad recipe gets its swagger from a great Caesar dressing recipe.", "dsf",
				new Category("Salad"));
		repository.save(recipy);
		assertThat(recipy.getId(), notNullValue());

	}

	@Test
	public void deleteRecipies() {
		repository.deleteAll();
		assertThat(repository.count(), is(0L));
	}

}