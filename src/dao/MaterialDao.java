package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Material;
import util.Conexao;
import util.Global;

public class MaterialDao {

	public MaterialDao() {
		
	}
	
	public void insMaterial(Material material) {
		String sql = "INSERT INTO materiais ("
				+ "material, codigo1, codigo2, idunidade, idtipo, preco, descricao, uscadast, dtcadast, usmodifi, dtmodifi)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = (Connection) Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);			
			pstm.setString(1, material.getMaterial());
			pstm.setString(2, material.getCodigo1());
			pstm.setString(3, material.getCodigo2());			
			pstm.setInt(4, material.getIdunidade());
			pstm.setInt(5, material.getIdtipo());			
			pstm.setFloat(6, material.getPreco());
			pstm.setString(7, material.getDescricao());			
			pstm.setString(8, material.getUscadast());
			pstm.setTimestamp(9, material.getDtcadast());			
			pstm.setString(10, null);
			pstm.setTimestamp(11, null);																	
			pstm.execute();				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {
				
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
		
		
	}
	
	public void delMaterial(int idmaterial) {
		String sql = "DELETE FROM materiais WHERE idmaterial = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = (Connection) Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);						
			pstm.setInt(1, idmaterial);			
			pstm.execute();				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

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
		
	}
	
	public void atlMaterial(Material material) {	
		String sql = "UPDATE materiais SET "
				+ "material=?, "
				+ "codigo1=?, "
				+ "codigo2=?, "
				+ "idunidade=?, "
				+ "idtipo=?, "
				+ "preco=?, "
				+ "descricao=?, "				
				+ "usmodifi=?, "
				+ "dtmodifi=? "
				+ "WHERE idmaterial=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = (Connection) Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);			
			pstm.setString(1, material.getMaterial());
			pstm.setString(2, material.getCodigo1());
			pstm.setString(3, material.getCodigo2());			
			pstm.setInt(4, material.getIdunidade());
			pstm.setInt(5, material.getIdtipo());
			pstm.setFloat(6, material.getPreco());							
			pstm.setString(7, material.getDescricao());										
			pstm.setString(8, material.getUsmodifi());			
			pstm.setTimestamp(9, material.getDtmodifi());									
			pstm.setInt(10, material.getIdmaterial());	
			pstm.execute();				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

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
	}
	
	
	public List<Material> lstMaterial() {			
		String sql = "SELECT "
				+ "  idmaterial, "
				+ "  material, "
				+ "  codigo1, "
				+ "  codigo2, "
				+ "  idunidade, "
				+ "  unidade, "
				+ "  sigla, "
				+ "  preco, "
				+ "  idtipo, "
				+ "  tipo, "
				+ "  descricao, "
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  vw_materiais ";
		List<Material> lista = new ArrayList<Material>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
 
			while (rset.next()) {
				Material material = new Material();				
				material.setIdmaterial(rset.getInt("idmaterial"));
				material.setMaterial(rset.getString("material"));
				material.setCodigo1(rset.getString("codigo1"));
				material.setCodigo2(rset.getString("codigo2"));					
				material.setIdunidade(rset.getInt("idunidade"));
				material.setUnidade(rset.getString("unidade"));
				material.setSigla(rset.getString("sigla"));
				material.setPreco(rset.getFloat("preco"));
				material.setIdtipo(rset.getInt("idtipo"));
				material.setTipo(rset.getString("tipo"));
				material.setDescricao(rset.getString("descricao"));
				material.setUscadast(rset.getString("uscadast"));
				material.setDtcadast(rset.getTimestamp("dtcadast"));
				material.setUsmodifi(rset.getString("usmodifi"));
				material.setDtmodifi(rset.getTimestamp("dtmodifi"));				
				lista.add(material);
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
		
	@SuppressWarnings("static-access")
	public ArrayList<Object[]> tblMaterial() {					
		String sql = "SELECT "
				+ "  idmaterial, "
				+ "  material, "
				+ "  codigo1, "
				+ "  codigo2, "
				+ "  idunidade, "
				+ "  unidade, "
				+ "  sigla, "
				+ "  preco, "
				+ "  idtipo, "
				+ "  tipo, "
				+ "  descricao, "
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  vw_materiais "
				+ "ORDER BY "
				+ "  idmaterial "
				+ "DESC ";
		
		ArrayList<Object[]> entidade = new ArrayList<Object[]>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery(); 			
			
			DateFormat dtf = new SimpleDateFormat(Global.funcao.getData().getDatahoraformat());			
			DecimalFormat dcf = new DecimalFormat(Global.funcao.getNumero().numeroformato.getFormatoTwo());
			
			while (rset.next()) {				
				entidade.add(new Object[] {
						rset.getInt("idmaterial"),
						rset.getString("material"),
						rset.getString("codigo1"),
						rset.getString("codigo2"),
						rset.getInt("idunidade"),		
						rset.getString("unidade"),		
						rset.getString("sigla"),						
						dcf.format(rset.getDouble("preco")),
						rset.getInt("idtipo"),		
						rset.getString("tipo"),		
						rset.getString("descricao"),
						rset.getString("uscadast"),																	
						rset.getTimestamp("dtcadast") != null ? dtf.format(rset.getTimestamp("dtcadast")) : rset.getTimestamp("dtcadast"),
						rset.getString("usmodifi"),
						rset.getTimestamp("dtmodifi") != null ? dtf.format(rset.getTimestamp("dtmodifi")) : rset.getTimestamp("dtmodifi")});								
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

		return entidade;
	}	
	
	public ArrayList<Object[]> grdMaterial() {					
		String sql = "SELECT "
				+ "  idmaterial, "
				+ "  material, "				
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  vw_materiais "
				+ "ORDER BY "
				+ "  idmaterial "
				+ "ASC ";
		
		ArrayList<Object[]> entidade = new ArrayList<Object[]>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery(); 			
			
			DateFormat dtf = new SimpleDateFormat(Global.funcao.getData().getDatahoraformat());						
			
			while (rset.next()) {				
				entidade.add(new Object[] {
						rset.getInt("idmaterial"),
						rset.getString("material"),						
						rset.getString("uscadast"),																	
						rset.getTimestamp("dtcadast") != null ? dtf.format(rset.getTimestamp("dtcadast")) : rset.getTimestamp("dtcadast"),
						rset.getString("usmodifi"),
						rset.getTimestamp("dtmodifi") != null ? dtf.format(rset.getTimestamp("dtmodifi")) : rset.getTimestamp("dtmodifi")});								
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

		return entidade;
	}
	
	public Material setMaterial(int idmaterial) {			
		String sql = "SELECT "
				+ "  idmaterial, "
				+ "  material, "
				+ "  codigo1, "
				+ "  codigo2, "
				+ "  idunidade, "
				+ "  unidade, "
				+ "  sigla, "
				+ "  preco, " 
				+ "  idtipo, "
				+ "  tipo, "
				+ "  descricao, "
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  vw_materiais "
				+ "WHERE "
				+ "  idmaterial = ? ";

		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;
		Material material = new Material();
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idmaterial);	
			rset = pstm.executeQuery();
			rset.next();
			
			material.setIdmaterial(rset.getInt("idmaterial"));
			material.setMaterial(rset.getString("material"));
			material.setCodigo1(rset.getString("codigo1"));
			material.setCodigo2(rset.getString("codigo2"));
			material.setIdunidade(rset.getInt("idunidade"));
			material.setUnidade(rset.getString("unidade"));
			material.setSigla(rset.getString("sigla"));
			material.setPreco(rset.getFloat("preco"));
			material.setIdtipo(rset.getInt("idtipo"));
			material.setTipo(rset.getString("tipo"));
			material.setDescricao(rset.getString("descricao"));
			material.setUscadast(rset.getString("uscadast"));
			material.setDtcadast(rset.getTimestamp("dtcadast"));
			material.setUsmodifi(rset.getString("usmodifi"));
			material.setDtmodifi(rset.getTimestamp("dtmodifi"));				
		
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
		
		return material;
	}
	
//	public String[] colMaterial(int idx) {								 		
//		List<Material> lista = lstMaterial();		
//		String[] line = new String[lista.size()];						
//		for (int i = 0; i < lista.size(); i++) {			
//			switch (idx) {				
//				case 0: line[i] = String.valueOf(lista.get(i).getIdmaterial()); break;
//				case 1: line[i] = lista.get(i).getMaterial(); break;
//				case 2: line[i] = lista.get(i).getCodigo1(); break;				
//				case 3: line[i] = lista.get(i).getCodigo2(); break;								
//				case 4: line[i] = String.valueOf(lista.get(i).getIdunidade()); break;
//				case 5: line[i] = lista.get(i).getUnidade(); break;
//				case 6: line[i] = lista.get(i).getSigla(); break;				
//				case 7: line[i] = String.valueOf(lista.get(i).getIdtipo()); break;
//				case 8: line[i] = lista.get(i).getTipo(); break;							
//				case 9: line[i] = lista.get(i).getUscadast(); break;
//				case 10: line[i] = lista.get(i).getDtcadast().toString(); break;
//				case 11: line[i] = lista.get(i).getUsmodifi(); break;
//				case 12: line[i] = lista.get(i).getDtmodifi().toString(); break;
//			}
//
//		}		
//		return line;
//	}
	
	

}
