package ru.lkodos.test;

import jakarta.persistence.EntityManager;
import ru.lkodos.entity.Player;
import ru.lkodos.config.JpaUtil;

import java.util.Locale;

public class RunnerGet {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        try (EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager()) {

            em.getTransaction().begin();

            Player player = em.find(Player.class, 1L);

            if (player != null) {
                System.out.println("Player" + player);
            } else {
                System.out.println("NOT FOUND IN DB");
            }

            em.getTransaction().commit();
        }
    }
}
