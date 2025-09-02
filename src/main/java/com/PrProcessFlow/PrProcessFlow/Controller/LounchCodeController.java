package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.LounchCode;
import com.PrProcessFlow.PrProcessFlow.Services.LounchCodeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*")
public class LounchCodeController {

    @Autowired
    private LounchCodeServices lounchCodeServices;

    @PostMapping("/add-lounch-code")
    public String addLounchCode(@RequestBody LounchCode lounchCode) {
        return this.lounchCodeServices.addLounchCode(lounchCode);
    }
}
