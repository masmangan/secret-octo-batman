package margulis.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

	public class JEmpresaPanel extends JPanel {

		/**
		 * @autor mauricio.victor.carvalho@gmail.com
		 */
		private static final long serialVersionUID = 1L;

		private JTable table;
		private JFrame frame;

		private CardLayout card;

		public JFrame getFrame() {
			return frame;
		}

		public CardLayout getCard() {
			return card;
		}

		/**
		 * Create the panel.
		 * 
		 * @param card
		 * @param frame
		 */
		public JEmpresaPanel(JFrame frame, CardLayout card) {
			this.frame = frame;
			this.card = card;

			setLayout(new BorderLayout());
			table = new JTable(new EmpresaTableModel());

			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(200, 100));

			// add(BorderLayout.CENTER, table);
			add(BorderLayout.CENTER, scrollPane);

			/*
			 * JButton button = new JButton(new ExtratoFecharAction(this));
			 * button.setToolTipText("Cancelar cadastro de ITEM");
			 * button.setMnemonic(KeyEvent.VK_N); add(BorderLayout.SOUTH, button);
			 */
		}

		/**
		 * Create the GUI and show it. For thread safety, this method should be
		 * invoked from the event-dispatching thread.
		 */
		private static void createAndShowGUI() {
			JFrame frame = new JFrame("Teste");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.getContentPane().add(new JEmpresaPanel(null, null));

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
