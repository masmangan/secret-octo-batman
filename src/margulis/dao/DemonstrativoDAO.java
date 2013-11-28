package margulis.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import margulis.pojo.Demonstrativo;




public class DemonstrativoDAO {
	
	
	public List<Demonstrativo> findDemonstrativo() {
		String cmd = "select * from demonstrativo";
		List<Demonstrativo> demonstrativo = new ArrayList<Demonstrativo>();

		Connection db = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);
			
			rs = st.executeQuery();

			while (rs.next()) {
				int rodada = rs.getInt(1);
				int empid = rs.getInt(2);
				float resultado = rs.getInt(3);
				int vendas =rs.getInt(4);
				
				
				demonstrativo.add(new Demonstrativo(rodada,empid, resultado, vendas));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return demonstrativo;
	}

}
