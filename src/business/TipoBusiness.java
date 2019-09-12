package business;

import java.util.List;

import dao.TipoDao;
import model.Tipo;

public class TipoBusiness {
	
	TipoDao dao = new TipoDao();
	
	public List<Tipo> ListarTipo() {		
		return dao.lstTipo();
	}
	
	public String[] ColunaTipo(int idx) {
		return dao.colTipo(idx);
	}	
	

}
