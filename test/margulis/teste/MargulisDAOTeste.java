package margulis.teste;

import margulis.dao.EmpresaDAO;
import margulis.pojo.Empresa;

/**
 * 
 * @author Dias
 * 
 */

public class MargulisDAOTeste {

	public static void main(String[] args) {
		EmpresaDAO dao = new EmpresaDAO();

		// Empresa emp = new Empresa("Empretek", "Ataliba Timbó");

		// dao.insertEmpresa(emp);

		Empresa teste = dao.findEmpresaByNome("Empretek");
		System.out.println(teste.toString());
	}

}
