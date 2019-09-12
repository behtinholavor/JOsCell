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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import business.AcessoBusiness;
import business.UsuarioBusiness;
import model.Usuario;
import util.TitleNote;
import util.Global;
import util.TabelaModelo;

@SuppressWarnings("serial")
public class UsuarioView extends CadastroView {
	protected Usuario clsUsuario;
	protected UsuarioBusiness bsnUsuario;	
	protected AcessoBusiness bsnAcesso;
	private JLabel lblIdUsuario;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblLogin;
	private JTextField txtLogin;
	private JLabel lblSenha;
	private JPasswordField txtSenha;		
	@SuppressWarnings("rawtypes")
	private JComboBox cbbAcesso;
	private JCheckBox chkAtivo;
	private TableRowSorter<TableModel> sorCadastro;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioView view = new UsuarioView();
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Create the frame.
	 * @param menu 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UsuarioView() {
		setTitle("Cadastro de Usuários");
		setType(Type.UTILITY);			
		setAlwaysOnTop(true);
		setResizable(false);		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\piece_small@1x.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 540);
		setLocationRelativeTo(null);		
		setContentPane(pnlCadastro);
			
		clsUsuario = new Usuario(psqCadastro);
		bsnUsuario = new UsuarioBusiness();		
		bsnAcesso  = new AcessoBusiness();
		
		lblIdUsuario = new JLabel("ID");
		lblIdUsuario.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblIdUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblIdUsuario.setBounds(709, 10, 65, 20);
		pnlForm.add(lblIdUsuario);
		
