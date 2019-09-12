package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Unidade;
import util.Conexao;

public class UnidadeDao {

	public UnidadeDao() {
		
	}
	
	public List<Unidade> lstUnidade() {	
		String sql = "SELECT "
				+ "  idunidade, "
				+ "  unidade, "
				+ "  sigla, "
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  unidades "
				+ "ORDER BY "
				+ "  idunidade ASC";		
		
		List<Unidade> listaUnidade = new ArrayList<Unidade>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();	
			
			while (rset.next()) {	
				Unidade unidade = new Unidade();				
				unidade.setIdunidade(rset.getInt("idunidade"));
				unidade.setUnidade(rset.getString("unidade"));
				unidade.setSigla(rset.getString("sigla"));
				unidade.setUscadast(rset.getString("uscadast"));
				unidade.setDtcadast(rset.getTimestamp("dtcadast"));
				unidade.setUsmodifi(rset.getString("usmodifi"));
				unidade.setDtmodifi(rset.getTimestamp("dtmodifi"));				
				listaUnidade.add(unidade);			
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
		
		return listaUnidade; 
	}
		
	public String[] colUnidade(int idx) {								 		
		List<Unidade> lista = lstUnidade();		
		String[] line = new String[lista.size()];						
		for (int i = 0; i < lista.size(); i++) {			
			switch (idx) {
				case 0: line[i] = String.valueOf(lista.get(i).getIdunidade()); break;
				case 1: line[i] = lista.get(i).getUnidade(); break;
				case 2: line[i] = lista.get(i).getSigla(); break;				
				case 3: line[i] = lista.get(i).getUscadast(); break;
				case 4: line[i] = lista.get(i).getDtcadast().toString(); break;
				case 5: line[i] = lista.get(i).getUsmodifi(); break;
				case 6: line[i] = lista.get(i).getDtmodifi().toString(); break;
			}

		}		
		return line;
	}
	

}
