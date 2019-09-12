package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Acesso;
import util.Conexao;

public class AcessoDao {
	
	public AcessoDao() {
	
	}
	
	public List<Acesso> lstAcesso() {	
		String sql = "SELECT idacesso, acesso, uscadast, dtcadast, usmodifi, dtmodifi FROM acessos ORDER BY idacesso ASC";		
		
		List<Acesso> listaAcesso = new ArrayList<Acesso>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();	
			
			while (rset.next()) {	
				Acesso acesso = new Acesso();				
				acesso.setIdacesso(rset.getInt("idacesso"));				
				acesso.setAcesso(rset.getString("acesso"));
				acesso.setUscadast(rset.getString("uscadast"));
				acesso.setDtcadast(rset.getTimestamp("dtcadast"));
				acesso.setUsmodifi(rset.getString("usmodifi"));
				acesso.setDtmodifi(rset.getTimestamp("dtmodifi"));				
				listaAcesso.add(acesso);			
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		return listaAcesso; 
	}
	
	public String[] colAcesso(int idx) {								 		
		List<Acesso> lista = lstAcesso();		
		String[] line = new String[lista.size()];						
		for (int i = 0; i < lista.size(); i++) {			
			switch (idx) {
				case 0: line[i] = String.valueOf(lista.get(i).getIdacesso()); break;
				case 1: line[i] = lista.get(i).getAcesso(); break;							
				case 2: line[i] = lista.get(i).getUscadast(); break;
				case 3: line[i] = lista.get(i).getDtcadast().toString(); break;
				case 4: line[i] = lista.get(i).getUsmodifi(); break;
				case 5: line[i] = lista.get(i).getDtmodifi().toString(); break;
			}

		}		
		return line;
	}
	
	

}
