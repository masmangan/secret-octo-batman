package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 * 
 * @author gustavo.domingues@rocketmail.com
 */
public class RelatorioAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	/**
	 * 
	 * @param frame
	 */
	public RelatorioAction(final JFrame frame) {
		super("Relatório");
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		System.out.println("Sem ação no momento");
	}

}