package margulis.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 
 * @author marco
 *
 */
public class ZerarDAO {
	
	/**
	 * 
	 */
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

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ZerarDAO dao = new ZerarDAO();
		dao.removerDemonstrativos();
	}
}
