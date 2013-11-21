package margulis.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Ândrei
 * 
 */
public class AjudaAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private JFrame frame;

	public AjudaAction(JFrame frame) {
		super("Conteúdo");
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(frame,
				"Ajuda",
				"Documentação.",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
