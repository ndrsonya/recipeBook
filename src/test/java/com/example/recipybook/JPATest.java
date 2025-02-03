package com.example.recipybook;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.recipybook.domain.*;



/**
 * Testing the web layer
 * Spring application context is started, but without the server
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class JPATest {
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