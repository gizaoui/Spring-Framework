package com.ex08.repository;

public interface DemoRepository<T> {
    
    void save(T t);

    T findStudentById(Long id);
}
