package simulador.gui;


import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

	import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import simulador.pojo.Decisao;


	/**
	 * 
	 * @author Dias
	 *
	 */
	public class JDecisaoPanel extends JPanel {
		public JFrame getFrame() {
			return frame;
		}
		
		public CardLayout getCard() {
			return card;
		}
		
		private static final long serialVersionUID = 1L;

		private JTextField periodo;
		private JTextField preco;
		private JTextField marketing;
		private JTextField quantidade;
		
		private JFrame frame;
		private CardLayout card;


		/**
		 * 
		 * @return
		 */
		public Decisao getDecisao() {
			return new Decisao(periodo.getText(),Double.parseDouble(preco.getText()),Double.parseDouble(marketing.getText()),Integer.parseInt(quantidade.getText()));
		}

		public void clear() {
			periodo.setText("");
			preco.setText("");
			marketing.setText("");
			quantidade.setText("");
		}


		/**
		 * 
		 */
		public JDecisaoPanel(JFrame frame, CardLayout card) {
			JLabel label;
			
			this.frame = frame;
			this.card = card;
			
			setLayout(new FlowLayout());

			label = new JLabel("Periodo");
			add(label);
			periodo = new JTextField(10);
			label.setLabelFor(periodo);
			add(periodo);

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
			marketing = new JTextField(10);
			label.setLabelFor(quantidade);
			add(quantidade);

			JButton button;
			
			
			//Falta fazer a Action
			//button = new JButton(new CadastrarDecisaoAction(this));
			//button.setToolTipText("Cadastrar Decisao");
			//button.setMnemonic(KeyEvent.VK_C);
			//add(button);

			//button = new JButton(new CadastrarDecisaoAction(this));
			//button.setToolTipText("Cancelar Cadastro de Decisao");
			//button.setMnemonic(KeyEvent.VK_N);
			//add(button);		
		}
	}

