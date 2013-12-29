package margulis.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import margulis.pojo.Decisao;
import margulis.pojo.Demonstrativo;

/**
 * 
 * @author Dias
 * @author marco.mangan@gmail.com
 * 
 */
public class DemonstrativoTableModel extends AbstractTableModel implements
		PropertyChangeListener {

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
		// DemonstrativoDAO dao = new DemonstrativoDAO();

		// lista = dao.findDemonstrativoByPeriodo();
		demonstrativos = new ArrayList<Demonstrativo>();
		this.decisaoModel = decisaoModel;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return demonstrativos.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Demonstrativo l = demonstrativos.get(lin);
		switch (col) {
		case 0:
			return l.getEmpid();
		case 1:
			return l.getRodada();
		case 2:
			return l.getResultado();
		case 3:
			return l.getVendas();
		case 4:
			return l.getDemanda();
		default:
			return "*ERRO*";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "EmpId";
		case 1:
			return "Rodada";
		case 2:
			return "Resultado";
		case 3:
			return "Vendas";
		case 4:
			return "Demanda";
		default:
			return "*ERRO*";
		}
	}

	public void step(int rodada) {
		int firstRow = demonstrativos.size();

		for (Decisao d : decisaoModel) {
			//FIXME: select * from decisoes where rodada = ?
			if (d.getRodada() == rodada) {
				demonstrativos.add(new Demonstrativo(d.getEmpId(), rodada, 10,
						20, 1.0));
			}
		}
		int lastRow = demonstrativos.size();

		fireTableRowsInserted(firstRow, lastRow);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		step((Integer) evt.getNewValue());
	}

}
