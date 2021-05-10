package iti.hadeer;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

public class MyHandlerMapping extends AbstractDetectingUrlHandlerMapping implements Ordered{

    @Override
    protected String[] determineUrlsForHandler(String beanName) {
        // System.out.println("ddddddddddddddddddddddddddddddddddd");
        String [] mappings = null;
        if(beanName.equals("helloController")){
            mappings = new String[2];
            mappings[0] = "/welcome";
            mappings[1] = "/hello";
        }
        return mappings;
    }
    
}
