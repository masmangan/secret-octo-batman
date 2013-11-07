package margulis.teste;

import margulis.dao.MargulisDAO;
import margulis.pojo.Empresa;

/**
 * 
 * @author Dias
 *
 */


public class MargulisDAOTeste {

	public static void main(String[] args) {
		MargulisDAO dao = new MargulisDAO();
			
		Empresa emp = new Empresa("Empretek", "Ataliba Timbó");
		
		//dao.insertEmpresa(emp);
		
		Empresa teste = dao.findEmpresaByNome("Empretek");
		System.out.println(teste.toString());
		
		
	}

}
