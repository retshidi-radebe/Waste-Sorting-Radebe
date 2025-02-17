# Waste Sorting

This project is a Spring Boot application that manages waste items. It uses H2 as an in-memory database and Swagger for API documentation.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Running the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using Maven:
   ```sh
   mvn spring-boot:run
   
The application will start on port 8081.

## Access H2 Database

- **Link**: [http://localhost:8081/h2-console](http://localhost:8081/h2-console)
- **DB URL**: `jdbc:h2:mem:demo`
- **User**: `radebe`

## Access Swagger

- **Link**: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

## API Endpoints

### WasteItem Controller

- **Create Waste Item**
  - **POST** `/wasteitems`
  - **Request Body**: `WasteItem`
  - **Response**: `WasteItem`

- **Get All Waste Items**
  - **GET** `/wasteitems`
  - **Response**: List of `WasteItem`

- **Get Waste Item by ID**
  - **GET** `/wasteitems/{id}`
  - **Path Variable**: `id`
  - **Response**: `WasteItem`

- **Update Waste Item by ID**
  - **PUT** `/wasteitems/{id}`
  - **Path Variable**: `id`
  - **Request Body**: `WasteItem`
  - **Response**: `WasteItem`

- **Delete Waste Item by ID**
  - **DELETE** `/wasteitems/{id}`
  - **Path Variable**: `id`
  - **Response**: `ResponseEntity`

- **Get Waste Items by Category Name**
  - **GET** `/wasteitems/category/{categoryName}`
  - **Path Variable**: `categoryName`
  - **Response**: List of `WasteItem`

## Configuration

The application configuration is located in the `application.properties` file.

```ini
server.port=8081

spring.h2.console.enabled=true
spring.datasource.platform=h2
spring.datasource.url=jdbc:h2:mem:demo
spring.datasource.username=radebe
spring.datasource.password=
spring.mvc.pathmatch.matching-strategy=ant_path_matcher

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

logging.level.org.hibernate.type=TRACE
