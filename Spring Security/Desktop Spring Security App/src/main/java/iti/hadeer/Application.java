package iti.hadeer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

public class Application {
    String userName = "hadeer";
    String password = "123";
    ApplicationContext applicationContext;

    public Application() {
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        try {
            UsernamePasswordAuthenticationToken authenticationToken = createUsernamePasswordAuthenticationToken(
                    userName, password);
            Authentication authentication = authenticate(authenticationToken);
            setSecurityContext(authentication);
        } catch (BadCredentialsException e) {
            System.out.println("Not Authenticated");
            return;
        }
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        try {
            System.out.println(helloService.sayHello("hadeer"));
            System.out.println(helloService.sayHi("hadeer"));
            helloService.sayMyName("name");
            User user = new User();
            user.setName("hhh");
            helloService.confirm(user);
            List<User> users = helloService.getAllUsers(user);
            System.out.println("Users list:");
            users.forEach((userr) -> {
                System.out.println(user.name);
            });
        } catch (AccessDeniedException e) {
            System.out.println("Not Authorized");
        }

    }

    private void setSecurityContext(Authentication authentication) {
        SecurityContextImpl securityContextImpl = new SecurityContextImpl(authentication);
        SecurityContextHolder.setContext(securityContextImpl);
    }

    private Authentication authenticate(UsernamePasswordAuthenticationToken authenticationToken) {
        AuthenticationManager authenticationManager = applicationContext.getBean(AuthenticationManager.class);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        return authentication;
    }

    private UsernamePasswordAuthenticationToken createUsernamePasswordAuthenticationToken(String userName2,
            String password2) {
        String[] roles = { "ROLE_USER", "ROLE_ADMIN" };
        List<GrantedAuthority> grantedAuthority = new ArrayList<>();
        for (String role : roles) {
            grantedAuthority.add(new SimpleGrantedAuthority(role));
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName2,
                password2, grantedAuthority);
        return authenticationToken;
    }

    public static void main(String[] args) {
        new Application();
    }

}
