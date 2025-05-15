package br.com.fiap.lojaclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Categoria {
	
	private int idCategoria;
	private String descricao;
	
	public Categoria(int idCategoria, String descricao) {
		super();
		this.idCategoria = idCategoria;
		this.descricao = descricao;
	}

	public Categoria() {}
	
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", descricao=" + descricao + "]";
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void inserirCategoria() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement stmt;
		String sql = "INSERT INTO CATEGORIA (IDCATEGORIA, DESCRICAO) VALUES (?,?)";
		try {
			stmt = cnx.prepareStatement(sql);
			stmt.setInt(1, this.idCategoria);
			stmt.setString(2, this.descricao);
			stmt.executeUpdate();
			System.out.println("Categoria iserida com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarCategoria() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "UPDATE CATEGORIA SET DESCRICAO = ? WHERE IDCATEGORIA = ?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setString(1, this.descricao);
			pstmt.setInt(2, this.idCategoria);
			pstmt.executeLargeUpdate();
			System.out.println("Categoria alterado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void excluirCategoria() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "DELETE FROM CATEGORIA WHERE IDCATEGORIA=?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, this.idCategoria);
			pstmt.executeUpdate();
			System.out.println("Categoria excluida com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Categoria> pesquisarCategorias() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		List<Categoria> lstCategorias = new ArrayList<Categoria>();
		String sql = "SELECT * FROM CATEGORIA";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria();
				c.idCategoria = rs.getInt("IDCATEGORIA");
				c.descricao = rs.getString("DESCRICAO");
				lstCategorias.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstCategorias;
	}
	
	public Categoria pesquisarCategorias(int idCategoria) {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "SELECT * FROM CATEGORIA WHERE IDCATEGORIA = ?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, idCategoria);
			ResultSet rs = pstmt.executeQuery();
						
			while(rs.next()) {
				Categoria c = new Categoria();
				c.idCategoria = rs.getInt("IDCATEGORIA");
				c.descricao = rs.getString("DESCRICAO");
				return c;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Categoria pesquisarCategorias(String descricao) {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "SELECT * FROM categoria WHERE descricao = ?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setString(1, descricao);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Categoria c = new Categoria();
				c.idCategoria = rs.getInt("idcategoria");
				c.descricao = rs.getString("descricao");
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
