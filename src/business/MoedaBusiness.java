package business;

import java.util.List;

import dao.MoedaDao;
import model.Moeda;

public class MoedaBusiness {

	MoedaDao dao = new MoedaDao(); 
	
	public List<Moeda> ListarMoeda() {		
		return dao.lstMoeda();
	}
	
	public String[] ColunaMoeda(int idx) {
		return dao.colMoeda(idx);
	}

}
