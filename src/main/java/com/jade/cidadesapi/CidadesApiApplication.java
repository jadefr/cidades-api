package com.jade.cidadesapi;

import com.jade.cidadesapi.model.City;
import com.jade.cidadesapi.repository.CityRepository;
import com.jade.cidadesapi.model.CityReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CidadesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CidadesApiApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CityRepository repository) {
        return args -> {
            repository.deleteAll();
            List<City> listFromCsv = new CityReader().setData();

            for (City city : listFromCsv) {
                repository.save(city);
            }
        };
    }
}
