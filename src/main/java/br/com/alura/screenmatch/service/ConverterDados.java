package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterDados implements IConverteDados {

    /**A classe ObjectMapper é parte do Jackson e é usada para fazer a serialização
     * e desserialização de objetos Java para JSON (e vice-versa). Em outras palavras,
     * é usada para converter objetos Java em strings JSON e strings JSON em objetos Java.*/
    private ObjectMapper mapper = new ObjectMapper();

    //É necessária a colocação "tipo <T>" em razão da não parametrização da Classe,
    // ou seja, está sendo parametrizado apenas o método obterDados()
    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            //Significa: Leia esse 'jason' e transforme nesta classe
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
