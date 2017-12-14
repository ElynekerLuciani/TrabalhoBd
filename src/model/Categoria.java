package model;

import dao.CategoriaDAO;

public class Categoria {
	private int idCategoria;
	private String nomeCat;
	
	public Categoria(){
		
	}
	
	public void adicionarCategoria(String add) throws Exception{
		try{
			CategoriaDAO categoria = new CategoriaDAO();
			categoria.criarCategoria(add);
			categoria.getBanco().getCon().close();
		} catch(Exception e) {
			throw new Exception(e.getMessage());
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
