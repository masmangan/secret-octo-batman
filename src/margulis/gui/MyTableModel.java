package margulis.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import margulis.dao.EmpresaDAO;
import margulis.pojo.Empresa;

public class MyTableModel extends AbstractTableModel {

	/**
	 * @autor mauricio.victor.carvalho@gmail.com
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Empresa> listadeempresas;

	public MyTableModel() {
		EmpresaDAO dao = new EmpresaDAO();
		
		listadeempresas = dao.findEmpresas();
		
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return listadeempresas.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Empresa l = listadeempresas.get(lin);
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
			return "cod";
		case 1:
			return "nome empresa";
		case 2:
			return "responsável";
		default:
			return "*ERRO*";
		}
	}
}

