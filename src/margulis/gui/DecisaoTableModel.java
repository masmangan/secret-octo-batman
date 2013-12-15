package margulis.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import margulis.dao.DecisaoDAO;
import margulis.pojo.Decisao;

/**
 * 
 * @author marco
 *
 */
public class DecisaoTableModel extends AbstractTableModel {

	/**
	 * @author Dias
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private List<Decisao> listadedecisoes;

	/**
	 * 
	 */
	public DecisaoTableModel() {
		DecisaoDAO dao = new DecisaoDAO();
		
		listadedecisoes = dao.findDecisaoByPeriodo();
		
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return listadedecisoes.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Decisao l = listadedecisoes.get(lin);
		switch (col) {
		case 0:
			return l.getDecisaoid();
		case 1:
			return l.getEmpid();
		case 2:
			return l.getRodada();
		case 3:
			return l.getPreco();
		case 4: 
			return l.getMarketing();
		case 5:
			return l.getProducao();
		default:
			return "*ERRO*";
		}		
	}
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Codigo";
		case 1:
			return "EmpId";
		case 2:
			return "Rodada";
		case 3:
			return "Preco";
		case 4: 
			return "Marketing";
		case 5:
			return "Producao";
		default:
			return "*ERRO*";
		}
	}
}

