package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.FornecedorDAO;

public class Fornecedor {
	private String nome;
	private String cpf;
	private String cnpj;
	private boolean pessoaF;
	private Endereco endereco;
	private Contato contato;
	private String dataCadastro;
	private String id;

	public Fornecedor(){
		super();
	}

	public Fornecedor(String nome, String cpf, String cnpj,boolean pessoaF,String endereco, String numero, String complemento,String numero1,String numero2,String email){
		this();
		setNome(nome);
		setCpf(cpf);
		setCnpj(cnpj);
		setPessoaF(pessoaF);
		setEndereco(new Endereco(endereco, numero, complemento));
		setContato(new Contato(numero1, numero2, email));
	}
	
	public void cadastrarFornecedor(String nome, String cpf, String cnpj,boolean pessoaF,String endereco, String numero, String complemento,String numero1,String numero2,String email) throws Exception{
		FornecedorDAO con=new FornecedorDAO();
		Fornecedor aux=new Fornecedor(nome, cpf, cnpj, pessoaF, endereco, numero, complemento, numero1, numero2, email);
		con.inserirContato(aux.getContato());
		con.inserirEndereco(aux.getEndereco());
		con.inserirFornecedor(aux);
		con.getBanco().getCon().close();
	}
	
	public ArrayList<Fornecedor> buscarFornecedor() throws Exception{
		FornecedorDAO con=new FornecedorDAO();
		ArrayList<Fornecedor> aux=con.buscarFornecedor();
		con.getBanco().getCon().close();
		return aux;
	}
	
	public Fornecedor buscarFornecedor(String id) throws Exception{
		FornecedorDAO con=new FornecedorDAO();
		Fornecedor aux=con.buscarFornecedor(id);
		con.getBanco().getCon().close();
		return aux;
	}
	
	public void excluirFornecedor(String id) throws Exception{
		FornecedorDAO con=new FornecedorDAO();
		con.excluirFornecedor(id);
		con.getBanco().getCon().close();
	}
	
	public void alterarFornecedor(String id,String nome, String endereco,String numero,String complemento,String numero1,String numero2,String email,String cpf,String cnpj, boolean isPessoaF) throws Exception{
		FornecedorDAO con=new FornecedorDAO();
		con.alterarFornecedor(id, nome, endereco, numero, complemento, numero1, numero2, email, cpf, cnpj, isPessoaF);
		con.getBanco().getCon().close();
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public boolean isPessoaF() {
		return pessoaF;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setPessoaF(boolean pessoaF) {
		this.pessoaF = pessoaF;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
