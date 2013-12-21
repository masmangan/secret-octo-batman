package margulis.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import margulis.pojo.DecisaoInicial;

/**
 * 
 * @author
 * 
 */
public class JDecisaoInicialPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private JTextField preco;

	/**
	 * 
	 */
	private JTextField marketing;

	/**
	 * 
	 */
	private JTextField quantidade;

	private JFrame frame;
	private CardLayout card;

	/**
	 * 
	 * @return
	 */
	public DecisaoInicial getDecisaoInicial() {
		return new DecisaoInicial(Double.parseDouble(preco.getText()),
				Double.parseDouble(marketing.getText()),
				Integer.parseInt(quantidade.getText()));
	}

	/**
	 * 
	 */
	public void clear() {

		preco.setText("");
		marketing.setText("");
		quantidade.setText("");
	}

	/**
	 * 
	 */
	public JDecisaoInicialPanel(JTabbedPane frame) {
		JLabel label;
		setLayout(new FlowLayout());

		label = new JLabel("Preço");
		add(label);
		preco = new JTextField(10);
		label.setLabelFor(preco);
		add(preco);

		label = new JLabel("Marketing");
		add(label);
		marketing = new JTextField(10);
		label.setLabelFor(marketing);
		add(marketing);

		label = new JLabel("Quantidade");
		add(label);
		quantidade = new JTextField(10);
		label.setLabelFor(quantidade);
		add(quantidade);

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Teste");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new JDecisaoInicialPanel(null));

		frame.setPreferredSize(new Dimension(800, 200));
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
