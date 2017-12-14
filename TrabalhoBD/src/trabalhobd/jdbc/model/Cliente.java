package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ClienteDAO;

public class Cliente {
	private String id;
	private String nome;
	private String cpf;
	private Endereco endereco;
	private Contato contato;
	private String dataCadastro;
	
	public Cliente(){
		super();
	}
	
	public Cliente(String nome, String cpf,String endereco, String numero, String complemento,String numero1,String numero2,String email){
		this();
		setNome(nome);
		setCpf(cpf);
		setEndereco(new Endereco(endereco, numero, complemento));
		setContato(new Contato(numero1, numero2, email));
	}
	
	public void cadastrarCliente(String nome, String cpf,String endereco, String numero, String complemento,String numero1,String numero2,String email) throws SQLException{
		ClienteDAO con=new ClienteDAO();
		Cliente aux=new Cliente(nome, cpf, endereco, numero, complemento, numero1, numero2, email);
		con.inserirContato(aux.getContato());
		con.inserirEndereco(aux.getEndereco());
		con.inserirCliente(aux);
		con.getBanco().getCon().close();
	}
	
	public ArrayList<Cliente> buscarFornecedor() throws SQLException{
		ClienteDAO con=new ClienteDAO();
		ArrayList<Cliente> aux=con.buscarCliente();
		con.getBanco().getCon().close();
		return aux;
	}
	
	public void excluirFornecedor(String id) throws SQLException{
		ClienteDAO con=new ClienteDAO();
		con.excluirCliente(id);
		con.getBanco().getCon().close();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereço) {
		this.endereco = endereço;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
