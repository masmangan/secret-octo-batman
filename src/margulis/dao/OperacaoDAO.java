package margulis.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import margulis.pojo.Demonstrativo;

/**
 * 
 * @author marco
 *
 */
public class OperacaoDAO {
	
	/**
	 * 
	 * @param d
	 */
	public void insereDemonstrativo(Demonstrativo d) {
		String cmd = "insert into demonstrativo(rodada, resultado, vendas) values (?, ?, ?)";

		Connection db = null;
		PreparedStatement st = null;

		try {
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);
			st.setInt(1, d.getRodada());
			st.setFloat(2, d.getResultado());
			st.setInt(3, d.getVendas());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new UnexpectedExecuteUpdateRuntimeException("ERRO AO INSERIR Demonstrativo!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
}
