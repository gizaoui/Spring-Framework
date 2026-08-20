package com.ex15.repository;

import java.util.Map;

public interface DataProcessingRepository<T> {

    public void save(T t);

    public T findById(Long id);

    public Map<Long, T> all();
}
