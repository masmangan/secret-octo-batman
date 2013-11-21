package margulis.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import margulis.pojo.DemandaInicial;
/**
 * @author Ândrei
 */
public class JInfoSobreDemandaPanel extends JPanel {

	private static final long serialVersionUID = -7585722317489961554L;

	private JLabel lblTitulo;
	private JLabel lblDemandaPadrao;
	private JLabel lblInfluenciaPreco;
	private JLabel lblInfluenciaMarketing;
	
	private JTextField demandaPadrao;
	private JTextField influenciaPreco;
	private JTextField influenciaMarketing;
	
	private JFrame frame;
	private CardLayout card;
	
	public JInfoSobreDemandaPanel(JFrame frame, CardLayout card) {
		this.frame = frame;
		this.card = card;
		
		setLayout(new BorderLayout());
		
		lblTitulo = new JLabel("Informações Sobre a Demanda");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel painel = new JPanel();
		painel.setLayout(null);
		lblDemandaPadrao = new JLabel("Demanda Padrão");
		lblDemandaPadrao.setBounds(12, 29, 214, 33);
		painel.add(lblDemandaPadrao);
		
		demandaPadrao = new JTextField();
		demandaPadrao.setHorizontalAlignment(SwingConstants.RIGHT);
		demandaPadrao.setBounds(225, 29, 218, 33);
		painel.add(demandaPadrao);
		lblInfluenciaPreco = new JLabel("Influência do Preço");
		lblInfluenciaPreco.setBounds(12, 91, 214, 33);
		painel.add(lblInfluenciaPreco);
		influenciaPreco = new JTextField();
		influenciaPreco.setHorizontalAlignment(SwingConstants.RIGHT);
		influenciaPreco.setBounds(225, 91, 218, 33);
		painel.add(influenciaPreco);
		lblInfluenciaMarketing = new JLabel("Influência do Marketing");
		lblInfluenciaMarketing.setBounds(17, 154, 209, 33);
		painel.add(lblInfluenciaMarketing);
		
		add(BorderLayout.NORTH, lblTitulo);
		add(BorderLayout.CENTER, painel);
		influenciaMarketing = new JTextField();
		influenciaMarketing.setHorizontalAlignment(SwingConstants.RIGHT);
		influenciaMarketing.setBounds(225, 154, 218, 33);
		painel.add(influenciaMarketing);
	}
	/** 
	 * Retorna o objeto <b>DemandaInicial</b> atribuindo as informações atuais no painel.
	 * @return Objeto <b>DemandaInicial</b>
	 */
	public DemandaInicial getInfoSobreDemanda() {
		return new DemandaInicial(Double.parseDouble(this.demandaPadrao.getText()), Double.parseDouble(this.influenciaPreco.getText()), Double.parseDouble(this.lblInfluenciaMarketing.getText()));
	}
	
	/**
	 * Reseta os atributos da janela.
	 */
	public void clear() {
		demandaPadrao.setText("");
		influenciaPreco.setText("");
		influenciaMarketing.setText("");
	}
	/**
	 * @return JFrame
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * @return CardLayout
	 */
	public CardLayout getCard() {
		return card;
	}
	
	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Teste");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new JInfoSobreDemandaPanel(null, null));

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