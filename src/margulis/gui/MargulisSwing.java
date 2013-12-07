package margulis.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import margulis.action.AjudaAction;
import margulis.action.ConfiguracaoAction;
import margulis.action.SairAction;
import margulis.action.SobreAction;

/**
 * 
 * @author Dias
 * 
 */
public class MargulisSwing {

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

		JMenuItem configuracao = new JMenuItem(new ConfiguracaoAction());
		arquivo.add(configuracao);
		configuracao.setIcon(new ImageIcon(MargulisSwing.class
				.getResource("/margulis/gui/image/config.png")));
		configuracao.setMnemonic(KeyEvent.VK_C);
		configuracao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));

		JMenuItem sair = new JMenuItem(new SairAction());
		sair.setIcon(new ImageIcon(MargulisSwing.class
				.getResource("/margulis/gui/image/sair.png")));
		sair.setMnemonic(KeyEvent.VK_S);
		sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));
		arquivo.add(sair);
		
		JMenuItem sobre = new JMenuItem(new SobreAction(frame));
		ajuda.add(sobre);
		sobre.setIcon(new ImageIcon(MargulisSwing.class
				.getResource("/margulis/gui/image/sobre.png")));
		sobre.setMnemonic(KeyEvent.VK_A);
		sobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));

		JMenuItem mi_ajuda = new JMenuItem(new AjudaAction(frame));
		mi_ajuda.setIcon(new ImageIcon(MargulisSwing.class
				.getResource("/margulis/gui/image/help.png")));
		mi_ajuda.setMnemonic(KeyEvent.VK_H);
		mi_ajuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
				ActionEvent.CTRL_MASK));
		ajuda.add(mi_ajuda);

		JPanel vazio = new JPanel();

		frame.setLayout(card);
		frame.getContentPane().add(vazio, "Vazio");

		frame.setPreferredSize(new Dimension(800, 200));
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
