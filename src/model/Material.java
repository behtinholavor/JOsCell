package model;

import java.sql.Timestamp;
import java.util.Observable;
import java.util.Observer;

import util.TitleNote;

public class Material implements Observer {
	@TitleNote(name="title",  value = "Cód")
	private int idmaterial;
	@TitleNote(name="title",  value = "Descrição")
	private String material;
	@TitleNote(name="title",  value = "Código 1")
	private String codigo1;
	@TitleNote(name="title",  value = "Código 2")
	private String codigo2;
	@TitleNote(name="title",  value = "")
	private int idunidade;
	@TitleNote(name="title",  value = "")
	private String unidade;
	@TitleNote(name="title",  value = "Sigla")
	private String sigla;
	@TitleNote(name="title",  value = "R$")
	private float preco;
	@TitleNote(name="title",  value = "")
	private int idtipo;
	@TitleNote(name="title",  value = "Tipo")
	private String tipo;
	@TitleNote(name="title",  value = "Descição auxiliar")
	private String descricao;
	@TitleNote(name="title",  value = "Inserido por")
	private String uscadast;
	@TitleNote(name="title",  value = "Inserido em")
	private Timestamp dtcadast;
	@TitleNote(name="title",  value = "Alterador por")
	private String usmodifi;
	@TitleNote(name="title",  value = "Alterador em")
	private Timestamp dtmodifi;
	Observable pesquisa;
	
	public Material() {

	}
	
	public Material(Observable pesquisa) {
		super();
		this.pesquisa = pesquisa;		
		pesquisa.addObserver(this);
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

	public String getCodigo1() {
		return codigo1;
	}

	public void setCodigo1(String codigo1) {
		this.codigo1 = codigo1;
	}

	public String getCodigo2() {
		return codigo2;
	}

	public void setCodigo2(String codigo2) {
		this.codigo2 = codigo2;
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public void setPesquisa(Observable pesquisa) {
		this.pesquisa = pesquisa;
	}

	@Override
	public void update(Observable pesquisaSubject, Object arg) {
		if (pesquisaSubject instanceof Pesquisa) {
			Pesquisa pesquisa = (Pesquisa) pesquisaSubject;			
			System.out.println("idproduto: " + pesquisa.getRetorno());
		}		
	}
	
	
}
