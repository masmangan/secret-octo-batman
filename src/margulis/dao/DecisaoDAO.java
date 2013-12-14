package margulis.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import margulis.pojo.Decisao;

/**
 * 
 * @author 
 *
 */
public class DecisaoDAO {
	
	Decisao dec;
	
	/**
	 * 
	 * @param periodo
	 * @return
	 */
	public List<Decisao> findDecisaoByPeriodo() {

		List<Decisao> decisoes = new ArrayList<Decisao>();
		String cmd = "select * from decisao";

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
				int decisaoid = rs.getInt("codigo");
				int empid = rs.getInt("codigo_empresa");
				int periodoBD = rs.getInt("periodo");
				double preco = rs.getDouble("preco");
				double marketing = rs.getDouble("marketing");
				int quantidade = rs.getInt("quantidade");
				decisoes.add(new Decisao(decisaoid, empid, periodoBD, preco, marketing, quantidade));
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
		return decisoes;
	}
	
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
				int decisaoid = rs.getInt("codigo");
				int empid = rs.getInt("codigo_empresa");
				int periodoBD = rs.getInt("periodo");
				double preco = rs.getDouble("preco");
				double marketing = rs.getDouble("marketing");
				int quantidade = rs.getInt("quantidade");
				dec = new Decisao(decisaoid, empid, periodoBD, preco, marketing, quantidade);
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
		String cmd = "insert into decisao(codigo_empresa, periodo, preco, marketing, quantidade) values (?, ?, ?, ?, ?, ?)";

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
			st.setInt(1, dec.getEmpid());
			st.setInt(2, dec.getRodada());
			st.setDouble(3, dec.getPreco());
			st.setDouble(4, dec.getMarketing());
			st.setInt(4, dec.getProducao());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new UnexpectedExecuteUpdateRuntimeException("ERRO AO INSERIR DECIS�O!");
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

	public void updateDecisao(int decisaoid) {
		String cmd = "update decisao set periodo = ?, preco = ?, marketing = ?, quantidade = ? where codigo = ?";

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
			st.setInt(1, dec.getRodada());
			st.setDouble(2, dec.getPreco());
			st.setDouble(3, dec.getMarketing());
			st.setInt(4, dec.getProducao());
			st.setInt(5, decisaoid);
			int r = st.executeUpdate();

			if (r != 1) {
				throw new UnexpectedExecuteUpdateRuntimeException("ERRO AO ATUALIZAR DECIS�O!");
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
