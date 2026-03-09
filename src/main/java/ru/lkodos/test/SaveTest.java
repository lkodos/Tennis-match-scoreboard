package ru.lkodos.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lkodos.dao.PlayerRepository;
import ru.lkodos.entity.Player;
import ru.lkodos.config.JpaUtil;

import java.util.Locale;

public class SaveTest {

    private static final Logger log = LoggerFactory.getLogger(SaveTest.class);

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

                em.getTransaction().begin();

                PlayerRepository playerRepository = new PlayerRepository(em);

                Player player = Player.builder()
                        .name("Arni1")
                        .build();

                playerRepository.save(player);

                em.getTransaction().commit();
        }
    }
}
