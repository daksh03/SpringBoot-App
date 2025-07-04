# SpringBoot-Application

The **@SpringBootApplication** annotation combines three annotations. Those three annotations are: @Configuration, @EnableAutoConfiguration, and @ComponentScan .

- `@AutoConfiguration` : This annotation automatically configuring beans in the class path and automatically scans the dependencies according to the application need.
- `@ComponentScan` : This annotation scans the components (@Component, @Service, etc.) in the package of annotated class and its sub-packages.
- `@Configuration` : This annotation configures the beans and packages in the class path.

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
