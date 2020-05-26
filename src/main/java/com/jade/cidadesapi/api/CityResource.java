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


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public City getCityById(@PathVariable("id") String id) {
        return cityService.getCityById(id);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewCity(@RequestBody City city) {
        cityService.persistNewCity(city.getIbge_id(), city);
    }
}
