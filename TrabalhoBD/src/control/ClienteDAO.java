package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import trabalhobd.jdbc.model.Contato;
import trabalhobd.jdbc.model.Endereco;
import trabalhobd.jdbc.model.Cliente;

public class ClienteDAO {
	private BancoDeDados banco = new BancoDeDados();

	public void conectar() {
		try {
			getBanco().conectaMysql("TrabalhoBD");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public ClienteDAO(){
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

	public void inserirEndereco(Endereco endereco) {
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
			throw new RuntimeException(e);
		}
	}

	public void inserirCliente(Cliente cliente) {
		String sql = "insert into cliente (nome,cpf,idContato,idEndereco) values (?,?,?,?)";
		String sql2 = "SELECT LAST_INSERT_ID() as id from contato";
		String sql3 = "SELECT LAST_INSERT_ID() as id from endereco";
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement(sql);
			PreparedStatement stmt2 = (PreparedStatement) getBanco().getCon().prepareStatement(sql2);
			ResultSet rs = stmt2.executeQuery();
			rs.next();
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, "" + rs.getString("id"));
			stmt2 = (PreparedStatement) getBanco().getCon().prepareStatement(sql3);
			rs=stmt2.executeQuery();
			rs.next();
			stmt.setString(4, "" + rs.getString("id"));
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
	
	public ArrayList<Cliente> buscarCliente(){
		ArrayList<Cliente> cliente=new ArrayList<Cliente>();
		ArrayList<Contato> contatos=buscarContato();
		ArrayList<Endereco> enderecos=buscarEndereco();
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement("select * from cliente");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Cliente aux= new Cliente();
				aux.setId(rs.getString("idcliente"));
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setEndereco(enderecos.remove(0));
				aux.setContato(contatos.remove(0));
				aux.setDataCadastro(rs.getString("dataCadastro"));
				cliente.add(aux);
			}
			stmt.close();
			rs.close();
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void excluirCliente(String id) {
		try {
			PreparedStatement stmt= (PreparedStatement) getBanco().getCon().prepareStatement("select * from cliente where idCliente="+id);
			ResultSet rs = stmt.executeQuery();
			String cliente=id;
			rs.next();
			String endereco=rs.getString("idEndereco");
			String contato=rs.getString("idContato");
			stmt=(PreparedStatement) getBanco().getCon().prepareStatement("delete from cliente where idCliente="+cliente);
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
