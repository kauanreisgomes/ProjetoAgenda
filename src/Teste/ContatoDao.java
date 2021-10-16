package Teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ContatoDao {
	
	private Connection con;

	public ContatoDao() {
		con = new ConnectionFactory().getConnection();
	}	
	//Salva um contato novo no banco de dados
	public void salvarDao(Contato contato) {
		
		String sql ="insert into contato(nome, sobrenome, idade, telefone) values(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getSobrenome());
			ps.setInt(3,contato.getIdade());
			ps.setString(4, contato.getTelefone());
			
			ps.execute();
			ps.close();
			
			System.out.println("Contato salvo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Edita um contato específico
	public void editarDao(Contato contato) {
		
		String sql = "update contato set nome=?, sobrenome=?, idade=?, telefone=? where id=?";					       
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getSobrenome());
			ps.setInt(3,contato.getIdade());
			ps.setString(4, contato.getTelefone());
			ps.setLong(5, contato.getId());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletarDao(Long id) {
		
		String sql ="delete from contato where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setLong(1, id);
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Retorna todos os contatos.
	public List<Contato> consultarDao() {

		List<Contato> contatos = new ArrayList<>();
		
		try {

			String sql = "select * from contato";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Contato contato = new Contato();
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setSobrenome(rs.getString("sobrenome"));
				contato.setIdade(rs.getInt("idade"));
				contato.setTelefone(rs.getString("Telefone"));
				
				contatos.add(contato);
			}

			rs.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return contatos;
	}
}
