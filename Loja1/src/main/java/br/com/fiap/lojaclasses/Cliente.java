package br.com.fiap.lojaclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private int idCliente;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	
	public int getIdCliente() {
		return idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf + "]";
	}
	
	public void insereCliente() {
		Connection cnx = ConnectionDB.obterConexao();
		String sql = "Insert into Cliente (idCliente, nome, email, telefone, cpf )values (?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, this.idCliente);
			pstmt.setString(2, this.nome);
			pstmt.setString(3, this.email);
			pstmt.setString(4, this.telefone);
			pstmt.setString(5, this.cpf);
			pstmt.executeUpdate();
			System.out.println("Sucesso");
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void alteraCliente() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "UPDATE CLIENTE SET EMAIL =?, TELEFONE =? WHERE IDCLIENTE = ?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setString(1, this.email);
			pstmt.setString(2, this.telefone);
			pstmt.setInt(3, this.idCliente);
			pstmt.executeUpdate();
			System.out.println("Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluirCliente() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "DELETE FROM CLIENTE WHERE IDCLIENTE =?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, this.idCliente);
			pstmt.executeUpdate();
			System.out.println("Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Cliente> pesquisarCliente(){
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		List<Cliente> lstCliente = new ArrayList<Cliente>();
		String sql = "SELECT * FROM Cliente";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
						
			while(rs.next()) {
				Cliente c = new Cliente();
				c.idCliente = rs.getInt("IDCLIENTE");
				c.nome = rs.getString("NOME");
				c.email = rs.getString("EMAIL");
				c.telefone = rs.getString("TELEFONE");
				c.cpf = rs.getString("CPF");
				lstCliente.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstCliente;
	}
	
	public List<Cliente> pesquisarCliente(int idCliente){
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		List<Cliente> lstCliente = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente WHERE idcliente = ?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, idCliente);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.idCliente = rs.getInt("IDCLIENTE");
				c.nome = rs.getString("NOME");
				c.email = rs.getString("EMAIL");
				c.telefone = rs.getString("TELEFONE");
				c.cpf = rs.getString("CPF");
				lstCliente.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstCliente;
	}
	
	public List<Cliente> pesquisarCliente(String nome){
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		List<Cliente> lstCliente = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente WHERE nome = ?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setString(1, nome);
			ResultSet rs = pstmt.executeQuery();
						
			while(rs.next()) {
				Cliente c = new Cliente();
				c.idCliente = rs.getInt("IDCLIENTE");
				c.nome = rs.getString("NOME");
				c.email = rs.getString("EMAIL");
				c.telefone = rs.getString("TELEFONE");
				c.cpf = rs.getString("CPF");
				lstCliente.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstCliente;
	}
	
}

