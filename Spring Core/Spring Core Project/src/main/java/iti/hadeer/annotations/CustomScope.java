package iti.hadeer.annotations;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;


public class CustomScope implements ScopeMetadataResolver{

    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
        System.out.println("Scope resolver");
        ScopeMetadata scopeMetadata = new ScopeMetadata();
        System.out.println(definition.getBeanClassName());
        if(definition.getBeanClassName().equals("iti.hadeer.annotations.MyService")){
            scopeMetadata.setScopeName("prototype");
        }
        return scopeMetadata;
    }
    
}
