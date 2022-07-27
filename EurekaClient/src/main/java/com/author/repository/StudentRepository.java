package com.author.repository;


import com.author.entity.Student;

import java.util.Collection;

public interface StudentRepository {
    void save(Student student);

    void deleteById(Long id);

    void update(Student student);

    Collection<Student> findAll();

    Student findById(Long id);
}
