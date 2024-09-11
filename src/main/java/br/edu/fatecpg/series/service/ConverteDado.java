package br.edu.fatecpg.series.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDado implements IConverteDado{
    ObjectMapper mapper = new ObjectMapper();

    public <T>T obterDado(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json,(Class<T>) classe);
    }
}
