package iti.hadeer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
    public SessionFactory getSessionFactory(){
        String configFile = "hibernate.cfg.xml";
        return new Configuration().configure(configFile).buildSessionFactory();
    }
}
