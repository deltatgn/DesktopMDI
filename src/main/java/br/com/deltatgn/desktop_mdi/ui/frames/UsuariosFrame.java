package br.com.deltatgn.desktop_mdi.ui.frames;

import br.com.deltatgn.desktop_mdi.persistence.model.Users;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuariosFrame extends JInternalFrame {

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JComboBox<String> cbPerfil;
    private JCheckBox chkAtivo;

    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnCancelar;

    private Users users;

    public UsuariosFrame() {
        super("Cadastro de Usuários", true, true, true, true);
        setSize(600, 400);
        setLayout(new BorderLayout());
        add(createFormPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> salvar());
        btnNovo.addActionListener(e -> limparFormulario());
        btnCancelar.addActionListener(e -> fechar());
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        txtId = new JTextField();
        txtId.setEditable(false);
        panel.add(txtId, gbc);

        // Nome
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        txtNome = new JTextField();
        panel.add(txtNome, gbc);

        // Login
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Login:"), gbc);

        gbc.gridx = 1;
        txtLogin = new JTextField();
        panel.add(txtLogin, gbc);

        // Senha
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        txtSenha = new JPasswordField();
        panel.add(txtSenha, gbc);

        // Perfil
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Perfil:"), gbc);

        gbc.gridx = 1;
        cbPerfil = new JComboBox<>();
        cbPerfil.addItem("Administrador");
        cbPerfil.addItem("Usuário");
        cbPerfil.addItem("Financeiro");
        cbPerfil.addItem("Vendas");

        panel.add(cbPerfil, gbc);

        // Ativo
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Ativo:"), gbc);

        gbc.gridx = 1;
        chkAtivo = new JCheckBox();
        chkAtivo.setSelected(true);

        panel.add(chkAtivo, gbc);

        return panel;
    }

    private JPanel createButtonPanel() {

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        btnCancelar = new JButton("Cancelar");

        panel.add(btnNovo);
        panel.add(btnSalvar);
        panel.add(btnEditar);
        panel.add(btnExcluir);
        panel.add(btnCancelar);

        return panel;
    }

    private void salvar() {
        users = new Users();

        // validação
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Informe o nome",
                    "Validação",
                    JOptionPane.WARNING_MESSAGE);

            txtNome.requestFocus();
            return;
        }

        users.setNome(txtNome.getText().trim().toUpperCase());

        System.out.println("Salvando usuário:");
        System.out.println("Nome: " + users.getNome());

        txtNome.setText(users.getNome());

    }

    private void fechar() {
        int opcao = JOptionPane.showConfirmDialog(
                this,
                "Deseja fechar esta janela?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcao == JOptionPane.YES_OPTION) {
            dispose(); // fecha o JInternalFrame
        }
    }

    private void limparFormulario() {
        txtId.setText("");
        txtNome.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        cbPerfil.setSelectedIndex(0);
        chkAtivo.setSelected(true);
        txtNome.requestFocus();
    }

}
