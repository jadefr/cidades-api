package com.jade.cidadesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class City {

    @Id
    private String ibge_id;

    private String name;
    private String uf;
    private String capital;
    private String lon;
    private String lat;
    private String no_accents;
    private String alternative_names;
    private String microregion;
    private String mesoregion;
}
