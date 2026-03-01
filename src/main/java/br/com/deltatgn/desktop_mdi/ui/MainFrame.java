package br.com.deltatgn.desktop_mdi.ui;

import javax.swing.*;
import java.awt.*;

import br.com.deltatgn.desktop_mdi.ui.frames.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private final JDesktopPane desktopPane;
    private final DesktopManager manager;

    public MainFrame() {
        setTitle("Sistema ERP");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmarSaida();
            }
        });

        setMinimumSize(new Dimension(1024, 768));
        setSize(1200, 800);

        desktopPane = new JDesktopPane();
        manager = new DesktopManager(desktopPane);

        setContentPane(desktopPane);
        setJMenuBar(createMenu());
    }

    private JMenuBar createMenu() {

        JMenuBar bar = new JMenuBar();

        // Cadastro
        JMenu cadastro = new JMenu("Cadastro");

        cadastro.add(createItem("Pessoas", PessoasFrame.class));
        cadastro.add(createItem("Produtos", ProdutosFrame.class));
        cadastro.add(createItem("Usuários", UsuariosFrame.class));

        // Financeiro
        JMenu financeiro = new JMenu("Financeiro");

        financeiro.add(createItem("Contas a pagar", ContasPagarFrame.class));
        financeiro.add(createItem("Contas a receber", ContasReceberFrame.class));
        financeiro.add(createItem("Tesouraria", TesourariaFrame.class));

        // Comercial
        JMenu comercial = new JMenu("Comercial");

        comercial.add(createItem("Vendas", VendasFrame.class));
        comercial.add(createItem("CRM", CrmFrame.class));
        comercial.add(createItem("NF-e", NfeFrame.class));
        comercial.add(createItem("Ordem de Serviço", OrdemServicoFrame.class));

        // Sair
        JMenu sair = new JMenu("Sair");
        sair.add(new JMenuItem(new AbstractAction("Fechar") {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                confirmarSaida();
            }
        }));

        bar.add(cadastro);
        bar.add(financeiro);
        bar.add(comercial);
        bar.add(sair);

        return bar;
    }

    private JMenuItem createItem(String title, Class<? extends JInternalFrame> clazz) {
        return new JMenuItem(new AbstractAction(title) {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                manager.openFrame(clazz);
            }
        });
    }

    private void confirmarSaida() {
        int opcao = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente sair do sistema?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }

}
