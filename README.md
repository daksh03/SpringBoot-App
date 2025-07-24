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

# Difference between @Controller and @RestController

| Feature                         | @Controller                                                        | @RestController                                              |
|---------------------------------|--------------------------------------------------------------------|--------------------------------------------------------------|
| Definition / Usage              | Marks a class as a Spring MVC controller (returns views/templates) | Combines `@Controller` + `@ResponseBody` (returns data directly) |
| Application                     | Traditional web applications with server-side rendered views       | RESTful APIs returning JSON/XML                              |
| Request Mapping & Handling      | Use `@RequestMapping` (or its variants) to map URLs to handler methods; handlers typically return view names | Use `@RequestMapping` (and HTTP-specific shortcuts) to map URLs to handler methods; return values are written directly to the response body |

# Dependency Injection and Its Types

Dependency Injection (DI) is a design pattern that enables loosely coupled components. In DI, an object’s ability to complete a task depends on another object.

## Types of Dependency Injection

| Type                  | Description                                                                                       |
|-----------------------|---------------------------------------------------------------------------------------------------|
| Constructor Injection | The dependency is provided through the dependent class’s constructor. This is the most common DI type in Spring Boot. |
| Setter Injection      | The dependency is provided through a setter method on the dependent class after instantiation.   |
| Field Injection       | The dependency is injected directly into a class field (usually via reflection, e.g. `@Autowired`). |

# Difference between Constructor Injection and Setter Injection

| Feature               | Constructor Injection                                               | Setter Injection                                                            |
|-----------------------|---------------------------------------------------------------------|------------------------------------------------------------------------------|
| Dependency            | Dependencies are provided through constructor parameters.          | Dependencies are set through setter methods after object creation.          |
| Immutability          | Promotes immutability as dependencies are set at creation.         | Dependencies can be changed dynamically after object creation.              |
| Dependency Overriding | Harder to override dependencies with different implementations.    | Allows easier overriding of dependencies using different setter values.     |

# Differences between JPA and Hibernate

| Feature                     | JPA                                                                    | Hibernate                                                         |
|-----------------------------|------------------------------------------------------------------------|-------------------------------------------------------------------|
| Package                     | javax.persistence                                                      | org.hibernate                                                     |
| Role                        | Java specification for handling relational data in Java applications   | Object-Relational Mapping (ORM) tool for persisting Java objects  |
| Nature                      | Standard API (only a specification, no implementation)                 | Concrete implementation of the JPA specification                  |
| Database Operations & Mapping | Defines CRUD operations and mapping Java data types to SQL tables     | Provides advanced mapping, caching and direct DB access beyond JPA |
| Query Language              | Java Persistence Query Language (JPQL)                                 | Hibernate Query Language (HQL)                                    |

## 🚀 Spring Boot Caching Overview

Spring Boot simplifies caching with powerful annotations that handle common caching tasks declaratively.

---

### 🔧 Caching Annotations in Spring Boot

| Annotation     | Purpose                                                                 |
|----------------|-------------------------------------------------------------------------|
| `@Cacheable`   | Caches the result of a method. If the method is called with the same parameters, the cached result is returned instead of executing the method again. |
| `@CachePut`    | Updates the cache with the method’s result, even if the result already exists in the cache. |
| `@CacheEvict`  | Removes data from the cache. It can be used for clearing caches after an update or delete operation. |

---

```java
@Cacheable("users")
public User getUserById(Long userId) {
    System.out.println("Fetching user from database...");
    return userRepository.findById(userId).orElse(null);
}
```

```java
@CachePut(value = "users", key = "#user.id")
public User updateUser(User user) {
    System.out.println("Updating user and refreshing cache...");
    return userRepository.save(user);
}
```

```java
@CacheEvict(value = "users", key = "#userId")
public void deleteUser(Long userId) {
    System.out.println("Deleting user from database and clearing cache...");
    userRepository.deleteById(userId);
}
```
