package br.com.jkalango.dto;

/**
 * DTO (Data Transfer Object) para carregar os dados de um novo jogador
 * da interface para o serviço. Esta classe deve conter apenas os dados.
 */
public class NovoJogador {
    private String nome;
    private String nickname; // Campo que estava faltando

    // Construtor padrão é uma boa prática para bibliotecas como Jackson
    public NovoJogador() {
    }

    /**
     * Construtor para criar um novo jogador com nome e nickname.
     * @param nome O nome do jogador.
     * @param nickname O apelido (nickname) do jogador.
     */
    public NovoJogador(String nome, String nickname) {
        this.nome = nome;
        this.nickname = nickname;
    }

    // Getters e Setters para todos os campos (essencial para o Jackson funcionar)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}