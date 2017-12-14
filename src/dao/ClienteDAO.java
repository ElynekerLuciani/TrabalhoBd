package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Cliente;
import model.Contato;
import model.Endereco;

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

	public void inserirContato(Contato contato) throws Exception {
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
			throw new Exception(e.getMessage());
		}
	}

	public void inserirEndereco(Endereco endereco) throws Exception {
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
			throw new Exception(e.getMessage());
		}
	}

	public void inserirCliente(Cliente cliente) throws Exception {
		String sql = "insert into cliente (nome,cpf,idContato,idEndereco) values (?,?,?,?)";
		String sql2 = "SELECT LAST_INSERT_ID() as idContato from contato";
		String sql3 = "SELECT LAST_INSERT_ID() as idEndereco from endereco";
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement(sql);
			PreparedStatement stmt2 = (PreparedStatement) getBanco().getCon().prepareStatement(sql2);
			ResultSet rs = stmt2.executeQuery();
			rs.next();
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, rs.getString("idContato"));
			stmt2 = (PreparedStatement) getBanco().getCon().prepareStatement(sql3);
			rs=stmt2.executeQuery();
			rs.next();
			stmt.setString(4, rs.getString("idEndereco"));
			stmt2.close();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Endereco buscarEndereco(String id) throws Exception{
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement("select * from Endereco where idEndereco="+id);
			ResultSet rs = stmt.executeQuery();
			Endereco aux= new Endereco();
			while(rs.next()){
				aux.setEndereco(rs.getString("endereco"));
				aux.setNumero(rs.getString("numero"));
				aux.setComplemento(rs.getString("complemento"));
				aux.setId(rs.getInt("idEndereco"));
			}
			stmt.close();
			rs.close();
			return aux;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public ArrayList<Endereco> buscarEndereco() throws Exception{
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
			throw new Exception(e.getMessage());
		}
	}
	
	public Contato buscarContato(String id) throws Exception{
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement("select * from Contato where idContato="+id);
			ResultSet rs = stmt.executeQuery();
			Contato aux= new Contato();
			while(rs.next()){
				aux.setNumero1(rs.getString("numero1"));
				aux.setNumero2(rs.getString("numero2"));
				aux.setEmail(rs.getString("email"));
				aux.setId(rs.getInt("idContato"));
			}
			stmt.close();
			rs.close();
			return aux;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public ArrayList<Contato> buscarContato() throws Exception{
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
			throw new Exception(e.getMessage());
		}
	}
	
	public Cliente buscarCliente(String id) throws Exception{
		Cliente aux=new Cliente();
		try {
			PreparedStatement stmt = (PreparedStatement) getBanco().getCon().prepareStatement("select * from Cliente where idCliente="+id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				aux.setId(rs.getString("idCliente"));
				aux.setNome(rs.getString("nome"));
				aux.setCpf(rs.getString("cpf"));
				aux.setEndereco(buscarEndereco(rs.getString("idEndereco")));
				aux.setContato(buscarContato(rs.getString("idContato")));
				aux.setDataCadastro(rs.getString("dataCadastro"));
			}
			return aux;	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public ArrayList<Cliente> buscarCliente() throws Exception{
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
			throw new Exception(e.getMessage());
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
	
	public void alterarCliente(String id,String nome, String endereco,String numero,String complemento,String numero1,String numero2,String email,String cpf) throws Exception{
		try{
			Cliente Cliente=buscarCliente(id);
			PreparedStatement stmt= (PreparedStatement) getBanco().getCon().prepareStatement("update Cliente set nome= '"+nome+"',cpf='"+cpf+"' where IdCliente =" + Cliente.getId() + ";");
			stmt.executeUpdate();
			stmt= (PreparedStatement) getBanco().getCon().prepareStatement("update Endereco set endereco= '"+endereco+"',numero='"+numero+"',complemento='"+complemento+"' where IdEndereco =" + Cliente.getEndereco().getId() + ";");
			stmt.executeUpdate();
			stmt= (PreparedStatement) getBanco().getCon().prepareStatement("update Contato set numero1= '"+numero1+"',numero2='"+numero2+"',email='"+email+"' where IdContato =" + Cliente.getContato().getId() + ";");
			stmt.executeUpdate();
			stmt.close();
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public BancoDeDados getBanco() {
		return banco;
	}
}
