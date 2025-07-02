package br.com.jkalango.service;

import br.com.jkalango.util.DadosCadastroJogador;
import br.com.jkalango.util.Jogador;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Cliente HTTP para se comunicar com a API de Jogadores.
 * Esta classe é responsável por enviar as requisições de cadastro
 * para o backend Spring.
 */
public class JogadorApiClient {

    // URL base da sua API. Certifique-se de que a API esteja rodando neste endereço.
    private static final String BASE_URL = "http://localhost:8080";

    /**
     * Envia os dados de um novo jogador para o endpoint de cadastro da API.
     *
     * @param dados Os dados do jogador a serem cadastrados (nome, nickname, email, etc.).
     * @return Um objeto Jogador se o cadastro for bem-sucedido (status 200), ou null em caso de falha.
     * @throws IOException          Se ocorrer um erro de entrada/saída durante a comunicação.
     * @throws InterruptedException Se a operação for interrompida.
     */
    public Jogador cadastrarJogador(DadosCadastroJogador dados) throws IOException, InterruptedException {
        // Cria um cliente HTTP moderno
        HttpClient client = HttpClient.newHttpClient();

        // Cria um ObjectMapper para converter o objeto Java (DadosCadastroJogador) em uma string JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(dados);

        // Constrói a requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/novos-usuarios")) // Aponta para o novo endpoint
                .header("Content-Type", "application/json")   // Define o tipo de conteúdo como JSON
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)) // Define o método como POST e envia o corpo JSON
                .build();

        // Envia a requisição e obtém a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifica o código de status da resposta
        if (response.statusCode() == 200) {
            System.out.println("Cadastro realizado com sucesso via API!");
            // Como o novo controller retorna 'void' (vazio), não há um corpo de resposta para converter.
            // Apenas retornamos um novo objeto Jogador para sinalizar sucesso à interface gráfica.
            return new Jogador();
        } else {
            // Em caso de erro, imprime o status e o corpo da resposta para ajudar na depuração
            System.err.println("Falha no cadastro. Status: " + response.statusCode());
            System.err.println("Resposta do servidor: " + response.body());
            return null;
        }
    }
}