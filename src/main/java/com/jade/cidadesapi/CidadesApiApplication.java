package com.jade.cidadesapi;

import com.jade.cidadesapi.model.City;
import com.jade.cidadesapi.repository.CidadeRepository;
import com.jade.cidadesapi.service.CsvReader;
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
    CommandLineRunner init(CidadeRepository repository) {
        return args -> {
            repository.deleteAll();
            repository.
                    save(new City(
                            "5", "city_name", "city_uf", "false", "longitute", "latitude", "no_accents", "alt_names", "micro", "meso"
                    ));

            List<City> listFromCsv = new CsvReader().setData();

            for (City city: listFromCsv) {
                repository.save(city);
            }
        };
    }
}
