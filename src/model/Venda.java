package model;

public class Venda {
	private int idVenda;
	private int idCliente;
	private int idProduto;
	private int qntProd;
	private float valorUnit;
	private float valorTotal;

	public Venda() {
		
	}

	
	//metodos getters setters
	public int getIdVenda() { return idVenda; }
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdCliente() { return idCliente; }
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdProduto() { return idProduto; }
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQntProd() { return qntProd; }
	public void setQntProd(int qntProd) {
		this.qntProd = qntProd;
	}

	public float getValorUnit() { return valorUnit; }
	public void setValorUnit(float valorUnit) {
		this.valorUnit = valorUnit;
	}

	public float getValorTotal() { return valorTotal; }
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
