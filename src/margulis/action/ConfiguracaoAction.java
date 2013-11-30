package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author paulo.limaesilva09@gmail.com
 */

public class ConfiguracaoAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConfiguracaoAction() {
		super("Configura��o");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Action configura��o");
	}

}
