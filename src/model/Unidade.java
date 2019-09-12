package model;

import java.sql.Timestamp;

import util.IndexNote;
import util.TitleNote;

public class Unidade {
	@TitleNote(name="title",  value = "Cód")
	@IndexNote(name="idunidade",  index = 0)
	private int idunidade;	
	@TitleNote(name="title",  value = "Unidade")
	@IndexNote(name="unidade",  index = 1)
	private String unidade;
	@TitleNote(name="title",  value = "Sigla")
	@IndexNote(name="sigla",  index = 2)
	private String sigla;	
	@TitleNote(name="title",  value = "Inserido por")
	@IndexNote(name="uscadast",  index = 3)
	private String uscadast;	
	@TitleNote(name="title",  value = "Inserido em")
	@IndexNote(name="dtcadast",  index = 4)
	private Timestamp dtcadast;	
	@TitleNote(name="title",  value = "Alterador por")
	@IndexNote(name="usmodifi",  index = 5)
	private String usmodifi;	
	@TitleNote(name="title",  value = "Alterador em")
	@IndexNote(name="dtmodifi",  index = 6)
	private Timestamp dtmodifi;
		
	public Unidade() {
	}

	public int getIdunidade() {
		return idunidade;
	}

	public void setIdunidade(int idunidade) {
		this.idunidade = idunidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
		return "Unidade [idunidade=" + idunidade + ", unidade=" + unidade + ", sigla=" + sigla + ", uscadast="
				+ uscadast + ", dtcadast=" + dtcadast + ", usmodifi=" + usmodifi + ", dtmodifi=" + dtmodifi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtcadast == null) ? 0 : dtcadast.hashCode());
		result = prime * result + ((dtmodifi == null) ? 0 : dtmodifi.hashCode());
		result = prime * result + idunidade;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
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
		Unidade other = (Unidade) obj;
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
		if (idunidade != other.idunidade)
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
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
