package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FormView extends JFrame {
	public FormView frmForm;	
	public JPanel pnlForm;
	public JFrame Owner;	
	
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
					FormView view = new FormView();
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
	public FormView() {
		setType(Type.UTILITY);			
		setAlwaysOnTop(true);
		setResizable(false);		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\piece_small@1x.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 615);
		setLocationRelativeTo(null);
		frmForm = this;
		
//		dtFormat 	= new SimpleDateFormat(Global.funcao.getData().getDataformat());
//		flFormat	= new DecimalFormat(Global.funcao.getNumero().numeroformato.getFormatoTwo());
//		dlFormat	= new DecimalFormat(Global.funcao.getNumero().numeroformato.getFormatoThree());	
		
		pnlForm = new JPanel();
		pnlForm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnlForm.setBackground(SystemColor.control);
		pnlForm.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlForm.setLayout(null);
		setContentPane(pnlForm);	
	}
	
	@SuppressWarnings("rawtypes")
	public void FormForm(Boolean flag, JPanel panel) {
		Component components[] = panel != null ? panel.getComponents() : frmForm.pnlForm.getComponents();		
		for (int i = 0; i < components.length; i++) {  
			if (components[i] instanceof JTextField) { 
				((JTextField)components[i]).setEditable(flag);
				((JFormattedTextField)components[i]).setEditable(flag);	
			} else if (components[i] instanceof JCheckBox) { 
				((JCheckBox)components[i]).setEnabled(flag);
			} else if (components[i] instanceof JComboBox) {
				((JComboBox)components[i]).setEnabled(flag);				
			} else if (components[i] instanceof JTextPane) {
				((JTextPane)components[i]).setEditable(flag);										
			} else if (components[i] instanceof JPanel) {
				FormForm(flag, (JPanel) components[i]);
				
			} 
		}			
	}	
	
	public void FormLoad() {			
		//				
	}
	
	@SuppressWarnings("rawtypes")
	public void FormClear(JPanel panel) {			
		Component components[] = panel != null ? panel.getComponents() : frmForm.pnlForm.getComponents();		
		for (int i = 0; i < components.length; i++) {  
			if (components[i] instanceof JTextField) { 
				((JTextField)components[i]).setText("");
//				((JFormattedTextField)components[i]).setText(flFormat.format(0));
			} else if (components[i] instanceof JCheckBox) { 
				((JCheckBox)components[i]).setSelected(false);	
			} else if (components[i] instanceof JComboBox) {
				((JComboBox)components[i]).setSelectedIndex(0);				
			} else if (components[i] instanceof JTextPane) {
				((JTextPane)components[i]).setText("");			
			} 			
		}		
	}
	
	public void FormAction(int action) {			
		//				
	}
	
	
}
