# SpringBoot-Application

The **@SpringBootApplication** annotation combines three annotations. Those three annotations are: @Configuration, @EnableAutoConfiguration, and @ComponentScan .

- `@AutoConfiguration` : This annotation automatically configuring beans in the class path and automatically scans the dependencies according to the application need.
- `@ComponentScan` : This annotation scans the components (@Component, @Service, etc.) in the package of annotated class and its sub-packages.
- `@Configuration` : This annotation configures the beans and packages in the class path.

## Features of Spring Boot:

- `Auto-configuration` - Spring Boot automatically configures dependencies by using @EnableAutoconfiguration annotation and reduces boilerplate code.
- `Spring Boot Starter POM` - These Starter POMs are pre-configured dependencies for functions like database, security, maven configuration etc.
` `Spring Boot CLI` (Command Line Interface) - This command line tool is generally for managing dependencies, creating projects and running the applications.
- `Actuator` - Spring Boot Actuator provides health check, metrics and monitors the endpoints of the application. It also simplifies the troubleshooting management.
- `Embedded Servers` - Spring Boot contains embedded servers like Tomcat and Jetty for quick application run. No need of external servers.

---

**@PathVariable** and **@RequestParam** are annotations in Spring Framework used to extract values from HTTP requests and pass them into controller methods. While they serve similar purposes, they are used in different scenarios.

@PathVariable
This annotation is used to extract values from the URI (path). It maps a variable in the URI to a method parameter.

Example:

java
@RestController
public class MyController {

    @GetMapping("/users/{userId}")
    public String getUserById(@PathVariable String userId) {
        return "User ID: " + userId;
    }
}
If a client sends a request to http://example.com/users/123, the value 123 will be assigned to the userId parameter.

It's used when the value is a part of the URL path (like /users/{userId}).

@RequestParam
This annotation is used to extract values from query parameters in the URL. It maps query parameters to method parameters.

Example:

java
@RestController
public class MyController {

    @GetMapping("/search")
    public String search(@RequestParam String query) {
        return "Search query: " + query;
    }
}
If a client sends a request to http://example.com/search?query=spring, the value spring will be assigned to the query parameter.

# Key Considerations:
Semantics:

Use @PathVariable when the value uniquely identifies a resource, such as an ID (/users/{userId}).

Use @RequestParam for optional parameters, filters, or search criteria (/search?query=example).

RESTful Design: REST APIs often use @PathVariable for clarity and alignment with REST principles, as it reflects the resource hierarchy (/categories/{id}/products/{id}).

Flexibility:

Both can technically achieve similar results, but @PathVariable is cleaner and more expressive for resource identification.

@RequestParam provides flexibility in handling optional parameters, defaults, or multiple filters.

## Basic Spring Boot Annotations

- `@SpringBootApplication`: This is the main annotation used to bootstrap a Spring Boot application. It combines three annotations: **@Configuration** , **@EnableAutoConfiguration** , and **@ComponentScan** . It is typically placed on the main class of the application.

- `@Configuration`: This annotation is used to indicate that a class contains configuration methods for the application context. It is typically used in combination with **@Bean** annotations to define beans and their dependencies.

- `@Component`: This annotation is the most generic annotation for any Spring-managed component. It is used to mark a class as a Spring bean that will be managed by the Spring container.

- `@RestController`: This annotation is used to define a RESTful web service controller. It is a specialized version of the **@Controller** annotation that includes the **@ResponseBody** annotation by default.
  
- `@RequestMapping`: This annotation is used to map HTTP requests to a specific method in a controller. It can be applied at the class level to define a base URL for all methods in the class, or at the method level to specify a specific URL mapping.

##  Disable a specific auto-configuration class?
To disable a specific auto-configuration class in a Spring Boot application, we can use the **@EnableAutoConfiguration** annotation with the " exclude" attribute.

```
@EnableAutoConfiguration(exclude = {//classname})
```

##  Flow of HTTPS requests through the Spring Boot application.

![image](https://github.com/user-attachments/assets/0b5c9f52-f45e-4df9-a970-990fb82e3437)
