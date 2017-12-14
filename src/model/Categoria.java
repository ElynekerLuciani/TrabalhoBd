package model;

import dao.CategoriaDAO;

public class Categoria {
	private int idCategoria;
	private String nomeCat;
	
	public Categoria(){
		
	}

	
	public void adicionarCategoria(String add){
		try{
			Categoria novaCategoria = new Categoria();
			novaCategoria.setNomeCat(add);
			CategoriaDAO categoria = new CategoriaDAO();
			categoria.criarCategoria(novaCategoria);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//metodos getters setters
	public int getIdCategoria() { return idCategoria; }
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCat() { return nomeCat; }
	public void setNomeCat(String nomeCat) {
		this.nomeCat = nomeCat;
	}
	
	

}
