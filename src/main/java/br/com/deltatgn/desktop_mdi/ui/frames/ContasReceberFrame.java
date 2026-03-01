package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class ContasReceberFrame extends JInternalFrame {

    public ContasReceberFrame() {
        super("Contas a Receber", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de Contas a Receber"));
    }
    
}
