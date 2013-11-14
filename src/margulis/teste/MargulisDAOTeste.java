package margulis.teste;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import margulis.dao.EmpresaDAO;
import margulis.pojo.Empresa;

/**
 * 
 * @author Dias
 *
 */


public class MargulisDAOTeste {

	public static void main(String[] args) {
//		EmpresaDAO dao = new EmpresaDAO();
//			
//		Empresa emp = new Empresa("Empretek", "Ataliba Timbó");
//		
//		//dao.insertEmpresa(emp);
//		
//		Empresa teste = dao.findEmpresaByNome("Empretek");
//		System.out.println(teste.toString());
		
		Connection db = null;
		PreparedStatement st = null;

		try {
			// abrir conexão
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);
			
			System.out.println("conectado");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
