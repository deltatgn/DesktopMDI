package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class OrdemServicoFrame extends JInternalFrame {

    public OrdemServicoFrame() {
        super("Ordem de Seriço", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de Ordem de Seriço"));
    }

}
