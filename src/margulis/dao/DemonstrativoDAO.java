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
		String cmd = "select * from demonstrativos";
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
				double demanda =rs.getDouble(4);

				
				demonstrativo.add(new Demonstrativo(rodada,empid, resultado, vendas, demanda));
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

	/**
	 * 
	 * @param d
	 */
	public void insereDemonstrativo(Demonstrativo d) {
		String cmd = "insert into demonstrativos(periodo, resultado, vendas) values (?, ?, ?)";

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