		lblUsuario = new JLabel("Nome do usu\u00E1rio");
		lblUsuario.setBounds(10, 10, 116, 20);
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 35, 764, 28);
		txtUsuario.setToolTipText("Nome do usu\u00E1rio");
		txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		pnlForm.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 80, 116, 20);
		lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(10, 105, 305, 28);
		txtLogin.setToolTipText("Login do usu\u00E1rio");
		txtLogin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtLogin.setColumns(10);
		pnlForm.add(txtLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(325, 80, 116, 20);
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(325, 105, 210, 28);
		txtSenha.setToolTipText("Senha do usu\u00E1rio");
		txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtSenha.setColumns(10);
		pnlForm.add(txtSenha);			
		
		cbbAcesso = new JComboBox();
		cbbAcesso.setToolTipText("Tipo de acesso do usu\u00E1rio");
		cbbAcesso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cbbAcesso.setModel(new DefaultComboBoxModel(bsnAcesso.ColunaAcesso(1)));
		cbbAcesso.setBounds(545, 104, 151, 28);
		pnlForm.add(cbbAcesso);
		
		chkAtivo = new JCheckBox("Status");
		chkAtivo.setSelected(true);
		chkAtivo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		chkAtivo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		chkAtivo.setBounds(702, 104, 73, 28);
		pnlForm.add(chkAtivo);		
		CadastroForm(false);	
	}
	

	@Override
	public void CadastroInserir() {
		super.CadastroInserir();
		txtUsuario.requestFocus();
	}

	@Override
	public void CadastroAlterar() {
		super.CadastroAlterar();
		txtUsuario.requestFocus();		
	}
	
	@Override
	public boolean CadastroRemover() {			
		boolean flag = super.CadastroRemover();		
		if (flag == true) {			
			int id = Integer.parseInt(lblIdUsuario.getText());					
			bsnUsuario.DeletarUsuario(id);					
			CadastroGrid(0);			
		}
		return flag;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean CadastroSalvar() {
		boolean flag = super.CadastroSalvar();		
		if (flag == true) {										
			clsUsuario.setIdusuario(Integer.parseInt(lblIdUsuario.getText()));
			clsUsuario.setUsuario(txtUsuario.getText());
			clsUsuario.setLogin(txtLogin.getText());
			clsUsuario.setSenha(txtSenha.getText());				
			clsUsuario.setIdacesso(cbbAcesso.getSelectedIndex()+1);	
			clsUsuario.setAcesso(cbbAcesso.getSelectedItem().toString());	
			clsUsuario.setAtivo(chkAtivo.isSelected() ? 1 : 0);	
						
			if (lblIdUsuario.getText().equals("0")) {
				clsUsuario.setUscadast(Global.sessao.getUsuario().getLogin());
				clsUsuario.setDtcadast(new Timestamp(new Date().getTime()));		
				bsnUsuario.InserirUsuario(clsUsuario);							
			} else {								
				clsUsuario.setUsmodifi(Global.sessao.getUsuario().getLogin());			
				clsUsuario.setDtmodifi(new Timestamp(new Date().getTime()));			
				bsnUsuario.AtualizarUsuario(clsUsuario);											
			}							
			CadastroGrid(lblIdUsuario.getText().equals("0") ? 0 : tblCadastro.getSelectedRow());
		}
		return flag;							
	}		

	@Override
	public void CadastroCancelar() {
		super.CadastroCancelar();	
		tblCadastro.requestFocus();
		CadastroGrid(0);
	}

	@Override
	public void CadastroGrid(int row) {		
		super.CadastroGrid(row);
		Field[] fields = clsUsuario.getClass().getDeclaredFields();						
		String[] colunas = new String[fields.length-1]; 											
		for (int i = 0; i < fields.length-1; i++) {												
			Annotation annotation = fields[i].getAnnotation(TitleNote.class);			
			if(annotation instanceof TitleNote) {			
				colunas[i] = ((TitleNote) annotation).value();						
			} else {			
				colunas[i] = fields[i].getName();			
			}
	    }	
						
		ArrayList<Object[]> linhas = bsnUsuario.TabelaUsuario();		
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
				
		tblCadastro.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblCadastro.getColumnModel().getColumn(2).setResizable(false);
		tblCadastro.getColumnModel().getColumn(2).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(2).setHeaderRenderer(ColCenter);
				
		tblCadastro.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblCadastro.getColumnModel().getColumn(3).setResizable(false);
		tblCadastro.getColumnModel().getColumn(3).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(3).setHeaderRenderer(ColCenter);					
		
		tblCadastro.getColumnModel().getColumn(4).setPreferredWidth(0);
		tblCadastro.getColumnModel().getColumn(4).setResizable(false);
		tblCadastro.getColumnModel().getColumn(4).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(4).setHeaderRenderer(ColCenter);
		tblCadastro.getColumnModel().getColumn(4).setMaxWidth(0);
				
		tblCadastro.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblCadastro.getColumnModel().getColumn(5).setResizable(false);
		tblCadastro.getColumnModel().getColumn(5).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(5).setHeaderRenderer(ColCenter);
				
		tblCadastro.getColumnModel().getColumn(6).setPreferredWidth(0);
		tblCadastro.getColumnModel().getColumn(6).setResizable(false);
		tblCadastro.getColumnModel().getColumn(6).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(6).setHeaderRenderer(ColCenter);
		tblCadastro.getColumnModel().getColumn(6).setMaxWidth(0);
				
		tblCadastro.getColumnModel().getColumn(7).setPreferredWidth(100);		
		tblCadastro.getColumnModel().getColumn(7).setResizable(false);
		tblCadastro.getColumnModel().getColumn(7).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(7).setHeaderRenderer(ColCenter);		
				
		tblCadastro.getColumnModel().getColumn(8).setPreferredWidth(130);
		tblCadastro.getColumnModel().getColumn(8).setResizable(false);
		tblCadastro.getColumnModel().getColumn(8).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(8).setHeaderRenderer(ColCenter);	
				
		tblCadastro.getColumnModel().getColumn(9).setPreferredWidth(100);
		tblCadastro.getColumnModel().getColumn(9).setResizable(false);
		tblCadastro.getColumnModel().getColumn(9).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(9).setHeaderRenderer(ColCenter);				
		
		tblCadastro.getColumnModel().getColumn(10).setPreferredWidth(130);
		tblCadastro.getColumnModel().getColumn(10).setResizable(false);
		tblCadastro.getColumnModel().getColumn(10).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(10).setHeaderRenderer(ColCenter);
		
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
			lblIdUsuario.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 0)));
			txtUsuario.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 1)));
			txtLogin.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 2)));
			txtSenha.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 3)));			
			cbbAcesso.setSelectedIndex(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 4)).equals("1") ? 0 : 1);
			chkAtivo.setSelected(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 6)).equals("1") ? true : false);						
		} else {
			CadastroClear();						
		}		
		
	}

	@Override
	public void CadastroClear() { 
		super.CadastroClear();
		lblIdUsuario.setText("0");
		txtUsuario.setText("");
		txtLogin.setText("");
		txtSenha.setText("");
		cbbAcesso.setSelectedIndex(1);
		chkAtivo.setSelected(true);		
	}

	@Override
	public void CadastroPesquisar() {
		super.CadastroPesquisar();		
		if (btnPesquisar.isEnabled()) {
			PesquisaView frmPesquisa = new PesquisaView();
			frmPesquisa.setOwner(frmCadastro);
			frmPesquisa.setAssembly(clsUsuario);	
			frmPesquisa.setSearch(psqCadastro);
			frmPesquisa.setVisible(true);					
		}		
	}	

	
}
