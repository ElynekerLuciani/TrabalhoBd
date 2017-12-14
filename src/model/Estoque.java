package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.EstoqueDAO;

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
	
	public ArrayList<Estoque> buscarEstoque () throws SQLException {
		EstoqueDAO daoEstoque = new EstoqueDAO();
		ArrayList<Estoque> aux= daoEstoque.listarEstoque();
		return aux;
	}
	
	public int quantidadeNoEstoque(int idProduto) {
		int temp = 0;
		try {
			Estoque quantidadeEstoque = new Estoque();
			quantidadeEstoque.setQuantidade(idProduto);
			EstoqueDAO estoque = new EstoqueDAO();
			temp = estoque.verificarEstoque(quantidadeEstoque);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return temp;
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
