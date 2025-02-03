# RecipyBook

## Description

**RecipyBook** is a Spring Boot-based web application designed as a school project for a server programming course. The project allows users to manage and view recipes in various categories like Salad, Soup, and Dessert. It supports basic CRUD (Create, Read, Update, Delete) operations for both categories and recipes and includes user authentication with roles (USER and ADMIN).

## Features

- **User Authentication**: Users can register and log in with a username and password. Roles (USER and ADMIN) are supported.
- **Recipe Management**: Users can create, read, update, and delete recipes categorized by types such as Salad, Soup, and Dessert.
- **Category Management**: Categories are created and assigned to recipes for easy browsing.
- **Secure Access**: Role-based access control for different functionalities. Admins have more permissions.

## Technologies Used

- **Spring Boot**: Framework for building the web application.
- **Thymeleaf**: Template engine used to generate HTML pages.
- **Spring Security**: Handles authentication and authorization.
- **Spring Data JPA**: Used for database access and CRUD operations.
- **H2 Database**: An embedded in-memory database used for data persistence.
- **BCrypt**: Used to hash passwords for user authentication.

## Project Structure

### Domain

The core entities of the application are:

- **Category**: Represents a category for the recipes (e.g., Salad, Soup).
- **Recipy**: Represents a recipe with properties such as title, ingredients, description, and instructions.
- **User**: Represents a user with roles (USER or ADMIN) for authentication and authorization.

### Repositories

- **CategoryRepository**: Repository for accessing Category data.
- **RecipyRepository**: Repository for accessing Recipy data.
- **UserRepository**: Repository for accessing User data.

### Security

- **WebSecurityConfig**: Configures Spring Security, including user roles, login, and logout functionality.
- **UserDetailServiceImpl**: Implements user authentication logic using the custom `UserRepository`.

## Getting Started

### Prerequisites

- **JDK 8** or later.
- **Maven** for project build management.
- **Spring Boot** for setting up the application.

### Running the Application

1. Clone the repository:

    ```bash
    git clone [https://github.com/yourusername/recipybook.git](https://github.com/ndrsonya/recipeBook)
    cd recipybook
    ```

2. Build and run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

    Or build and run with GUI in your IDE

3. Open the application in your browser by navigating to:

    ```
    http://localhost:8080/login
    ```

4. Login with default users:

    - **Admin**: Username: `admin`, Password: `admin`
    - **User**: Username: `user`, Password: `user`

### Database

This project uses **H2 Database**, which is an in-memory database, so the data will be lost when the application is stopped.

### Access Control

- **Admin**: Can create, update, and delete categories and recipes.
- **User**: Can view recipes and add new ones, but cannot modify the existing repipes.

## Example Recipes

1. **Caesar Salad**: A great Caesar salad recipe gets its swagger from a great Caesar dressing recipe.
2. **Dill Chicken Soup**: A light and healthy soup with dill and spinach.
3. **Chocolate Covered Strawberries**: Delicious and indulgent dessert.
4. **Lemon Pound Cake**: A classic dessert for any occasion.
5. **Greek Salad**: A light and refreshing salad with romaine lettuce, olives, and goat cheese.

## License

This project is open-source and available under the MIT License.

