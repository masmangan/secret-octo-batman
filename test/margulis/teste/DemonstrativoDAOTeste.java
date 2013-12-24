package margulis.teste;

import java.util.List;

import margulis.dao.DemonstrativoDAO;
import margulis.dao.OperacaoDAO;
import margulis.pojo.Demonstrativo;

public class DemonstrativoDAOTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DemonstrativoDAO dao = new DemonstrativoDAO();
		
		List<Demonstrativo> teste = dao.getDemonstrativo();
		
		System.out.println(teste.toString());
		
		OperacaoDAO dao2 = new OperacaoDAO();
		
		
		
		Demonstrativo demos = new Demonstrativo(1, 4, 5, 1.0);
	
		dao2.insereDemonstrativo(demos);
	

	}

}
