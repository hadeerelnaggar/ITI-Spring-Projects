package iti.hadeer;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
@Component
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    public void configureGlobal(DataSource dataSource, AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource).and();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/admin**").access("hasRole('ROLE_USER')")
        .and().logout().logoutUrl("/customlogout").deleteCookies("JSESSIONID").logoutSuccessUrl("/login?logout")
        .and().formLogin().loginPage("/login").usernameParameter("userName").passwordParameter("password").
        failureUrl("/login?error").loginProcessingUrl("/submitlogin")
        .and().sessionManagement().and().rememberMe().key("remember-me-key").rememberMeParameter("remember-me").tokenValiditySeconds(2547584);
        // .maximumSessions(2).maxSessionsPreventsLogin(true);
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springsecurityschema?autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        return dataSource;
    }

}
