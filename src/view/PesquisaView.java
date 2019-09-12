package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import business.ClienteBusiness;
import business.MaterialBusiness;
//import business.ServicoBusiness;
import business.UsuarioBusiness;
import model.Cliente;
import model.Pesquisa;
import model.Material;
import model.Usuario;
import util.TitleNote;
import util.TabelaModelo;

@SuppressWarnings("serial")
public class PesquisaView extends JFrame  {
	public PesquisaView frmPesquisa;
	public JFrame Owner;
	public Object Assembly;
	public Pesquisa Search;
	public JPanel pnlFrame;
	public JPanel pnlFiltro;
	public JTextField txtFiltar;
	public JTable tblPesquisa;
	public JLabel lblFiltar;
	public JScrollPane spnPesquisa;	
	public JButton btnFiltar;
	public JButton btnConfirmar;
	public JButton btnCadastar;	
	private JPanel pnlPesquisa;
	protected DefaultTableCellRenderer CellLeft;
	protected DefaultTableCellRenderer CellCenter;
	protected DefaultTableCellRenderer CellRight;
	protected DefaultTableCellRenderer ColLeft;
	protected DefaultTableCellRenderer ColCenter;
	protected DefaultTableCellRenderer ColRight;
	private TableRowSorter<TableModel> sorPesquisa;		
	
	public JFrame getOwner() {
		return Owner;
	}

	public void setOwner(JFrame owner) {
		Owner = owner;
	}
		
	public Object getAssembly() {		
		return Assembly;
	}

	public void setAssembly(Object assembly) {
		Assembly = assembly;				
	}	
	
	public Pesquisa getSearch() {
		return Search;
	}

	public void setSearch(Pesquisa search) {
		Search = search;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaView view = new PesquisaView();
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
	public PesquisaView() {
		setTitle("");				
		setType(Type.UTILITY);			
		setAlwaysOnTop(true);
		setResizable(false);		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\piece_small@1x.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 615);
		setLocationRelativeTo(null); 
		frmPesquisa = this;
		
		pnlFrame = new JPanel();
		pnlFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlFrame);
		pnlFrame.setLayout(null);
		
		pnlFiltro = new JPanel();
		pnlFiltro.setBackground(new Color(245, 245, 245));
		pnlFiltro.setBorder(new LineBorder(Color.GRAY, 1, true));		
		pnlFiltro.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		pnlFiltro.setBounds(5, 6, 794, 45);
		pnlFrame.add(pnlFiltro);
		pnlFiltro.setLayout(null);
		
		lblFiltar = new JLabel("Filtros da pesquisa");
		lblFiltar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFiltar.setBounds(10, 11, 119, 20);
		pnlFiltro.add(lblFiltar);
		
		txtFiltar = new JTextField();
		txtFiltar.setToolTipText("Filtros da pesquisa");
		txtFiltar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtFiltar.setColumns(10);
		txtFiltar.setBounds(135, 9, 562, 25);		
		txtFiltar.addKeyListener(new KeyListener() {			
			@Override
			public void keyTyped(KeyEvent e) {
				FiltroGrid(txtFiltar.getText());				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				FiltroGrid(txtFiltar.getText());				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				FiltroGrid(txtFiltar.getText());				
			}	
		});
		pnlFiltro.add(txtFiltar);
		
