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
			
			log.info("save a couple of recipies");
			
			//Adding categories to database 
			
			crepository.save(new Category("Salad"));
			crepository.save(new Category("Soup"));
			crepository.save(new Category("Dessert"));
			
			//Adding recipes to database

			repository.save(new Recipy("Caesar", "Croutons 50 g, 3 tbsp olive oil, 2 skinless, boneless chicken breasts, 1 large cos or romaine lettuce, leaves separated, ceasar dressing", 
					"A great Caesar salad recipe gets its swagger from a great Caesar dressing recipe.", "Make chicken: Heat remaining tablespoon oil in a large skillet over high. Season chicken with salt and pepper. Cook until opaque throughout, 1 to 2 minutes per side; remove from skillet and let cool. Prepare lettuce: Cut romaine crosswise into 1-inch ribbons; wash and dry. If stored in refrigerator, bring chicken and dressing to room temperature. Slice chicken crosswise into strips; toss with croutons, lettuce, and dressing.",
					crepository.findByName("Salad").get(0)));
			
			repository.save(new Recipy("Dill Chicken Soup", "1 tablespoon canola oil, 1 small onion, coarsely chopped, 2 garlic cloves, minced, 1/2 cup uncooked whole wheat orzo pasta, 1-1/2 cups coarsely shredded rotisserie chicken",
					"I could eat soup for every meal of the day, all year long. I particularly like dill and spinach—they add a brightness to this light and healthy soup. —Robin Haas, Jamaica Plain, Massachusetts", "In a 6-qt. stockpot, heat oil. Add carrots, onion and garlic.Add carrots, onion and garlic; saute until carrots are tender.Stir in orzo, chicken and broth; bring to a boil. Reduce heat; simmer 5 minutes. Stir in peas, spinach and dill; return to a boil. Reduce heat; simmer, uncovered, until orzo is tender, 3-4 minutes. Stir in lemon juice. If desired, top each serving with coarsely ground pepper.", crepository.findByName("Soup").get(0)));
			
			repository.save(new Recipy("Chocolate Covered Strawberries", "pt. strawberries, 2 c. semisweet chocolate chips, 2 tbsp. coconut oil",  "Is there anything better than chocolate-covered strawberries? We think not. They're at once indulgent and classy, romantic and a little cheesy.", "Line a large baking sheet with parchment paper. Rinse strawberries and pat dry with paper towels. In a small microwave-safe bowl, combine chocolate chips and coconut oil and microwave in 30-second intervals, stirring in between, until completely melted. Dip strawberries in chocolate and place on prepared baking sheet. Refrigerate until chocolate is set, about 30 minutes.",
					crepository.findByName("Dessert").get(0)));
			
			repository.save(new Recipy("Lemon Pound Cake", "1 1/2 c. (3 sticks) unsalted butter, 3 c. granulated sugar, 6 large eggs, 5 tbsp. lemon extract, 3 tbsp. sour cream, 4 tbsp. Miracle Whip, 3 c. cake flour, 1 tsp. baking powder, Cooking spray", "This recipe was submitted to us for our Mother's Day recipe contest by Katrina Adams. Her mom, Mary Windham, came from a family of 8 boys and 8 girls and learned to cook at a very young age. According to Katrina, she’s a wonderful cook with a multitude of delicious recipes, but she’s most famous for her pound cake. It’s so good, her grandmother has been known to hide some in the freezer before anyone else can get to it. ", 
					"Preheat oven 325° and grease a large tube pan with cooking spray. Combine butter and sugar in a large bowl and beat until creamy, 3 to 4 minutes. Add eggs one at a time, beating thoroughly until completely incorporated. Add lemon flavor, sour cream, and Miracle Whip and beat until combined. Then add cake flour and baking powder and mix until just combined. Spray tube cake pan with cooking spray. Transfer batter and bake until a toothpick inserted into the center of the cake comes out clean, 1 hour and 30 minutes.  ",
					crepository.findByName("Dessert").get(0)));
			
			repository.save(new Recipy("GREEK SALAD", "5 cups chopped romaine lettuce, 1 small red onion, thinly sliced, 1 English cucumber, thinly sliced, 1/2 cup cherry tomatoes, halved, 1/4 cup sliced Kalamata olives, 1/4 cup crumbled goat cheese, Freshly ground black pepper, to taste",
					"This healthy Greek salad is so easy to whip up, and it’s absolutely amazing when tossed in a light and refreshing lemon vinaigrette!", 
					"To assemble the salad, place romaine lettuce in a large bowl; top with red onion, cucumber, tomatoes, olives, goat cheese and pepper, to taste. Pour dressing on top of the salad and gently toss to combine. Serve immediately.",
					crepository.findByName("Salad").get(0)));
		
			//Creating users with different rights
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all recipies");
			for (Recipy recipy : repository.findAll()) {
				log.info(recipy.toString());
			}

		};
	}

}
