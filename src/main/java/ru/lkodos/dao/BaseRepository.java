package ru.lkodos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseRepository<K extends Serializable, E> implements Repository<K, E> {

    private final EntityManager em;
    private final Class<E> clazz;

    @Override
    public E save(E entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public void delete(K id) {

    }

    @Override
    public void update(E entity) {

    }

    @Override
    public Optional<E> findById(K id) {
        return Optional.empty();
    }

    @Override
    public List<E> findAll() {
        return List.of();
    }


}
