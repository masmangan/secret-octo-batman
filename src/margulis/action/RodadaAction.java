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
	
	private JFrame frame;

	public RodadaAction(JFrame frame) {
		super("Rodada");
		this.frame = frame;
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
