package margulis.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import margulis.model.MargulisModel;

/**
 * 
 * @author paulo.limaesilva09@gmail.com
 * @author marco.mangan@gmail.com
 * 
 */
public class ForwardSimulationAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private final MargulisModel model;

	/**
	 * 
	 * @param model
	 */
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
		int key = KeyEvent.VK_P;
		putValue(MNEMONIC_KEY, key);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(key, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask()));
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		model.forward();
	}

}
