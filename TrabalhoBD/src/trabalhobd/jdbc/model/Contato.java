package trabalhobd.jdbc.model;

public class Contato {
	private String numero1;
	private String numero2;
	private String email;
	private static int cont=0;
	private int id;
	
	public Contato(){
		super();
	}
	
	public Contato(String numero1, String numero2, String email){
		this();
		cont++;
		setId(getCont());
		setNumero1(numero1);
		setNumero2(numero2);
		setEmail(email);
	}

	public String getNumero1() {
		return numero1;
	}

	public String getNumero2() {
		return numero2;
	}

	public String getEmail() {
		return email;
	}

	public void setNumero1(String numero1) {
		this.numero1 = numero1;
	}

	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}

	public void setEmail(String email) {
		this.email = email;
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
