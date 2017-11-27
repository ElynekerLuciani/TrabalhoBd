package trabalhobd.jdbc.model;

public class Estoque {
	private int idProduto;
	private String dataEntrada;
	private String dataSaida;
	private Produto prod = new Produto();
	private int quantidade;
	
	public Estoque() {
		
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

	public Produto getProd() { return prod; }
	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
