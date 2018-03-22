package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class PaisDAO extends Pais {
	
	public PaisDAO(){}
	
	// INCLUIR
		public void incluir(Pais pais) {
		String sql = "INSERT INTO Pais(id, nome, populacao, area) VALUES (?, ?, ?, ?)";
				try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt   (1, pais.getId());
			stm.setString(2, pais.getNome());
			stm.setLong  (3, pais.getPopulacao());
			stm.setDouble(4, pais.getArea());
		stm.execute();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		//Update
		public void atualizar(Pais pais) {
		String sql = "UPDATE Pais SET nome=?, area=?, populacao=? WHERE id=?";
			    try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt   (1, pais.getId());
			stm.setString(2, pais.getNome());
			stm.setLong  (3, pais.getPopulacao());
			stm.setDouble(4, pais.getArea());
			stm.execute();
			} catch (Exception e) {
			e.printStackTrace();
		}
		}
		//Delete
		public void excluir(int id){
			String sql = "DELETE FROM Pais WHERE id = ?";
				try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sql);) {
				stm.setInt   (1, id);
				stm.execute  ();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		//maiorPopulação
		public void maiorPopulacao() {
			String sql = "SELECT * FROM Pais WHERE populacao = (SELECT MAX(populacao) FROM Pais)";
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(sql);	
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setId(rs.getInt("id"));
					setArea(rs.getDouble("area"));
				}else {
					System.out.println("Error Result Set");
				}
				
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		//menorArea
		public void menorArea() {
			String get = "SELECT * FROM pais WHERE area = (SELECT Min(area) FROM Pais)";
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(get);
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					setNome(rs.getString    ("nome"));
					setPopulacao(rs.getLong ("populacao"));
					setId(rs.getInt			("id"));
					setArea(rs.getDouble    ("area"));
				}else {
					System.out.println("ERROR RESULT SET");
				}
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		//vetorPaises
		public String[] vetorPaises() {	
			String get = "SELECT nome FROM paises ORDER BY nome";
			String[] array = new String[3];
			int cont = 0 ;
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(get);
				ResultSet rs = stm.executeQuery();
				while(rs.next() && cont < 3 ) {
					array[cont] = rs.getString("nome");
					cont ++;
				}
			}catch (SQLException e) {
				System.out.println(e);
			}	
			return array;
		}
}
