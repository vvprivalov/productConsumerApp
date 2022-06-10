package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.beans.ConsumerDAO;
import ru.geekbrains.beans.ProductDAO;
import ru.geekbrains.entity.Consumer;
import ru.geekbrains.entity.Product;

import java.util.List;

@Service
public class FindData {
    private final ConsumerDAO consumerDAO;
    private final ProductDAO productDAO;

    @Autowired
    public FindData(ConsumerDAO consumerDAO, ProductDAO productDAO) {
        this.consumerDAO = consumerDAO;
        this.productDAO = productDAO;
    }

    public Product findProductById(int id) {

        return productDAO.findById(id);
    }

    public List<Product> findProductsByIdConsumer(int id) {

        return consumerDAO.findProductsByIdConsumer(id);
    }


    public Consumer findConsumerById(int id) {

        return consumerDAO.findById(id);
    }

    public List<Consumer> findConsumersByIdProduct(int id) {

        return productDAO.findConsumersByIdProduct(id);
    }
}
