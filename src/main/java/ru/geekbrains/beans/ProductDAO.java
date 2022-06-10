package ru.geekbrains.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.config.FactoryClass;
import ru.geekbrains.entity.Consumer;
import ru.geekbrains.entity.Product;

import java.util.List;

@Component

public class ProductDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDAO(FactoryClass factoryClass) {

        this.sessionFactory = factoryClass.getFactory();
    }

    // Сохранение продукта
    public void saveOrUpdate(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    // Поиск продукта по ID продукта
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    // Поиск всех покупателей, купивших этот продукт
    public List<Consumer> findConsumersByIdProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = (Product)session.createQuery("select p from Product p join p.consumerList where p.id=:param")
                .setParameter("param", id).getSingleResult();
        List<Consumer> consumers = product.getConsumerList();
        session.getTransaction().commit();
        System.out.println(product);
        return consumers;
    }
    // Удаление продукта по ID продукта
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        System.out.println("Продукт с id " + id + " успешно удален");
    }

    // Получение всего списка продуктов из БД
    public List<Product> findByAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> productList;
        session.beginTransaction();
        productList = session.createQuery("FROM Product ", Product.class).getResultList();
        session.getTransaction().commit();
        return productList;
    }
}
