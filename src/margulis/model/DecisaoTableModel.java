package margulis.model;

import java.util.Iterator;
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
public class DecisaoTableModel extends AbstractTableModel implements
		Iterable<Decisao> {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private transient final List<Decisao> listadedecisoes;

	/**
	 * 
	 */
	private transient final DecisaoDAO dao;

	/**
	 * 
	 */
	public DecisaoTableModel() {
		super();
		dao = new DecisaoDAO();
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
		final Decisao decision = listadedecisoes.get(lin);
		Object value;

		switch (col) {
		case 0:
			value = decision.getDecisaoId();
			break;
		case 1:
			value = decision.getEmpId();
			break;

		case 2:
			value = decision.getRodada();
			break;

		case 3:
			value = decision.getPreco();
			break;

		case 4:
			value = decision.getMarketing();
			break;

		case 5:
			value = decision.getProducao();
			break;

		default:
			value = "*ERRO*";
			break;

		}

		return value;
	}

	@Override
	public String getColumnName(final int col) {
		String columnName;

		switch (col) {
		case 0:
			columnName = "Codigo";
			break;

		case 1:
			columnName = "EmpId";
			break;

		case 2:
			columnName = "Rodada";
			break;

		case 3:
			columnName = "Preco";
			break;

		case 4:
			columnName = "Marketing";
			break;

		case 5:
			columnName = "Producao";
			break;

		default:
			columnName = "*ERRO*";
			break;

		}

		return columnName;
	}

	@Override
	public Iterator<Decisao> iterator() {
		return listadedecisoes.iterator();
	}

	/**
	 * Média harmônica do preço em cada decisão.
	 * 
	 * @param rodada
	 * @return
	 */
	public double getMediaPreco(int rodada) {
		double media = 0;
		double soma = 0;
		int n = 0;
		for (Decisao d : this) {
			if (d.getRodada() == rodada) {
				n++;
				soma += (1.0 / d.getPreco());
			}
		}
		if (n == 0 || soma == 0) {
			return 0.0;
		}
		media = n / soma;
		return media;
	}
}
