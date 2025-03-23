package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {

        //Cria um cliente HTTP, que é quem vai mandar o pedido para o site/API.
        HttpClient client = HttpClient.newHttpClient();

        //Cria o pedido (requisição) para o endereço da API.
        HttpRequest request = HttpRequest.newBuilder()
                //Transforma o texto do link em um formato que o Java entende.
                .uri(URI.create(endereco))
                //Finaliza o pedido
                .build();
        //Aqui é criada a variável que vai guardar a resposta da API.
        HttpResponse<String> response = null;
        try {
            //Esse trecho envia o pedido com client.send() e espera a resposta.
            //O BodyHandlers.ofString() quer dizer que queremos a resposta como texto.
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body(); //Resposta da requisição em formato json
        return json;
    }
}

