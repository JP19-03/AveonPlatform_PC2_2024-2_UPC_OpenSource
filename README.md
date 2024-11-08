CRM Rating Service

This project is a Spring Boot application for managing product ratings in a CRM system.

Getting Started

Prerequisites
Before you begin, ensure you have the following tools installed:

- Java 17 or higher
- Maven 3.8.1 or higher

Building the Project
To build the project, run the following command:

mvn clean install

Running the Application
To run the application, use the following command:

mvn test

Project Structure
- src/main/java/com/aventon/platform/u202014511/crm: Contains the main application code.
- src/main/resources: Contains the application configuration files.
- src/test/java/com/aventon/platform/u202014511/crm: Contains the test code.

Key Classes

- Rating  
  Represents a product rating.

- CreateRatingCommand  
  Command to create a new rating.

- DuplicateRatingException  
  Exception thrown when a duplicate rating is detected.

- RatingCommandServiceImpl  
  Service implementation for handling rating commands.

Validation
- Email addresses are validated using the following annotations:
    - @Email
    - @NotBlank
    - @Size

- Enums are validated using a custom @ValidEnum annotation.

Reference Documentation
For further reference, please consider the following sections:
- Official Apache Maven documentation
- Spring Boot Maven Plugin Reference Guide

Create an OCI image
This project can be packaged into an OCI image. See the Maven documentation for more details.

Maven Parent Overrides
Due to Maven's design, elements are inherited from the parent POM to the project POM. While most of the inheritance is fine, it also inherits unwanted elements like <license> and <developers> from the parent. To prevent this, the project POM contains empty overrides for these elements. If you manually switch to a different parent and want the inheritance, you need to remove those overrides.

License
This project is licensed under the MIT License - see the LICENSE file for details.
