package trabalhobd.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import trabalhobd.jdbc.conexao.dao.ConnectionFactory;
import trabalhobd.jdbc.model.Pedido;

public class PedidoDAO {
	private Connection connection;
	private String sql;
	
	public PedidoDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
	
	public void adicionarPedido(Pedido ped) throws Exception {
		sql = "INSERT INTO pedido idProduto, quantidade, idCliente VALUES (?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, ped.getProduto().getIdProduto());
			stmt.setInt(2, ped.getQuantidade());
			stmt.setString(3, ped.getCliente().getId());
			stmt.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
