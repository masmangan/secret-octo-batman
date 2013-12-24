package margulis.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

/**
 * Margulis simulator exit action.
 * 
 * @author thiagodiasads@gmail.com
 */
public class QuitApplicationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public QuitApplicationAction() {
		super("Sair");

		putValue(
				SMALL_ICON,
				new ImageIcon(OpenAboutPanelAction.class
						.getResource("/margulis/gui/image/sair.png")));
		putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		System.exit(0);
	}

}