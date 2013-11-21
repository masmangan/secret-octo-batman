package margulis.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JValoresIniciais extends JPanel {
	private JTextField textEstoqueInicial;
	private JTextField textCustosVariaveis;
	private JTextField textCustosFixos;
	private JTextField textDespesasAdministrativas;
	private JTextField textJurosSobreEmprestimo;
	private JTextField textValorDoImposto;

	/**
	 * Create the panel.
	 */
	public JValoresIniciais() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, "8, 2, 1, 17");
		
		JLabel lblValoresIniciais = new JLabel("Valores iniciais");
		lblValoresIniciais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblValoresIniciais, "4, 4");
		
		JLabel lblEstoqueInicial = new JLabel("Estoque inicial");
		lblEstoqueInicial.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblEstoqueInicial, "4, 8, left, top");
		
		textEstoqueInicial = new JTextField();
		add(textEstoqueInicial, "6, 8, fill, default");
		textEstoqueInicial.setColumns(10);
		
		JLabel lblCustosVariaveis = new JLabel("Custos variaveis");
		add(lblCustosVariaveis, "4, 10, left, default");
		
		textCustosVariaveis = new JTextField();
		add(textCustosVariaveis, "6, 10, fill, default");
		textCustosVariaveis.setColumns(10);
		
		JLabel lblCustosFixos = new JLabel("Custos fixos");
		add(lblCustosFixos, "4, 12, left, default");
		
		textCustosFixos = new JTextField();
		add(textCustosFixos, "6, 12, fill, default");
		textCustosFixos.setColumns(10);
		
		JLabel lblDespesasAdministrativas = new JLabel("Despesas administrativas");
		add(lblDespesasAdministrativas, "4, 14, left, default");
		
		textDespesasAdministrativas = new JTextField();
		add(textDespesasAdministrativas, "6, 14, fill, default");
		textDespesasAdministrativas.setColumns(10);
		
		JLabel lblJurosSobreEmprstimos = new JLabel("Juros sobre empr\u00E9stimos banc\u00E1rios");
		add(lblJurosSobreEmprstimos, "4, 16, left, default");
		
		textJurosSobreEmprestimo = new JTextField();
		add(textJurosSobreEmprestimo, "6, 16, fill, default");
		textJurosSobreEmprestimo.setColumns(10);
		
		JLabel lblValorDoImposto = new JLabel("Valor do imposto de renda");
		add(lblValorDoImposto, "4, 18, left, default");
		
		textValorDoImposto = new JTextField();
		textValorDoImposto.setText("");
		add(textValorDoImposto, "6, 18, fill, default");
		textValorDoImposto.setColumns(10);

	}

}
