package ru.lkodos.repository;

import java.io.Serializable;

public interface Repository<K extends Serializable, E> {

    void save (E entity);
}
