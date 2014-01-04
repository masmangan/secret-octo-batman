package margulis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import margulis.model.MargulisModel;
import margulis.pojo.Decisao;

/**
 * Read-only panel to display company initial values to price, marketing, and
 * production.
 * 
 * @see http
 *      ://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.
 *      oracle.com/javase/tutorial/uiswing/examples/components/
 *      FormattedTextFieldDemoProject/src/components/FormattedTextFieldDemo.java
 * 
 * @author marco.mangan@gmail.com
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
	private transient JFormattedTextField preco;

	/**
	 * 
	 */
	private transient JTextField marketing;

	/**
	 * 
	 */
	private transient JTextField quantidade;

	/**
	 * 
	 */
	public JDecisaoInicialPanel(final MargulisModel model) {
		super(new BorderLayout());
		JLabel label;
		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		JPanel fieldPane = new JPanel(new GridLayout(0, 1));

		// NumberFormat paymentFormat = NumberFormat.getCurrencyInstance();
		NumberFormat paymentFormat = NumberFormat.getNumberInstance();
		paymentFormat.setMinimumFractionDigits(2);
		label = new JLabel("Preço (R$/un)");
		labelPane.add(label);
		preco = new JFormattedTextField(paymentFormat);
		preco.setColumns(10);
		label.setLabelFor(preco);
		fieldPane.add(preco);

		label = new JLabel("Marketing (R$)");
		labelPane.add(label);
		marketing = new JTextField(10);
		label.setLabelFor(marketing);
		fieldPane.add(marketing);

		label = new JLabel("Quantidade (un)");
		labelPane.add(label);
		quantidade = new JTextField(10);
		label.setLabelFor(quantidade);
		fieldPane.add(quantidade);

		updateUI(model);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.LINE_END);
	}

	/**
	 * 
	 * @param model
	 */
	private void updateUI(MargulisModel model) {
		if (model != null) {
			Decisao inicial = model.getDecisaoInicial();
			// preco.setText(String.format("%.2f", inicial.getPreco()));
			preco.setValue(inicial.getPreco());
			marketing.setText(String.format("%.2f", inicial.getMarketing()));
			quantidade.setText(String.format("%d", inicial.getProducao()));

			preco.setEditable(false);
			marketing.setEditable(false);
			quantidade.setEditable(false);
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
