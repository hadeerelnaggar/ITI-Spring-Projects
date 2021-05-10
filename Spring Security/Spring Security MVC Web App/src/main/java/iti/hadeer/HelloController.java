package iti.hadeer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class HelloController {

    @GetMapping(value = {"/", "welcome**"})
    public ModelAndView welcomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Spring security hello world");
        modelAndView.addObject("message", "The welcome page");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @GetMapping("/admin**")
    public ModelAndView getAdminPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Admin page");
        modelAndView.addObject("message", "hello admin");
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout
    ,HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        if(error!=null)
            model.addObject("error",getErrorMessage(request,"SPRING_SECURITY_LAST_EXCEPTION"));
        if(logout!=null)
            model.addObject("msg","You've been logged out");
        model.setViewName("login");
        return model;
    }

    private Object getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error;
        if(exception instanceof BadCredentialsException)
            error = "Invalid username and password";
        if(exception instanceof LockedException)
            error = exception.getMessage();
        else
            error = "Invalid username and password!";
        return error;
    }

    @GetMapping("logout")
    public String logout(){
        return "/logout";
    }
    
}
