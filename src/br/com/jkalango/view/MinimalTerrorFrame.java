package br.com.jkalango.view;

import javax.swing.*;
import java.net.URL; // Necessário para carregar a imagem de um link

public class MinimalTerrorFrame extends JFrame {

    // **SUBSTITUA PELA URL DIRETA DA SUA IMAGEM DE TERROR**
    // Ex: https://i.imgur.com/gK6n4V0.jpeg (garanta que seja um link direto)
    private static final String IMAGEM_URL = "C:\\Users\\professor\\Desktop\\jkalangoapp\\jkalangoconsole\\src\\br\\com\\jkalango\\view\\background.png";

    public MinimalTerrorFrame() {
        setTitle("Terror Simples"); // Título da janela
        setSize(800, 600); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no 'X'
        setLocationRelativeTo(null); // Centraliza a janela

        try {
            // Cria a URL a partir do link da imagem
            URL url = new URL(IMAGEM_URL);
            
            // Cria o ImageIcon a partir da URL
            ImageIcon icon = new ImageIcon(url);

            // Cria um JLabel com o ImageIcon e o adiciona diretamente ao frame
            // Com FlowLayout (padrão), a imagem ficará no tamanho original e centralizada.
            add(new JLabel(icon)); 
            
            System.out.println("Tentou carregar imagem: " + IMAGEM_URL);

        } catch (Exception e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
            // Em caso de erro, adiciona um JLabel simples com mensagem de erro
            add(new JLabel("Erro ao carregar imagem: " + e.getMessage()));
        }

        setVisible(true); // Torna a janela visível
    }

    public static void main(String[] args) {
        // Garante que a GUI seja criada na thread correta do Swing
        SwingUtilities.invokeLater(() -> new MinimalTerrorFrame());
    }
}