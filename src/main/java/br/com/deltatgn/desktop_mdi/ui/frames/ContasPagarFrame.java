package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class ContasPagarFrame extends JInternalFrame {

    public ContasPagarFrame() {
        super("Contas a Pagar", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de Contas a Pagar"));
    }

}
