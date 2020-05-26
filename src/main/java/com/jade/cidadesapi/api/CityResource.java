package com.jade.cidadesapi.api;

import com.jade.cidadesapi.model.City;
import com.jade.cidadesapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/cidades")
public class CityResource {

    private final CityService cityService;

    @Autowired
    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }


    /**
     * get all
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }


    /**
     * get city by id
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public City getCityById(@PathVariable("id") String id) {
        return cityService.getCityById(id);
    }


    /**
     * insert city
     */
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewCity(@RequestBody City city) {
        cityService.persistNewCity(city.getIbge_id(), city);
    }


    /**
     * update city
     */
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public void updateCity(@PathVariable("id") String id, @RequestBody City city) {
        cityService.updateCityById(city.getIbge_id(), city);
    }


    /**
     *  delete city
     */
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteStudent(@PathVariable("id") String id) {
        cityService.deleteCityById(id);
    }
}
