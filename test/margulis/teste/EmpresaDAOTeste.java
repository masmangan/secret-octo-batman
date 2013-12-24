package margulis.teste;

import java.util.Random;

import margulis.dao.EmpresaDAO;
import margulis.pojo.Empresa;

/**
 * 
 * @author Dias
 * 
 */
public class EmpresaDAOTeste {
	public static void main(String[] args) {
		EmpresaDAO dao = new EmpresaDAO();
		// random name, column nome is unique
		double r = new Random().nextDouble();
		String empresa = String.format("Empretek (%f)", r);
		Empresa emp = new Empresa(empresa, "Ataliba Timbó");
		dao.insertEmpresa(emp);
		
		emp.setResponsavel("Athaliba Timbou");
		dao.updateEmpresa(emp);

		System.out.println(dao.findEmpresas());
	}
}
