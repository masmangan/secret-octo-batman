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

		Demonstrativo demos = new Demonstrativo(1, 4, 5, 1.0);
		dao.insereDemonstrativo(demos);

		List<Demonstrativo> teste = dao.findDemonstrativos();
		System.out.println(teste.toString());
	}

}
