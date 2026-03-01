package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class ProdutosFrame extends JInternalFrame {

    public ProdutosFrame() {
        super("Cadastro de Produtos", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de Produtos"));
    }

}
