package margulis.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import margulis.pojo.Decisao;

/**
 * 
 * @author 
 *
 */
public class DecisaoDAO {

	Decisao dec;

	public Decisao findDecisaoByPeriodo(String periodo) {

		Decisao dec = null;
		String cmd = "select * from decisao where periodo = ? order by empid";

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
			st.setString(1, periodo);
			rs = st.executeQuery();

			while (rs.next()) {
				int decisaoid = rs.getInt(1);
				int empid = rs.getInt(2);
				String periodoBD = rs.getString("periodo");
				double preco = rs.getDouble(5);
				double marketing = rs.getDouble(6);
				int quantidade = rs.getInt(7);
				dec = new Decisao(decisaoid, empid, periodoBD, preco,
						marketing, quantidade);
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
		return dec;
	}

	public void insertDecisao() {
		String cmd = "insert into decisao(decisaoid, empid, periodo, preco, marketing, quantidade) values (?, ?, ?, ?, ?, ?)";

		Connection db = null;
		PreparedStatement st = null;

		try {
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);
			dec = null;
			st.setInt(1, dec.getDecisaoid());
			st.setInt(2, dec.getEmpid());
			st.setString(3, dec.getPeriodo());
			st.setDouble(4, dec.getPreco());
			st.setDouble(5, dec.getMarketing());
			st.setInt(6, dec.getQuantidade());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("ERRO AO INSERIR DECISÃO!");
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
