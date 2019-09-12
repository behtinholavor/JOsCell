package model;

import java.sql.Timestamp;

import util.IndexNote;
import util.TitleNote;

public class Acesso {
	@TitleNote(name="title",  value = "Cód")
	@IndexNote(name="idacesso",  index = 0)
	private int idacesso; 
	@TitleNote(name="title",  value = "Acesso")
	@IndexNote(name="acesso",  index = 1)
	private String acesso;
	@TitleNote(name="title",  value = "Inserido por")
	@IndexNote(name="uscadast",  index = 2)
	private String uscadast;	
	@TitleNote(name="title",  value = "Inserido em")
	@IndexNote(name="dtcadast",  index = 3)
	private Timestamp dtcadast;	
	@TitleNote(name="title",  value = "Alterador por")
	@IndexNote(name="usmodifi",  index = 4)
	private String usmodifi;	
	@TitleNote(name="title",  value = "Alterador em")
	@IndexNote(name="dtmodifi",  index = 5)
	private Timestamp dtmodifi;
	
	public Acesso() {
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
		return "Acesso [idacesso=" + idacesso + ", acesso=" + acesso + ", uscadast=" + uscadast + ", dtcadast="
				+ dtcadast + ", usmodifi=" + usmodifi + ", dtmodifi=" + dtmodifi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acesso == null) ? 0 : acesso.hashCode());
		result = prime * result + ((dtcadast == null) ? 0 : dtcadast.hashCode());
		result = prime * result + ((dtmodifi == null) ? 0 : dtmodifi.hashCode());
		result = prime * result + idacesso;
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
		Acesso other = (Acesso) obj;
		if (acesso == null) {
			if (other.acesso != null)
				return false;
		} else if (!acesso.equals(other.acesso))
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
	
}
