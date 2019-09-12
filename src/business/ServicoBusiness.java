package business;

import java.util.ArrayList;
import java.util.List;

import dao.ServicoDao;
import model.Servico;

public class ServicoBusiness {
	ServicoDao servicoDao = new ServicoDao();
	
	public void InserirServico(Servico servico) {
		if (servico != null) { //&& (servico.getServicoProduto().size() > 0)) {
			servicoDao.insServico(servico);
		}
	}
	
	public void StatusServico(int idservico, int idstatus) {
		if ((idservico > 0) && (idstatus > -1)) {
			servicoDao.stsServico(idservico, idstatus);
		}
	}
	
	public void AtualizarServico(Servico servico) {	
		servicoDao.atlServico(servico);
	}
	
	public List<Servico> ListarServico() {			
		return servicoDao.lstServico();
	}	
	
	public ArrayList<Object[]> TabelaServico() {	
		return servicoDao.tblServico();
	}
	
	public ArrayList<Object[]> TabelaServicoProduto() {	
		return servicoDao.tblServicoProduto();
	}
	
	public ArrayList<Object[]> GridServico() {	
		return servicoDao.grdServico();
	}	
	
	public Servico SetarServico(int idservico) {		
		return idservico > 0 ? servicoDao.setServico(idservico) : null;	
	}
	

}
