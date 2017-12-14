package view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Documento extends PlainDocument{
	
	int tam=0;
	String regex=null;
	
	public Documento(int a,String r){
		super();
		this.tam=a;
		this.regex=r;
	}
	
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		int tamanho=(this.getLength() + str.length());
		if(tamanho <=this.tam){
			super.insertString(offs, str.replaceAll(this.regex, ""), a);
		}else{
			super.insertString(offs, str.replaceAll("[\\S\\s]", ""), a);
		}
	}
}
