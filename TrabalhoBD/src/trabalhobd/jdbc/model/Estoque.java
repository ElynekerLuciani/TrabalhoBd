package trabalhobd.jdbc.model;

import trabalhobd.jdbc.dao.EstoqueDAO;

public class Estoque {
	private int idProduto;
	private String dataEntrada;
	private String dataSaida;
	private int prod;
	private int quantidade;
	
	public Estoque() {
		
	}

	public void adicionarNoEstoque(int idProduto, int qnt, String dataEntr) {
		try {
			Estoque novoItem = new Estoque();
			novoItem.setIdProduto(idProduto);
			novoItem.setQuantidade(qnt);
			novoItem.setDataEntrada(dataEntr);
			EstoqueDAO adicionarNovoItem = new EstoqueDAO();
			adicionarNovoItem.inserirNoEstoque(novoItem);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro ao adicionar no estoque!" );
		}
	}
	
	public void retirarDoEstoque(int idProduto, int qnt) {
		try {
			Estoque retirarItem = new Estoque();
			retirarItem.setIdProduto(idProduto);
			retirarItem.setQuantidade(qnt);
			EstoqueDAO retirarDoEstoque = new EstoqueDAO();
			retirarDoEstoque.retirarDoEstoque(retirarItem, qnt);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro de retirar do estoque!");
		}
		
	}
	
	//metodos getters setters
	public int getIdProduto() { return idProduto; }
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDataEntrada() { return dataEntrada; }
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() { return dataSaida; }
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public int getProd() { return prod; }
	public void setProd(int prod) {
		this.prod = prod;
	}
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
