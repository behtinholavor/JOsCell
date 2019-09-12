package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import model.Pesquisa;
import util.Global;

@SuppressWarnings("serial")
public class CadastroView extends JFrame {			
	public CadastroView frmCadastro;
	public JFrame Owner;
	public JPanel pnlCadastro;	
	public JPanel pnlForm;
	public JPanel pnlDados;
	public JPanel pnlAcoes;	
	public JButton btnInserir;
	public JButton btnAlterar;
	public JButton btnRemover;
	public JButton btnSalvar;
	public JButton btnCancelar;
	public JButton btnPesquisar;	
	public JScrollPane spnCadastro;
	public JTable tblCadastro;	
	protected Pesquisa psqCadastro;
	protected DefaultTableCellRenderer CellLeft;
	protected DefaultTableCellRenderer CellCenter;
	protected DefaultTableCellRenderer CellRight;
	protected DefaultTableCellRenderer ColLeft;
	protected DefaultTableCellRenderer ColCenter;
	protected DefaultTableCellRenderer ColRight;	
		
	public JFrame getOwner() {
		return Owner;
	}

	public void setOwner(JFrame owner) {
		Owner = owner;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView view = new CadastroView();
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
	public CadastroView() {
		setType(Type.UTILITY);			
		setAlwaysOnTop(true);
		setResizable(false);		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\piece_small@1x.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 540);
		setLocationRelativeTo(null);
		frmCadastro = this;		
		psqCadastro = new Pesquisa();	
		
		pnlCadastro = new JPanel();
		pnlCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlCadastro.setBackground(SystemColor.control);
		pnlCadastro.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlCadastro.setLayout(null);
		setContentPane(pnlCadastro);
		
		pnlForm = new JPanel();
		pnlForm.setBackground(new Color(245, 245, 245));
		pnlForm.setBorder(new LineBorder(Color.GRAY, 1, true));		
		pnlForm.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		pnlForm.setBounds(10, 11, 784, 339);
		pnlCadastro.add(pnlForm);
		pnlForm.setLayout(null);
		
		pnlDados = new JPanel();
		pnlDados.setBounds(10, 355, 752, 150);		
		pnlDados.setLayout(null);
		pnlCadastro.add(pnlDados);
		
		tblCadastro = new JTable();
		tblCadastro.setBounds(0, 0, 0, 0);
		spnCadastro = new JScrollPane(tblCadastro);
		spnCadastro.setLocation(0, 0);
		spnCadastro.setSize(752, 150);
		pnlDados.add(spnCadastro);
		tblCadastro.setBounds(10, 11, 764, 140);
		
		pnlAcoes = new JPanel();
		pnlAcoes.setBounds(767, 355, 27, 150);
		pnlCadastro.add(pnlAcoes);
		pnlAcoes.setBackground(new Color(255, 255, 255));
		pnlAcoes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlAcoes.setLayout(new GridLayout(6, 1, 0, 1));
		
		btnInserir = new JButton("");
		btnInserir.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\symbol-add_small@1x.png"));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroInserir();								
			}
		});
		btnInserir.setBackground(SystemColor.control);
		btnInserir.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInserir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlAcoes.add(btnInserir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\symbol-refresh_small@1x.png"));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAlterar();
			}
		});
		btnAlterar.setBackground(SystemColor.control);
		btnAlterar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlterar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlAcoes.add(btnAlterar);
		
		btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\symbol-remove_small@1x.png"));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroRemover();
			}
		});
		btnRemover.setBackground(SystemColor.control);
		btnRemover.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRemover.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlAcoes.add(btnRemover);
		
		btnSalvar = new JButton("");
		btnSalvar.setEnabled(false);
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\symbol-ok_small@1x.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroSalvar();
			}
		});
		btnSalvar.setBackground(SystemColor.control);
		btnSalvar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSalvar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlAcoes.add(btnSalvar);
		
		btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\symbol-cancel_small@1x.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCancelar();
			}
		});
		btnCancelar.setBackground(SystemColor.control);
		btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlAcoes.add(btnCancelar);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\find_small@1x.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPesquisar();
			}
		});
		btnPesquisar.setBackground(SystemColor.control);
		btnPesquisar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPesquisar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlAcoes.add(btnPesquisar);		
		
		tblCadastro.getSelectionModel().addListSelectionListener(new ListSelectionListener() {						
			@Override
			public void valueChanged(ListSelectionEvent e) {								
				CadastroLoad();
			}
		});		
		
		CadastroAcoes(false);	
		
	}		
	
	@SuppressWarnings("deprecation")
	@Override
	public void show() { 
		super.show();		
		CadastroGrid(0);	
		CadastroRetorno();
		if (getOwner() != null) {
			getOwner().setVisible(false);
		}
	}	
	
	@Override
	public void dispose() { 
		super.dispose();
		if (getOwner() != null) {
			getOwner().setVisible(true);
		}
	}

	public void CadastroInserir() {		
		CadastroAcoes(true);
		tblCadastro.clearSelection();
		frmCadastro.CadastroClear();		
	}
	
	public void CadastroAlterar() {
		CadastroAcoes(true);		
		frmCadastro.CadastroClear();
		frmCadastro.CadastroLoad();		
	}
		
	public boolean CadastroRemover() {		
		boolean flag = false;		 	
		Global.funcao.getMsg().setComponent(this);
		Global.funcao.getMsg().setMessage("Remover registro?");
		Global.funcao.getMsg().setTitle("Pergunta");
		Global.funcao.getMsg().setType(3);		
		if ((tblCadastro.getRowCount() > 0) && (Global.funcao.getMsg().Show() == 0)) {	
			flag = true;			
			CadastroAcoes(false);			
		}	
		return flag;
	}
	
	public boolean CadastroSalvar() {			
		boolean flag = false;		
		Global.funcao.getMsg().setComponent(this);
		Global.funcao.getMsg().setMessage("Salvar registro?");
		Global.funcao.getMsg().setTitle("Pergunta");
		Global.funcao.getMsg().setType(3);			
		if (Global.funcao.getMsg().Show() == 0) {
			flag = true;
			CadastroAcoes(false);			
		}
		return flag;
	}
	
	public void CadastroCancelar() {		
		CadastroAcoes(false);		
	}
	
	public void CadastroPesquisar() {				
//		Global.funcao.getMsg().setComponent(this);
//		Global.funcao.getMsg().setMessage("Pesquisa de ... ");
//		Global.funcao.getMsg().setTitle("Pesquisa");
//		Global.funcao.getMsg().setType(1);									
//		if (Global.funcao.getMsg().Show() == 0) {				
//			CadastroAcoes(false);		
//		}
		
	}
	
	public void CadastroAcoes(Boolean flag) {
		btnInserir.setEnabled(!flag);
		btnAlterar.setEnabled(!flag);
		btnRemover.setEnabled(!flag);
		btnSalvar.setEnabled(flag);
		btnCancelar.setEnabled(flag);
		btnPesquisar.setEnabled(!flag);		
		CadastroForm(flag);
	}
	
	public void CadastroGrid(int row) {	
		CellLeft = new DefaultTableCellRenderer();
		CellLeft.setHorizontalAlignment(SwingConstants.LEFT);
		
		CellCenter = new DefaultTableCellRenderer();
		CellCenter.setHorizontalAlignment(SwingConstants.CENTER);
		
		CellRight = new DefaultTableCellRenderer();
		CellRight.setHorizontalAlignment(SwingConstants.RIGHT);
		
		ColLeft = new DefaultTableCellRenderer();
		ColLeft.setHorizontalAlignment(SwingConstants.LEFT);
		ColLeft.setFont(new Font("Segoe UI", Font.BOLD, 13));
		ColLeft.setForeground(UIManager.getColor("Button.foreground"));	
		ColLeft.setBackground(UIManager.getColor("Button.background"));
				
		ColCenter = new DefaultTableCellRenderer();		
		ColCenter.setHorizontalAlignment(SwingConstants.CENTER);
		ColCenter.setFont(new Font("Segoe UI", Font.BOLD, 13));
		ColCenter.setForeground(UIManager.getColor("Button.foreground"));
		ColCenter.setBackground(UIManager.getColor("Button.background"));
				
		ColRight = new DefaultTableCellRenderer(); 
		ColRight.setHorizontalAlignment(SwingConstants.RIGHT);
		ColRight.setFont(new Font("Segoe UI", Font.BOLD, 13));
		ColRight.setForeground(UIManager.getColor("Button.foreground"));
		ColRight.setBackground(UIManager.getColor("Button.background"));
		
	}
	
	@SuppressWarnings("rawtypes")
	public void CadastroForm(Boolean flag) {		
		Component components[] = frmCadastro.pnlForm.getComponents();		
		for (int i = 0; i < components.length; i++) {  
			if (components[i] instanceof JTextField) { 
				((JTextField)components[i]).setEditable(flag);
			} else if (components[i] instanceof JCheckBox) { 
				((JCheckBox)components[i]).setEnabled(flag);
			} else if (components[i] instanceof JComboBox) {
				((JComboBox)components[i]).setEnabled(flag);				
			} else if (components[i] instanceof JTextPane) {
				((JTextPane)components[i]).setEditable(flag);
			}
		}			
	}
		
	public void CadastroLoad() {			
		//				
	}
	
	public void CadastroClear() {			
		//				
	}

	public void CadastroRetorno() {
		if ((psqCadastro.getRetorno() != null) && (psqCadastro.getRetorno() != "")) {						
			int row	= 0; 
			if (tblCadastro.getRowCount() > 0) {		
				for (int i = 0; i < tblCadastro.getRowCount(); i++) {
					if ((Integer) tblCadastro.getValueAt(i, 0) == Integer.parseInt(psqCadastro.getRetorno())) {
						row = i;
						break;
					}
				}				
				tblCadastro.setRowSelectionInterval(row, row);
			}
			
			
			psqCadastro.setRetorno(null);
		}
	}
	
	
}
