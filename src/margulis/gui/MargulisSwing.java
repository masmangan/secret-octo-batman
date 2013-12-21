package margulis.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import margulis.action.ConfigurationAction;
import margulis.action.HelpAction;
import margulis.action.ProcessarRodadaAction;
import margulis.action.RodadaAction;
import margulis.action.SairAction;
import margulis.action.SobreAction;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				MargulisSwing.class
						.getResource("/margulis/gui/iconemargulis.png")));

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

		JMenuItem configuracao = new JMenuItem(new ConfigurationAction(p,
				card));
		arquivo.add(configuracao);

		JMenuItem rodada = new JMenuItem(new RodadaAction(frame,card));
		arquivo.add(rodada);		
		
		arquivo.addSeparator();
		JMenuItem sair = new JMenuItem(new SairAction());
		arquivo.add(sair);

		JMenuItem ajudaItem = new JMenuItem(new HelpAction(frame));
		ajuda.add(ajudaItem);

		JMenuItem sobre = new JMenuItem(new SobreAction(frame));
		ajuda.add(sobre);
		
		JPanel emptyPanel = new JPanel();
		JPanel configurationPanel = new JConfiguracaoPanel(frame, card);
		JToolBar toolBar = new JToolBar("Controle da simulação");
		
		JButton forward = new JButton(new ProcessarRodadaAction(frame, card));
		//JButton forward = new JButton("teste");
		   toolBar.add(forward);
		p.setLayout(card);
		p.add(emptyPanel, "EmptyPanel");
		p.add(configurationPanel, "ConfigurationPanel");

		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
		frame.getContentPane().add(p, BorderLayout.CENTER);

		frame.setPreferredSize(new Dimension(800, 200));
		frame.pack();
		frame.setVisible(true);
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
