package business;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioBusiness {	
	UsuarioDao dao = new UsuarioDao(); 
	
	public void InserirUsuario(Usuario usuario) {		
		if ((usuario != null) && (usuario.getUsuario().length() > 0)) {			
			dao.insUsuario(usuario);
		}	
	}
	
	public void AtualizarUsuario(Usuario usuario) {
		if (usuario != null) {			
			dao.atlUsuario(usuario);
		}		
	}
	
	public void DeletarUsuario(int idusuario){
		if (idusuario > 0) {	
			dao.delUsuario(idusuario);				
		}
	}	
	
	public List<Usuario> ListarUsuario() {		
		return dao.lstUsuario();
	}		
	
	public Usuario AutenticarUsuario(String login, String senha) {						
		return dao.autUsuario(login, senha);				
	}
	
	public boolean ResetartUsuario(Usuario usuario) {
		if (usuario != null) {			
			dao.rstUsuario(usuario);
			return true;
		} else {		
			return false;
		}
	}
	
	public ArrayList<Object[]> TabelaUsuario() {
		return dao.tblUsuario();
	}
	
	public ArrayList<Object[]> GridUsuario() {
		return dao.grdUsuario();
	}

}
