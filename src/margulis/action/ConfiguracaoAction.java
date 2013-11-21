package margulis.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 * @author paulo.limaesilva09@gmail.com
 */

public class ConfiguracaoAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConfiguracaoAction() {
		super("Configuração");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Action configuração");
	}

}
