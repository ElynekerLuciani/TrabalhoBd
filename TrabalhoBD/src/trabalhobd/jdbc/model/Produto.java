package trabalhobd.jdbc.model;

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
