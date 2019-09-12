package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import util.TitleNote;

public class Servico implements Observer {
	@TitleNote(name="title",  value = "Nº")
	private int idservico;
	@TitleNote(name="title",  value = "Data")
	private Date dtservico;
	@TitleNote(name="title",  value = "")
	private int idstatus;
	@TitleNote(name="title",  value = "Status")
	private String status;
	@TitleNote(name="title",  value = "")
	private int idcliente;
	@TitleNote(name="title",  value = "Cliente")
	private String nome;	
	@TitleNote(name="title",  value = "")
	private int idmoeda;
	@TitleNote(name="title",  value = "Moeda")
	private String moeda;	
	@TitleNote(name="title",  value = "Valor")
	private float valor;
	@TitleNote(name="title",  value = "Acres $")
	private float acrescimo;
	@TitleNote(name="title",  value = "Acres %")
	private double acrescimoperc;
	@TitleNote(name="title",  value = "Desc $")
	private float desconto;
	@TitleNote(name="title",  value = "Desc %")
	private double descontoperc;
	@TitleNote(name="title",  value = "Total")
	private float total;	
	@TitleNote(name="title",  value = "Produto/Serviços")
	private List<ServicoMaterial> ServicoMaterial;
	@TitleNote(name="title",  value = "Inserido por")
	private String uscadast;
	@TitleNote(name="title",  value = "Inserido em")
	private Timestamp dtcadast;
	@TitleNote(name="title",  value = "Alterado por")
	private String usmodifi;
	@TitleNote(name="title",  value = "Alterado em")
	private Timestamp dtmodifi;
		
	Observable pesquisa;
	
	public Servico() {
		
	}
	
	public Servico(Observable pesquisa) {
		super();
		this.pesquisa = pesquisa;
		pesquisa.addObserver(this);
	}

	public int getIdservico() {
		return idservico;
	}

	public void setIdservico(int idservico) {
		this.idservico = idservico;
	}

	public Date getDtservico() {
		return dtservico;
	}

	public void setDtservico(Date dtservico) {
		this.dtservico = dtservico;
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

	public int getIdmoeda() {
		return idmoeda;
	}

	public void setIdmoeda(int idmoeda) {
		this.idmoeda = idmoeda;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(float acrescimo) {
		this.acrescimo = acrescimo;
	}

	public double getAcrescimoperc() {
		return acrescimoperc;
	}

	public void setAcrescimoperc(double acrescimoperc) {
		this.acrescimoperc = acrescimoperc;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public double getDescontoperc() {
		return descontoperc;
	}

	public void setDescontoperc(double descontoperc) {
		this.descontoperc = descontoperc;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	public List<ServicoMaterial> getServicoMaterial() {
		return ServicoMaterial;
	}

	public void setServicoMaterial(List<ServicoMaterial> servicoMaterial) {
		ServicoMaterial = servicoMaterial;
	}
	
	@Override
	public String toString() {
		return "Servico [idservico=" + idservico + ", dtservico=" + dtservico + ", idstatus=" + idstatus + ", status="
				+ status + ", idcliente=" + idcliente + ", nome=" + nome + ", idmoeda=" + idmoeda + ", moeda=" + moeda
				+ ", valor=" + valor + ", acrescimo=" + acrescimo + ", acrescimoperc=" + acrescimoperc + ", desconto="
				+ desconto + ", descontoperc=" + descontoperc + ", total=" + total + ", ServicoMaterial="
				+ ServicoMaterial + ", uscadast=" + uscadast + ", dtcadast=" + dtcadast + ", usmodifi=" + usmodifi
				+ ", dtmodifi=" + dtmodifi + "]";
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ServicoMaterial == null) ? 0 : ServicoMaterial.hashCode());
		result = prime * result + Float.floatToIntBits(acrescimo);
		long temp;
		temp = Double.doubleToLongBits(acrescimoperc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(desconto);
		temp = Double.doubleToLongBits(descontoperc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dtcadast == null) ? 0 : dtcadast.hashCode());
		result = prime * result + ((dtmodifi == null) ? 0 : dtmodifi.hashCode());
		result = prime * result + ((dtservico == null) ? 0 : dtservico.hashCode());
		result = prime * result + idcliente;
		result = prime * result + idmoeda;
		result = prime * result + idservico;
		result = prime * result + idstatus;
		result = prime * result + ((moeda == null) ? 0 : moeda.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + Float.floatToIntBits(total);
		result = prime * result + ((uscadast == null) ? 0 : uscadast.hashCode());
		result = prime * result + ((usmodifi == null) ? 0 : usmodifi.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
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
		Servico other = (Servico) obj;
		if (ServicoMaterial == null) {
			if (other.ServicoMaterial != null)
				return false;
		} else if (!ServicoMaterial.equals(other.ServicoMaterial))
			return false;
		if (Float.floatToIntBits(acrescimo) != Float.floatToIntBits(other.acrescimo))
			return false;
		if (Double.doubleToLongBits(acrescimoperc) != Double.doubleToLongBits(other.acrescimoperc))
			return false;
		if (Float.floatToIntBits(desconto) != Float.floatToIntBits(other.desconto))
			return false;
		if (Double.doubleToLongBits(descontoperc) != Double.doubleToLongBits(other.descontoperc))
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
		if (dtservico == null) {
			if (other.dtservico != null)
				return false;
		} else if (!dtservico.equals(other.dtservico))
			return false;
		if (idcliente != other.idcliente)
			return false;
		if (idmoeda != other.idmoeda)
			return false;
		if (idservico != other.idservico)
			return false;
		if (idstatus != other.idstatus)
			return false;
		if (moeda == null) {
			if (other.moeda != null)
				return false;
		} else if (!moeda.equals(other.moeda))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
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
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

	@Override
	public void update(Observable pesquisaSubject, Object arg) {		
		if (pesquisaSubject instanceof Pesquisa) {
			Pesquisa pesquisa = (Pesquisa) pesquisaSubject;			
			System.out.println("idservico: " + pesquisa.getRetorno());
		}
	}
		

}
