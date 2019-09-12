package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import business.UsuarioBusiness;
import util.Global;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuView extends JFrame {
	public JFrame frmMenu;
	private JPanel pnlPrincipal;
	private UsuarioBusiness bsnMenu;
	private JPanel pnlMenu;
	private JMenuBar mnBar;
	private JMenu mnUsuario;
	private JMenuItem mniUsuarioSenha;
	private JMenu mniCadastro;
	private JMenuItem mniCliente;
	private JMenuItem mniMaterial;
	private JMenu mnRelatorio;
	private JMenuItem mnrCliente;
	private JMenuItem mnrMaterial;
	private JMenu mnSistema;
	private JMenuItem mniSobre;
	private JMenuItem mniSair;	
	private SystemTray tryMenu;
	private TrayIcon IcoMenu;
	private Image imgMenu;
	private JLabel lblUsuario;
	private JLabel lblAcesso;
	private JPanel pnlUsuario;
	private JMenu mnMovimentacao;
	private JMenuItem mniServico;
	private JMenuItem mniPesquisa;
	private JMenuItem mniCaixa;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {															
					LoginView view = new LoginView();
					view.setVisible(true);							
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings("static-access")
	public MenuView() {
		this.setAlwaysOnTop(true);
		this.setType(Type.NORMAL);
		this.setName("frmMenu");
		this.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.setResizable(false);
		this.setTitle("OSCell - Ordem de Serviço");						
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 340);		
		this.setIconImage(Global.getInstance().getImageIcon("device-phone@1x.png"));				
		setScreen(-1);
		
		frmMenu = this;	
		bsnMenu = new UsuarioBusiness();		
					
		try {
			tryMenu = SystemTray.getSystemTray();		
			imgMenu = new ImageIcon(Global.getInstance().getPathgrc()+"\\png\\device-phone@1x.png").getImage();		
			IcoMenu = new TrayIcon(imgMenu);
			IcoMenu.setImageAutoSize(true);		
			IcoMenu.addMouseListener(new MouseListener() {
				
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
					if ((e.getButton() == 2) || (e.getButton() == 3)) {
						System.exit(ABORT);
					} else if (e.getClickCount() == 1) {																							
						if (frmMenu.getState() == ICONIFIED) {
							frmMenu.setState(NORMAL);
		                } else if (frmMenu.getState() == NORMAL) {
		                	frmMenu.setState(ICONIFIED);		                	
		                }
						
						frmMenu.repaint();
					} 
				}						
				
			
			});	
			
				
			tryMenu.add(IcoMenu);
		} catch (Exception e) {

		} 		
		
		pnlPrincipal = new JPanel();
		pnlPrincipal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlPrincipal.setFocusCycleRoot(true);
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		
		pnlMenu = new JPanel();
		pnlMenu.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		pnlMenu.setBounds(0, 0, 450, 45);
		pnlMenu.setBorder(new LineBorder(SystemColor.controlShadow));
		pnlMenu.setBackground(SystemColor.control);
		pnlPrincipal.add(pnlMenu);
		
		mnBar = new JMenuBar();
		mnBar.setBorderPainted(false);
		
		mniCadastro = new JMenu("Cadastros");
		mniCadastro.setName("mniCadastro");
		mniCadastro.setIcon(new ImageIcon(Global.getInstance().getImageIcon("database_large@1x.png")));		
		mnBar.add(mniCadastro);
		
		mniCliente = new JMenuItem("Clientes");
		mniCliente.setIcon(new ImageIcon(Global.getInstance().getImageIcon("user_small@1x.png")));
		mniCliente.setName("mniCliente");
		mniCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								 												
				ClienteView frmCliente = new ClienteView();			
				frmCliente.setOwner(frmMenu);
				frmCliente.setVisible(true);				
			}
		});	
		mniCadastro.add(mniCliente);
		
		mniMaterial = new JMenuItem("Materiais");
		mniMaterial.setName("mniMaterial");
		mniMaterial.setIcon(new ImageIcon(Global.getInstance().getImageIcon("phone-iphone_small@1x.png")));
		mniMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								 												
				MaterialView frmMaterial = new MaterialView();			
				frmMaterial.setOwner(frmMenu);
				frmMaterial.setVisible(true);			
			}
		});
		mniCadastro.add(mniMaterial);
		
		mnMovimentacao = new JMenu("Movimenta\u00E7\u00E3o");
		mnMovimentacao.setIcon(new ImageIcon(Global.getInstance().getImageIcon("select-all_large@1x.png")));
		mnMovimentacao.setName("mnMovimentacao");
		mnBar.add(mnMovimentacao);
		
		mniServico = new JMenuItem("Servi\u00E7os");
		mniServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServicoView frmServico = new ServicoView();			
				frmServico.setOwner(frmMenu);
				frmServico.setVisible(true);
			}
		});
		mniServico.setIcon(new ImageIcon(Global.getInstance().getImageIcon("servicos_small@1x.png")));
		mniServico.setName("mniServico");
		mnMovimentacao.add(mniServico);
		
		mniPesquisa = new JMenuItem("Pesquisas");
		mniPesquisa.setIcon(new ImageIcon(Global.getInstance().getImageIcon("pesquisas_small@1x.png")));
		mniPesquisa.setName("mniPesquisa");
		mnMovimentacao.add(mniPesquisa);
		
		mniCaixa = new JMenuItem("Caixa");
		mniCaixa.setIcon(new ImageIcon(Global.getInstance().getImageIcon("caixas_small@1x.png")));
		mniCaixa.setName("mniCaixa");
		mnMovimentacao.add(mniCaixa);
		
		mnRelatorio = new JMenu("Relat\u00F3rios");
		mnRelatorio.setName("mnRelatorio");
		mnRelatorio.setIcon(new ImageIcon(Global.getInstance().getImageIcon("report-open_large@1x.png")));
		mnBar.add(mnRelatorio);
		
		mnrCliente = new JMenuItem("Relat\u00F3rio de clientes");
		mnrCliente.setName("mnrClientes");
		mnrCliente.setIcon(new ImageIcon(Global.getInstance().getImageIcon("report-open-user_small@1x.png")));
		mnRelatorio.add(mnrCliente);
		
		mnrMaterial = new JMenuItem("Relat\u00F3rio de materiais");
		mnrMaterial.setName("mnrMateriais");
		mnrMaterial.setIcon(new ImageIcon(Global.getInstance().getImageIcon("report-open-device_small@1x.png")));
		mnRelatorio.add(mnrMaterial);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setName("mnSistema");
		mnSistema.setIcon(new ImageIcon(Global.getInstance().getImageIcon("gear_large@1x.png")));
		mnBar.add(mnSistema);
		
		mniSobre = new JMenuItem("Sobre");
		mniSobre.setName("mniSobre");
		mniSobre.setIcon(new ImageIcon(Global.getInstance().getImageIcon("button-info_small@1x.png")));
		mniSobre.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {								
				Global.funcao.getMsg().setComponent(frmMenu);
				Global.funcao.getMsg().setMessage("Versão do Sistema 1.0");
				Global.funcao.getMsg().setTitle("Sobre");
				Global.funcao.getMsg().setType(1);					
				Global.funcao.getMsg().Show();	
			}
		});
		
		mnUsuario = new JMenu("Usu\u00E1rios");
		mnUsuario.setName("mnUsuario");
		mnSistema.add(mnUsuario);
		mnUsuario.setIconTextGap(5);
		mnUsuario.setIcon(new ImageIcon(Global.getInstance().getImageIcon("usercustom_small@1x.png")));
		
		JMenuItem mniUsuarioDados = new JMenuItem("Dados gerais");
		mniUsuarioDados.setName("mniUsuarioDados");
		mniUsuarioDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								 												
				UsuarioView frmUsuario = new UsuarioView();
				frmUsuario.setOwner(frmMenu);
				frmUsuario.setVisible(true);				
			}
		});
		mniUsuarioDados.setIcon(new ImageIcon(Global.getInstance().getImageIcon("contact-card_small@1x.png")));
		mnUsuario.add(mniUsuarioDados);
		
		mniUsuarioSenha = new JMenuItem("Resetar Senha");
		mniUsuarioSenha.setName("mniUsuarioSenha");
		mniUsuarioSenha.setIcon(new ImageIcon(Global.getInstance().getImageIcon("password_small@1x.png")));
		mniUsuarioSenha.addActionListener(new ActionListener() {						
			@Override
			public void actionPerformed(ActionEvent e) {								
				Global.funcao.getMsg().setComponent(frmMenu);
				Global.funcao.getMsg().setMessage("Deseja resetar a senha do usuário logado?");
				Global.funcao.getMsg().setTitle("Pergunta");
				Global.funcao.getMsg().setType(3);
				String login = Global.sessao.getUsuario().getLogin();					
				
				if (Global.funcao.getMsg().Show() == 0) {															
					bsnMenu.ResetartUsuario(Global.sessao.getUsuario());
					Global.sessao.setUsuario(bsnMenu.AutenticarUsuario(login, Global.sessao.system_pswd));					
					if ((Global.sessao.getUsuario() != null) && (Global.sessao.getUsuario().getIdusuario() > 0)) { 																
						lblUsuario.setText(""+Global.sessao.getUsuario().getUsuario().toString());
						lblAcesso.setText("Acesso: "+Global.sessao.getUsuario().getAcesso().toString());
					}
				}
				
			}
		});
		mnUsuario.add(mniUsuarioSenha);
		
		JMenuItem mniUsuarioAcesso = new JMenuItem("Acessos");
		mniUsuarioAcesso.setIcon(new ImageIcon(Global.getInstance().getImageIcon("protection-user_small@1x.png")));
		mniUsuarioAcesso.setName("mniUsuarioAcesso");
		mnUsuario.add(mniUsuarioAcesso);
		mnSistema.add(mniSobre);
		
		mniSair = new JMenuItem("Sair");
		mniSair.setName("mniSair");
		mniSair.setIcon(new ImageIcon(Global.getInstance().getImageIcon("exit_small@1x.png")));
		mniSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		pnlMenu.setLayout(new BorderLayout(0, 0));
		mnSistema.add(mniSair);
		pnlMenu.add(mnBar);
		
		JPanel pnlAcesso = new JPanel();
		pnlAcesso.setName("pnlAcesso");
		pnlAcesso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		pnlAcesso.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlAcesso.setBackground(SystemColor.control);
		pnlAcesso.setBounds(5, 45, 440, 224);
		pnlPrincipal.add(pnlAcesso);
		
		JButton btnServico = new JButton("Servi\u00E7os");
		btnServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServicoView frmServico = new ServicoView();			
				frmServico.setOwner(frmMenu);
				frmServico.setVisible(true);
			}
		});
		btnServico.setName("btnServico");
		btnServico.setHideActionText(true);
		btnServico.setIconTextGap(5);
		btnServico.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		btnServico.setIcon(new ImageIcon(Global.getInstance().getImageIcon("servicos_large@1x.png")));
		btnServico.setBackground(SystemColor.control);
		btnServico.setBounds(2, 4, 215, 105);
		
		JButton btnPesquisa = new JButton("Pesquisas");
		btnPesquisa.setName("btnPesquisa");
		btnPesquisa.setHideActionText(true);
		btnPesquisa.setIcon(new ImageIcon(Global.getInstance().getImageIcon("pesquisas_large@1x.png")));
		btnPesquisa.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		btnPesquisa.setIconTextGap(5);
		btnPesquisa.setBackground(SystemColor.control);
		btnPesquisa.setBounds(222, 4, 215, 105);
		
		JButton btnMaterial = new JButton("Materiais");
		btnMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialView frmMaterial = new MaterialView();			
				frmMaterial.setOwner(frmMenu);
				frmMaterial.setVisible(true);
			}
		});
		btnMaterial.setName("btnMaterial");
		btnMaterial.setHideActionText(true);
		btnMaterial.setIcon(new ImageIcon(Global.getInstance().getImageIcon("phone-iphone_large@1x.png")));
		btnMaterial.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		btnMaterial.setIconTextGap(5);
		btnMaterial.setBackground(SystemColor.control);
		btnMaterial.setBounds(222, 115, 215, 105);
		
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.setName("btnCaixa");
		btnCaixa.setHideActionText(true);
		btnCaixa.setIcon(new ImageIcon(Global.getInstance().getImageIcon("caixas_large@1x.png")));
		btnCaixa.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		btnCaixa.setIconTextGap(5);
		btnCaixa.setBackground(SystemColor.control);
		btnCaixa.setBounds(2, 115, 215, 105);
		pnlAcesso.setLayout(null);
		pnlAcesso.add(btnServico);
		pnlAcesso.add(btnPesquisa);
		pnlAcesso.add(btnMaterial);
		pnlAcesso.add(btnCaixa);
		
		pnlUsuario = new JPanel();
		pnlUsuario.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlUsuario.setName("pnlUsuario");
		pnlUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		pnlUsuario.setBounds(10, 275, 434, 24);
		pnlPrincipal.add(pnlUsuario);
		pnlUsuario.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblUsuario = new JLabel("");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);		
		lblUsuario.setIcon(new ImageIcon(Global.getInstance().getImagePath("useracess_small@1x.png")));				
		lblUsuario.setName("lblUsuario");
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlUsuario.add(lblUsuario);
		
		lblAcesso = new JLabel("");
		lblAcesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcesso.setIcon(new ImageIcon(Global.getInstance().getImagePath("keyacess_small@1x.png")));			
		lblAcesso.setName("lblAcesso");
		lblAcesso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlUsuario.add(lblAcesso);
		
		lblUsuario.setText(""+Global.sessao.getUsuario().getUsuario().toString());
		lblAcesso.setText(""+Global.sessao.getUsuario().getAcesso().toString());	
	}
	
	
	public void setScreen(int screenType){
	    Toolkit tk = Toolkit.getDefaultToolkit(); 
	    Dimension scrSize = tk.getScreenSize();
	    
	    switch(screenType){
	    	case -1: // Custom
	    		//this.setLocation(null);
	    		this.setLocationRelativeTo(null);
	    		this.setSize(457, 340);
	    		break;
	        case 0: // Normal	        	
	        	this.setSize(this.getWidth(),this.getHeight());
	            int scrWidth = scrSize.width - this.getWidth(); 
	            int scrHeight = scrSize.height - this.getHeight();
	            this.setLocation(scrWidth/2,scrHeight/2);
	            break;
	        case 1: // Maximizada
	            this.setLocation(0,0);
	            this.setSize(scrSize.width, scrSize.height-40);
	            break;	        
	    }
	}
}