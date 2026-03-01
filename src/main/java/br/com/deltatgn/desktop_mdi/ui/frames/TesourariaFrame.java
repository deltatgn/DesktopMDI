package br.com.deltatgn.desktop_mdi.ui.frames;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class TesourariaFrame extends JInternalFrame {

    public TesourariaFrame() {
        super("Tesouraria", true, true, true, true);
        setSize(600, 400);
        add(new JLabel("Tela de Tesouraria"));
    }

}
