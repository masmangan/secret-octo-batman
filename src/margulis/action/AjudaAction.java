package margulis.action;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * 
 * @author Ândrei
 * 
 */
public class AjudaAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private JFrame frame;

	public AjudaAction(JFrame frame) {
		super("Manual");
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		URI uri = null;
		try {
			uri = new URI("https://github.com/masmangan/secret-octo-batman/wiki/Manual-do-Usu%C3%A1rio");
			Desktop.getDesktop().browse(uri);
		} catch(Exception ex) {  
		  ex.printStackTrace();  
		  JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
		}  

	}
}
