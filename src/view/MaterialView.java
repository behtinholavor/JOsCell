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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import business.MaterialBusiness;
import business.TipoBusiness;
import business.UnidadeBusiness;
import model.Material;
import util.TitleNote;
import util.Global;
import util.TabelaModelo;

@SuppressWarnings("serial")
public class MaterialView extends CadastroView {
	private Material clsMaterial;
	private MaterialBusiness bsnMaterial;
	private UnidadeBusiness bsnUnidade;
	private TipoBusiness bsnTipo;
	private JLabel lblIdMaterial;
	private JLabel lblMaterial;
	private JTextField txtMaterial;
	private JLabel lblCodigo1;
	private JTextField txtCodigo1;
	private JLabel lblPreco;
	private JTextField txtPreco;
	@SuppressWarnings("rawtypes")
	private JComboBox cbbUnidade;
	@SuppressWarnings("rawtypes")
	private JComboBox cbbTipo;
	private JLabel lblDescricao;
	private JTextPane txtDescricao;
	private TableRowSorter<TableModel> sorCadastro;	
	private JTextField txtCodigo2;
	private JLabel lblTipo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaterialView view = new MaterialView();
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
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public MaterialView() {
		setTitle("Cadastro de Materiais");
		setType(Type.UTILITY);			
		setAlwaysOnTop(true);
		setResizable(false);		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Global.getInstance().getPathgrc()+"\\png\\piece_small@1x.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 540);
		setLocationRelativeTo(null);		
		setContentPane(pnlCadastro);
		
		clsMaterial = new Material(psqCadastro);
		bsnMaterial = new MaterialBusiness();
		bsnUnidade = new UnidadeBusiness();
		bsnTipo = new TipoBusiness();
		
		lblIdMaterial = new JLabel("ID");
		lblIdMaterial.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblIdMaterial.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblIdMaterial.setBounds(709, 10, 65, 20);
		pnlForm.add(lblIdMaterial);
		
		lblMaterial = new JLabel("Descrição");
		lblMaterial.setBounds(10, 10, 182, 20);
		lblMaterial.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblMaterial);
		
		txtMaterial = new JTextField();
		txtMaterial.setBounds(10, 35, 764, 28);
		txtMaterial.setToolTipText("Descrição do produto");
		txtMaterial.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		pnlForm.add(txtMaterial);
		txtMaterial.setColumns(10);
		
