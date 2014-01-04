package margulis.teste;

import java.util.List;

import margulis.dao.DemonstrativoDAO;
import margulis.pojo.Demonstrativo;

public class DemonstrativoDAOTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DemonstrativoDAO dao = new DemonstrativoDAO();

		Demonstrativo demos = new Demonstrativo(1, 4);
		demos.vendas = 5;
		demos.demanda = 1;
		dao.insereDemonstrativo(demos);

		List<Demonstrativo> teste = dao.findDemonstrativos();
		System.out.println(teste.toString());
	}

}
