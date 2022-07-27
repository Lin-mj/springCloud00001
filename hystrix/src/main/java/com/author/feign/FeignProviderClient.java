package com.author.feign;

import com.author.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider")
public interface FeignProviderClient {
    @GetMapping("/findAll")
    Collection<Student> findAll();

    @GetMapping("/index")
    String index();
}
