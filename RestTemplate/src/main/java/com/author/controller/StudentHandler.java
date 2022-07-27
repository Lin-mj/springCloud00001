package com.author.controller;

import com.author.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class StudentHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return restTemplate.getForEntity("http://localhost:8010/findAll", Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2() {
        return restTemplate.getForObject("http://localhost:8010/findAll", Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Long id) {
        return restTemplate.getForEntity("http://localhost:8010/findById/{id}", Student.class, id).getBody();
    }

    @GetMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://localhost:8010/findById/{id}", Student.class, id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        restTemplate.postForEntity("http://localhost:8010/save", student, null).getBody();
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        restTemplate.put("http://localhost:8010/update", student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        restTemplate.delete("http://localhost:8010/deleteById/{id}", id);
    }
}
