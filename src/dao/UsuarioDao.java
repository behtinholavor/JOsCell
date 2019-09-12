package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Usuario;
import util.Conexao;
import util.Global;
import util.Sessao;

public class UsuarioDao {

	public UsuarioDao() {
		
	}	
	
	public void insUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios("
				+ "usuario, login, senha, idacesso, ativo, uscadast, dtcadast, usmodifi, dtmodifi) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);			
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, usuario.getLogin());
			pstm.setString(3, usuario.getSenha());			
			pstm.setInt(4, usuario.getIdacesso());
			pstm.setInt(5, usuario.getAtivo());
			pstm.setString(6, usuario.getUscadast());
			pstm.setTimestamp(7, usuario.getDtcadast());			
			pstm.setString(8, null);
			pstm.setTimestamp(9, null);																		
			pstm.execute();				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {
				
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		
	}
	
	public void delUsuario(int idusuario) {
		String sql = "DELETE FROM usuarios WHERE idusuario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);						
			pstm.setInt(1, idusuario);			
			pstm.execute();				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
	}
	
	public void atlUsuario(Usuario usuario) {	
		String sql = "UPDATE usuarios SET "
				+ "usuario=?, "
				+ "login=?, "
				+ "senha=?, "
				+ "idacesso=?, "
				+ "ativo=?, "				
				+ "usmodifi=?, "
				+ "dtmodifi=? "
				+ "WHERE idusuario=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);			
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, usuario.getLogin());
			pstm.setString(3, usuario.getSenha());						
			pstm.setInt(4, usuario.getIdacesso());
			pstm.setInt(5, usuario.getAtivo());			
			pstm.setString(6, usuario.getUsmodifi());
			pstm.setTimestamp(7, usuario.getDtmodifi());			
			pstm.setInt(8, usuario.getIdusuario());														
			pstm.execute();				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}
	
	
	public List<Usuario> lstUsuario() {			
		String sql = "SELECT "
				+ "  idusuario, "
				+ "  usuario, "
				+ "  login, "
				+ "  senha, "
				+ "  idacesso, "
				+ "  acesso, "
				+ "  ativo, "
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  vw_usuarios";		
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
 			
			while (rset.next()) {
				Usuario usuario = new Usuario();				
				usuario.setIdusuario(rset.getInt("idusuario"));
				usuario.setUsuario(rset.getString("usuario"));
				usuario.setLogin(rset.getString("login"));
				usuario.setSenha(rset.getString("senha"));				
				usuario.setIdacesso(rset.getInt("idacesso"));
				usuario.setAcesso(rset.getString("acesso"));
				usuario.setAtivo(rset.getInt("ativo"));						
				usuario.setUscadast(rset.getString("uscadast"));
				usuario.setDtcadast(rset.getTimestamp("dtcadast"));
				usuario.setUsmodifi(rset.getString("usmodifi"));
				usuario.setDtmodifi(rset.getTimestamp("dtmodifi"));				
				listaUsuario.add(usuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listaUsuario;
	}	
	
	public Usuario autUsuario(String login, String senha) {
		String sql = "SELECT "
				+ "  idusuario, "
				+ "  usuario, "
				+ "  login, "
				+ "  senha, "
				+ "  idacesso, "
				+ "  acesso, "
				+ "  ativo, "
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  vw_usuarios "
				+ "WHERE login = ? AND senha = ? AND ativo = 1 ";
		Usuario usuario = new Usuario();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
				
		try {							
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);						
			pstm.setString(1, login);
			pstm.setString(2, senha);
			rset = pstm.executeQuery();
			while (rset.next()) {							
				usuario.setIdusuario(rset.getInt("idusuario"));
				usuario.setUsuario(rset.getString("usuario"));
				usuario.setLogin(rset.getString("login"));
				usuario.setSenha(rset.getString("senha"));				
				usuario.setIdacesso(rset.getInt("idacesso"));
				usuario.setAcesso(rset.getString("acesso"));
				usuario.setAtivo(rset.getInt("ativo"));						
				usuario.setUscadast(rset.getString("uscadast"));
				usuario.setDtcadast(rset.getTimestamp("dtcadast"));
				usuario.setUsmodifi(rset.getString("usmodifi"));
				usuario.setDtmodifi(rset.getTimestamp("dtmodifi"));								
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return usuario;  				
	}
	
	
	public void rstUsuario(Usuario usuario) {
		String sql = "UPDATE usuarios SET "								
				+ "senha=?,"
				+ "dtmodifi=?"	
				+ "WHERE idusuario=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);						
			pstm.setString(1, Sessao.system_pswd);	
			pstm.setTimestamp(2, new Timestamp(new Date().getTime()));
			pstm.setInt(3, usuario.getIdusuario());														
			pstm.execute();				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Object[]> tblUsuario() {			
		String sql = "SELECT "
				+ "  idusuario, "
				+ "  usuario, "
				+ "  login, "
				+ "  senha, "
				+ "  idacesso, "
				+ "  acesso, "
				+ "  ativo, "
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  vw_usuarios "
				+ "ORDER BY "
				+ "  idusuario "
				+ "DESC";		
		ArrayList<Object[]> dadosUsuario = new ArrayList<Object[]>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery(); 			
		
			DateFormat dtf = new SimpleDateFormat(Global.funcao.getData().getDatahoraformat());
			
			while (rset.next()) {				
				dadosUsuario.add(new Object[] {
						rset.getInt("idusuario"),
						rset.getString("usuario"),
						rset.getString("login"),
						rset.getString("senha"),						
						rset.getInt("idacesso"),
						rset.getString("acesso"),
						rset.getInt("ativo"),						
						rset.getString("uscadast"),																	
						rset.getTimestamp("dtcadast") != null ? dtf.format(rset.getTimestamp("dtcadast")) : rset.getTimestamp("dtcadast"),
						rset.getString("usmodifi"),
						rset.getTimestamp("dtmodifi") != null ? dtf.format(rset.getTimestamp("dtmodifi")) : rset.getTimestamp("dtmodifi")});								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return dadosUsuario;
	}
	
	public ArrayList<Object[]> grdUsuario() {			
		String sql = "SELECT idusuario, usuario, uscadast, dtcadast, usmodifi, dtmodifi FROM usuarios ORDER BY idusuario ASC";		
		ArrayList<Object[]> entidade = new ArrayList<Object[]>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;
		
		DateFormat dtf = new SimpleDateFormat(Global.funcao.getData().getDatahoraformat());

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery(); 									
			
			while (rset.next()) {				
				entidade.add(new Object[] {
						rset.getInt("idusuario"),						
						rset.getString("usuario"),								
						rset.getString("uscadast"),																	
						rset.getTimestamp("dtcadast") != null ? dtf.format(rset.getTimestamp("dtcadast")) : rset.getTimestamp("dtcadast"),
						rset.getString("usmodifi"),
						rset.getTimestamp("dtmodifi") != null ? dtf.format(rset.getTimestamp("dtmodifi")) : rset.getTimestamp("dtmodifi")});								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return entidade;
	}
	
}
