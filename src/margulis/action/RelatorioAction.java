package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 * 
 * @author gustavo.domingues@rocketmail.com
 *
 */

public class RelatorioAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	public RelatorioAction(JFrame frame) {
		super("Relat�rio");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Sem a��o no momento");
	}

}