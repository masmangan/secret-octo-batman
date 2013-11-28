package margulis.gui;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import margulis.pojo.Decisao;


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
		
		private JTextField empid;
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
			return new Decisao(Integer.parseInt(empid.getText()),Integer.parseInt(periodo.getText()),Double.parseDouble(preco.getText()),Double.parseDouble(marketing.getText()),Integer.parseInt(quantidade.getText()));
		}

		public void clear() {
			empid.setText("");
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

			label = new JLabel("empid");
			add(label);
			empid = new JTextField(10);
			label.setLabelFor(empid);
			add(empid);
			
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

			frame.getContentPane().add(new JDecisaoPanel(frame, null));

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

