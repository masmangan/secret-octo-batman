package margulis.teste;

import java.util.List;

import margulis.dao.DemonstrativoDAO;
import margulis.pojo.Demonstrativo;

public class DemonstrativoDAOTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DemonstrativoDAO dao = new DemonstrativoDAO();
		
		List<Demonstrativo> teste = dao.getDemonstrativo();
		
		System.out.println(teste.toString());
		

	}

}
