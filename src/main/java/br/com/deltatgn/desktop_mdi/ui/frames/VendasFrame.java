package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class VendasFrame extends JInternalFrame {

    public VendasFrame() {
        super("Vendas", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de Vendas"));
    }

}
