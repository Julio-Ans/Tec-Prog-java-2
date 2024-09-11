package br.edu.fatecpg.series.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Serie(
    @JsonAlias("Title") String titulo,
    @JsonAlias("Runtime") String duracao,
    @JsonAlias("Country") String pais,
    @JsonAlias("Poster") String poster){

}
