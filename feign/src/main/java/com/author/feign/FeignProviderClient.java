package com.author.feign;

import com.author.entity.Student;
import com.author.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
@Component
@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {
    @GetMapping("/findAll")
    Collection<Student> findAll();

    @GetMapping("/index")
    String index();
}
