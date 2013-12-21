package margulis.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import margulis.gui.MargulisModel;

/**
 * 
 * @author paulo.limaesilva09@gmail.com
 */
public class ForwardSimulationAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private MargulisModel model;

	public ForwardSimulationAction(final MargulisModel model) {
		super("Processar Rodada");
		this.model = model;
		 URL url = ForwardSimulationAction.class
				.getResource("/margulis/gui/image/StepForward16.gif");

		 ImageIcon ico = new ImageIcon(url);
		putValue(SMALL_ICON, ico);
		url = ForwardSimulationAction.class
				.getResource("/margulis/gui/image/StepForward24.gif");
		ico = new ImageIcon(url);
		 putValue(LARGE_ICON_KEY, ico);
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		model.forward();
	}

}
