package br.com.treinaweb.javaee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	public Usuario verificar(Usuario usuario){
		String query = "SELECT usu.idUsuarios "
			         + "FROM loja.usuarios usu "
			         + "WHERE usu.login = '" + usuario.getLogin() + "'"
			         + "  AND usu.senha = '" + usuario.getSenha() + "'";
		
		try {
			ResultSet rs = Conexao.getConnection().createStatement().executeQuery(query);
			if(rs.next()){
				usuario.setIdUsuarios(rs.getInt("idUsuarios"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return usuario;
	}
	
	public boolean salvar(Usuario usuario){
		String query = "INSERT INTO loja.Usuarios( nome , login, senha) "
				                       + "VALUES ( '" + usuario.getNome()  + "'"
				                       + 		", '" + usuario.getLogin() + "'"
				                       + 		", '" + usuario.getSenha() + "'"
				                       + 		")";
		
		 try {
			if(Conexao.getConnection().createStatement().executeUpdate(query) > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
}
