# Features
* Multimodular build with maven inheritance. Each microservice can be separately built and deployed
* Uses Jib to build optimized docker images
* Spring boot packaging runtime is used (default Tomcat server bootstrapped)
* Limited support for Internationalization (no support on API yet)
* Auto-generated Springdoc Swagger UI accessed through /swagger-ui/index.html

# How To Use
* Each module is a microservice that can be independently built and depolyed
* Docker compose instructions will be added later
1. Navigate to each specific microservice folder
2. Use the following commands to compile/package/run code:
```
mvn clean # to clear the target folders for fresh build
mvn compile # to compile the code
mvn package # to package the code as jar for execution/deployment
mvn springboot:run # to run the built files. refer to doc for specific args
```
3. Use the following command to create optimized docker image:
```
mvn jib:dockerBuild # requires running daemon and availabe jar
mvn jib:build # requires only the jar file
```