		lblCodigo1 = new JLabel("C\u00F3digo 1");
		lblCodigo1.setBounds(198, 80, 188, 20);
		lblCodigo1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblCodigo1);
		
		txtCodigo1 = new JTextField();
		txtCodigo1.setBounds(198, 105, 188, 28);
		txtCodigo1.setToolTipText("C\u00F3digo prim\u00E1rio do material");
		txtCodigo1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtCodigo1.setColumns(10);
		pnlForm.add(txtCodigo1);
				
		lblPreco = new JLabel("R$");
		lblPreco.setBounds(595, 80, 82, 20);
		lblPreco.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(595, 105, 116, 28);
		txtPreco.setToolTipText("Preço do produto (R$)");
		txtPreco.setFont(new Font("Segoe UI", Font.PLAIN, 15));		
		pnlForm.add(txtPreco);
		
		cbbUnidade = new JComboBox();
		cbbUnidade.setToolTipText("Unidade do material");
		cbbUnidade.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cbbUnidade.setModel(new DefaultComboBoxModel(bsnUnidade.ColunaUnidade(2)));
		cbbUnidade.setBounds(721, 105, 53, 28);
		pnlForm.add(cbbUnidade);
		
		lblDescricao = new JLabel("Descrição auxiliar");
		lblDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDescricao.setBounds(10, 150, 156, 20);
		pnlForm.add(lblDescricao);
		
		txtDescricao = new JTextPane();
		txtDescricao.setToolTipText("Descrição auxiliar do produto");
		txtDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtDescricao.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDescricao.setBounds(10, 175, 764, 153);
		pnlForm.add(txtDescricao);
		
		JLabel lblCodigo2 = new JLabel("C\u00F3digo 2");
		lblCodigo2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCodigo2.setBounds(396, 80, 188, 20);
		pnlForm.add(lblCodigo2);
		
		txtCodigo2 = new JTextField();
		txtCodigo2.setToolTipText("C\u00F3digo secund\u00E1rio do material");
		txtCodigo2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtCodigo2.setColumns(10);
		txtCodigo2.setBounds(396, 105, 188, 28);
		pnlForm.add(txtCodigo2);
		
		cbbTipo = new JComboBox();
		cbbTipo.setToolTipText("Tipo do material");
		cbbTipo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cbbTipo.setModel(new DefaultComboBoxModel(bsnTipo.ColunaTipo(1)));
		cbbTipo.setBounds(10, 105, 179, 28);
		pnlForm.add(cbbTipo);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTipo.setBounds(10, 80, 179, 20);
		pnlForm.add(lblTipo);
		
		CadastroForm(false);
		
	}
	
	
	@Override
	public void CadastroInserir() {
		super.CadastroInserir();
		txtMaterial.requestFocus();
	}

	@Override
	public void CadastroAlterar() {
		super.CadastroAlterar();
		txtMaterial.requestFocus();		
	}
	
	@Override
	public boolean CadastroRemover() {			
		boolean flag = super.CadastroRemover();		
		if (flag == true) {			
			int id = Integer.parseInt(lblIdMaterial.getText());					
			bsnMaterial.DeletarMaterial(id);					
			CadastroGrid(0);			
		}
		return flag;
	}
	
	@Override
	public boolean CadastroSalvar() {
		boolean flag = super.CadastroSalvar();		
		if (flag == true) {										
			clsMaterial.setIdmaterial(Integer.parseInt(lblIdMaterial.getText()));
			clsMaterial.setMaterial(txtMaterial.getText());
			clsMaterial.setCodigo1(txtCodigo1.getText());
			clsMaterial.setCodigo2(txtCodigo1.getText());			
			clsMaterial.setPreco(Float.parseFloat(txtPreco.getText().replaceAll(",", ".")));			
			clsMaterial.setIdunidade(cbbUnidade.getSelectedIndex()+1);	
			clsMaterial.setUnidade(cbbUnidade.getSelectedItem().toString());						
			clsMaterial.setIdtipo(cbbTipo.getSelectedIndex()+1);	
			clsMaterial.setTipo(cbbTipo.getSelectedItem().toString());						
			clsMaterial.setDescricao(txtDescricao.getText());
			
			if (lblIdMaterial.getText().equals("0")) {
				clsMaterial.setUscadast(Global.sessao.getUsuario().getLogin());
				clsMaterial.setDtcadast(new Timestamp(new Date().getTime()));		
				bsnMaterial.InserirMaterial(clsMaterial);							
			} else {								
				clsMaterial.setUsmodifi(Global.sessao.getUsuario().getLogin());			
				clsMaterial.setDtmodifi(new Timestamp(new Date().getTime()));			
				bsnMaterial.AtualizarMaterial(clsMaterial);											
			}							
			CadastroGrid(lblIdMaterial.getText().equals("0") ? 0 : tblCadastro.getSelectedRow());
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
		Field[] fields = clsMaterial.getClass().getDeclaredFields();						
		String[] colunas = new String[fields.length-1]; 											
		
		for (int i = 0; i < fields.length-1; i++) {												
			Annotation annotation = fields[i].getAnnotation(TitleNote.class);			
			if(annotation instanceof TitleNote) {			
				colunas[i] = ((TitleNote) annotation).value();						
			} else {			
				colunas[i] = fields[i].getName();			
			}
	    }	
						
		ArrayList<Object[]> linhas = bsnMaterial.TabelaMaterial();		
		TabelaModelo table = new TabelaModelo(linhas, colunas);
		
		tblCadastro.setModel(table);		
		tblCadastro.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblCadastro.getColumnModel().getColumn(0).setResizable(false);
		tblCadastro.getColumnModel().getColumn(0).setCellRenderer(CellRight);		
		tblCadastro.getColumnModel().getColumn(0).setHeaderRenderer(ColLeft);		
		
		tblCadastro.getColumnModel().getColumn(1).setPreferredWidth(250);
		tblCadastro.getColumnModel().getColumn(1).setResizable(false);
		tblCadastro.getColumnModel().getColumn(1).setCellRenderer(CellLeft);
		tblCadastro.getColumnModel().getColumn(1).setHeaderRenderer(ColLeft);
				
		tblCadastro.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblCadastro.getColumnModel().getColumn(2).setResizable(false);
		tblCadastro.getColumnModel().getColumn(2).setCellRenderer(CellLeft);
		tblCadastro.getColumnModel().getColumn(2).setHeaderRenderer(ColLeft);
		
		tblCadastro.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblCadastro.getColumnModel().getColumn(3).setResizable(false);
		tblCadastro.getColumnModel().getColumn(3).setCellRenderer(CellLeft);
		tblCadastro.getColumnModel().getColumn(3).setHeaderRenderer(ColLeft);
				
		tblCadastro.getColumnModel().getColumn(4).setPreferredWidth(-10);
		tblCadastro.getColumnModel().getColumn(4).setResizable(false);
		tblCadastro.getColumnModel().getColumn(4).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(4).setHeaderRenderer(ColCenter);
		tblCadastro.getColumnModel().getColumn(4).setMaxWidth(-10);

		tblCadastro.getColumnModel().getColumn(5).setPreferredWidth(-10);
		tblCadastro.getColumnModel().getColumn(5).setResizable(false);
		tblCadastro.getColumnModel().getColumn(5).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(5).setHeaderRenderer(ColCenter);
		tblCadastro.getColumnModel().getColumn(5).setMaxWidth(-10);		
		
		tblCadastro.getColumnModel().getColumn(6).setPreferredWidth(50);
		tblCadastro.getColumnModel().getColumn(6).setResizable(false);
		tblCadastro.getColumnModel().getColumn(6).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(6).setHeaderRenderer(ColCenter);		
						
		tblCadastro.getColumnModel().getColumn(7).setPreferredWidth(75);
		tblCadastro.getColumnModel().getColumn(7).setResizable(false);
		tblCadastro.getColumnModel().getColumn(7).setCellRenderer(CellRight);
		tblCadastro.getColumnModel().getColumn(7).setHeaderRenderer(ColRight);
		
		tblCadastro.getColumnModel().getColumn(8).setPreferredWidth(-10);
		tblCadastro.getColumnModel().getColumn(8).setResizable(false);
		tblCadastro.getColumnModel().getColumn(8).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(8).setHeaderRenderer(ColCenter);
		tblCadastro.getColumnModel().getColumn(8).setMaxWidth(-10);
		
		tblCadastro.getColumnModel().getColumn(9).setPreferredWidth(150);
		tblCadastro.getColumnModel().getColumn(9).setResizable(false);
		tblCadastro.getColumnModel().getColumn(9).setCellRenderer(CellLeft);
		tblCadastro.getColumnModel().getColumn(9).setHeaderRenderer(ColLeft);	
									
		tblCadastro.getColumnModel().getColumn(10).setPreferredWidth(500);		
		tblCadastro.getColumnModel().getColumn(10).setResizable(false);
		tblCadastro.getColumnModel().getColumn(10).setCellRenderer(CellLeft);
		tblCadastro.getColumnModel().getColumn(10).setHeaderRenderer(ColLeft);		
				
		tblCadastro.getColumnModel().getColumn(11).setPreferredWidth(100);
		tblCadastro.getColumnModel().getColumn(11).setResizable(false);
		tblCadastro.getColumnModel().getColumn(11).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(11).setHeaderRenderer(ColCenter);	
				
		tblCadastro.getColumnModel().getColumn(12).setPreferredWidth(130);
		tblCadastro.getColumnModel().getColumn(12).setResizable(false);
		tblCadastro.getColumnModel().getColumn(12).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(12).setHeaderRenderer(ColCenter);				
		
		tblCadastro.getColumnModel().getColumn(13).setPreferredWidth(100);
		tblCadastro.getColumnModel().getColumn(13).setResizable(false);
		tblCadastro.getColumnModel().getColumn(13).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(13).setHeaderRenderer(ColCenter);	
				
		tblCadastro.getColumnModel().getColumn(14).setPreferredWidth(130);
		tblCadastro.getColumnModel().getColumn(14).setResizable(false);
		tblCadastro.getColumnModel().getColumn(14).setCellRenderer(CellCenter);
		tblCadastro.getColumnModel().getColumn(14).setHeaderRenderer(ColCenter);
		
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
			lblIdMaterial.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 0)));
			txtMaterial.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 1)));						
			cbbTipo.setSelectedItem(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 9)));			
			txtCodigo1.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 2)));			
			txtCodigo2.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 3)));
			txtPreco.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 7)));							
			cbbUnidade.setSelectedItem(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 6)));																				
			txtDescricao.setText(String.valueOf(tblCadastro.getValueAt(tblCadastro.getSelectedRow(), 10)));		
		} else {
			CadastroClear();
		}
		
	}

	@Override
	public void CadastroClear() {
		super.CadastroClear();
		lblIdMaterial.setText("0");
		txtMaterial.setText("");
		txtCodigo1.setText("");
		txtCodigo2.setText("");
		txtPreco.setText("0.00");
		cbbUnidade.setSelectedIndex(1);
		cbbTipo.setSelectedIndex(1);
		txtDescricao.setText("");
	}

	@Override
	public void CadastroPesquisar() {
		super.CadastroPesquisar();		
		if (btnPesquisar.isEnabled()) {
			PesquisaView frmPesquisa = new PesquisaView();
			frmPesquisa.setOwner(frmCadastro);
			frmPesquisa.setAssembly(clsMaterial);	
			frmPesquisa.setSearch(psqCadastro);
			frmPesquisa.setVisible(true);					
		}		
	}
}
