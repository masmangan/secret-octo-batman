package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * 
 * @author thiagodiasads@gmail.com
 *
 */

public class SairAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SairAction() {
		super("Sair");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}

}