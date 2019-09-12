package model;

import java.sql.Timestamp;

import util.IndexNote;
import util.TitleNote;

public class Status {
	@TitleNote(name="title",  value = "Cód")
	@IndexNote(name="idstatus",  index = 0)
	private int idstatus;
	@TitleNote(name="title",  value = "Status")
	@IndexNote(name="status",  index = 1)
	private String status; 
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
	
	public Status() {
		
	}

	public int getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(int idstatus) {
		this.idstatus = idstatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Status [idstatus=" + idstatus + ", status=" + status + ", uscadast=" + uscadast + ", dtcadast="
				+ dtcadast + ", usmodifi=" + usmodifi + ", dtmodifi=" + dtmodifi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtcadast == null) ? 0 : dtcadast.hashCode());
		result = prime * result + ((dtmodifi == null) ? 0 : dtmodifi.hashCode());
		result = prime * result + idstatus;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Status other = (Status) obj;
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
		if (idstatus != other.idstatus)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
