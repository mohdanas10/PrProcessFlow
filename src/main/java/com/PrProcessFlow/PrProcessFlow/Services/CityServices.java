package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.City;
import com.PrProcessFlow.PrProcessFlow.Repository.CityRepo;
import org.hibernate.annotations.ConcreteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServices {

    @Autowired
    private CityRepo cityRepo;

    public String addCity(City city) {

        City city1 = cityRepo.findByCityName(city.getCityName().trim());
        if (city1 == null) {
            this.cityRepo.save(city);
            return "City added successfully";
        }
        return "City already exists";

    }

    public List<City> getAllCities() {
        return this.cityRepo.findAll();
    }
}
