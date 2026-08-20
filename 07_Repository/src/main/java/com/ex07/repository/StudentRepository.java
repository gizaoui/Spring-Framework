package com.ex07.repository;

import java.util.HashMap;
import java.util.Map;

import com.ex07.entity.Student;

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
