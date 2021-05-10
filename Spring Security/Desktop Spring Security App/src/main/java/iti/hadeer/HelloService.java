package iti.hadeer;

import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

public interface HelloService {
    // @Secured("ROLE_USER")
    @UserPermission
    public String sayHello(String name);

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public String sayHi(String name);

    @PermitAll
    // @RolesAllowed({"ROLE_ADMIN"})
    public void sayMyName(String name);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER') and #user.name.length() < 8")
    @PostAuthorize("returnObject.name.length() >1")
    // @PreAuthorize("permitAll()")
    public User confirm(User user);

    @PostFilter("filterObject.name.length() > 3")
    public List<User> getAllUsers(User user);
}
