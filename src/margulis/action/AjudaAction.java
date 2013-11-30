package margulis.action;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.net.URI;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author �ndrei
 * 
 */
public class AjudaAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private JFrame frame;

	public AjudaAction(JFrame frame) {
		super("Manual");
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		URI uri = null;
		try {
			uri = new URI(
					"https://github.com/masmangan/secret-octo-batman/wiki/Manual-do-Usu%C3%A1rio");
			Desktop.getDesktop().browse(uri);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Erro no Desktop: " + ex);
		}

	}
}
