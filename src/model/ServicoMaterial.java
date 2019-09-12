package model;

import java.sql.Timestamp;

import util.TitleNote;

public class ServicoMaterial {
	@TitleNote(name="title",  value = "Seq")
	private int idservicomaterial;
	@TitleNote(name="title",  value = "OS")
	private int idservico;
	@TitleNote(name="title",  value = "Cód")
	private int idmaterial;	
	@TitleNote(name="title",  value = "Descrição")
	private String material;
	@TitleNote(name="title",  value = "")
	private int idunidade;
	@TitleNote(name="title",  value = "")
	private String unidade;
	@TitleNote(name="title",  value = "Sigla")
	private String sigla;
	@TitleNote(name="title",  value = "Qtd")	
	private double qtd;
	@TitleNote(name="title",  value = "Preço")
	private double preco;
	@TitleNote(name="title",  value = "Valor")
	private float valor;		
	@TitleNote(name="title",  value = "")
	private String idtipo;
	@TitleNote(name="title",  value = "Tipo")
	private String tipo;	
	@TitleNote(name="title",  value = "Inserido por")
	private String uscadast;
	@TitleNote(name="title",  value = "Inserido em")
	private Timestamp dtcadast;
	@TitleNote(name="title",  value = "Alterador por")
	private String usmodifi;
	@TitleNote(name="title",  value = "Alterador em")
	private Timestamp dtmodifi;

	public ServicoMaterial() {
		
	}

	public int getIdservicomaterial() {
		return idservicomaterial;
	}

	public void setIdservicomaterial(int idservicomaterial) {
		this.idservicomaterial = idservicomaterial;
	}

	public int getIdservico() {
		return idservico;
	}

	public void setIdservico(int idservico) {
		this.idservico = idservico;
	}

	public int getIdmaterial() {
		return idmaterial;
	}

	public void setIdmaterial(int idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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

	public double getQtd() {
		return qtd;
	}

	public void setQtd(double qtd) {
		this.qtd = qtd;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(String idtipo) {
		this.idtipo = idtipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return "ServicoMaterial [idservicomaterial=" + idservicomaterial + ", idservico=" + idservico + ", idmaterial="
				+ idmaterial + ", material=" + material + ", idunidade=" + idunidade + ", unidade=" + unidade
				+ ", sigla=" + sigla + ", qtd=" + qtd + ", preco=" + preco + ", valor=" + valor + ", idtipo=" + idtipo
				+ ", tipo=" + tipo + ", uscadast=" + uscadast + ", dtcadast=" + dtcadast + ", usmodifi=" + usmodifi
				+ ", dtmodifi=" + dtmodifi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtcadast == null) ? 0 : dtcadast.hashCode());
		result = prime * result + ((dtmodifi == null) ? 0 : dtmodifi.hashCode());
		result = prime * result + idmaterial;
		result = prime * result + idservico;
		result = prime * result + idservicomaterial;
		result = prime * result + ((idtipo == null) ? 0 : idtipo.hashCode());
		result = prime * result + idunidade;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(qtd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
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
		ServicoMaterial other = (ServicoMaterial) obj;
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
		if (idmaterial != other.idmaterial)
			return false;
		if (idservico != other.idservico)
			return false;
		if (idservicomaterial != other.idservicomaterial)
			return false;
		if (idtipo == null) {
			if (other.idtipo != null)
				return false;
		} else if (!idtipo.equals(other.idtipo))
			return false;
		if (idunidade != other.idunidade)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (Double.doubleToLongBits(qtd) != Double.doubleToLongBits(other.qtd))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
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
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}
	
	

}
