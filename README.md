# Features
* Limited support for Internationalization (no support on API yet)
* Auto-generated Springdoc Swagger UI accessed through /swagger-ui/index.html
* Spring boot packaging runtime is used (default Tomcat server bootstrapped)
* Uses Jib to build optimized docker images with command(requires running docker daemon): mvn compile jib:dockerBuild
