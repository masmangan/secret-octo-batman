package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 * 
 * @author gustavo.domingues@rocketmail.com
 *
 */

public class GraficosAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	

	public GraficosAction(JFrame frame) {
		super("Graficos");
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Sem a��o no momento");
	}

}