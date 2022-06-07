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
public class ConsumerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ConsumerDAO(FactoryClass factoryClass) {
        this.sessionFactory = factoryClass.getFactory();
    }

    // Сохранение покупателя
    public void saveOrUpdate(Consumer consumer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(consumer);
        session.getTransaction().commit();
    }

    // Поиск покупателя по ID покупателя
    public Consumer findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Consumer consumer = session.get(Consumer.class, id);
        session.getTransaction().commit();
        return consumer;
    }

    // Поиск всех товаров, которые купил покупатель
    public List<Product> findProductsByIdConsumer(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Consumer consumer = session.get(Consumer.class, id);
        List<Product> productList = consumer.getProductList();
        session.getTransaction().commit();
        return productList;
    }

    // Удаление покупателя по ID покупателя
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Consumer consumer = session.get(Consumer.class, id);
        session.delete(consumer);
        session.getTransaction().commit();
        System.out.println("Покупатель с id " + id + " успешно удален");
    }

    // Получение всего списка продуктов из БД
    public List<Consumer> findByAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Consumer> consumerList;
        session.beginTransaction();
        consumerList = session.createQuery("FROM Consumer ", Consumer.class).getResultList();
        session.getTransaction().commit();
        return consumerList;
    }
}
