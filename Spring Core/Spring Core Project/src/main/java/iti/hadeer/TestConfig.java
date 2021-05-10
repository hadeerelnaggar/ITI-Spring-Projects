package iti.hadeer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("testing")
@ImportResource("classpath:/annotationsbeans.xml")
public class TestConfig {
    
}
