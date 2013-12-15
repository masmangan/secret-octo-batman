package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 * 
 * @author rafaelsmdm@gmail.com
 */
public class RodadaAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param frame
	 */
	public RodadaAction(final JFrame frame) {
		super("Rodada");
	}
	
	@Override
	public void actionPerformed(final ActionEvent event) {
		System.out.println("Sem ação no momento");		
	}

}
