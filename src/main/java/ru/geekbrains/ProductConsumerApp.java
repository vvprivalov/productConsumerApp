package ru.geekbrains;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.Context;
import ru.geekbrains.entity.Consumer;
import ru.geekbrains.entity.Product;
import ru.geekbrains.services.FindData;

import java.util.List;

public class ProductConsumerApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Context.class);

//        ProductDAO productDAO = context.getBean("ProductDAO", ProductDAO.class);
//        ConsumerDAO consumerDAO = context.getBean("ConsumerDAO", ConsumerDAO.class);

        FindData findData = context.getBean(FindData.class);

//        Consumer consumerByIdProduct = findData.findConsumerById(2);
//        System.out.println(consumerByIdProduct);
//        List<Product> productsByIdConsumer = findData.findProductsByIdConsumer(2);
//        System.out.println(productsByIdConsumer);
        Product product = findData.findProductById(1);
        System.out.println(product);
        List<Consumer> consumersByIdProduct = findData.findConsumersByIdProduct(1);
        System.out.println(consumersByIdProduct);
    }
}
