package iti.hadeer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    
    // @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public String createNewUser(Model model){
        model.addAttribute(new User());
        return "formView";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result){
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            modelAndView.setViewName("formView");
            return modelAndView;
        }
        else{
        System.out.println(user.name);
        modelAndView.addObject("msg", "hello"+user.name);
        modelAndView.setViewName("Hello");
        return modelAndView;
        }
    }
}
