package com.jade.cidadesapi.repository;

import com.jade.cidadesapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * JpaRepository contains the full API of CrudRepository and PagingAndSortingRepository
 */
public interface CityRepository {


    City selectCityById(String id);

    int insertNewCity(String id, City city);

    List<City> selectAllCities();

    int updateCityById(String id, City cityUpdate);

    int deleteCityById(String id);

}

