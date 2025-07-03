# Features
* Multimodular build with maven inheritance. Each microservice can be separately built and deployed
* Uses Jib to build optimized docker images with command(requires running docker daemon): mvn jib:dockerBuild
* Spring boot packaging runtime is used (default Tomcat server bootstrapped)
* Limited support for Internationalization (no support on API yet)
* Auto-generated Springdoc Swagger UI accessed through /swagger-ui/index.html
