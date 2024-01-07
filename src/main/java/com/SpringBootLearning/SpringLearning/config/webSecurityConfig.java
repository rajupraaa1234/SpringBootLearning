package com.SpringBootLearning.SpringLearning.config;


import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
@Configuration
@EnableMethodSecurity   // to enable PreAuthorize annotation we need to add EnableMethodSecurity annotation.
public class webSecurityConfig {
    private static final String[] WHITE_LIST_URLS = {
            "/register"
    };
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }


    // Here we can define the role of user .
    // For example i have defined 2 role Normal & Admin with credential. Using this we can categories the api access. We just need to
    // add the PreAuthorize Annotation with role.
     @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normalUser = User
                .withUsername("raju")
                .password(passwordEncoder().encode("password"))
                .roles("NORMAL")
                .build();

        UserDetails adminUser = User
                .withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUser,adminUser);
        return inMemoryUserDetailsManager;
    }

    // Here we can define the accessibility of any Api .
    // we just need to mention the api end point in requestMatchers
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/register")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
                return http.build();

    }
}
