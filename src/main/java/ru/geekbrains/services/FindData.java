package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.beans.ConsumerDAO;
import ru.geekbrains.beans.ProductDAO;
import ru.geekbrains.entity.Consumer;
import ru.geekbrains.entity.Product;

import java.util.List;

@Component
public class FindData {
    private final ConsumerDAO consumerDAO;
    private final ProductDAO productDAO;

    @Autowired
    public FindData(ConsumerDAO consumerDAO, ProductDAO productDAO) {
        this.consumerDAO = consumerDAO;
        this.productDAO = productDAO;
    }

    public List<Product> findProductByIdConsumer(int id) {
        return consumerDAO.findById(id).getProductList();
    }

    public List<Consumer> findConsumerByIdProduct(int id) {
        return productDAO.findById(id).getConsumerList();
    }
}
