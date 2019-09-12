package business;

import java.util.List;

import dao.UnidadeDao;
import model.Unidade;

public class UnidadeBusiness {
	
	UnidadeDao dao = new UnidadeDao(); 
	
	public List<Unidade> ListarUnidade() {		
		return dao.lstUnidade();
	}
	
	public String[] ColunaUnidade(int idx) {
		return dao.colUnidade(idx);
	}

}
