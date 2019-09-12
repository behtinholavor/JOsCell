package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.UsuarioBusiness;
import util.Funcao;
import util.Global;
import util.Sessao;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class LoginView extends JFrame {		
	private LoginView frmLogin;
	private MenuView frmPrincipal;
	private JPanel pnlLogin;
	private JTextField txtSenha;
	private JTextField txtLogin;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private UsuarioBusiness bsnLogin;	
	private JButton btnCancelar;
	private JButton btnConfirmar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Create the frame.
	 */
	public LoginView() {
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setType(Type.NORMAL);
		this.setTitle("OSCell");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 245, 205);
		this.setLocationRelativeTo(null);		
		this.setIconImage(Global.getInstance().getImageIcon("key_small@1x.png"));
//		this.addKeyListener(CloseKeyPressed());
		frmLogin = this;												
		bsnLogin = new UsuarioBusiness();	
		
		Global.funcao = new Funcao();
		Global.sessao = new Sessao();
		
		pnlLogin = new JPanel();
		pnlLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlLogin.addKeyListener(CloseKeyPressed());
		pnlLogin.setLayout(null);				       
		setContentPane(pnlLogin);
		
		txtLogin = new JTextField();	
		txtLogin.addKeyListener(NextKeyPressed());
		txtLogin.addKeyListener(CloseKeyPressed());
		txtLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtLogin.setToolTipText("Login do usu\u00E1rio");
		txtLogin.setColumns(10);
		txtLogin.setBounds(10, 30, 221, 25);
		pnlLogin.add(txtLogin);
		
		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(NextKeyPressed());
		txtSenha.addKeyListener(CloseKeyPressed());
		txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtSenha.setToolTipText("Senha do usu\u00E1rio");
		txtSenha.setBounds(10, 90, 221, 25);
		pnlLogin.add(txtSenha);
		txtSenha.setColumns(10);			
		
		btnConfirmar = new JButton("Acessar");		
		btnConfirmar.setBackground(SystemColor.control);
		btnConfirmar.setIcon(new ImageIcon(Global.getInstance().getImagePath("login_small@1x.png")));				
		btnConfirmar.setName("btnConfirmar");
		btnConfirmar.addActionListener(LoginButtonAction());
		btnConfirmar.addKeyListener(LogKeyPressed());		
		btnConfirmar.addKeyListener(CloseKeyPressed());
		btnConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnConfirmar.setBounds(10, 135, 105, 25);		
		pnlLogin.add(btnConfirmar);
		
		btnCancelar = new JButton("Sair");
		btnCancelar.setBackground(SystemColor.control);
		btnCancelar.setIcon(new ImageIcon(Global.getInstance().getImagePath("logout_small@1x.png")));
		btnCancelar.setName("btnCancelar");
		btnCancelar.addActionListener(LogoutButtonAction());		
		btnCancelar.addKeyListener(LogKeyPressed());
		btnCancelar.addKeyListener(CloseKeyPressed());
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCancelar.setBounds(126, 135, 105, 25);
		pnlLogin.add(btnCancelar);		
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 10, 46, 14);
		pnlLogin.add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 70, 46, 14);
		pnlLogin.add(lblSenha);
				
		txtLogin.setText("USR001");
		txtSenha.setText("123456");				
	}
	
	
	public KeyAdapter NextKeyPressed() {
		return new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {		
				if ((e.getComponent().getClass() == JTextField.class) || (e.getComponent().getClass() == JPasswordField.class)) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER){				
						JTextField txtField = ((JTextField)(e.getComponent()));
						txtField.transferFocus();
			        }	
				}
			}
						
		};
	}
	
	public ActionListener LoginButtonAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Global.sessao.setUsuario(bsnLogin.AutenticarUsuario(txtLogin.getText().trim(), txtSenha.getText().trim()));				
				if ((Global.sessao.getUsuario() != null) && (Global.sessao.getUsuario().getIdusuario() > 0)) { 																														
					frmPrincipal = new MenuView();
					frmPrincipal.setVisible(true);
					frmLogin.setVisible(false);
				} else {																									
					Global.funcao.getMsg().setComponent(frmLogin);
					Global.funcao.getMsg().setMessage("Falha na autenticação do usuário!");
					Global.funcao.getMsg().setTitle("Erro");
					Global.funcao.getMsg().setType(0);					
					Global.funcao.getMsg().Show();										
				}
			}			
		};		
	}
	
	public ActionListener LogoutButtonAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}			
		};
	}	
	
	public KeyAdapter LogKeyPressed() {
		return new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {					
				if (e.getComponent().getClass() == JButton.class) {																	
					if (e.getKeyCode() == KeyEvent.VK_ENTER){				
						JButton button = ((JButton)(e.getComponent()));
						if (button.getName() == btnConfirmar.getName()) {
							btnConfirmar.doClick();
						} else if (button.getName() == btnCancelar.getName()) {
							btnCancelar.doClick();
						}
			        }								
				}
			}
						
		};
	}
		
	public KeyAdapter CloseKeyPressed() {
		return new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {					
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE){				
					System.exit(0);
		        }	
			
			}
						
		};
	}
	
}
