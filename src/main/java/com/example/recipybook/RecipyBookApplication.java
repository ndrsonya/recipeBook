package com.example.recipybook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.recipybook.domain.Category;
import com.example.recipybook.domain.CategoryRepository;
import com.example.recipybook.domain.Recipy;
import com.example.recipybook.domain.RecipyRepository;
import com.example.recipybook.domain.User;
import com.example.recipybook.domain.UserRepository;

@SpringBootApplication
public class RecipyBookApplication {
	private static final Logger log = LoggerFactory.getLogger(RecipyBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RecipyBookApplication.class, args);
	}

	@Bean
	public CommandLineRunner recipyDemo(RecipyRepository repository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {
			// Your code...add some demo data to db
			log.info("save a couple of recipies");

			crepository.save(new Category("Salad"));
			crepository.save(new Category("Soup"));
			crepository.save(new Category("Dessert"));

			repository.save(new Recipy("Caesar", "1 medium ciabatta loaf (or 4 thick slices crusty white bread), 3 tbsp olive oil, 2 skinless, boneless chicken breasts, 1 large cos or romaine lettuce, leaves separated", 
					"A great Caesar salad recipe gets its swagger from a great Caesar dressing recipe.", "dsf",
					crepository.findByName("Salad").get(0)));
			repository.save(new Recipy("Lohiketto", "Salmon, potato, cream, carrot, ",
					"Traditional finnish salmon soup", "dsf", crepository.findByName("Soup").get(0)));
			repository.save(new Recipy("Ceasar", "Salad, chicken, mayo, tomatoes", "easy and delicious salad", "dsf",
					crepository.findByName("Salad").get(0)));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all recipies");
			for (Recipy recipy : repository.findAll()) {
				log.info(recipy.toString());
			}

			// Book b1 = new Book("The picture of Doriann Gray", "Oscar Wilde", 2014,
			// "tpodd2014", 10.00);
			// Book b2 = new Book("The Little Mermaid", "Hans Christian Anderson", 1999,
			// "tlm1999", 15.00);
			// Book b3 = new Book("Anna Karenina", "Leo Tolstoy", 2010, "ak2010", 10.00);

		};
	}

}
