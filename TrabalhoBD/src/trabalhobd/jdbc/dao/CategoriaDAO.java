package trabalhobd.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import trabalhobd.jdbc.conexao.dao.ConnectionFactory;
import trabalhobd.jdbc.model.Categoria;

public class CategoriaDAO {
	private Connection connection;
	private String sql;
	
	public CategoriaDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void criarCategoria(Categoria categoria) {
		sql = "INSERT INTO categoria(nomeCat) VALUES('?');";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, categoria.getNomeCat());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro ao inserir uma categoria!");
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
	create table categoria(
			idCategoria INTEGER NOT NULL AUTO_INCREMENT,
		    nomeCat VARCHAR(45) NOT NULL,
		    
		    PRIMARY KEY(idCategoria)
		);
	*/
	

}
