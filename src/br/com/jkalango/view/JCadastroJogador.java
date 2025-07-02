package br.com.jkalango.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// Importe as classes DTO e Service que você está usando
import br.com.jkalango.dto.NovoJogador;
import br.com.jkalango.service.JogadorApiClient;

public class JCadastroJogador extends JFrame {

    // 1. Declare TODOS os componentes da tela como campos da classe
    private JTextField txtNome;
    private JTextField txtNickName;
    private JButton btnCadastrar;

    /**
     * Construtor que inicializa e monta os componentes do formulário.
     */
    public JCadastroJogador() {
        // --- Configurações da Janela ---
        setTitle("Faça parte do JKalango!");
        setSize(300, 200); // Ajustei o tamanho para o FlowLayout
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // 2. Configure o Layout Manager
        // FlowLayout organiza os componentes um após o outro.
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // --- Inicialização dos Componentes ---

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20); // 'txtNome' agora é um campo da classe

        // NickName
        JLabel lblNickName = new JLabel("NickName:");
        txtNickName = new JTextField(20); // 'txtNickName' agora é um campo da classe

        // Botão
        btnCadastrar = new JButton("Cadastrar");

        // --- Adicionando os Componentes na Janela (na ordem que devem aparecer) ---
        // 3. Removi todas as referências ao 'panel' e 'setBounds'
        add(lblNome);
        add(txtNome);
        add(lblNickName);
        add(txtNickName);
        add(btnCadastrar);

        // --- Lógica do Botão ---
        // 4. Corrigi o ActionListener
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String nickname = txtNickName.getText();
        
                // 1. VALIDAÇÃO MOVIDA PARA O LUGAR CORRETO (A TELA)
                if (!nome.toLowerCase().contains("java")) {
                    JOptionPane.showMessageDialog(
                        JCadastroJogador.this, 
                        "O nome do jogador precisa conter a palavra 'java'.", 
                        "Regra de Cadastro", 
                        JOptionPane.ERROR_MESSAGE
                    );
                    return; // Para a execução do método aqui se a regra não for atendida
                }
        
                // 2. A CRIAÇÃO DO OBJETO AGORA FUNCIONA, POIS O CONSTRUTOR ESTÁ CORRETO
                NovoJogador novoJogador = new NovoJogador(nome, nickname);
        
                try {
                    JogadorApiClient apiClient = new JogadorApiClient();
                    // O código para chamar a API continua o mesmo
                    NovoJogador jogadorCadastrado = apiClient.cadastrarJogador(novoJogador);
        
                    if (jogadorCadastrado != null) {
                        JOptionPane.showMessageDialog(JCadastroJogador.this, "Jogador cadastrado com sucesso!");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(JCadastroJogador.this, "Erro ao cadastrar jogador.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(JCadastroJogador.this, "Erro de comunicação com o servidor.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 5. Deixe o 'setVisible(true)' como a última instrução
        setVisible(true);
    }
}