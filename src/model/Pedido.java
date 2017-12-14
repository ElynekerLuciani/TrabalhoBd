package trabalhobd.jdbc.model;

import trabalhobd.jdbc.dao.PedidoDAO;

public class Pedido {
	private Produto produto;
	private int quantidade;
	private Cliente cliente;
	
	Pedido() {
		
	}
	
	public void adicionarPedido(Pedido ped) throws Exception {
		try {
			PedidoDAO pedidoDAO = new PedidoDAO();
			Pedido novo = new Pedido();
			novo.setCliente(ped.getCliente());
			novo.setProduto(ped.getProduto());
			novo.setQuantidade(ped.getQuantidade());
			pedidoDAO.adicionarPedido(novo);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
