package margulis.action;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * Margulis simulator user guide action.
 * 
 * <p>
 * User documentation is provided by a GitHub hosted wiki page.
 * 
 * <p>
 * If some event prevents the contact with GitHub, a generic error message
 * appears on a dialog.
 * 
 * @author Ândrei
 * 
 */
public class OpenHelpPanelAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private transient final JFrame frame;

	/**
	 * 
	 */
	private static String address = "https://github.com/masmangan/secret-octo-batman/wiki/Manual";

	/**
	 * 
	 * @param frame
	 */
	public OpenHelpPanelAction(final JFrame frame) {
		super("Manual");
		this.frame = frame;
		putValue(
				SMALL_ICON,
				new ImageIcon(OpenHelpPanelAction.class
						.getResource("/margulis/gui/image/help.png")));
		putValue(MNEMONIC_KEY, KeyEvent.VK_H);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		try {
			final URI uri = new URI(address);
			final Desktop desk = Desktop.getDesktop();
			desk.browse(uri);
		} catch (Exception ex) {
			final Logger logger = Logger.getLogger("margulis");
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
