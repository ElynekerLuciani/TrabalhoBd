package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Contato;
import model.Endereco;
import model.Fornecedor;

public class FornecedorDAO {
	private BancoDeDados banco = new BancoDeDados();

	public void conectar() {
		try {
			getBanco().conectaMysql("TrabalhoBD");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public FornecedorDAO(){
		super();
		conectar();
	}

	public void inserirContato(Contato contato) {
		Contato aux = contato;
		String sql = "insert into contato (numero1,numero2,email) values (?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement(sql);
			stmt.setString(1, aux.getNumero1());
			stmt.setString(2, aux.getNumero2());
			stmt.setString(3, aux.getEmail());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void inserirEndereco(Endereco endereco) throws SQLException{
		Endereco aux = endereco;
		String sql = "insert into endereco (endereco,numero,complemento) values (?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement(sql);
			stmt.setString(1, aux.getEndereco());
			stmt.setString(2, aux.getNumero());
			stmt.setString(3, aux.getComplemento());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	public void inserirFornecedor(Fornecedor fornecedor) {
		String sql = "insert into fornecedor (nome,cpf,cnpj,isPessoaF,idContato,idEndereco) values (?,?,?,?,?,?)";
		String sql2 = "SELECT LAST_INSERT_ID() as id from contato";
		String sql3 = "SELECT LAST_INSERT_ID() as id from endereco";
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement(sql);
			PreparedStatement stmt2 = (PreparedStatement) getBanco().getCon().prepareStatement(sql2);
			ResultSet rs = stmt2.executeQuery();
			rs.next();
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getCpf());
			stmt.setString(3, fornecedor.getCnpj());
			stmt.setString(4, "" + fornecedor.isPessoaF());
			stmt.setString(5, "" + rs.getString("id"));
			stmt2 = (PreparedStatement) getBanco().getCon().prepareStatement(sql3);
			rs=stmt2.executeQuery();
			rs.next();
			stmt.setString(6, "" + rs.getString("id"));
			stmt2.close();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Endereco> buscarEndereco(){
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement("select * from Endereco");
			ResultSet rs = stmt.executeQuery();
			ArrayList<Endereco> enderecos=new ArrayList<Endereco>();
			while(rs.next()){
				Endereco aux= new Endereco();
				aux.setEndereco(rs.getString("endereco"));
				aux.setNumero(rs.getString("numero"));
				aux.setComplemento(rs.getString("complemento"));
				enderecos.add(aux);
			}
			stmt.close();
			rs.close();
			return enderecos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Contato> buscarContato(){
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement("select * from Contato");
			ResultSet rs = stmt.executeQuery();
			ArrayList<Contato> contatos=new ArrayList<Contato>();
			while(rs.next()){
				Contato aux= new Contato();
				aux.setNumero1(rs.getString("numero1"));
				aux.setNumero2(rs.getString("numero2"));
				aux.setEmail(rs.getString("email"));
				contatos.add(aux);
			}
			stmt.close();
			rs.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Fornecedor> buscarFornecedor(){
		ArrayList<Fornecedor> fornecedores=new ArrayList<Fornecedor>();
		ArrayList<Contato> contatos=buscarContato();
		ArrayList<Endereco> enderecos=buscarEndereco();
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement("select * from Fornecedor");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Fornecedor aux= new Fornecedor();
				aux.setId(rs.getString("idFornecedor"));
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setCnpj(rs.getString("cnpj"));
				aux.setPessoaF(Boolean.parseBoolean(rs.getString("isPessoaF")));
				aux.setEndereco(enderecos.remove(0));
				aux.setContato(contatos.remove(0));
				aux.setDataCadastro(rs.getString("dataCadastro"));
				fornecedores.add(aux);
			}
			stmt.close();
			rs.close();
			return fornecedores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void excluirFornecedor(String id) {
		try {
			PreparedStatement stmt= (PreparedStatement) getBanco().getCon().prepareStatement("select * from Fornecedor where idFornecedor="+id);
			ResultSet rs = stmt.executeQuery();
			String fornecedor=id;
			rs.next();
			String endereco=rs.getString("idEndereco");
			String contato=rs.getString("idContato");
			stmt=(PreparedStatement) getBanco().getCon().prepareStatement("delete from fornecedor where idfornecedor="+fornecedor);
			stmt.executeUpdate();
			stmt=(PreparedStatement) getBanco().getCon().prepareStatement("delete from endereco where idendereco="+endereco);
			stmt.executeUpdate();
			stmt=(PreparedStatement) getBanco().getCon().prepareStatement("delete from contato where idcontato="+contato);
			stmt.executeUpdate();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	public BancoDeDados getBanco() {
		return banco;
	}
}
