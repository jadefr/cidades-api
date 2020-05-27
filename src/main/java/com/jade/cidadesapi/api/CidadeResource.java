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

//    private final CidadeRepository cidadeRepository;
//
//    public CidadeResource(CidadeRepository cidadeRepository) {
//        this.cidadeRepository = cidadeRepository;
//    }
//
//    @GetMapping
//    public List findAll() {
//        return cidadeRepository.findAll();
//    }
//
//    @GetMapping(path = {"/{id}"})
//    public ResponseEntity findById(@PathVariable String id) {
//        return cidadeRepository.findById(id)
//                .map(record -> ResponseEntity.ok().body(record))
//                .orElse(ResponseEntity.notFound().build());
//    }

    private final CidadeService cidadeService;

    @Autowired
    public CidadeResource(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }



    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<City> getAllCities() {
        return cidadeService.getAllCities();
    }



    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public City getCityById(@PathVariable("id") String id) {
        return cidadeService.findCityById(id)
                .orElse(null);
    }



    @GetMapping(path = "{id}")
    public boolean isCityCapital(@PathVariable("id") String id) {
        return cidadeService.isCapital(id);
    }


    @PostMapping
    public City create(@RequestBody City city) {
        return cidadeService.addCity(city);
    }

}
