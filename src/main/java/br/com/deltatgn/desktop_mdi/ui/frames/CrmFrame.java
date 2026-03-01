package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class CrmFrame extends JInternalFrame {

    public CrmFrame() {
        super("CRM", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de CRM"));
    }

}
