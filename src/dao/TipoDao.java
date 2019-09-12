package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Tipo;
import util.Conexao;

public class TipoDao {

	public TipoDao() {

	}
	
	public List<Tipo> lstTipo() {	
		String sql = "SELECT "
				+ "  idtipo, "
				+ "  tipo, "
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  tipos "
				+ "ORDER BY "
				+ "  idtipo ASC";		
		
		List<Tipo> lista = new ArrayList<Tipo>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();	
			
			while (rset.next()) {	
				Tipo entidade = new Tipo();				
				entidade.setIdtipo(rset.getInt("idtipo"));
				entidade.setTipo(rset.getString("tipo"));
				entidade.setUscadast(rset.getString("uscadast"));
				entidade.setDtcadast(rset.getTimestamp("dtcadast"));
				entidade.setUsmodifi(rset.getString("usmodifi"));
				entidade.setDtmodifi(rset.getTimestamp("dtmodifi"));				
				lista.add(entidade);			
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
		
		return lista; 
	}
		
	public String[] colTipo(int idx) {								 		
		List<Tipo> lista = lstTipo();		
		String[] line = new String[lista.size()];						
		for (int i = 0; i < lista.size(); i++) {			
			switch (idx) {
				case 0: line[i] = String.valueOf(lista.get(i).getIdtipo()); break;
				case 1: line[i] = lista.get(i).getTipo(); break;							
				case 2: line[i] = lista.get(i).getUscadast(); break;
				case 3: line[i] = lista.get(i).getDtcadast().toString(); break;
				case 4: line[i] = lista.get(i).getUsmodifi(); break;
				case 5: line[i] = lista.get(i).getDtmodifi().toString(); break;
			}

		}		
		return line;
	}

}
