package margulis.teste;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 
 * @author Paulo
 * 
 */

public class SQListeTeste {

	public static void main(String[] args) {

		Connection db = null;

		try {
			// abrir conexão
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			System.out.println("conectado");
			System.out.println(db);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
