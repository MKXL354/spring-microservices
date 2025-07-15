# Features
* Multimodular build with maven inheritance. Each microservice can be separately built and deployed
* Uses Jib to build optimized docker images
* Spring boot packaging runtime is used (default Tomcat server bootstrapped)
* Limited support for Internationalization (no support on API yet)
* Auto-generated Springdoc Swagger UI accessed through /swagger-ui/index.html
* Uses unsecured and unrestricted actuator access (for now) for remote management
* Uses Feign client to connect to external APIs
* Returns Spring-style API error objects
* Can be configured to use Hashicorp Vault

# How To Use
* Each module is a microservice that can be independently built and depolyed
1. Navigate to each specific microservice folder
2. Use the following commands to clean/compile/package/run code:
```
mvn clean #To clear the target folders for fresh build
mvn compile #To compile the code
mvn package #To package the code as jar for execution/deployment
mvn springboot:run #To run the built files. refer to doc for specific args
```
3. Use the following command to create optimized docker image:
```
mvn jib:dockerBuild #Requires running daemon and availabe jar
mvn jib:build #Requires only the jar file
mvn clean package jib:dockerBuild #Can also be used as a compound command
```

* Note: You can also create the entire project and all the images by running maven commands in the parent module.

# Local Setup

in order to be able to run the dev profile locally and without docker compose, you need to pass the following
Environment
variables:

* SPRING_PROFILES_ACTIVE: "dev"
* SPRING_CONFIG_IMPORT: "configserver:http://localhost:8071"

of course this way all services must be started manually and in order:
Database -> Config Server -> Service Discovery -> Other Services...
