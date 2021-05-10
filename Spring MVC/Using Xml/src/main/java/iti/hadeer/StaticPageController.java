package iti.hadeer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.AbstractUrlViewController;
import org.springframework.web.util.UrlPathHelper;

public class StaticPageController extends AbstractUrlViewController{

    @Override
    protected String getViewNameForRequest(HttpServletRequest request) {
        String requestPath = new UrlPathHelper().getPathWithinApplication(request);
        System.out.println(requestPath); 
        return requestPath;
    }
    
}
