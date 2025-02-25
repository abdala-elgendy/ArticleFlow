# ArticleFlow API - Spring Boot Implementation

## Overview
**Article Flow**  provides a **robust backend** for a blogging platform, handling authentication, article management, user interactions, and more.

## Features
- **User Authentication & Authorization** (JWT-based security)
- **CRUD operations** for Articles, Comments, and Users
- **User Profiles & Followers system**
- **Favoriting Articles**
- **Tag-based Article Filtering**
- **RESTful API Design**
- **Spring Security Integration**
- **Redis Caching for Performance Optimization**

## Technologies Used
- **Java 17+**
- **Spring Boot 3**
- **Spring Security (JWT Authentication)**
- **Spring Data JPA (MySQL Database)**
- **Redis (Caching)**
- **Lombok**
- **Jackson (JSON Processing)**
- **MapStruct (DTO Mapping)**

## API Endpoints
### **User Management** (`/api/users`)
- `POST /post-user` - Create a new user
- `GET /{id}` - Get user details
- `PUT /{id}` - Update user
- `DELETE /{id}` - Delete user
- `GET /{userId}/articles` - Get user's articles
- `GET /{userId}/followers` - Get user's followers
- `GET /{userId}/profile` - Get user's profile

### **Authentication** (`/api/auth`)
- `POST /register` - Register a new user
- `POST /authenticate` - Authenticate and get JWT token
- `POST /refresh-token` - Refresh JWT token

### **Articles** (`/api/articles`)
- `GET /all` - Get all articles
- `GET /tag/{tagName}` - Get articles by tag
- `POST /create` - Create an article
- `GET /{id}` - Get article details
- `PUT /{id}` - Update an article
- `DELETE /{id}` - Delete an article (Admin only)
- `GET /{id}/comments` - Get article comments
- `GET /slug/{slug}` - Get article by slug
- `GET /{id}/author` - Get article author
- `POST /{articleId}/comment` - Add a comment
- `GET /search/{query}` - Search for articles

### **Favorites** (`/api/favorites`)
- `POST /{userId}/{articleId}` - Favorite an article
- `DELETE /{userId}/{articleId}` - Remove article from favorites
- `GET /{userId}` - Get user's favorite articles

## How to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/abdala-elgendy/ArticleFlow.git
   cd ArticleFlow
   ```
2. **Configure Database & Redis** (update `application.properties`)
   - Build the Docker image:
  ```sh
   docker build -t my-redis . 
  ```
  - Run the Docker container:
  ```sh
     docker run -d -p 6379:6379 --name redis-server my-redis
  ```
3. **Build & Run the Application**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
Contributing

Feel free to open issues and submit pull requests! 🚀

License

This project is licensed under the MIT License.

## Contributing
Feel free to open issues and submit pull requests! 🚀

## License
This project is licensed under the [MIT License](LICENSE).

