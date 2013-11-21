package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author marco.mangan@gmail.com
 * 
 */
public class SobreAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	public SobreAction(JFrame frame) {
		super("Sobre");
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(frame,
				"v. 2.0 (dev) (c) 2013, LAPRO III, FSPOA.",
				"Sobre Margulis, um Simulador de Mercado",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
