# Spring Cloud Service Discovery and API Gateway example project

Minimal microservices topology that leverages:
* Spring Cloud Netflix for service registration and discovery (Eureka server)
* Spring Cloud Gateway provides simple and effective way to route to microservice exposed APIs
* Eureka discovery client used to register the service but also discover other services
* Spring Boot MVC used in exposing simple Rest endpoints

## Requirements

For building and running the application you need:

- [JDK 21](https://docs.oracle.com/en/java/javase/21/)
- [Gradle 8](https://gradle.org/)

## Running the services locally

This example contains four subprojects, one for each service:
- [Service Discovery](service-discovery)
- [API Gateway](api-gateway)
- [Sample Service 1](service-one)
- [Sample Service 2](service-two)

Each of the services can be run using Gradle by executing the `bootRun` task of that particular service, like so:

```shell
./gradlew :service-discovery:bootRun
```

# Resources

For further reference, please consider the following sections:

* [Spring Cloud Netflix](https://spring.io/projects/spring-cloud-netflix)
* [Spring Cloud Gateway](https://cloud.spring.io/spring-cloud-gateway)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/reference/spring-cloud-netflix.html#_service_discovery_eureka_clients)
* [Spring Boot](https://spring.io/projects/spring-boot)
