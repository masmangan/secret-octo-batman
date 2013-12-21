package margulis.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

/**
 * Margulis simulator initial configuration action.
 * 
 * @author paulo.limaesilva09@gmail.com
 */
public class OpenSetupPanelAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private transient final JTabbedPane panel;

	/**
	 * 
	 * @param panel
	 * @param card
	 */
	public OpenSetupPanelAction(final JTabbedPane panel) {
		super("Configuração");
		this.panel = panel;
		putValue(
				SMALL_ICON,
				new ImageIcon(OpenSetupPanelAction.class
						.getResource("/margulis/gui/image/config.png")));
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		panel.setSelectedIndex(1);
	}
}
