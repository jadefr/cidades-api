package com.jade.cidadesapi.service;

import com.jade.cidadesapi.model.City;

import com.jade.cidadesapi.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public int persistNewCity(String id, City city) {
        city.setIbge_id(id);
        return cityRepository.insertNewCity(id, city);
    }

    public City getCityById(String id) {
        return cityRepository.selectCityById(id);
    }

    public List<City> getAllCities() {
        return cityRepository.selectAllCities();
    }

    public int updateCityById(String id, City cityUpdate) {
        return cityRepository.updateCityById(id, cityUpdate);
    }

    public int deleteCityById(String id) {
        return cityRepository.deleteCityById(id);
    }

//    public int isCapital(String id) {
//        City city = getCityById(id);
//        if (city.getCapital().equals("true")) {
//            return 1;
//        }
//        return 0;
//    }
//
//    public List<City> getAllCapitals() {
//    }
}
