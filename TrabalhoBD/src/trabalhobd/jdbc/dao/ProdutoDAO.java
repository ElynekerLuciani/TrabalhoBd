package trabalhobd.jdbc.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

import trabalhobd.jdbc.conexao.dao.ConnectionFactory;
import trabalhobd.jdbc.model.Produto;

public class ProdutoDAO {
	private Connection connection;
	private String sql;
	
	
	public ProdutoDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	
	public void inserirProduto(Produto produto) throws Exception {
		sql = "INSERT INTO produto(idCat, nomeProd, idForn, descricao, valorCompra, valorVenda)" + 
			"VALUES('?', '?','?', '?', '?', '?');";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, produto.getIdCat());
			stmt.setString(2, produto.getNomeProd());
			stmt.setInt(3, produto.getIdFornecedor());
			stmt.setString(4, produto.getDescricao());
			stmt.setFloat(5, produto.getValorCompra());
			stmt.setFloat(6, produto.getValorVenda());
			stmt.execute();
			stmt.close();
		} catch(Exception e) {
			throw new Exception(e.getMessage() + " Erro ao inserir um produto!");
		}
	}
	
	public void removerProduto(Produto idProd) {
		sql = "delete from produto where idProd = '" + idProd.getIdProduto() + "'";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idProd.getIdProduto());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro ao remover produto!");
		}
	}
	
	
	
	//metodos getter setters
	public Connection getConnection() { return connection; }
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getSql() { return sql; }
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	/*
	create table produto(
		idProduto INTEGER NOT NULL AUTO_INCREMENT,
    	idCat INTEGER NOT NULL,
    	nomeProd VARCHAR(45) NOT NULL,
    	idForn INTEGER NOT NULL,
    	descricao VARCHAR(45),
    	valorCompra FLOAT,
    	valorVenda FLOAT,
    
    	PRIMARY KEY(idProduto),
    	FOREIGN KEY(idCat) REFERENCES categoria(idCategoria),
   		FOREIGN KEY(idForn) REFERENCES fornecedor(idFornecedor)
);

	create table fornecedor(
		idFornecedor INTEGER NOT NULL AUTO_INCREMENT,
    	nomeForn VARCHAR(45) NOT NULL,
    	cnpj VARCHAR(14) NOT NULL,
    	email VARCHAR(45),
		celular VARCHAR(15),
		telefone VARCHAR(15), 
		rua VARCHAR(45),
		bairro VARCHAR(45),
		bloco VARCHAR(10),
		numero INTEGER,
		cidade VARCHAR(45),
		estado VARCHAR(45),
		cep VARCHAR(10),
    
    	PRIMARY KEY (idFornecedor)
);

SELECT valorVenda FROM produto WHERE idProduto = 2;

*/

}
