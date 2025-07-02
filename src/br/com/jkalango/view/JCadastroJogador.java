package br.com.jkalango.view;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.jkalango.dto.NovoJogador;
import br.com.jkalango.service.JogadorApiClient;

import javax.swing.JButton;

//extends é herança
public class JCadastroJogador extends JFrame{
    //Construtor inicializa os componentes do formulário

    private JTextField txtNickName;
    private JLabel lblNickName;
    public JCadastroJogador(){
       //Título da Janela 
       setTitle("Faça parte do JKalango!");
       //Garante que a aplicação não seja finalizada
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
       //tamanho
       setSize(400,450);
       //posição ao centro
       setLocationRelativeTo(null);
       setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
       JLabel lblNome = new JLabel("Nome:");
       JTextField txtNome = new JTextField(20);
       //'JPasswordField
       add(lblNome);
       add(txtNome);

       // NickName
        lblNickName = new JLabel("NickName:");
        lblNickName.setBounds(34, 90, 80, 16); // Ajuste a posição (Y)
        panel.add(lblNickName);

        txtNickName = new JTextField();
        txtNickName.setBounds(120, 85, 200, 26); // Ajuste a posição (Y)
        panel.add(txtNickName);
        txtNickName.setColumns(10);

       JButton btnCadastrar = new JButton("Cadastrar");
       btnCadastrar.addActionListener(new ActionListener(){
       
       String nome = txtNome.getText();  
       @Override
    public void actionPerformed(ActionEvent e) {
        // Crie um objeto com os dados do jogador a partir do formulário
        NovoJogador novoJogador = new NovoJogador(
            txtNome.getText(),
            txtNickName.getText() // <-- Coletando o novo campo
        );

        try {
            JogadorApiClient apiClient = new JogadorApiClient();
            NovoJogador novojogadorCadastrado = apiClient.cadastrarJogador(novoJogador);

            if (novojogadorCadastrado != null) {
                JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso!");
                dispose(); // Fecha a janela de cadastro
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar jogador.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de comunicação com o servidor.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
});
       setVisible(true);
       add(btnCadastrar);
    }
    
}