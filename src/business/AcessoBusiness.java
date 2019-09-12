package business;

import java.util.List;

import dao.AcessoDao;
import model.Acesso;

public class AcessoBusiness {	
	
	AcessoDao dao = new AcessoDao();
	
	public List<Acesso> ListarAcesso() {		
		return dao.lstAcesso();
	}
	
	public String[] ColunaAcesso(int idx) {
		return dao.colAcesso(idx);
	}

}
