package margulis.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import margulis.pojo.Empresa;

public class EmpresaDAO {

	public Empresa findEmpresaByNome(String nome) {
		Empresa emp = null;
		String cmd = "select * from empresas where nome= ?";

		Connection db = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// abrir conexão
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);
			st.setString(1, nome);
			rs = st.executeQuery();

			while (rs.next()) {
				// copiar dados para POJO
				int EmpId = rs.getInt(1);
				String n = rs.getString(2);
				String responsavel = rs.getString(3);
				emp = new Empresa(EmpId, n, responsavel);
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
		return emp;
	}

	public void insertEmpresa(Empresa emp) {
		String cmd = "insert into empresas(nome, responsavel) values (?, ?)";

		Connection db = null;
		PreparedStatement st = null;

		try {
			// abrir conexão
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);
			st.setInt(1, emp.getEmpId());
			st.setString(2, emp.getNome());
			st.setString(3, emp.getResponsavel());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Empresa!");
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

	public List<Empresa> findEmpresas() {
		String cmd = "select * from empresa ?";
		List<Empresa> empresas = new ArrayList<Empresa>();

		Connection db = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			Properties props = new Properties();
			props.load(new FileInputStream("margulis.properties"));
			String url = props.getProperty("url");

			db = DriverManager.getConnection(url, props);

			st = db.prepareStatement(cmd);
			// st.setString(1, pais);
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

}
