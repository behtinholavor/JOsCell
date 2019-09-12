package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import business.ClienteBusiness;
import model.Cliente;
import util.TitleNote;
import util.Global;
import util.TabelaModelo;

@SuppressWarnings("serial")
public class ClienteView extends CadastroView {
	protected Cliente clsCliente;
	protected ClienteBusiness bsnCliente;
	private JLabel lblIdCliente;
	private JLabel lblNome;
	private JTextField txtNome ;
	private JLabel lblFone;
	private JTextField txtFone;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblObs;
	private JTextPane txtObs;
	private TableRowSorter<TableModel> sorCadastro;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView view = new ClienteView();
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteView() {
		setTitle("Cadastro de Clientes");
		setType(Type.UTILITY);			
		setAlwaysOnTop(true);
		setResizable(false);		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\piece_small@1x.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 540);
		setLocationRelativeTo(null);		
		setContentPane(pnlCadastro);
		
		clsCliente = new Cliente(psqCadastro);
		bsnCliente = new ClienteBusiness();
		
		lblIdCliente = new JLabel("ID");
		lblIdCliente.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblIdCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblIdCliente.setBounds(709, 10, 65, 20);
		pnlForm.add(lblIdCliente);
		
		lblNome = new JLabel("Nome do Cliente");
		lblNome.setBounds(10, 10, 116, 20);
		lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 35, 764, 28);
		txtNome.setToolTipText("Nome do Cliente");
		txtNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		pnlForm.add(txtNome);
		txtNome.setColumns(10);
		
		lblFone = new JLabel("Fone");
		lblFone.setBounds(10, 80, 116, 20);
		lblFone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblFone);
		
		txtFone = new JTextField();
		txtFone.setBounds(10, 105, 162, 28);
		txtFone.setToolTipText("Fone do cliente");
		txtFone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtFone.setColumns(10);
		pnlForm.add(txtFone);
		
		lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(182, 80, 116, 20);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(182, 105, 592, 28);
		txtEmail.setToolTipText("e-mail do cliente");
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		pnlForm.add(txtEmail);
		
		lblObs = new JLabel("Observações");
		lblObs.setBounds(10, 150, 116, 20);
		lblObs.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblObs);
		
		txtObs = new JTextPane();
		txtObs.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtObs.setBounds(10, 175, 764, 153);
		txtObs.setToolTipText("Observações do cliente");
		txtObs.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		pnlForm.add(txtObs);
		CadastroForm(false);

	}
	
	@Override
	public void CadastroInserir() {
		super.CadastroInserir();
		txtNome.requestFocus();
	}

	@Override
	public void CadastroAlterar() {
		super.CadastroAlterar();
		txtNome.requestFocus();
	}

	@Override
	public boolean CadastroRemover() {
		boolean flag = super.CadastroRemover();		
		if (flag == true) {			
			int id = Integer.parseInt(lblIdCliente.getText());					
			bsnCliente.DeletarCliente(id);					
			CadastroGrid(0);			
		}
		return flag;
	}	
	
	@Override
	public boolean CadastroSalvar() {
		boolean flag = super.CadastroSalvar();		
		if (flag == true) {														
			clsCliente.setIdcliente(Integer.parseInt(lblIdCliente.getText()));
			clsCliente.setNome(txtNome.getText());
			clsCliente.setFone(txtFone.getText());
			clsCliente.setEmail(txtEmail.getText());				
			clsCliente.setObs(txtObs.getText());
			
			if (lblIdCliente.getText().equals("0")) {
				clsCliente.setUscadast(Global.sessao.getUsuario().getLogin());
				clsCliente.setDtcadast(new Timestamp(new Date().getTime()));		
				bsnCliente.InserirCliente(clsCliente);					
			} else {								
				clsCliente.setUsmodifi(Global.sessao.getUsuario().getLogin());			
				clsCliente.setDtmodifi(new Timestamp(new Date().getTime()));			
				bsnCliente.AtualizarCliente(clsCliente);											
			}				
			CadastroGrid(lblIdCliente.getText().equals("0") ? 0 : tblCadastro.getSelectedRow());			
		}
		return flag;
	}

	@Override
	public void CadastroCancelar() {
		super.CadastroCancelar();
		tblCadastro.requestFocus();	
	}

	@Override
	public void CadastroGrid(int row) {
		super.CadastroGrid(row);
		
		Field[] fields = clsCliente.getClass().getDeclaredFields();						
		String[] colunas = new String[fields.length-1]; 											
		for (int i = 0; i < fields.length-1; i++) {												
			Annotation annotation = fields[i].getAnnotation(TitleNote.class);			
			if(annotation instanceof TitleNote) {			
				colunas[i] = ((TitleNote) annotation).value();						
			} else {			
				colunas[i] = fields[i].getName();			
			}
	    }	
						
		ArrayList<Object[]> linhas = bsnCliente.TabelaCliente();
		TabelaModelo table = new TabelaModelo(linhas, colunas);	
		
		tblCadastro.setModel(table);		
		tblCadastro.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblCadastro.getColumnModel().getColumn(0).setResizable(false);
		tblCadastro.getColumnModel().getColumn(0).setCellRenderer(CellRight);		
		tblCadastro.getColumnModel().getColumn(0).setHeaderRenderer(ColLeft);
		
		tblCadastro.getColumnModel().getColumn(1).setPreferredWidth(300);
		tblCadastro.getColumnModel().getColumn(1).setResizable(false);
		tblCadastro.getColumnModel().getColumn(1).setCellRenderer(CellLeft);
		tblCadastro.getColumnModel().getColumn(1).setHeaderRenderer(ColLeft);
				
		tblCadastro.getColumnModel().getColumn(2).setPreferredWidth(120);
		tblCadastro.getColumnModel().getColumn(2).setResizable(false);
		tblCadastro.getColumnModel().getColumn(2).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(2).setHeaderRenderer(ColCenter);
				
		tblCadastro.getColumnModel().getColumn(3).setPreferredWidth(350);
		tblCadastro.getColumnModel().getColumn(3).setResizable(false);
		tblCadastro.getColumnModel().getColumn(3).setCellRenderer(CellLeft);
		tblCadastro.getColumnModel().getColumn(3).setHeaderRenderer(ColLeft);					
		
		tblCadastro.getColumnModel().getColumn(4).setPreferredWidth(500);
		tblCadastro.getColumnModel().getColumn(4).setResizable(false);
		tblCadastro.getColumnModel().getColumn(4).setCellRenderer(CellLeft);
		tblCadastro.getColumnModel().getColumn(4).setHeaderRenderer(ColLeft);		
		
		tblCadastro.getColumnModel().getColumn(5).setPreferredWidth(100);		
		tblCadastro.getColumnModel().getColumn(5).setResizable(false);
		tblCadastro.getColumnModel().getColumn(5).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(5).setHeaderRenderer(ColCenter);		
				
		tblCadastro.getColumnModel().getColumn(6).setPreferredWidth(130);
		tblCadastro.getColumnModel().getColumn(6).setResizable(false);
		tblCadastro.getColumnModel().getColumn(6).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(6).setHeaderRenderer(ColCenter);	
				
		tblCadastro.getColumnModel().getColumn(7).setPreferredWidth(100);
		tblCadastro.getColumnModel().getColumn(7).setResizable(false);
		tblCadastro.getColumnModel().getColumn(7).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(7).setHeaderRenderer(ColCenter);				
		
		tblCadastro.getColumnModel().getColumn(8).setPreferredWidth(130);
		tblCadastro.getColumnModel().getColumn(8).setResizable(false);
		tblCadastro.getColumnModel().getColumn(8).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(8).setHeaderRenderer(ColCenter);
		
		
		tblCadastro.getTableHeader().setReorderingAllowed(false);
		tblCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tblCadastro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblCadastro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);			
		tblCadastro.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tblCadastro.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblCadastro.setFillsViewportHeight(true);						
		tblCadastro.setCellSelectionEnabled(false); 		
		tblCadastro.setRowSelectionAllowed(true);	
		
		sorCadastro = new TableRowSorter<TableModel>(tblCadastro.getModel());
		sorCadastro.setRowFilter(null);
        tblCadastro.setRowSorter(sorCadastro);
        
        if (linhas.size() > 0) {
			tblCadastro.setRowSelectionInterval(row, row);
		}
	}

	@Override
	public void CadastroLoad() {
		//super.CadastroLoad();
		if ((tblCadastro.getRowCount() > 0) && (tblCadastro.getSelectedRow() >= 0)) {			
			lblIdCliente.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 0)));
			txtNome.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 1)));
			txtFone.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 2)));
			txtEmail.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 3)));
			txtObs.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 4)));									
		} else {
			CadastroClear();						
		}
	}

	@Override
	public void CadastroClear() {
		super.CadastroClear();
		lblIdCliente.setText("0");
		txtNome.setText("");
		txtFone.setText("");
		txtEmail.setText("");
		txtObs.setText("");
	}
	
	@Override
	public void CadastroPesquisar() {
		super.CadastroPesquisar();		
		if (btnPesquisar.isEnabled()) {
			PesquisaView frmPesquisa = new PesquisaView();
			frmPesquisa.setOwner(frmCadastro);
			frmPesquisa.setAssembly(clsCliente);	
			frmPesquisa.setSearch(psqCadastro);
			frmPesquisa.setVisible(true);					
		}		
	}
	
}
