package br.com.jkalango.view; // Mantendo o mesmo pacote

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel; // Para organizar os componentes

import java.awt.BorderLayout; // Um bom layout para organizar áreas
import java.awt.Color;     // Para definir cores
import java.awt.Font;      // Para definir a fonte
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JIntro extends JFrame {
  
    
    public JIntro() {
    
        // --- Configurações do JFrame (Formulário) ---
        setTitle("JKalango: A Missão Começa"); // Título da janela
        setSize(700, 400); // Tamanho da janela (ajustado para a mensagem)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        ImageIcon backgroundImage = new ImageIcon("background.png");
        JLabel lblImg = new JLabel(backgroundImage);
        getLayeredPane().add(lblImg, JLayeredPane.DEFAULT_LAYER);
        // --- Definir o fundo Dark (ideia de filme de terror) ---
        // propriedades do JFrame
        getContentPane().setBackground(Color.BLACK); // O painel de conteúdo do JFrame

        // --- 1. Mensagem do JKalango ---
        JLabel mensagemLabel = new JLabel();
        // Usamos HTML para quebrar a linha e aplicar a cor branca e tamanho da fonte
        mensagemLabel.setText("<html><body style='text-align: center; color: white; font-family: \"Press Start 2P\", cursive; font-size: 10px; text-shadow: 1px 1px 2px black;'>"
                            + "Nas entranhas pútridas do **Cerrado Mágico**, outrora um Éden da **Orientação a Objetos**, agora jaz um domínio de pesadelo e **corrupção digital**. "
                            + "Você é **JKalango**, um resquício mutante de uma classe esquecida, com o último lampejo de pureza em seu ser. "
                            + "As outrora vibrantes **JFormigas** e **JAbelhinhas** foram diluídas em **monstros polimórficos e abstratos**, aberrações de código que rastejam por este plano distorcido. "
                            + "Cada **interface** se manifesta como um portão para o abismo, sussurrando promessas de loucura, enquanto **métodos destruídos** ecoam os lamentos de suas funções perdidas. "
                            + "Sua missão, se ousar aceitá-la, é navegar por este purgatório digital, confrontando os horrores da **aniquilação de dados** e do **esquecimento de instâncias**. "
                            + "Desvende os **mistérios corrompidos** antes que o próprio tecido da programação se desfaça, e o Cerrado Mágico se torne apenas mais um **loop infinito de terror**."
                            + "</body></html>");
        
        // Centraliza o texto horizontalmente dentro do JLabel
        mensagemLabel.setHorizontalAlignment(JLabel.CENTER);
        // Define a cor da fonte diretamente no HTML ou aqui para garantir
        mensagemLabel.setForeground(Color.WHITE); // Garante a cor branca da fonte
        // O tamanho da fonte já está no HTML, mas podemos setar um Font object se preferir um tipo específico
        mensagemLabel.setFont(new Font("Serif", Font.PLAIN, 16)); // Exemplo: fonte Serif, simples, tamanho 16

        // --- 2. Criar e Adicionar o JButton ---
        JButton iniciarMissaoButton = new JButton("Iniciar Primeira Missão");
        
        // Define a cor do texto do botão (opcional, mas complementa o tema)
        iniciarMissaoButton.setForeground(Color.WHITE);
        // Define a cor de fundo do botão (um cinza escuro para combinar com o tema)
        iniciarMissaoButton.setBackground(new Color(50, 50, 50)); // Um cinza bem escuro
        // Remove a borda padrão do botão (opcional, para um visual mais "limpo" de terror)
        iniciarMissaoButton.setFocusPainted(false); // Remove o "quadrado" de foco

        // --- 3. Adicionar ação ao botão ---
        iniciarMissaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JCadastroJogador();
                dispose();//libera recursos da JIntro.

              
            }
        });

        // --- Layout e Adição dos Componentes ---
        // Usamos BorderLayout para colocar a mensagem no centro e o botão no sul (parte inferior)
        setLayout(new BorderLayout()); // Define o gerenciador de layout do JFrame

        // Adiciona a mensagem ao centro
        add(mensagemLabel, BorderLayout.CENTER);

        // Cria um JPanel para o botão para que ele não ocupe toda a largura do BorderLayout.SOUTH
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY); // Fundo do painel do botão igual ao do JFrame
        buttonPanel.add(iniciarMissaoButton); // Adiciona o botão ao painel
        
        // Adiciona o painel do botão ao sul (parte inferior) do JFrame
        add(buttonPanel, BorderLayout.SOUTH);
        
        // --- Tornar o JFrame visível (sempre por último) ---
        setVisible(true);
    }

  
}
