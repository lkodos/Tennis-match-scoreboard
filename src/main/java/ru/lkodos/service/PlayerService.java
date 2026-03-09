package ru.lkodos.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import ru.lkodos.dao.PlayerRepository;
import ru.lkodos.entity.Player;
import ru.lkodos.config.JpaUtil;

@RequiredArgsConstructor
public class PlayerService {

//    private final PlayerRepository playerRepository;

    public void createMatch(Player player1, Player player2) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try (em) {
            transaction.begin();
            PlayerRepository playerRepository = new PlayerRepository(em);
            playerRepository.save(player1);
            playerRepository.save(player2);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
