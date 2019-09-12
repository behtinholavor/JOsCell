package model;

import java.sql.Timestamp;
import java.util.Observable;
import java.util.Observer;

import util.TitleNote;

public class Cliente implements Observer {
	@TitleNote(name="title",  value = "Cód")
	private int idcliente;
	@TitleNote(name="title",  value = "Nome/Razão")
	private String nome;
	@TitleNote(name="title",  value = "Fone")
	private String fone;
	@TitleNote(name="title",  value = "e-mail")
	private String email;
	@TitleNote(name="title",  value = "observções")
	private String obs;
	@TitleNote(name="title",  value = "Inserido por")
	private String uscadast;
	@TitleNote(name="title",  value = "Inserido em")
	private Timestamp dtcadast;
	@TitleNote(name="title",  value = "Alterador por")
	private String usmodifi;
	@TitleNote(name="title",  value = "Alterador em")
	private Timestamp dtmodifi;
	Observable pesquisa;
	
	public Cliente() {
		
	}
	
	public Cliente(Observable pesquisa) {
		super();
		this.pesquisa = pesquisa;		
		pesquisa.addObserver(this);
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
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
	
	public Observable getPesquisa() {
		return pesquisa;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", nome=" + nome + ", fone=" + fone + ", email=" + email + ", obs="
				+ obs + ", uscadast=" + uscadast + ", dtcadast=" + dtcadast + ", usmodifi=" + usmodifi + ", dtmodifi="
				+ dtmodifi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtcadast == null) ? 0 : dtcadast.hashCode());
		result = prime * result + ((dtmodifi == null) ? 0 : dtmodifi.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fone == null) ? 0 : fone.hashCode());
		result = prime * result + idcliente;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((uscadast == null) ? 0 : uscadast.hashCode());
		result = prime * result + ((usmodifi == null) ? 0 : usmodifi.hashCode());
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
		Cliente other = (Cliente) obj;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		if (idcliente != other.idcliente)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
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
		return true;
	}

	@Override
	public void update(Observable pesquisaSubject, Object arg) {
		if (pesquisaSubject instanceof Pesquisa) {
			Pesquisa pesquisa = (Pesquisa) pesquisaSubject;			
			System.out.println("idcliente: " + pesquisa.getRetorno());
		}		
	}
	
	
}
