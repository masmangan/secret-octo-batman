package margulis.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

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
		putValue(
				SMALL_ICON,
				new ImageIcon(ProcessarRodadaAction.class
						.getResource("margulis/gui/Forward24.gif")));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// panel.setRodada();
		System.out.println("Processando rodada...");
	}

}
