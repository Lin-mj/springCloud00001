package com.author.controller;

import com.author.entity.Student;
import com.author.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Long id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        studentRepository.update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/index")
    public String index(){
        return "端口号为" + port;
    }
}
