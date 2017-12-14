package dao;

import com.mysql.jdbc.PreparedStatement;
import dao.BancoDeDados;

public class CategoriaDAO {
	private BancoDeDados banco = new BancoDeDados();
	private String sql;
	
	public CategoriaDAO() throws Exception {
		try{
			getBanco().conectaMysql("TrabalhoBD");
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public void criarCategoria(String add) throws Exception {
		sql = "insert into categoria(categoria.nomCat) values (?)";
		try {
			PreparedStatement stmt =(PreparedStatement) getBanco().getCon().prepareStatement(sql);
			stmt.setString(1, add);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	//metodos getters setters

	public String getSql() { return sql; }
	public void setSql(String sql) {
		this.sql = sql;
	}

	public BancoDeDados getBanco() {
		return banco;
	}

	public void setBanco(BancoDeDados banco) {
		this.banco = banco;
	}

}
