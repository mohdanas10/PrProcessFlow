package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.City;
import com.PrProcessFlow.PrProcessFlow.Services.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class CityController {

    @Autowired
    private CityServices cityServices;

    @PostMapping("/add-city")
    public String addCity(@RequestBody City city) {
        System.out.println("City Added ");
        return this.cityServices.addCity(city);
    }

    @GetMapping("/get-cities")
    public List<City> getCities() {
        return  this.cityServices.getAllCities();
    }

}
