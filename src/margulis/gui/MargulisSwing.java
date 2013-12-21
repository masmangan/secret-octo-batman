package margulis.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import margulis.action.ForwardSimulationAction;
import margulis.action.OpenAboutPanelAction;
import margulis.action.OpenConfigurationPanelAction;
import margulis.action.OpenHelpPanelAction;
import margulis.action.QuitApplicationAction;

/**
 * Margulis simulator main window.
 * 
 * @author Dias
 */
public class MargulisSwing {

	/**
	 * 
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Margulis");
		configureFrame(frame);

		CardLayout card = new CardLayout(0, 0);

		JMenuBar mb = new JMenuBar();
		frame.setJMenuBar(mb);

		JMenu arquivo = new JMenu("Arquivo");
		arquivo.setMnemonic(KeyEvent.VK_A);
		mb.add(arquivo);

		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic(KeyEvent.VK_U);
		mb.add(ajuda);
		JPanel p = new JPanel();

		JMenuItem configuracao = new JMenuItem(new OpenConfigurationPanelAction(p, card));
		arquivo.add(configuracao);

		JMenuItem forward = new JMenuItem(new ForwardSimulationAction(frame, card));
		arquivo.add(forward);

		arquivo.addSeparator();
		JMenuItem sair = new JMenuItem(new QuitApplicationAction());
		arquivo.add(sair);

		JMenuItem ajudaItem = new JMenuItem(new OpenHelpPanelAction(frame));
		ajuda.add(ajudaItem);

		JMenuItem sobre = new JMenuItem(new OpenAboutPanelAction(frame));
		ajuda.add(sobre);

		JPanel emptyPanel = new JPanel();
		JPanel configurationPanel = new JConfiguracaoPanel(frame, card);
		JToolBar toolBar = new JToolBar("Controle da simulação");

		toolBar.setFloatable(false);
		toolBar.add(configuracao.getAction());
		toolBar.add(forward.getAction());

		p.setLayout(card);
		p.add(emptyPanel, "EmptyPanel");
		p.add(configurationPanel, "ConfigurationPanel");

		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
		frame.getContentPane().add(p, BorderLayout.CENTER);

		frame.setPreferredSize(new Dimension(800, 400));
		frame.pack();
		frame.setVisible(true);
	}

	private static void configureFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		URL iconFile = MargulisSwing.class
				.getResource("/margulis/gui/image/iconemargulis.png");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(iconFile));		
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
