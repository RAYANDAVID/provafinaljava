package br.com.jkalango.dto;

import javax.swing.JOptionPane;

public class NovoJogador {
    private String nome;
    
    public NovoJogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void verificarJava(){
        if (getNome().toLowerCase().contains("java")) {
            JOptionPane.showMessageDialog(null,"Jogador cadastrado com sucesso!");
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "Jogador Não pode ser Cadastrado, precisa conter 'java' no nome.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