		btnFiltar = new JButton("");
		btnFiltar.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\search_small@1x.png"));
		btnFiltar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnFiltar.setBounds(699, 9, 25, 25);
		btnFiltar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				PesquisaGrid(0);				
			}
		});
		pnlFiltro.add(btnFiltar);
		
		btnCadastar = new JButton("");
		btnCadastar.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\symbol-add_small_red@1x.png"));
		btnCadastar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCadastar.setBounds(728, 9, 25, 25);
		btnCadastar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {			
				if (getAssembly() instanceof Cliente) {
					ClienteView frmCadastro = new ClienteView();
					frmCadastro.setOwner(frmPesquisa);
					frmCadastro.setVisible(true);
				} else if (getAssembly() instanceof Material) {
					MaterialView frmCadastro = new MaterialView();			
					frmCadastro.setOwner(frmPesquisa);
					frmCadastro.setVisible(true);
//				} else if (getAssembly() instanceof Servico) {
//					ServicoView frmCadastro = new ServicoView();
//					frmCadastro.setOwner(frmPesquisa);
//					frmCadastro.setVisible(true);
				} else if (getAssembly() instanceof Usuario) {
					UsuarioView frmUsuario = new UsuarioView();
					frmUsuario.setOwner(frmPesquisa);
					frmUsuario.setVisible(true);
				} 									
			}
		});
		pnlFiltro.add(btnCadastar);
		
		btnConfirmar = new JButton("");
		btnConfirmar.setIcon(new ImageIcon("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\symbol-ok_small@1x.png"));
		btnConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnConfirmar.setBounds(757, 9, 25, 25);
		btnConfirmar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {	
				ConfirmaGrid();						
			}
		});
		pnlFiltro.add(btnConfirmar);
		
		pnlPesquisa = new JPanel();
		pnlPesquisa.setBounds(5, 57, 794, 518);
		pnlFrame.add(pnlPesquisa);
		pnlPesquisa.setBackground(new Color(245, 245, 245));
		pnlPesquisa.setBorder(new LineBorder(Color.GRAY, 1, true));		
		pnlPesquisa.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		pnlPesquisa.setLayout(null);
		
		tblPesquisa = new JTable();
		tblPesquisa.setBounds(10, 11, 794, 140);
		tblPesquisa.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					ConfirmaGrid();
				}				
			}
		});
		spnPesquisa = new JScrollPane(tblPesquisa);
		spnPesquisa.setLocation(0, 0);
		spnPesquisa.setSize(794, 518);		
		pnlPesquisa.add(spnPesquisa);
				
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void show() { 
		super.show();			
		if (getAssembly() instanceof Cliente) {
			setTitle("Pesquisa de Clientes");
		} else if (getAssembly() instanceof Material) {
			setTitle("Pesquisa de Produtos");
//		} else if (getAssembly() instanceof Servico) {
//			setTitle("Pesquisa de Ordem de Serviço");
		} else if (getAssembly() instanceof Usuario) {
			setTitle("Pesquisa de Usuários");
		}
				
		PesquisaGrid(0);
		
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
		
	public void PesquisaGrid(int row) {	
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
		
		Field[] fields = null; 			
		if (getAssembly() instanceof Cliente) {
			fields = ((Cliente)getAssembly()).getClass().getDeclaredFields();
		} else if (getAssembly() instanceof Material) {
			fields = ((Material)getAssembly()).getClass().getDeclaredFields();		
//		} else if (getAssembly() instanceof Servico) {
//			fields = ((Servico)getAssembly()).getClass().getDeclaredFields();
		} else if (getAssembly() instanceof Usuario) {
			fields = ((Usuario)getAssembly()).getClass().getDeclaredFields();
		}
		
		int cont = fields.length-1; //observer
		
		String[] colunas = new String[6];		
		int tam = spnPesquisa.getWidth(); 
		
		Annotation annotation; 	
		annotation = fields[0].getAnnotation(TitleNote.class);
		colunas[0] = ((TitleNote) annotation).value();		
		annotation = fields[1].getAnnotation(TitleNote.class);
		colunas[1] = ((TitleNote) annotation).value();				
		annotation = fields[cont - 4].getAnnotation(TitleNote.class);
		colunas[2] = ((TitleNote) annotation).value();		
		annotation = fields[cont - 3].getAnnotation(TitleNote.class);
		colunas[3] = ((TitleNote) annotation).value();		
		annotation = fields[cont - 2].getAnnotation(TitleNote.class);
		colunas[4] = ((TitleNote) annotation).value();		
		annotation = fields[cont - 1].getAnnotation(TitleNote.class);
		colunas[5] = ((TitleNote) annotation).value();
				
		ArrayList<Object[]> linhas = null;		
		if (getAssembly() instanceof Cliente) {
			ClienteBusiness business = new ClienteBusiness();
			linhas = business.GridCliente();
		} else if (getAssembly() instanceof Material) {
			MaterialBusiness business = new MaterialBusiness();
			linhas = business.GridMaterial();
//		} else if (getAssembly() instanceof Servico) {
//			ServicoBusiness business = new ServicoBusiness();
//			linhas = business.GridServico();
		} else if (getAssembly() instanceof Usuario) {
			UsuarioBusiness business = new UsuarioBusiness();
			linhas = business.GridUsuario();
		}
			
		TabelaModelo table = new TabelaModelo(linhas, colunas);		
		tblPesquisa.setModel(table);		
		tblPesquisa.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblPesquisa.getColumnModel().getColumn(0).setResizable(false);
		tblPesquisa.getColumnModel().getColumn(0).setCellRenderer(CellRight);		
		tblPesquisa.getColumnModel().getColumn(0).setHeaderRenderer(ColLeft);
		
		tblPesquisa.getColumnModel().getColumn(1).setPreferredWidth(tam - 510);
		tblPesquisa.getColumnModel().getColumn(1).setResizable(false);
		tblPesquisa.getColumnModel().getColumn(1).setCellRenderer(CellLeft);
		tblPesquisa.getColumnModel().getColumn(1).setHeaderRenderer(ColLeft);
		
		tblPesquisa.getColumnModel().getColumn(2).setPreferredWidth(100);		
		tblPesquisa.getColumnModel().getColumn(2).setResizable(false);
		tblPesquisa.getColumnModel().getColumn(2).setCellRenderer(CellCenter);
		tblPesquisa.getColumnModel().getColumn(2).setHeaderRenderer(ColCenter);		
				
		tblPesquisa.getColumnModel().getColumn(3).setPreferredWidth(130);
		tblPesquisa.getColumnModel().getColumn(3).setResizable(false);
		tblPesquisa.getColumnModel().getColumn(3).setCellRenderer(CellCenter);
		tblPesquisa.getColumnModel().getColumn(3).setHeaderRenderer(ColCenter);	
				
		tblPesquisa.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblPesquisa.getColumnModel().getColumn(4).setResizable(false);
		tblPesquisa.getColumnModel().getColumn(4).setCellRenderer(CellCenter);
		tblPesquisa.getColumnModel().getColumn(4).setHeaderRenderer(ColCenter);				
		
		tblPesquisa.getColumnModel().getColumn(5).setPreferredWidth(130);
		tblPesquisa.getColumnModel().getColumn(5).setResizable(false);
		tblPesquisa.getColumnModel().getColumn(5).setCellRenderer(CellCenter);
		tblPesquisa.getColumnModel().getColumn(5).setHeaderRenderer(ColCenter);
		
		tblPesquisa.getTableHeader().setReorderingAllowed(false);
		tblPesquisa.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tblPesquisa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);			
		tblPesquisa.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tblPesquisa.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblPesquisa.setFillsViewportHeight(true);						
		tblPesquisa.setCellSelectionEnabled(false); 		
		tblPesquisa.setRowSelectionAllowed(true);	
						
        sorPesquisa = new TableRowSorter<TableModel>(tblPesquisa.getModel());
        sorPesquisa.setRowFilter(null);
        tblPesquisa.setRowSorter(sorPesquisa);
        
        if (linhas.size() > 0) {
			tblPesquisa.setRowSelectionInterval(row, row);
		}
        		
	}
	
	public void FiltroGrid(String text) {
		if (text.length() == 0) {
			sorPesquisa.setRowFilter(null);
		} else {
			try {
				List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>();				
				filters.add(RowFilter.regexFilter("(?i)" + text, 0));
				filters.add(RowFilter.regexFilter("(?i)" + text, 1));				
				filters.add(RowFilter.regexFilter("(?i)" + text, 2));
				filters.add(RowFilter.regexFilter("(?i)" + text, 4));
				sorPesquisa.setRowFilter(RowFilter.orFilter(filters));														
            } catch (PatternSyntaxException pse) {
            	System.out.println(pse.getMessage());
            }
        }		
		
	}
	
	public void ConfirmaGrid() {
		if ((tblPesquisa.getRowCount() > 0) && (tblPesquisa.getSelectedRow() >= 0)) {										
			getSearch().setRetorno(String.valueOf(tblPesquisa.getValueAt(tblPesquisa.getSelectedRow(), 0)));						
		}
		dispose();
	}
	
			
}
