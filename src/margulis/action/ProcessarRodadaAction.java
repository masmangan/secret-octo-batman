package margulis.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import margulis.gui.JRodadaPanel;

/**
 * @author paulo.limaesilva09@gmail.com
 */

public class ProcessarRodadaAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JRodadaPanel panel;

	public ProcessarRodadaAction(final JRodadaPanel panel) {
		super("Processar Rodada");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		panel.setRodada();
	}

}
