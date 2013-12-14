package margulis.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author mauricio.victor.carvalho@gmail.com
 */
public class JConfiguracaoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private CardLayout card;

	/**
	 * 
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * 
	 * @return
	 */
	public CardLayout getCard() {
		return card;
	}

	/**
	 * 
	 * @param frame
	 * @param card
	 */
	public JConfiguracaoPanel(JFrame frame, CardLayout card) {

		this.frame = frame;
		this.card = card;

		setLayout(new FlowLayout());

		JEmpresaPanel empresaPanel = new JEmpresaPanel(frame, card);
		add(empresaPanel);

		JValoresIniciais valoresIniciaisPanel = new JValoresIniciais();
		add(valoresIniciaisPanel);

		JInfoSobreDemandaPanel demandaPanel = new JInfoSobreDemandaPanel(
				frame, card);
		add(demandaPanel);

		JDecisaoInicialPanel decisaoInicialPanel = new JDecisaoInicialPanel(
				frame, card);
		add(decisaoInicialPanel);

		JButton botaoum = new JButton("Zerar simulação");
		add(botaoum);

		JButton botaodois = new JButton("Outras informações iniciais");
		add(botaodois);

		JButton botaotres = new JButton("Iniciar simulação");
		add(botaotres);

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Teste");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new JConfiguracaoPanel(frame, null));

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
