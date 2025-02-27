package id.putra.movierspticket.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        /// These Spring Security using default configuration and some tweaking
        /// default REST API is not exposed to public
        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http, RoleAuthenticationHandler authenticationHandler)
                        throws Exception {
                http
                                .cors(Customizer.withDefaults())
                                .csrf(Customizer.withDefaults())
                                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                                                .requestMatchers("webjars/**", "/auth/**", "/error").permitAll()
                                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                                .requestMatchers("/user/**").hasRole("USER")
                                                .anyRequest().authenticated())
                                .formLogin(form -> form.successHandler(authenticationHandler))
                                .logout(Customizer.withDefaults())
                                .exceptionHandling(Customizer.withDefaults());
                return http.build();
        }

        @Bean
        UserDetailsManager userDetailsManager(DataSource dataSource) {
                JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
                userDetailsManager
                                .setUsersByUsernameQuery(
                                                "select username, password, is_enabled from users where username = ?");
                userDetailsManager
                                .setAuthoritiesByUsernameQuery(
                                                "select u.username, r.\"name\" from roles r left join users u on r.user_id = u.id where u.username = ?");
                return userDetailsManager;
        }
}
