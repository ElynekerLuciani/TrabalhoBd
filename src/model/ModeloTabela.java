package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel{
	private ArrayList<Object> Linhas= null;
	private String[] Colunas=null;
	
	public ModeloTabela(ArrayList<Object> lin,String[] col){
		super();
		setLinhas(lin);
		setColunas(col);
	}
	
	public ArrayList<Object> getLinhas(){
		return Linhas;
	}
	
	public void setLinhas(ArrayList<Object> dados){
		this.Linhas = dados;
	}
	
	public String[] getColunas(){
		return Colunas;
	}
	
	public void setColunas(String[] nomes){
		this.Colunas=nomes;
	}
	
	public int getColumnCount(){
		return Colunas.length;
	}
	
	public int getRowCount(){
		return Linhas.size();
	}
	
	public String getColumnName(int numCol){
		return Colunas[numCol];
	}
	
	public Object getValueAt(int numLin,int numCol){
		Object[] Linha=(Object[])getLinhas().get(numLin);
		return Linha[numCol];
	}
}
