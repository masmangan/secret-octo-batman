package margulis.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * Margulis simulator about action.
 * 
 * @author marco.mangan@gmail.com
 */
public class SobreAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private transient final JFrame frame;

	public SobreAction(final JFrame frame) {
		super("Sobre");
		this.frame = frame;
		putValue(
				SMALL_ICON,
				new ImageIcon(SobreAction.class
						.getResource("/margulis/gui/image/sobre.png")));
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		JOptionPane.showMessageDialog(frame,
				"v. 2.0 (dev) (c) 2013, LAPRO III, FSPOA.",
				"Sobre Margulis, um Simulador de Mercado",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
