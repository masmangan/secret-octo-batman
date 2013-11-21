package margulis.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import margulis.action.AjudaAction;
import margulis.action.SairAction;
import margulis.action.SobreAction;


/**
 * 
 * @author Dias
 *
 */
public class MargulisSwing {
	
		private static void createAndShowGUI() {
			JFrame frame = new JFrame("Margulis - Tela Principal");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
					MargulisSwing.class.getResource("/margulis/gui/iconemargulis.png")));

			
			
			CardLayout card = new CardLayout (0,0);
			
			JMenuBar mb = new JMenuBar();
			frame.setJMenuBar(mb);

			JMenu arquivo = new JMenu("Arquivo");
			arquivo.setMnemonic(KeyEvent.VK_A);
			mb.add(arquivo);

			JMenu ajuda = new JMenu("Ajuda");
			ajuda.setMnemonic(KeyEvent.VK_U);
			mb.add(ajuda);
			
			JMenuItem sair = new JMenuItem(new SairAction());
			arquivo.add(sair);
			
			//TODO: mover para action
			sair.setMnemonic(KeyEvent.VK_S);
			sair.setAccelerator(KeyStroke.getKeyStroke(
			        KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
			
			JMenuItem configuracao = new JMenuItem(new ConfiguracaoAction());
			arquivo.add(configuracao);
			configuracao.setMnemonic(KeyEvent.VK_C);
			configuracao.setAccelerator(KeyStroke.getKeyStroke(
			        KeyEvent.VK_S, ActionEvent.CTRL_MASK));

			JMenuItem sobre = new JMenuItem(new SobreAction(frame));
			ajuda.add(sobre);
			//TODO: mover para action		
			sobre.setMnemonic(KeyEvent.VK_S);
			
			JMenuItem mi_ajuda = new JMenuItem(new AjudaAction(frame));
			ajuda.add(mi_ajuda);
			
			JPanel vazio = new JPanel();
			
			frame.setLayout(card);
			frame.getContentPane().add(vazio, "Vazio");

			frame.setPreferredSize(new Dimension(800,200));
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

