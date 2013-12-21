package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 * 
 * @author gustavo.domingues@rocketmail.com
 */
public class OpenReportPanelAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	/**
	 * 
	 * @param frame
	 */
	public OpenReportPanelAction(final JFrame frame) {
		super("Relatório");
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		System.out.println("Sem ação no momento");
	}

}