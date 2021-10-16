package Teste;

import java.sql.Connection;
import java.util.List;

public class teste {

	public static void main(String[] args) {
		
		Connection con = ConnectionFactory.getConnection();
		
		ContatoDao dao = new ContatoDao();
		
		//dao.salvarDao();
		//dao.editarDao();
		//dao.deletarDao();
		
		List<Contato> lista = dao.consultarDao();
		
		for(Contato contato: lista) {
			System.out.print(contato.getNome() + " " + contato.getIdade());
		}
		
	}

}
