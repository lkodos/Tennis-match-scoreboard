package ru.lkodos.dao;

import jakarta.persistence.EntityManager;
import ru.lkodos.entity.Player;

public class PlayerRepository extends BaseRepository<Integer, Player> {

    public PlayerRepository(EntityManager em) {
        super(em, Player.class);
    }
}