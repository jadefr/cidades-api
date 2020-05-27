package com.jade.cidadesapi.service;

import com.jade.cidadesapi.model.City;
import com.jade.cidadesapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
//        cidadeRepository.save(new City(
//                "1", "city_name", "city_uf", "false", "longitute", "latitude", "no_accents", "alt_names", "micro", "meso"
//        ));
    }

    public City addCity(City city) {
        return cidadeRepository.save(city);
    }

    public List<City> getAllCities() {
        return cidadeRepository.findAll();
    }

    public Optional<City> findCityById(String id) {
        return cidadeRepository.findById(id);
    }

    public void deleteCity(String id) {
        cidadeRepository.deleteById(id);
    }

    public boolean isCapital(String id) {
        City city = cidadeRepository.getOne(id);

        return city.getCapital().equals("true");
    }
}
