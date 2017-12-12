package trabalhobd.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import sun.print.PeekGraphics;
import trabalhobd.jdbc.conexao.dao.ConnectionFactory;
import trabalhobd.jdbc.model.Endereco;
import trabalhobd.jdbc.model.Estoque;
import trabalhobd.jdbc.model.Produto;

public class EstoqueDAO {
	private Connection connection;
	private String sql;
	
	
	public EstoqueDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void inserirNoEstoque(Estoque novo) throws Exception{
		sql = "CONSULTA DE INSERIR"; 
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, novo.getIdProduto());
			stmt.setInt(2, novo.getQuantidade());
			stmt.setString(3, novo.getDataEntrada());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage() + " Erro em inserir no estoque.");
		}
	}
	
	public void alterarProduto(Estoque prod) throws Exception {
		sql = "\"UPDATE estoque SET dataEntrada = '?', dataSaida = '?', quantidade = '?' ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, prod.getDataEntrada());
			stmt.setString(2, prod.getDataSaida());
			stmt.setInt(3, prod.getQuantidade());
			
			stmt.executeQuery();
			stmt.close();
			
		} catch (Exception e) {
			throw new Exception("Erro de alterar produto");
		}
	}
	
	
	
	public void retirarDoEstoque(Estoque prod, int qnt) throws Exception {
		if (prod.getQuantidade()> 0) {
			prod.setQuantidade(prod.getQuantidade() - qnt);
			alterarProduto(prod);	
		} else {
			throw new Exception("não tem produto disponível");
		}
	}
	
	public boolean verificarEstoque(Estoque produto) {
		sql = "SELECT quantidade FROM estoque WHERE idProd = " + produto.getIdProduto() + ";";
		try { 
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.close();
			rs.close();
			if( rs.getInt("quantidade") <= 0 ) {
				return false;
			}
			} catch (Exception e) {
			throw new RuntimeException(e);
			}
		return true;
	}
	
	public Produto retornarProduto(int idProduto) throws Exception {
		sql = "SELECT *FROM  produto WHERE idProd = "+ idProduto + ";";
		Produto retorna = new Produto();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			retorna.setIdProduto(idProduto);
			retorna.setIdCat(rs.getInt("idCat"));
			retorna.setNomeProd(rs.getString("nomeProd"));
			retorna.setIdFornecedor(rs.getInt("idFornecedor"));
			retorna.setDescricao(rs.getString("descricao"));
			retorna.setValorCompra(rs.getFloat("valorCompra"));
			retorna.setValorVenda(rs.getFloat("valorVenda"));
			stmt.close();
			rs.close();
			return retorna;
		} catch (Exception e) {
			throw new Exception("Erro em retornar Produto");
		}
	}
	
	
	//metodos getters setters
	public Connection getConnection() { return connection; }
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public String getSql() { return sql; }
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	
	/*
	create table estoque(
			idEstoque INTEGER NOT NULL AUTO_INCREMENT,
		    dataEntrada DATE NOT NULL,
		    dataSaida DATE,
		    idProd INTEGER NOT NULL,
		    quantidade INTEGER NOT NULL,
		    
		    PRIMARY KEY(idEstoque),
		    FOREIGN KEY(idProd) REFERENCES produto(idProduto)
		);
		
		INSERT INTO estoque(dataEntrada, idProd, quantidade)VALUES('2017-11-26', 2, 15);
		
		*/
	
	
}
