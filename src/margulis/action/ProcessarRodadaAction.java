package margulis.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 * @author paulo.limaesilva09@gmail.com
 */
public class ProcessarRodadaAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	// private final JRodadaPanel panel;

	public ProcessarRodadaAction(JFrame frame, CardLayout card) {
		super("Processar Rodada");
		URL url = ProcessarRodadaAction.class
				.getResource("/margulis/gui/image/StepForward16.gif");

		ImageIcon ico = new ImageIcon(url);
		putValue(SMALL_ICON, ico);
		putValue(LARGE_ICON_KEY, ico);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// panel.setRodada();
		System.out.println("Processando rodada...");
	}

}
