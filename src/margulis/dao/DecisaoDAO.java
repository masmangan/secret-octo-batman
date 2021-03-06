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
 */
public class DecisaoDAO {
		
	/**
	 * 
	 * @param periodo
	 * @return
	 */
	public List<Decisao> findDecisaoByPeriodo() {

		final List<Decisao> decisoes = new ArrayList<Decisao>();
		final String cmd = "select * from decisoes";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("org.sqlite.JDBC");
			final Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			connection = DriverManager.getConnection(url, props);

			statement = connection.prepareStatement(cmd);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int decisaoid = resultSet.getInt("iddecisao");
				int empid = resultSet.getInt("idempresa");
				int periodoBD = resultSet.getInt("periodo");
				double preco = resultSet.getDouble("preco");
				double marketing = resultSet.getDouble("marketing");
				int producao = resultSet.getInt("producao");
				decisoes.add(new Decisao(decisaoid, empid, periodoBD, preco, marketing, producao));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return decisoes;
	}
	
	public Decisao findDecisaoByPeriodo(final String periodo) {

		Decisao dec = null;
		String cmd = "select * from decisao where periodo = ? order by idempresa";

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

	public void insertDecisao(Decisao dec) {
		String cmd = "insert into decisao(idempresa, periodo, preco, marketing, quantidade) values (?, ?, ?, ?, ?, ?)";

		Connection db = null;
		PreparedStatement st = null;

		try {
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);
			//Decisao dec = null;
			st.setInt(1, dec.getEmpId());
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

	public void updateDecisao(Decisao dec) {
		String cmd = "update decisao set periodo = ?, preco = ?, marketing = ?, quantidade = ? where decisaoid = ?";

		Connection db = null;
		PreparedStatement st = null;

		try {
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);
			//Decisao dec = null;
			st.setInt(1, dec.getRodada());
			st.setDouble(2, dec.getPreco());
			st.setDouble(3, dec.getMarketing());
			st.setInt(4, dec.getProducao());
			//st.setInt(5, decisaoid);
			st.setInt(5, dec.getDecisaoId());

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
