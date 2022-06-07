package ru.geekbrains;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.Context;
import ru.geekbrains.services.FindData;

public class ProductConsumerApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Context.class);

//        ProductDAO productDAO = context.getBean("ProductDAO", ProductDAO.class);
//        ConsumerDAO consumerDAO = context.getBean("ConsumerDAO", ConsumerDAO.class);

        FindData findData = context.getBean("FindData", FindData.class);
        System.out.println(findData.findConsumerByIdProduct(1));
        System.out.println(findData.findProductByIdConsumer(3));
    }
}
