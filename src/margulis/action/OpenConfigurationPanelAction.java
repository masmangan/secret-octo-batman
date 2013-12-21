package margulis.action;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * Margulis simulator initial configuration action.
 * 
 * @author paulo.limaesilva09@gmail.com
 */
public class OpenConfigurationPanelAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private transient final JPanel panel;

	/**
	 * 
	 */
	private transient final CardLayout card;

	/**
	 * 
	 * @param panel
	 * @param card
	 */
	public OpenConfigurationPanelAction(final JPanel panel, final CardLayout card) {
		super("Configuração");
		this.panel = panel;
		this.card = card;
		putValue(
				SMALL_ICON,
				new ImageIcon(OpenConfigurationPanelAction.class
						.getResource("/margulis/gui/image/config.png")));
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		card.show(panel, "ConfigurationPanel");
	}
}
