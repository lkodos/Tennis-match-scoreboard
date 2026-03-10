package ru.lkodos.service;

import ru.lkodos.entity.Player;
import ru.lkodos.repository.PlayerRepository;

public class CreateNewMatchService {

    private final PlayerRepository playerRepository = new PlayerRepository();

    public void createNewMatch(String name1, String name2) {
        playerRepository.save(Player.builder().name(name1).build());
        playerRepository.save(Player.builder().name(name2).build());
    }
}
