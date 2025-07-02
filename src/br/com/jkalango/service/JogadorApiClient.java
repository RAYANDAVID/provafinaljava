package br.com.jkalango.service;
import java.io.IOException;
import java.net.http.HttpClient;// Crie este arquivo em um pacote como 'br.com.jkalango.service'




public class JogadorApiClient<Jogador> {

    // URL base da sua API de cadastro de jogadores
    // **ATENÇÃO: Substitua por a URL real da sua API!**
    private static final String API_BASE_URL = "http://localhost:8080/api/jogadores"; // Exemplo: porta 8080 para Spring Boot

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper; // Para serializar/deserializar JSON

    public JogadorApiClient() {
        this.httpClient = HttpClient.newBuilder().build();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Envia os dados de um novo jogador para a API via requisição POST.
     * @param jogador O objeto Jogador a ser cadastrado.
     * @return O objeto Jogador retornado pela API (com ID, por exemplo), ou null em caso de erro.
     * @throws IOException Se ocorrer um erro de I/O durante a requisição.
     * @throws InterruptedException Se a operação for interrompida.
     */
    public Jogador cadastrarJogador(Jogador jogador) throws IOException, InterruptedException {
        // 1. Converter o objeto Jogador para uma string JSON
        String requestBody = objectMapper.writeValueAsString(jogador);

        // 2. Criar a requisição HTTP POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL))
                .header("Content-Type", "application/json") // Informa que o corpo da requisição é JSON
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)) // Define o método POST e o corpo da requisição
                .build();

        // 3. Enviar a requisição e obter a resposta
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // 4. Verificar o código de status da resposta
        if (response.statusCode() == 201) { // 201 Created é o status comum para criação bem-sucedida
            System.out.println("Jogador cadastrado com sucesso! Resposta da API: " + response.body());
            // Opcional: Converter a resposta JSON da API de volta para um objeto Jogador
            return objectMapper.readValue(response.body(), Jogador.class);
        } else {
            System.err.println("Erro ao cadastrar jogador. Status: " + response.statusCode());
            System.err.println("Corpo da resposta de erro: " + response.body());
            // Lançar uma exceção ou retornar null, dependendo da sua estratégia de erro
            return null;
        }
    }
}