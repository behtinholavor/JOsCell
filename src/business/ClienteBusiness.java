package business;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import model.Cliente;

public class ClienteBusiness {	
	
	ClienteDao dao = new ClienteDao(); 
	
	public void InserirCliente(Cliente cliente) {		
		if ((cliente != null) && (cliente.getNome().length() > 0)) {			
			dao.insCliente(cliente);
		}
	}
	
	public void AtualizarCliente(Cliente cliente) {
		if (cliente != null) {			
			dao.atlCliente(cliente);
		}
	}
	
	public void DeletarCliente(int idcliente){
		if (idcliente > 0) {	
			dao.delCliente(idcliente);
		}
	}
		
	public List<Cliente> ListarCliente() {		
		return dao.lstCliente();
	}
	
	public ArrayList<Object[]> TabelaCliente() {
		return dao.tblCliente();
	}
	
	public ArrayList<Object[]> GridCliente() {
		return dao.grdCliente();
	}
	
	public Cliente SetarCliente(int idcliente) {
		return idcliente > 0 ? dao.setCliente(idcliente) : null; 		
	}

}
