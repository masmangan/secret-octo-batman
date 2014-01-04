package margulis.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import margulis.model.MargulisModel;

/**
 * @author mauricio.victor.carvalho@gmail.com
 */
public class JSetupPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param frame
	 * @param card
	 */
	public JSetupPanel(final MargulisModel model) {
		super();

		setLayout(new FlowLayout());

		JValoresIniciais valoresIniciaisPanel = new JValoresIniciais();
		add(valoresIniciaisPanel);

		JInfoSobreDemandaPanel demandaPanel = new JInfoSobreDemandaPanel();
		add(demandaPanel);

		JDecisaoInicialPanel decisaoInicialPanel = new JDecisaoInicialPanel(
				model);
		add(decisaoInicialPanel);

		// JButton botaoum = new JButton("Zerar simulação");
		// add(botaoum);
		//
		// JButton botaodois = new JButton("Outras informações iniciais");
		// add(botaodois);
		//
		// JButton botaotres = new JButton("Iniciar simulação");
		// add(botaotres);

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Teste");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new JSetupPanel(null));

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
