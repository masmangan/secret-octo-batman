package margulis.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	/**
	 * @author mauricio.victor.carvalho@gmail.com
	 */

public class JConfiguracaoPanel extends JPanel {

	public JFrame getFrame() {
		return frame;
	}

	public CardLayout getCard() {
		return card;
	}
	
	private static final long serialVersionUID = 1L;

	private JPanel painelempresas;
	private JPanel painelvaloresiniciais;
	private JPanel painelinfosobre;
	private JPanel paineldecisaoinicial;
	
	private JFrame frame;
	private CardLayout card;
	
	public JConfiguracaoPanel(JFrame frame, CardLayout card) {
		JLabel label;

		this.frame = frame;
		this.card = card;

		setLayout(new FlowLayout());
		
		JEmpresaPanel panel_empresa = new JEmpresaPanel(frame, card);
		add(panel_empresa);
		
		JValoresIniciais panel_valores_iniciais = new JValoresIniciais();
		add(panel_valores_iniciais);
		
		JInfoSobreDemandaPanel panel_info_sobre_demanda = new JInfoSobreDemandaPanel(frame, card);
		add(panel_info_sobre_demanda);
		
		JDecisaoInicialPanel panel_decisao_inicial = new JDecisaoInicialPanel(frame, card);
		add(panel_decisao_inicial);
		
		JButton botaoum = new JButton("ZERAR SIMULAÇÃO");
		add(botaoum);

		JButton botaodois = new JButton("OUTRAS INFORMAÇÕES INICIAS");
		add(botaodois);

		JButton botaotres = new JButton("INICIAR INFORMAÇÃO");
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
	
