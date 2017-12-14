package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDeDados;

public class VendaDAO {
	private Connection connection;
	private String sql;
	
	public VendaDAO() throws SQLException {
		this.connection = new BancoDeDados().getCon();
	}

	public void realizarVenda() {
		
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
	
	

}
