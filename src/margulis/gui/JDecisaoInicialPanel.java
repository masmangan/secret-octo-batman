package margulis.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import margulis.model.MargulisModel;
import margulis.pojo.Decisao;

/**
 * 
 * @author
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

	/**
	 * 
	 */
	public JDecisaoInicialPanel(MargulisModel model) {
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

		updateUI(model);

	}

	/**
	 * 
	 * @param model
	 */
	private void updateUI(MargulisModel model) {
		if (model != null) {
			Decisao inicial = model.getDecisaoInicial();
			preco.setText(String.format("%.2f", inicial.getPreco()));
			marketing.setText(String.format("%.2f", inicial.getMarketing()));
			quantidade.setText(String.format("%d", inicial.getProducao()));
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Teste");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MargulisModel model = new MargulisModel();

		frame.getContentPane().add(new JDecisaoInicialPanel(model));

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
