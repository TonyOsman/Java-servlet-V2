package br.com.fiap.lojaclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Produto {
	
	private int idProduto;
	private String descricao;
	private double preco;
	private Categoria categoria;
	
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricao=" + descricao + ", preco=" + preco + ", categoria="
				+ categoria.getDescricao() + "]";
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void inserirProduto() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "INSERT INTO produto (idproduto, descricao, preco, idcategoria) VALUES(?,?,?,?)";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, this.idProduto);
			pstmt.setString(2, this.descricao);
			pstmt.setDouble(3, this.preco);
			pstmt.setInt(4, this.categoria.getIdCategoria());
			pstmt.executeUpdate();
			System.out.println("Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarProduto() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "UPDATE produto SET descricao=?, preco=? WHERE idproduto=?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setString(1, this.descricao);
			pstmt.setDouble(2, this.preco);
			pstmt.setInt(3, this.idProduto);
			pstmt.executeUpdate();
			System.out.println("Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Produto> pesquisarProduto(){
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		List<Produto> lstProduto = new ArrayList<Produto>();
		String sql = "SELECT a.idproduto, a.descricao, a.preco, b.descricao categoria FROM produto a INNER JOIN categoria b ON a.idcategoria = b.idcategoria";
		try {
			pstmt = cnx.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();
				Categoria c = new Categoria();
				p.descricao = rs.getString("descricao");
				p.idProduto = rs.getInt("idProduto");
				p.preco = rs.getDouble("preco");
				c.setDescricao(rs.getString("categoria"));
				p.categoria = c.pesquisarCategorias(rs.getString("categoria"));
				lstProduto.add(p);
			}
			System.out.println("Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstProduto;
	}
	
	public List<Produto> pesquisarProduto(String descricao) {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "SELECT a.idproduto, a.descricao, a.preco, b.descricao categoria FROM produto a INNER JOIN categoria b ON a.idcategoria = b.idcategoria WHERE a.descricao LIKE UPPER(?) COLLATE BINARY_CI";
		List<Produto> lstProduto = new ArrayList<Produto>();
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setString(1, "%"+descricao.toUpperCase()+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Produto p = new Produto();
				Categoria c = new Categoria();
				p.idProduto = rs.getInt("idproduto");
				p.descricao = rs.getString("descricao");
				p.preco = rs.getDouble("preco");
				p.categoria = c.pesquisarCategorias(rs.getString("categoria"));
				lstProduto.add(p);
			}
			System.out.println("Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstProduto;
	}
}
