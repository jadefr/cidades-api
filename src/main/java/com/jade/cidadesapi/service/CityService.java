package com.jade.cidadesapi.service;

import com.jade.cidadesapi.model.City;
import com.jade.cidadesapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    /**
     * insert city
     */
    public City addCity(City city) {
        return cityRepository.save(city);
    }


    /**
     * get all
     */
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }


    /**
     * get by id
     */
    public Optional<City> findCityById(String id) {
        return cityRepository.findById(id);
    }


    /**
     * update
     */
    public void updateCityById(String id, City cityUpdate) {
        cityRepository.deleteById(id);
        cityRepository.save(cityUpdate);
    }


    /**
     * delete
     */
    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }


    /**
     * get all capitals
     */
    public List<City> getCapitalList() {
        List<City> cityList = cityRepository.findAll();
        List<City> capitals = new ArrayList<>();

        for (City city: cityList) {
            if (city.getCapital().equals("true")) {
                capitals.add(city);
//                System.out.println(city.getName());
            }
        }

        return capitals;
    }


    /**
     * get capitals in ascending order
     */
    public List<City> getAscendingCapitalList() {
        List<City> capitals = getCapitalList();

        return capitals.stream()
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.toList());
    }


    /**
     * get capitals in descending order
     */
    public List<City> getDescendingCapitalList() {
        List<City> capitals = getCapitalList();

        return capitals.stream()
                .sorted(Comparator.comparing(City::getName).reversed())
                .collect(Collectors.toList());
    }


    /**
     * get total amount of records
     */
    public long getTotalAmount() {
        return cityRepository.count();
    }
}
