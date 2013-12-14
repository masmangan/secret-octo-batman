package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class RodadaAction extends AbstractAction {

	/**
	 * 
	 * @author rafaelsmdm@gmail.com
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	public RodadaAction(final JFrame frame) {
		super("Rodada");
	}
	
	
	public void actionPerformed(final ActionEvent event) {
		System.out.println("Sem a��o no momento");		
	}

}
