package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Moeda;
import util.Conexao;

public class MoedaDao {

	public MoedaDao() {

	}
	
	public List<Moeda> lstMoeda() {	
		String sql = "SELECT idmoeda, moeda, uscadast, dtcadast, usmodifi, dtmodifi FROM moedas ORDER BY idmoeda ASC";		
		
		List<Moeda> listaMoeda = new ArrayList<Moeda>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();	
			
			while (rset.next()) {	
				Moeda moeda = new Moeda();				
				moeda.setIdmoeda(rset.getInt("idmoeda"));
				moeda.setMoeda(rset.getString("moeda"));
				moeda.setUscadast(rset.getString("uscadast"));
				moeda.setDtcadast(rset.getTimestamp("dtcadast"));
				moeda.setUsmodifi(rset.getString("usmodifi"));
				moeda.setDtmodifi(rset.getTimestamp("dtmodifi"));				
				listaMoeda.add(moeda);			
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
		
		return listaMoeda; 
	}
	
	public String[] colMoeda(int idx) {								 		
		List<Moeda> lista = lstMoeda();		
		String[] line = new String[lista.size()];						
		for (int i = 0; i < lista.size(); i++) {			
			switch (idx) {
				case 0: line[i] = String.valueOf(lista.get(i).getIdmoeda()); break;
				case 1: line[i] = lista.get(i).getMoeda(); break;							
				case 2: line[i] = lista.get(i).getUscadast(); break;
				case 3: line[i] = lista.get(i).getDtcadast().toString(); break;
				case 4: line[i] = lista.get(i).getUsmodifi(); break;
				case 5: line[i] = lista.get(i).getDtmodifi().toString(); break;
			}

		}		
		return line;
	}

}
