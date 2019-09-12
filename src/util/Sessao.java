package util;

import model.Usuario;

public final class Sessao {
	public static String system_user = "system";
	public static String system_pswd = "123456";	
	private Usuario usuario;
	
	public Sessao() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
