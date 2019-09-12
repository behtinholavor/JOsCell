package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Servico;
import model.ServicoMaterial;
import util.Conexao;
import util.Global;

public class ServicoDao {

	public ServicoDao() {
		
	}
	
	public void insServico(Servico servico) {
		String sql_serv = "INSERT INTO servicos("
				+ "dtservico, "
				+ "idstatus, "
				+ "idcliente, "
				+ "idveiculo, "
				+ "idetapa, "
				+ "idmoeda, "
				+ "valor, "
				+ "acrescimo, "
				+ "acrescimoperc, "
				+ "desconto, "
				+ "descontoperc, "
				+ "total, "
				+ "uscadast, "
				+ "dtcadast, "
				+ "usmodifi, "
				+ "dtmodifi)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		//String sql_prod = "INSERT INTO servicosprodutos(";
		
		Connection conn = null;
		PreparedStatement pstm_serv = null;
		PreparedStatement pstm_prod = null;
				
		try {							
			conn = (Connection) Conexao.createConnectionToPostgres();
			
			pstm_serv = conn.prepareStatement(sql_serv);					
			pstm_serv.setDate(1, servico.getDtservico());			
			pstm_serv.setInt(2, servico.getIdstatus());			
			pstm_serv.setInt(3, servico.getIdcliente());
			pstm_serv.setInt(4, servico.getIdveiculo());
			pstm_serv.setInt(5, servico.getIdetapa());
			pstm_serv.setInt(6, servico.getIdmoeda());			
			pstm_serv.setFloat(7, servico.getValor());
			pstm_serv.setFloat(8, servico.getAcrescimo());
			pstm_serv.setDouble(9, servico.getAcrescimoperc());
			pstm_serv.setFloat(10, servico.getDesconto());
			pstm_serv.setDouble(11, servico.getDescontoperc());
			pstm_serv.setFloat(12, servico.getTotal());						
			pstm_serv.setString(13, servico.getUscadast());
			pstm_serv.setTimestamp(14, servico.getDtcadast());			
			pstm_serv.setString(15, null);
			pstm_serv.setTimestamp(16, null);																				
			pstm_serv.execute();						
			
//			pstm_prod = conn.prepareStatement(sql_prod);
//			pstm_prod.setString(6, produto.getUscadast());
//			pstm_prod.setTimestamp(7, produto.getDtcadast());			
//			pstm_prod.setString(8, null);
//			pstm_prod.setTimestamp(9, null);																				
//			pstm_prod.execute();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {
				
				if (pstm_serv != null) {
					pstm_serv.close();
				}
				
				if (pstm_prod != null) {
					pstm_prod.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 		
	}
	
	
	public void stsServico(int idservico, int idstatus) {
		String sql = "UPDATE servicos SET idstatus = ? WHERE idservico = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = (Connection) Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);						
			pstm.setInt(1, idstatus);
			pstm.setInt(2, idservico);
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
	
	public void atlServico(Servico servico) {	
		String sql_serv = "UPDATE servicos SET "				
				+ "dtservico=?, "
				+ "idstatus=?, "
				+ "idcliente=?, "
				+ "idveiculo=?, "
				+ "idetapa=?, "
				+ "idmoeda=?, "
				+ "valor=?, "
				+ "acrescimo=?, "
				+ "acrescimoperc=?, "
				+ "desconto=?, "
				+ "descontoperc=?, "
				+ "total=?, "				
				+ "usmodifi=?, "
				+ "dtmodifi=?"
				+ "WHERE idservico=? ";
		
		Connection conn = null;
		PreparedStatement pstm_serv = null;
		PreparedStatement pstm_prod = null;
				
		try {							
			conn = (Connection) Conexao.createConnectionToPostgres();			
			pstm_serv = conn.prepareStatement(sql_serv);					
			pstm_serv.setDate(1, servico.getDtservico());	
			pstm_serv.setInt(2, servico.getIdstatus());			
			pstm_serv.setInt(3, servico.getIdcliente());
			pstm_serv.setInt(4, servico.getIdveiculo());
			pstm_serv.setInt(5, servico.getIdetapa());
			pstm_serv.setInt(6, servico.getIdmoeda());			
			pstm_serv.setFloat(7, servico.getValor());
			pstm_serv.setFloat(8, servico.getAcrescimo());
			pstm_serv.setDouble(9, servico.getAcrescimoperc());
			pstm_serv.setFloat(10, servico.getDesconto());
			pstm_serv.setDouble(11, servico.getDescontoperc());
			pstm_serv.setFloat(12, servico.getTotal());												
			pstm_serv.setString(13, servico.getUsmodifi());
			pstm_serv.setTimestamp(14, servico.getDtmodifi());
			pstm_serv.setInt(15, servico.getIdservico());
			pstm_serv.execute();
			
//			pstm = conn.prepareStatement(sql_serv);			
//			pstm.setString(1, produto.getProduto());
//			pstm.setString(2, produto.getCodproduto());
//			pstm.setInt(3, produto.getIdunidade());			
//			pstm.setFloat(4, produto.getPreco());							
//			pstm.setString(5, produto.getDescricao());										
//			pstm.setString(6, produto.getUsmodifi());
//			pstm.setTimestamp(7, produto.getDtmodifi());									
//			pstm.setInt(8, produto.getIdproduto());	
					
			pstm_serv.execute();				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			try {

				if (pstm_serv != null) {
					pstm_serv.close();
				}
				
				if (pstm_prod != null) {
					pstm_prod.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}
	
	public List<Servico> lstServico() {			
		String sql = "SELECT * FROM vw_servicos";
		List<Servico> lista = new ArrayList<Servico>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
 
			while (rset.next()) {
				Servico servico = new Servico();				
				servico.setIdservico(rset.getInt("idservico"));
				servico.setDtservico(rset.getDate("dtservico"));
				servico.setIdstatus(rset.getInt("idstatus"));
				servico.setStatus(rset.getString("status"));
				servico.setIdcliente(rset.getInt("idstatus"));
				servico.setNome(rset.getString("nome"));
				servico.setIdveiculo(rset.getInt("idveiculo"));
				servico.setPlaca(rset.getString("placa"));
				servico.setIdetapa(rset.getInt("idetapa"));
				servico.setEtapa(rset.getString("etapa"));
				servico.setIdmoeda(rset.getInt("idmoeda"));
				servico.setMoeda(rset.getString("moeda"));
				servico.setValor(rset.getFloat("valor"));
				servico.setAcrescimo(rset.getFloat("acrescimo"));
				servico.setAcrescimoperc(rset.getDouble("acrescimoperc"));
				servico.setDesconto(rset.getFloat("desconto"));
				servico.setDescontoperc(rset.getDouble("descontoperc"));
				servico.setTotal(rset.getFloat("total"));
				servico.setUscadast(rset.getString("uscadast"));
				servico.setDtcadast(rset.getTimestamp("dtcadast"));
				servico.setUsmodifi(rset.getString("usmodifi"));
				servico.setDtmodifi(rset.getTimestamp("dtmodifi"));		
				servico.setServicoProduto(lstServicoProduto(servico.getIdservico()));								
				lista.add(servico);
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
	
	public List<ServicoMaterial> lstServicoProduto(int idservico) {			
		String sql = "SELECT * FROM vw_servicosprodutos WHERE idservico = ? ";
		
		List<ServicoMaterial> lista = new ArrayList<ServicoMaterial>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idservico);
			rset = pstm.executeQuery();
 
			while (rset.next()) {
				ServicoMaterial servicoproduto = new ServicoMaterial();				
				servicoproduto.setIdservicoproduto(rset.getInt("idservicoproduto"));
				servicoproduto.setIdservico(rset.getInt("idservico"));						
				servicoproduto.setIdproduto(rset.getInt("idproduto"));				
				servicoproduto.setProduto(rset.getString("produto"));
				servicoproduto.setIdunidade(rset.getInt("idunidade"));
				servicoproduto.setUnidade(rset.getString("unidade"));
				servicoproduto.setSigla(rset.getString("sigla"));				
				servicoproduto.setQtd(rset.getDouble("qtd"));
				servicoproduto.setPreco(rset.getDouble("preco"));
				servicoproduto.setValor(rset.getFloat("valor"));				
				servicoproduto.setUscadast(rset.getString("uscadast"));
				servicoproduto.setDtcadast(rset.getTimestamp("dtcadast"));
				servicoproduto.setUsmodifi(rset.getString("usmodifi"));
				servicoproduto.setDtmodifi(rset.getTimestamp("dtmodifi"));		
				lista.add(servicoproduto);
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
	public ArrayList<Object[]> tblServico() {			
		String sql = "SELECT * FROM vw_servicos ORDER BY idservico DESC";
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
			DecimalFormat dcd = new DecimalFormat(Global.funcao.getNumero().numeroformato.getFormatoThree());
			
			while (rset.next()) {				
				entidade.add(new Object[] {
						rset.getInt("idservico"),						
						rset.getDate("dtservico") != null ? dtf.format(rset.getDate("dtservico")) : rset.getDate("dtservico"),
						rset.getInt("idstatus"), 
						rset.getString("status"),
						rset.getInt("idcliente"),
						rset.getString("nome"),
						rset.getInt("idveiculo"),	
						rset.getString("placa"),
						rset.getInt("idetapa"), 
						rset.getString("etapa"),
						rset.getInt("idmoeda"), 
						rset.getString("moeda"),						
						dcf.format(rset.getFloat("valor")),
						dcf.format(rset.getFloat("acrescimo")),
						dcd.format(rset.getFloat("acrescimoperc")), 
						dcf.format(rset.getFloat("desconto")),
						dcd.format(rset.getFloat("descontoperc")), 
						dcf.format(rset.getFloat("total")), 
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
	
	@SuppressWarnings("static-access")
	public ArrayList<Object[]> tblServicoProduto() {			
		String sql = "SELECT * FROM vw_servicosprodutos";
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
			DecimalFormat dcd = new DecimalFormat(Global.funcao.getNumero().numeroformato.getFormatoThree());
			
			while (rset.next()) {				
				entidade.add(new Object[] {
						rset.getInt("idservicoproduto"),
						rset.getInt("idservico"),
						rset.getInt("idproduto"),
						rset.getString("produto"),	
						rset.getInt("idunidade"), 
						rset.getString("unidade"),
						rset.getString("sigla"),												
						dcd.format(rset.getFloat("qtd")), 
						dcd.format(rset.getFloat("preco")), 
						dcf.format(rset.getFloat("valor")), 						
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
	
	public ArrayList<Object[]> grdServico() {					
		String sql = "SELECT "
				+ "  idservico, "
				+ "  nome, "				
				+ "  uscadast, "
				+ "  dtcadast, "
				+ "  usmodifi, "
				+ "  dtmodifi "
				+ "FROM "
				+ "  vw_servicos "
				+ "ORDER BY "
				+ "  idservico "
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
						rset.getInt("idservico"),
						rset.getString("nome"),		
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
	
	public Servico setServico(int idservico) {			
		String sql = "SELECT * FROM vw_servicos WHERE idservico = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;
		Servico servico = new Servico();
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idservico);
			rset = pstm.executeQuery();
			rset.next();	
			
			servico.setIdservico(rset.getInt("idservico"));
			servico.setDtservico(rset.getDate("dtservico"));
			servico.setIdstatus(rset.getInt("idstatus"));
			servico.setStatus(rset.getString("status"));
			servico.setIdcliente(rset.getInt("idcliente"));
			servico.setNome(rset.getString("nome"));
			servico.setIdveiculo(rset.getInt("idveiculo"));
			servico.setPlaca(rset.getString("placa"));
			servico.setIdetapa(rset.getInt("idetapa"));
			servico.setEtapa(rset.getString("etapa"));
			servico.setIdmoeda(rset.getInt("idmoeda"));
			servico.setMoeda(rset.getString("moeda"));
			servico.setValor(rset.getFloat("valor"));
			servico.setAcrescimo(rset.getFloat("acrescimo"));
			servico.setAcrescimoperc(rset.getDouble("acrescimoperc"));
			servico.setDesconto(rset.getFloat("desconto"));
			servico.setDescontoperc(rset.getDouble("descontoperc"));
			servico.setTotal(rset.getFloat("total"));
			servico.setUscadast(rset.getString("uscadast"));
			servico.setDtcadast(rset.getTimestamp("dtcadast"));
			servico.setUsmodifi(rset.getString("usmodifi"));
			servico.setDtmodifi(rset.getTimestamp("dtmodifi"));	
			servico.setServicoProduto(lstServicoProduto(servico.getIdservico()));	
				
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

		return servico;
	}


}
