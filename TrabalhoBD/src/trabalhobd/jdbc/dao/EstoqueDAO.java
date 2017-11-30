package trabalhobd.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import trabalhobd.jdbc.conexao.dao.ConnectionFactory;
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
	
	public void retirarDoEstoque(Estoque prod) {
		sql = "CONSULTA PARA RETIRAR DO ESTOQUE";
		if (true) {
			
		} else {

		}
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean verificarEstoque(int idProd) {
		return true;
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
