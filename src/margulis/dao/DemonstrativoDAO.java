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

/**
 * 
 * @author marco
 *
 */
public class DemonstrativoDAO {
	
	/**
	 * 
	 * @return
	 */
	public List<Demonstrativo> findDemonstrativos() {
		final String cmd = "select * from demonstrativos";
		final List<Demonstrativo> demonstrativo = new ArrayList<Demonstrativo>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("org.sqlite.JDBC");
			final Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			final String url = props.getProperty("url");

			connection = DriverManager.getConnection(url, props);

			statement = connection.prepareStatement(cmd);
			
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int rodada = resultSet.getInt(1);
				int empid = resultSet.getInt(2);
				float resultado = resultSet.getInt(3);
				int vendas =resultSet.getInt(4);
				int demanda =resultSet.getInt(4);

				Demonstrativo de;
				demonstrativo.add(de = new Demonstrativo(rodada,empid));
				de.resultado = resultado;
						de.vendas = vendas;
						de.demanda = demanda;
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
		return demonstrativo;
	}

	/**
	 * 
	 * @param d
	 */
	public void insereDemonstrativo(final Demonstrativo d) {
		final String cmd = "insert into demonstrativos(periodo, resultado, vendas) values (?, ?, ?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			connection = DriverManager.getConnection(url, props);

			statement = connection.prepareStatement(cmd);
			statement.setInt(1, d.getRodada());
			statement.setDouble(2, d.getResultado());
			statement.setInt(3, d.getVendas());
			int r = statement.executeUpdate();

			if (r != 1) {
				throw new UnexpectedExecuteUpdateRuntimeException("ERRO AO INSERIR Demonstrativo!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	}
		
	public final void removerDemonstrativos(){
		String cmd = "delete from demonstrativo";
		
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
			int r = st.executeUpdate();

			if (r != 1) {
				throw new UnexpectedExecuteUpdateRuntimeException("Erro ao remover demonstrativo!");
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
	}
}
