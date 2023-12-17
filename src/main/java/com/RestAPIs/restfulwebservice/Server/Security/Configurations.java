package com.RestAPIs.restfulwebservice.Server.Security;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // ! to use @PreAuthorize

public class Configurations {
    private final PasswordEncoder passwordEncoder; // Configration take place to use BCrypt

    // @Autowired
    public Configurations(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf -> csrf.disable())) // ! to use POST,PATCH,DELETE without

                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/", "index").permitAll()

                        .requestMatchers("/noLimit/**").hasRole(theRoles.USER.name())

                        .anyRequest().authenticated())
                .httpBasic(t -> {
                });

        return http.build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails abouromia = User.builder()
                .username("abouromia")
                .password(passwordEncoder.encode("abouromia")) // ! Password Must be Encoded
                .authorities(theRoles.USER.getGrandtedAuthorties())
                .build();
        UserDetails theAdmin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .authorities(theRoles.ADMIN.getGrandtedAuthorties())

                .build();
        UserDetails theAdminTrainee = User.builder()
                .username("tren")
                .password(passwordEncoder.encode("tren"))
                .authorities(theRoles.ADMINTRAINEE.getGrandtedAuthorties())

                .build();
        return new InMemoryUserDetailsManager(abouromia, theAdmin, theAdminTrainee);

    }
}
