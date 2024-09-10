package tacos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig  {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager (){
        UserDetails user =  User.withDefaultPasswordEncoder()
                .username("adrian")
                .password("qwerty")
                .roles("ROLE_USER")
                .build();

        UserDetails user2 =  User.withDefaultPasswordEncoder()
                .username("david")
                .password("qwerty_2")
                .roles("ROLE_USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
