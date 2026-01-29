package ru.lkodos.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lkodos.entity.Player;

import java.util.Locale;

public class HibernateRunner {

    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            System.out.println("TEST OK");
            Player player = Player.builder()
                    .name("Arni1")
                    .build();

            session.persist(player);


            session.getTransaction().commit();
        }
    }
}
