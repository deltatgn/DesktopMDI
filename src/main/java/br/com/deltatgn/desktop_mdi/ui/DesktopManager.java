package br.com.deltatgn.desktop_mdi.ui;


import java.util.HashMap;
import java.util.Map;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class DesktopManager {

    private final JDesktopPane desktopPane;
    private final Map<Class<?>, JInternalFrame> openFrames = new HashMap<>();

    public DesktopManager(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public void openFrame(Class<? extends JInternalFrame> clazz) {

        try {

            if (openFrames.containsKey(clazz)) {

                JInternalFrame frame = openFrames.get(clazz);
                frame.setSelected(true);
                frame.toFront();
                return;
            }

            JInternalFrame frame = clazz.getDeclaredConstructor().newInstance();

            frame.setVisible(true);

            desktopPane.add(frame);

            centralizar(frame);

            openFrames.put(clazz, frame);

            frame.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
                public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
                    openFrames.remove(clazz);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void centralizar(JInternalFrame frame) {

        int x = (desktopPane.getWidth() - frame.getWidth()) / 2;
        int y = (desktopPane.getHeight() - frame.getHeight()) / 2;

        frame.setLocation(x, y);
    }
    
}

