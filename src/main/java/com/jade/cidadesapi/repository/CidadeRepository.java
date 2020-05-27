package com.jade.cidadesapi.repository;

import com.jade.cidadesapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<City, String> {
}
