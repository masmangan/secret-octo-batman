package margulis.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import margulis.dao.EmpresaDAO;
import margulis.pojo.Empresa;

/**
 * @autor mauricio.victor.carvalho@gmail.com
 */
public class EmpresaTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private List<Empresa> empresas;

	/**
	 * 
	 */
	public EmpresaTableModel() {
		EmpresaDAO dao = new EmpresaDAO();
		empresas = dao.findEmpresas();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return empresas.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Empresa l = empresas.get(lin);
		switch (col) {
		case 0:
			return l.getEmpId();
		case 1:
			return l.getNome();
		case 2:
			return l.getResponsavel();
		default:
			return "*ERRO*";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Código";
		case 1:
			return "Denominação";
		case 2:
			return "Responsável";
		default:
			return "*ERRO*";
		}
	}

}
