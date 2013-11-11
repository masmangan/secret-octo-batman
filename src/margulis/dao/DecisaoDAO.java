package  margulis.dao;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import  margulis.pojo.Decisao;


public class DecisaoDAO {

	 public Decisao findDecisaoByPeriodo(String periodo) {
         Decisao dec = null;
         String cmd = "select * from decisao where periodo = ? order by empid";

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
                 st.setString(1, periodo);
                 rs = st.executeQuery();

                 while (rs.next()) {
                         // copiar dados para POJO
                         int decisaoId = rs.getInt(1);
                         int empId = rs.getInt(2);
                         String periodoBD = rs.getString("periodo");
                         String preco = rs.getString(5);
                         String marketing = rs.getString(6);
                         String quantidade = rs.getString(7);
                         dec = new Decisao(decisaoId, empId, periodoBD, preco, marketing, quantidade);
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

	 public void insertDecisao(){
		 String cmd = "insert into decisao(decisaoId, empId, periodo, preco, marketing, quantidade) values (?, ?, ?, ?, ?, ?)";

         Connection db = null;
         PreparedStatement st = null;

         try {
                 // abrir conexão
                 Properties props = new Properties();
                 props.load(new FileInputStream("margulis.properties"));
                 String url = props.getProperty("url");

                 db = DriverManager.getConnection(url, props);

                 st = db.prepareStatement(cmd);
                 st.setString(1, dec.getDecisaoId());
                 st.setString(2, dec.getEmpId());
                 st.setString(3, dec.getPeriodo());
                 st.setString(4, dec.getPreco());
                 st.setString(5, dec.getMarketing());
                 st.setString(6, dec.getQuantidade());
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
