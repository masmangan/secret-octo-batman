package margulis.action;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * Margulis simulator initial configuration action.
 * 
 * @author paulo.limaesilva09@gmail.com
 */
public class ConfigurationAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private transient final JFrame frame;
	private transient final CardLayout card;

	/**
	 * 
	 * @param frame
	 * @param card
	 */
	public ConfigurationAction(final JFrame frame, final CardLayout card) {
		super("Configuração");
		this.frame = frame;
		this.card = card;
		putValue(
				SMALL_ICON,
				new ImageIcon(ConfigurationAction.class
						.getResource("/margulis/gui/image/config.png")));
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		card.show(frame.getContentPane(), "ConfigurationPanel");
	}
}
