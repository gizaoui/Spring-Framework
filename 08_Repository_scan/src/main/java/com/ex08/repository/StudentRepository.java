package com.ex08.repository;

import java.util.HashMap;
import java.util.Map;

import com.ex08.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements DemoRepository<Student> {

    private final Map<Long, Student> repository;

    public StudentRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Student student) {
        repository.put(student.getId(), student);
    }

    @Override
    public Student findStudentById(Long id) {
        return repository.get(id);
    }
}
