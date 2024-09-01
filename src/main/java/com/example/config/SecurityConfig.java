/*
 * package com.example.config; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity;
 * 
 * import org.springframework.security.core.userdetails.User;
 * 
 * import org.springframework.security.core.userdetails.UserDetails;
 * 
 * import org.springframework.security.core.userdetails.UserDetailsService;
 * 
 * import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * 
 * import org.springframework.security.crypto.password.NoOpPasswordEncoder;
 * 
 * import org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * 
 * 
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * public class SecurityConfig {
 * 
 * 
 * 
 * 
 * @Bean
 * 
 * public PasswordEncoder passwordEncoder() {
 * 
 * // Use NoOpPasswordEncoder for plain text passwords (not recommended for
 * production)
 * 
 * return NoOpPasswordEncoder.getInstance();
 * 
 * }
 * 
 * 
 * 
 * 
 * @Bean
 * 
 * public UserDetailsService userDetailsService() {
 * 
 * return new UserDetailsService() {
 * 
 * @Override
 * 
 * public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * 
 * // Replace this with your logic to load user details from the database
 * 
 * if ("user".equals(username)) {
 * 
 * return User.withUsername("user")
 * 
 * .password("password") // Provide the plain text password here
 * 
 * .roles("USER")
 * 
 * .build();
 * 
 * } else {
 * 
 * throw new UsernameNotFoundException("User not found with username: " +
 * username);
 * 
 * }
 * 
 * }
 * 
 * };
 * 
 * }
 * 
 * }
 * 
 * 
 */