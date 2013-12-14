package margulis.action;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Margulis simulator user guide. User documentation is provided by a GitHub
 * hosted wiki page.
 * 
 * <p>
 * If Internet connection is down, wiki is unavaliable, or some other event
 * prevents the contact with GitHub, a generic error message appears on a
 * dialog.
 * 
 * @author Ândrei
 * 
 */
public class HelpAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private JFrame frame;

	private static String address = "htt ps://github.com/masmangan/secret-octo-batman/wiki/Manual-do-Usu%C3%A1rio";

	/**
	 * 
	 * @param frame
	 */
	public HelpAction(JFrame frame) {
		super("Manual");
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			URI uri = new URI(address);
			Desktop.getDesktop().browse(uri);
		} catch (Exception ex) {
			Logger logger = Logger.getLogger("margulis");
			logger.info("User guide not available");
			logger.info(Arrays.toString(ex.getStackTrace()));
			JOptionPane
					.showMessageDialog(
							frame,
							"A ajuda não está disponível no momento. Tente novamente mais tarde.",
							"Manual", JOptionPane.ERROR_MESSAGE);
		}
	}
}
