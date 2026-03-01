package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class UsuariosFrame extends JInternalFrame {

    public UsuariosFrame() {
        super("Cadastro de Usuários", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de Usuários"));
    }

}
