package com.jade.cidadesapi.repository;

import com.jade.cidadesapi.model.City;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CityRepositoryImpl implements CityRepository {

    private final Map<String, City> database;

    public CityRepositoryImpl() {
        database = new HashMap<>();
        // fazer um for para inserir todos os dados in memory, com o put
        database.put("1", new City(
                "1", "city_name", "city_uf", "false", "longitute", "latitude", "no_accents", "alt_names", "micro", "meso"
        ));
    }

    @Override
    public int insertNewCity(String id, City city) {
        database.put(id, city);
        return 1;
    }

    @Override
    public City selectCityById(String id) {
        return database.get(id);
    }

    @Override
    public List<City> selectAllCities() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateCityById(String id, City cityUpdate) {
        database.put(id, cityUpdate);
        return 1;
    }

    @Override
    public int deleteCityById(String id) {
        database.remove(id);
        return 1;
    }
}

