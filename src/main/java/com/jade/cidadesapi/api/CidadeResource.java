package com.jade.cidadesapi.api;

import com.jade.cidadesapi.model.City;
import com.jade.cidadesapi.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/cidades")
public class CidadeResource {

    private final CidadeService cidadeService;

    @Autowired
    public CidadeResource(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }


    /**
     * get all
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<City> getAllCities() {
        return cidadeService.getAllCities();
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
        return cidadeService.findCityById(id)
                .orElse(null);
    }


    /**
     * is capital
     */
//    @GetMapping(path = "{id}")
//    public boolean isCityCapital(@PathVariable("id") String id) {
//        return cidadeService.isCapital(id);
//    }


    /**
     * create city
     */
    @PostMapping
    public City create(@RequestBody City city) {
        return cidadeService.addCity(city);
    }

}
