package margulis.gui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import margulis.action.ProcessarRodadaAction;

/**
 * 
 * @author paulo.limaesilva09@gmail.com.
 * 
 */

public class JRodadaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblRodada = new JLabel("Rodada");
	private JLabel lblNumeroRodada = new JLabel("");

	private int numeroRodada = 0;
	private JTextField textFieldPreco;
	private JTextField textFieldMarketing;
	private JTextField textFieldProducao;

	/**
	 * Create the panel.
	 */

	public void setRodada() {
		numeroRodada++;
		lblNumeroRodada.setText(Integer.toString(numeroRodada));
	}

	public JRodadaPanel() {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"), }));

		add(lblRodada, "2, 2");

		add(lblNumeroRodada, "2, 4");

		JLabel lblDecisao = new JLabel("Decis\u00E3o");
		add(lblDecisao, "10, 6, 5, 1, center, default");

		JLabel lblEmpresa = new JLabel("empresa");
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblEmpresa, "8, 6, 1, 3");

		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblPreco, "10, 8");

		JLabel lblMarketing = new JLabel("Marketing");
		lblMarketing.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblMarketing, "12, 8");

		JLabel lblProducao = new JLabel("Produ\u00E7\u00E3o");
		lblProducao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblProducao, "14, 8");

		textFieldPreco = new JTextField();
		add(textFieldPreco, "10, 10, fill, default");
		textFieldPreco.setColumns(10);

		textFieldMarketing = new JTextField();
		add(textFieldMarketing, "12, 10, fill, default");
		textFieldMarketing.setColumns(10);

		textFieldProducao = new JTextField();
		add(textFieldProducao, "14, 10, fill, default");
		textFieldProducao.setColumns(10);

		JPanel panelButton = new JPanel();
		add(panelButton, "2, 14, 24, 1, fill, fill");
		panelButton.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		//FIXME:
		//JButton btnProcessar = new JButton(new ProcessarRodadaAction(this));
		//panelButton.add(btnProcessar, "14, 4");

	}
}
