package trabalhobd.jdbc.conexao.dao;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.management.RuntimeErrorException;

//gera conexao com a base de dados
public class ConnectionFactory {
	public Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/fj21", "root", "");
		} catch(Error e) {
			throw new RuntimeErrorException(e);
		}
	}
//teste de maquina
}
