package margulis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import margulis.action.ForwardSimulationAction;
import margulis.action.OpenAboutPanelAction;
import margulis.action.OpenChartPanelAction;
import margulis.action.OpenHelpPanelAction;
import margulis.action.OpenSetupPanelAction;
import margulis.action.QuitApplicationAction;
import margulis.model.MargulisModel;

/**
 * Margulis simulator main window.
 * 
 * @author Dias
 */
public class MargulisSwing {

	/**
	 * 
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Margulis");
		MargulisModel model = new MargulisModel();

		configureFrame(frame);

		JTabbedPane tabbedPane = new JTabbedPane();

		JMenuBar mb = new JMenuBar();
		frame.setJMenuBar(mb);

		JMenu arquivo = new JMenu("Arquivo");
		arquivo.setMnemonic(KeyEvent.VK_A);
		mb.add(arquivo);

		JMenu window = new JMenu("Janelas");
		arquivo.setMnemonic(KeyEvent.VK_J);
		mb.add(window);

		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic(KeyEvent.VK_U);
		mb.add(ajuda);

		JMenuItem configuracao = new JMenuItem(new OpenSetupPanelAction(
				tabbedPane));
		window.add(configuracao);

		JMenuItem forward = new JMenuItem(new ForwardSimulationAction(model));
		arquivo.add(forward);

		JMenuItem chart = new JMenuItem(new OpenChartPanelAction(tabbedPane));
		window.add(chart);

		arquivo.addSeparator();
		JMenuItem sair = new JMenuItem(new QuitApplicationAction());
		arquivo.add(sair);

		JMenuItem ajudaItem = new JMenuItem(new OpenHelpPanelAction(frame));
		ajuda.add(ajudaItem);

		JMenuItem sobre = new JMenuItem(new OpenAboutPanelAction(frame));
		ajuda.add(sobre);

		JPanel companyPanel = new JEmpresaPanel(tabbedPane);
		JPanel decisionPanel = new JDecisaoPanel(tabbedPane);
		JPanel resultsPanel = new JPanel();
		JPanel chartPanel = new JChartPanel(tabbedPane);
		JPanel reportPanel = new JPanel();
		JPanel configurationPanel = new JSetupPanel(tabbedPane);

		JToolBar toolBar = new JToolBar("Controle da simulação");

		toolBar.setFloatable(false);
		toolBar.add(configuracao.getAction());
		toolBar.add(forward.getAction());
		final JLabel rodada = new JLabel("Rodada: 0");
		toolBar.addSeparator();
		toolBar.add(rodada);

		PropertyChangeListener listener;
		listener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				String text = String.format("Rodada: %s", evt.getNewValue().toString());
				rodada.setText(text );	
			}	
		};
		
		model.addPropertyChangeListener(listener);
		
		tabbedPane.add(companyPanel, "Empresas");
		tabbedPane.add(decisionPanel, "Decisões");
		tabbedPane.add(resultsPanel, "Resultados");
		tabbedPane.add(chartPanel, "Análise");
		tabbedPane.add(reportPanel, "Relatório");
		tabbedPane.add(configurationPanel, "Configuração");

		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		frame.setPreferredSize(new Dimension(800, 400));
		frame.pack();
		frame.setVisible(true);
	}

	private static void configureFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		URL iconFile = MargulisSwing.class
				.getResource("/margulis/gui/image/iconemargulis.png");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(iconFile));
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
