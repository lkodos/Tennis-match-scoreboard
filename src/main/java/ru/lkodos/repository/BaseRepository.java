package ru.lkodos.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import ru.lkodos.config.EntityManagerHolder;

import java.io.Serializable;

@RequiredArgsConstructor
public abstract class BaseRepository<K extends Serializable, E> implements Repository<K, E> {

    @Override
    public void save(E entity) {
        getEntityManager().persist(entity);
    }

    private EntityManager getEntityManager() {
        return EntityManagerHolder.get();
    }
}
