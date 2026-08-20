package com.ex16.repository;

import java.util.HashMap;
import java.util.Map;

import com.ex16.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements DataProcessingRepository<Student> {

    private final Map<Long, Student> repository;

    public StudentRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Student student) {
        repository.put(student.getId(), student);
    }

    @Override
    public Student findById(Long id) {
        return repository.get(id);
    }

    @Override
    public Map<Long, Student> all() {
        return repository;
    }

}