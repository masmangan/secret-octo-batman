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
import margulis.action.OpenCompanyPanelAction;
import margulis.action.OpenDecisionPanelAction;
import margulis.action.OpenHelpPanelAction;
import margulis.action.OpenResultPanelAction;
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
		MargulisModel model = new MargulisModel();
		JFrame frame = new JFrame("Margulis");
		JTabbedPane tabbedPane = new JTabbedPane();
		JMenuBar mb = new JMenuBar();

		configureFrame(frame);
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

		JMenuItem forward = new JMenuItem(new ForwardSimulationAction(model));
		arquivo.add(forward);

		JMenuItem company = new JMenuItem(
				new OpenCompanyPanelAction(tabbedPane));
		window.add(company);

		JMenuItem decision = new JMenuItem(new OpenDecisionPanelAction(
				tabbedPane));
		window.add(decision);

		JMenuItem result = new JMenuItem(new OpenResultPanelAction(tabbedPane));
		window.add(result);

		JMenuItem chart = new JMenuItem(new OpenChartPanelAction(tabbedPane));
		window.add(chart);

		JMenuItem configuracao = new JMenuItem(new OpenSetupPanelAction(
				tabbedPane));
		window.add(configuracao);

		arquivo.addSeparator();
		JMenuItem sair = new JMenuItem(new QuitApplicationAction());
		arquivo.add(sair);

		JMenuItem ajudaItem = new JMenuItem(new OpenHelpPanelAction(frame));
		ajuda.add(ajudaItem);

		JMenuItem sobre = new JMenuItem(new OpenAboutPanelAction(frame));
		ajuda.add(sobre);

		JPanel companyPanel = new JEmpresaPanel(tabbedPane, model);
		JPanel decisionPanel = new JDecisaoPanel(tabbedPane, model);
		JPanel resultsPanel = new JDemonstrativoPanel(tabbedPane, model);
		JPanel chartPanel = new JChartPanel(tabbedPane);
		// JPanel reportPanel = new JPanel();
		JPanel configurationPanel = new JSetupPanel(tabbedPane, model);

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
				String text = String.format("Rodada: %s", evt.getNewValue()
						.toString());
				rodada.setText(text);
			}
		};

		model.addPropertyChangeListener(listener);

		tabbedPane.add(companyPanel, "Empresas");
		tabbedPane.add(decisionPanel, "Decisões");
		tabbedPane.add(resultsPanel, "Resultados");
		tabbedPane.add(chartPanel, "Gráficos");
		// tabbedPane.add(reportPanel, "Relatório");
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
