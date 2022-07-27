package com.author.repository.impl;

import com.author.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository implements com.author.repository.StudentRepository {
    private static Map<Long, Student> map;

    static {
        map = new HashMap<>();
        map.put(1l, new Student(1l, "小明", 13));
        map.put(2l, new Student(2l, "张三", 14));
        map.put(3l, new Student(3l, "李四", 15));
        map.put(4l, new Student(4l, "小红", 16));
    }

    @Override
    public void save(Student student) {
        map.put(student.getId(), student);
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public void update(Student student) {
        map.put(student.getId(), student);
    }

    @Override
    public Collection<Student> findAll() {
        return map.values();
    }

    @Override
    public Student findById(Long id) {
        return map.get(id);
    }
}
