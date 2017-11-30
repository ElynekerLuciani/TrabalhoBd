package trabalhobd.jdbc.model;

import trabalhobd.jdbc.dao.ProdutoDAO;

public class Produto {
	private int idProduto;
	private int idCat;
	private String nomeProd;
	private int idFornecedor;
	private String descricao;
	private float valorCompra;
	private float valorVenda;
	
	public Produto() {
		
	}

	public void adicionarProduto (int idCateg, String nome, int idForn, String descr, float vCompra, float vVenda) {
		try {
			Produto novoProduto = new Produto();
			novoProduto.setIdCat(idCateg);
			novoProduto.setNomeProd(nome);
			novoProduto.setIdFornecedor(idForn);
			novoProduto.setDescricao(descr);
			novoProduto.setValorCompra(vCompra);
			novoProduto.setValorVenda(vVenda);
			ProdutoDAO novo = new ProdutoDAO();
			novo.inserirProduto(novoProduto);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro em adicionar produto");
		}
	}
	
	public void removerProduto (int idProd) {
		try {
			Produto prod = new Produto();
			prod.setIdProduto(idProd);
			ProdutoDAO remover = new ProdutoDAO();
			remover.removerProduto(prod);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro em remover produto!");
		}
		
	}
	
	
	//metodos getters setters
	public int getIdProduto() { return idProduto; }
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdCat() { return idCat; }
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getNomeProd() { return nomeProd; }
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public int getIdFornecedor() { return idFornecedor; }
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { 
		this.descricao = descricao; 
		}
	
	public float getValorCompra() { return valorCompra; }
	public void setValorCompra(float valorCompra) { 
		this.valorCompra = valorCompra; 
	}
	
	public float getValorVenda() { return valorVenda; }
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	

}
