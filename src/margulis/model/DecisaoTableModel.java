package margulis.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import margulis.dao.DecisaoDAO;
import margulis.pojo.Decisao;

/**
 * 
 * @author Dias
 * @author marco.mangan@gmail.com
 * 
 */
public class DecisaoTableModel extends AbstractTableModel {

	/**
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
			return l.getDecisaoId();
		case 1:
			return l.getEmpId();
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
