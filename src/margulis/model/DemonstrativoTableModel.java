package margulis.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import margulis.pojo.Demonstrativo;

/**
 * 
 * @author Dias
 * @author marco.mangan@gmail.com
 * 
 */
public class DemonstrativoTableModel extends AbstractTableModel {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private List<Demonstrativo> demonstrativos;

	private DecisaoTableModel decisaoModel;

	/**
	 * @param decisaoModel
	 * 
	 */
	public DemonstrativoTableModel(DecisaoTableModel decisaoModel) {
		// DecisaoDAO dao = new DemonstrativoDAO();

		// lista = dao.findDemonstrativoByPeriodo();
		demonstrativos = new ArrayList<Demonstrativo>();
		this.decisaoModel = decisaoModel;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int lin, int col) {
		// Decisao l = listadedecisoes.get(lin);
		// switch (col) {
		// case 0:
		// return l.getDecisaoId();
		// case 1:
		// return l.getEmpId();
		// case 2:
		// return l.getRodada();
		// case 3:
		// return l.getPreco();
		// case 4:
		// return l.getMarketing();
		// case 5:
		// return l.getProducao();
		// default:
		// return "*ERRO*";
		// }
		return "*ERRO*";
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
		 return "Resultado";
		 case 4:
		 return "Vendas";
		 default:
		 return "*ERRO*";
		 }
	}
}
