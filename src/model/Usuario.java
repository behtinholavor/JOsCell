package model;

import java.sql.Timestamp;
import java.util.Observable;
import java.util.Observer;

import util.TitleNote;

public class Usuario implements Observer {
	@TitleNote(name="title",  value = "Cód")	
	private int idusuario;	
	@TitleNote(name="title",  value = "Nome do usuário")
	private String usuario;	
	@TitleNote(name="title",  value = "Login")	
	private String login;
	@TitleNote(name="title",  value = "Senha")
	private String senha;	
	@TitleNote(name="title",  value = "")	
	private int idacesso;	
	@TitleNote(name="title",  value = "Tipo de acesso")
	private String acesso;
	@TitleNote(name="title",  value = "")
	private int ativo;
	@TitleNote(name="title",  value = "Inserido por")
	private String uscadast;
	@TitleNote(name="title",  value = "Inserido em")
	private Timestamp dtcadast;
	@TitleNote(name="title",  value = "Alterado por")
	private String usmodifi;
	@TitleNote(name="title",  value = "Alterado em")
	private Timestamp dtmodifi;
	
	Observable pesquisa;
	
	public Usuario() {			
		
	}
	
	public Usuario(Observable pesquisa) {
		super();
		this.pesquisa = pesquisa;
		pesquisa.addObserver(this);
	}


	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdacesso() {
		return idacesso;
	}

	public void setIdacesso(int idacesso) {
		this.idacesso = idacesso;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public String getUscadast() {
		return uscadast;
	}

	public void setUscadast(String uscadast) {
		this.uscadast = uscadast;
	}

	public Timestamp getDtcadast() {
		return dtcadast;
	}

	public void setDtcadast(Timestamp dtcadast) {
		this.dtcadast = dtcadast;
	}

	public String getUsmodifi() {
		return usmodifi;
	}

	public void setUsmodifi(String usmodifi) {
		this.usmodifi = usmodifi;
	}

	public Timestamp getDtmodifi() {
		return dtmodifi;
	}

	public void setDtmodifi(Timestamp dtmodifi) {
		this.dtmodifi = dtmodifi;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", usuario=" + usuario + ", login=" + login + ", senha=" + senha
				+ ", idacesso=" + idacesso + ", acesso=" + acesso + ", ativo=" + ativo + ", uscadast=" + uscadast
				+ ", dtcadast=" + dtcadast + ", usmodifi=" + usmodifi + ", dtmodifi=" + dtmodifi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acesso == null) ? 0 : acesso.hashCode());
		result = prime * result + ativo;
		result = prime * result + ((dtcadast == null) ? 0 : dtcadast.hashCode());
		result = prime * result + ((dtmodifi == null) ? 0 : dtmodifi.hashCode());
		result = prime * result + idacesso;
		result = prime * result + idusuario;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((uscadast == null) ? 0 : uscadast.hashCode());
		result = prime * result + ((usmodifi == null) ? 0 : usmodifi.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (acesso == null) {
			if (other.acesso != null)
				return false;
		} else if (!acesso.equals(other.acesso))
			return false;
		if (ativo != other.ativo)
			return false;
		if (dtcadast == null) {
			if (other.dtcadast != null)
				return false;
		} else if (!dtcadast.equals(other.dtcadast))
			return false;
		if (dtmodifi == null) {
			if (other.dtmodifi != null)
				return false;
		} else if (!dtmodifi.equals(other.dtmodifi))
			return false;
		if (idacesso != other.idacesso)
			return false;
		if (idusuario != other.idusuario)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (uscadast == null) {
			if (other.uscadast != null)
				return false;
		} else if (!uscadast.equals(other.uscadast))
			return false;
		if (usmodifi == null) {
			if (other.usmodifi != null)
				return false;
		} else if (!usmodifi.equals(other.usmodifi))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public void update(Observable pesquisaSubject, Object arg) {		
		if (pesquisaSubject instanceof Pesquisa) {
			Pesquisa pesquisa = (Pesquisa) pesquisaSubject;			
			System.out.println("idusuario: " + pesquisa.getRetorno());
		}
	}
	
}
