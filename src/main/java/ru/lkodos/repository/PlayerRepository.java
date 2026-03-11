package ru.lkodos.repository;

import ru.lkodos.entity.Player;

import java.util.List;
import java.util.Optional;

public class PlayerRepository extends BaseRepository<Integer, Player> {

    public Optional<Player> getPlayerByName(String name) {
        List<Player> players = getEntityManager().createQuery("SELECT p FROM Player p WHERE p.name = :name", Player.class)
                .setParameter("name", name)
                .getResultList();
        return players.stream().findFirst();
    }
}