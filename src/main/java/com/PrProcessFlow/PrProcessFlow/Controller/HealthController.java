package com.PrProcessFlow.PrProcessFlow.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*")
public class HealthController {

    @GetMapping("/health")
    public String applicationHealth(){
        return "OK";
    }
}
