package br.com.deltatgn.desktop_mdi;

import javax.swing.SwingUtilities;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.deltatgn.desktop_mdi.ui.MainFrame;

@SpringBootApplication
public class DesktopMdiApplication {

	public static void main(String[] args) {

        System.setProperty("java.awt.headless", "false");

        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(DesktopMdiApplication.class)
                        .headless(false)
                        .run(args);

        SwingUtilities.invokeLater(() -> {

            MainFrame frame = new MainFrame();

            frame.setVisible(true);

        });
    }

}
