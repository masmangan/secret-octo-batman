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
	
	private JRodadaPanel panel;

	public ProcessarRodadaAction(JRodadaPanel p) {
		super("Processar Rodada");
		panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.setRodada();
	}

}
