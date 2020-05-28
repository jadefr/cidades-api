package com.jade.cidadesapi.service;

import com.jade.cidadesapi.model.City;
import com.jade.cidadesapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }


    /**
     * insert city
     */
    public City addCity(City city) {
        return cidadeRepository.save(city);
    }


    /**
     * get all
     */
    public List<City> getAllCities() {
        return cidadeRepository.findAll();
    }


    /**
     * get by id
     */
    public Optional<City> findCityById(String id) {
        return cidadeRepository.findById(id);
    }


    /**
     * update
     */
    public void updateCityById(String id, City cityUpdate) {
        cidadeRepository.deleteById(id);
        cidadeRepository.save(cityUpdate);
    }


    /**
     * delete
     */
    public void deleteCity(String id) {
        cidadeRepository.deleteById(id);
    }


    /**
     * is capital
     */
    public boolean isCapital(String id) {
        City city = cidadeRepository.getOne(id);

        return city.getCapital().equals("true");
    }
}
