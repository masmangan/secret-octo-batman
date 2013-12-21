package margulis.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

/**
 * 
 * @author gustavo.domingues@rocketmail.com
 * 
 */
public class OpenChartPanelAction extends AbstractAction {

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
	 * @param frame
	 * @param card
	 */
	public OpenChartPanelAction(final JTabbedPane panel) {
		super("Gráficos");
		this.panel = panel;
		// putValue(
		// SMALL_ICON,
		// new ImageIcon(OpenSetupPanelAction.class
		// .getResource("/margulis/gui/image/config.png")));
		putValue(MNEMONIC_KEY, KeyEvent.VK_G);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_G, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		panel.setSelectedIndex(3);
	}

}