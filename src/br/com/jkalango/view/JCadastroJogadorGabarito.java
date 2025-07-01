package br.com.jkalango.view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField; // Para o campo de senha
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane; // Para exibir mensagens ao usuário

public class JCadastroJogadorGabarito extends JFrame {

    public JCadastroJogadorGabarito() {
        // 1º) Configuração do formulário (JFrame)
        setTitle("Cadastro de Jogador - JKalango");
        setSize(400, 450); // Tamanho ajustado para acomodar mais campos
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Apenas fecha esta janela, não encerra o programa
        setLocationRelativeTo(null); // Centraliza na tela
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout mais organizado com espaçamento

        // 2º) Adicionar os campos de texto (JTextField) para os dados do jogador
        // Nome
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(30); // 30 colunas de largura
        add(lblNome);
        add(txtNome);

        // Nick Name
        JLabel lblNickName = new JLabel("Nick Name:");
        JTextField txtNickName = new JTextField(30);
        add(lblNickName);
        add(txtNickName);

        // Email
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(30);
        add(lblEmail);
        add(txtEmail);

        // Telefone
        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField(30);
        add(lblTelefone);
        add(txtTelefone);

        // Senha (usando JPasswordField para esconder a entrada)
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(30);
        add(lblSenha);
        add(txtSenha);

        // 3º) Adicionar o botão "Cadastrar"
        JButton btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        // 4º) Adicionar um evento ao botão de cadastrar
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pegaria os dados dos campos
                String nome = txtNome.getText();
                String nickName = txtNickName.getText();
                String email = txtEmail.getText();
                String telefone = txtTelefone.getText();
                // A senha precisa ser obtida como char[] e convertida para String para uso
                String senha = new String(txtSenha.getPassword());

                // Exemplo simples: exibir os dados em uma caixa de diálogo
                String mensagem = "Dados do Jogador:\n" +
                                  "Nome: " + nome + "\n" +
                                  "Nick Name: " + nickName + "\n" +
                                  "Email: " + email + "\n" +
                                  "Telefone: " + telefone + "\n" +
                                  "Senha: " + senha;
                JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this, mensagem, "Dados do Cadastro", JOptionPane.INFORMATION_MESSAGE);

                // *** Próximos passos (integração com banco de dados): ***
                // 1. Validar os dados (ex: campos não vazios, formato de email, etc.)
                // 2. Chamar um método em uma classe de serviço/DAO para salvar esses dados no banco de dados.
                //    Por exemplo: JogadorDAO.salvar(new Jogador(nome, nickName, email, telefone, senha));
                // 3. Lidar com o resultado do salvamento (sucesso/falha).
                // 4. Fechar esta janela após o cadastro bem-sucedido: dispose();
            }
        });

        // 5º) Mostrar o formulário - Deve ser o último passo no construtor
        setVisible(true);
    }
}