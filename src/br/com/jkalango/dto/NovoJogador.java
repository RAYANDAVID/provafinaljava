package br.com.jkalango.dto;

import javax.swing.JOptionPane;

import br.com.jkalango.view.JCadastroJogador;

public class NovoJogador extends JCadastroJogador{

    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NovoJogador(String string){
        if (verifica(nome)) {
            this.nome = nome;
            JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Erro: O nome deve conter a palavra 'java' para ser cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean verifica(String nome) {
        return nome.toLowerCase().contains("java");
    }


}
