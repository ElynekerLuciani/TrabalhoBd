package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		Fornecedor a= new Fornecedor();
		//a.cadastrarFornecedor("Antonio", "065.185.793-74", "", true, "Rua aaaaaaaaaa bbbbbbbb", "123", "", "(99) 99999-9999", "", "aaaaaaaaaaa@bbbb.com");
		ArrayList<Fornecedor> b;
		try {
			a.excluirFornecedor(""+4);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
