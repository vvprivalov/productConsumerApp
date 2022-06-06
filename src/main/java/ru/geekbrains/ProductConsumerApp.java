package ru.geekbrains;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductConsumerApp {

    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Context.class);

    }
}
