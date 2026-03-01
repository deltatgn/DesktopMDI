package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class PessoasFrame extends JInternalFrame {

    public PessoasFrame() {
        super("Cadastro de Pessoas", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de Pessoas"));
    }

}
