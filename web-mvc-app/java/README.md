Example Spring Boot MVC Application
===================================

The article: [http://kielczewski.eu/2014/04/spring-boot-mvc-application/](http://kielczewski.eu/2014/04/spring-boot-mvc-application/)

Also check out: [http://kielczewski.eu/2014/04/developing-restful-web-service-with-spring-boot/](http://kielczewski.eu/2014/04/developing-restful-web-service-with-spring-boot/)

Requirements
------------
* [Java Platform (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)

Quick start
-----------
1. `mvn package`
2. `java -jar target/example-spring-boot-mvc-1.0-SNAPSHOT.war`
3. Point your browser to [http://localhost:8080/user_list.html](http://localhost:8080/user_list.html)

Testing performace
-------------------

The application heapSize is limited to 50m and the RAM on docker container to 150m

	$ docker-compose up
	$ siege -v -c5 -t30s http://openjdk7.mageddo:9595/user_list.html
	

get docker container ram usage

	docker stats docker-container

