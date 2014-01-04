package margulis.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import margulis.pojo.Empresa;

/**
 * 
 * @author
 * 
 */
public class EmpresaDAO {

	/**
	 * Insert a new company into database.
	 * 
	 * Before saving, company ID must be set to -1.
	 * After saving, company ID is updated to generated key.
	 * 
	 * @param emp
	 */
	public void insertEmpresa(final Empresa emp) {
		final String cmd = "insert into empresas(nome, responsavel) values (?, ?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			if (emp.getEmpId() != -1) {
				throw new UnexpectedExecuteUpdateRuntimeException("Erro ao inserir Empresa!");
			}

			connection = DriverManager.getConnection(url, props);

			statement = connection.prepareStatement(cmd);
			statement.setString(1, emp.getNome());
			statement.setString(2, emp.getResponsavel());
			int r = statement.executeUpdate();
			if (r != 1) {
				throw new UnexpectedExecuteUpdateRuntimeException("Erro ao inserir Empresa!");
			}
			
			ResultSet x = statement.getGeneratedKeys();
			x.next();
			int k = x.getInt(1);
			emp.setEmpId(k);

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

	/**
	 * Find and retrieve all companies from database.
	 * 
	 * @return
	 */
	public List<Empresa> findEmpresas() {
		String cmd = "select * from empresas";
		List<Empresa> empresas = new ArrayList<Empresa>();

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
				int empid = rs.getInt(1);
				String nome = rs.getString(2);
				String responsavel = rs.getString(3);
				empresas.add(new Empresa(empid, nome, responsavel));
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
		return empresas;
	}

	/**
	 * Updates a company record, based on company ID.
	 * 
	 * Company ID is set after insert or find.
	 * 
	 * @param emp
	 */
	public void updateEmpresa(Empresa emp) {

		if (emp.getEmpId() == -1) {
			throw new UnexpectedExecuteUpdateRuntimeException("Erro ao atualizar Empresa!");
		}
		
		String cmd = "update empresas set nome = ?, responsavel = ? where idempresa = ?";

		Connection db = null;
		PreparedStatement st = null;
		try {
			Class.forName("org.sqlite.JDBC");
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);

			st.setString(1, emp.getNome());
			st.setString(2, emp.getResponsavel());
			st.setInt(3, emp.getEmpId());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new UnexpectedExecuteUpdateRuntimeException("Erro ao atualizar dado!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((st != null) || (db != null)) {
				try {
					st.close();
					db.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
