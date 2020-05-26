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


// JPA
    /*@Override
    public List<City> findAll() {
        return new ArrayList<>(database.values());
    }


    @Override
    public List<City> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<City> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(City city) {

    }

    @Override
    public void deleteAll(Iterable<? extends City> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends City> S save(S s) {
        return null;
    }

    @Override
    public <S extends City> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<City> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends City> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<City> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public City getOne(String s) {
        return null;
    }

    @Override
    public <S extends City> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends City> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends City> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends City> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends City> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends City> boolean exists(Example<S> example) {
        return false;
    }
*/
}
