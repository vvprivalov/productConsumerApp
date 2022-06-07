package ru.geekbrains.beans;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Factory {
    private final SessionFactory factory;

    public Factory() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public SessionFactory getFactory() {
        return factory;
    }
}
