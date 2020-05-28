package com.jade.cidadesapi.api;

import com.jade.cidadesapi.model.City;
import com.jade.cidadesapi.model.CityNotFoundException;
import com.jade.cidadesapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

import static org.springframework.hateoas.server.core.WebHandler.linkTo;

@RestController
@RequestMapping("api/v2/cidades")
public class CityResource {

    private final CityService cityService;

    @Autowired
    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }



    /**
     * GET
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
     * GET
     * get city by id
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public EntityModel<City> getCityById(@PathVariable("id") String id) {
        return cityService.findCityById(id)
                .orElse(null);
    }


    /**
     * POST
     * insert city
     */
    @PostMapping
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }


    /**
     * PUT
     * update city
     */
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public void updateCity(@PathVariable("id") String id, @RequestBody City city) {
        cityService.updateCityById(id, city);
    }


    /**
     * DELETE
     * delete city
     */
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteCity(@PathVariable("id") String id) {
        cityService.deleteCity(id);
    }


    /**
     * GET
     * get a list of all cities that are capitals
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "capitais"
    )
    @ResponseBody
    public List<City> getCapitals() {
        return cityService.getCapitalList();
    }


    /**
     * GET
     * get a list of all cities that are capitals
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = {"capitais", "sort"}
    )
    @ResponseBody
    public List<City> getSortedCapitals(@RequestParam("sort") String sort) {
        System.out.println(sort);
        if (sort.equals("asc")) {
            return cityService.getAscendingCapitalList();
        }
        return cityService.getDescendingCapitalList();
    }


    /**
     * GET
     * get total amount of cities
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "total"
    )
    @ResponseBody
    public long getTotal() {
        return cityService.getTotalAmount();
    }
}
