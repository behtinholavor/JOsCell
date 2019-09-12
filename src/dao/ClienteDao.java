package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import util.Conexao;
import util.Global;

public class ClienteDao {

	public ClienteDao() {
		
	}
	
	public void insCliente(Cliente cliente) {
		String sql = "INSERT INTO clientes("
				+ "nome, fone, email, obs, uscadast, dtcadast, usmodifi, dtmodifi)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getFone());
			pstm.setString(3, cliente.getEmail());			
			pstm.setString(4, cliente.getObs());							
			pstm.setString(5, cliente.getUscadast());
			pstm.setTimestamp(6, cliente.getDtcadast());			
			pstm.setString(7, null);
			pstm.setTimestamp(8, null);																	
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
	
	public void delCliente(int idcliente) {
		String sql = "DELETE FROM clientes WHERE idcliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);						
			pstm.setInt(1, idcliente);			
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
	
	public void atlCliente(Cliente cliente) {	
		String sql = "UPDATE clientes SET "				
				+ "nome=?, "
				+ "fone=?, "
				+ "email=?, "
				+ "obs=?, "
				+ "usmodifi=?, "
				+ "dtmodifi=? "
				+ "WHERE idcliente=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {							
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getFone());
			pstm.setString(3, cliente.getEmail());			
			pstm.setString(4, cliente.getObs());												
			pstm.setString(5, cliente.getUsmodifi());
			pstm.setTimestamp(6, cliente.getDtmodifi());		
			pstm.setInt(7, cliente.getIdcliente());	
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
	
	
	public List<Cliente> lstCliente() {			
		String sql = "SELECT * FROM clientes";
		List<Cliente> lista = new ArrayList<Cliente>();
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
 
			while (rset.next()) {
				Cliente cliente = new Cliente();				
				cliente.setIdcliente(rset.getInt("idcliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setFone(rset.getString("fone"));
				cliente.setEmail(rset.getString("email"));
				cliente.setObs(rset.getString("obs"));				
				cliente.setUscadast(rset.getString("uscadast"));
				cliente.setDtcadast(rset.getTimestamp("dtcadast"));
				cliente.setUsmodifi(rset.getString("usmodifi"));
				cliente.setDtmodifi(rset.getTimestamp("dtmodifi"));				
				lista.add(cliente);
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
	
	public ArrayList<Object[]> tblCliente() {			
		String sql = "SELECT idcliente, nome, fone, email, obs, uscadast, dtcadast, usmodifi, dtmodifi FROM clientes ORDER BY idcliente DESC";		
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
						rset.getInt("idcliente"),
						rset.getString("nome"),
						rset.getString("fone"),
						rset.getString("email"),												
						rset.getString("obs"),
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
	
	public ArrayList<Object[]> grdCliente() {			
		String sql = "SELECT idcliente, nome, uscadast, dtcadast, usmodifi, dtmodifi FROM clientes ORDER BY idcliente DESC";		
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
						rset.getInt("idcliente"),
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
	
	public Cliente setCliente(int idcliente) {			
		String sql = "SELECT * FROM clientes WHERE idcliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null;
		Cliente cliente = new Cliente();
		
		try {
			conn = Conexao.createConnectionToPostgres();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idcliente);		
			
			rset = pstm.executeQuery();
			rset.next();
			
			cliente.setIdcliente(rset.getInt("idcliente"));
			cliente.setNome(rset.getString("nome"));
			cliente.setFone(rset.getString("fone"));
			cliente.setEmail(rset.getString("email"));
			cliente.setObs(rset.getString("obs"));				
			cliente.setUscadast(rset.getString("uscadast"));
			cliente.setDtcadast(rset.getTimestamp("dtcadast"));
			cliente.setUsmodifi(rset.getString("usmodifi"));
			cliente.setDtmodifi(rset.getTimestamp("dtmodifi"));				
			
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
		
		return cliente;
	}

}
