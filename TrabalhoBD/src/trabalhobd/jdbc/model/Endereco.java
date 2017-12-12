package trabalhobd.jdbc.model;

public class Endereco {
	private String endereco;
	private String numero;
	private String complemento;
	private static int cont=0;
	private int id;
	
	public Endereco(){
		super();
	}
	
	public Endereco(String endereco,String numero,String complemento){
		this();
		cont++;
		setId(getCont());
		setEndereco(endereco);
		setNumero(numero);
		setComplemento(complemento);
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static int getCont() {
		return cont;
	}
}
