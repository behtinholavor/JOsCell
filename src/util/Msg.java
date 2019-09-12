package util;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Msg {	
	private JOptionPane msg;
	private Component component;
	private Object message;
	private Object title;
	private int type;

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}
	
	public Object getTitle() {
		return title;
	}

	public void setTitle(Object title) {
		this.title = title;
	}	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int Show() {						
//		ERROR_MESSAGE       = 0;
//	    INFORMATION_MESSAGE = 1;
//	    WARNING_MESSAGE     = 2;
//	    QUESTION_MESSAGE    = 3;
//	    PLAIN_MESSAGE       = -1;				
		if (getType() == 3) {
			Quest quest = new Quest();
			return quest.Show();
		} else {
			Alert alert = new Alert();			
			return alert.Show();
		}										
	}
	
	private class Alert {							
		public Alert() {					
			msg = new JOptionPane();			
		}							 			
		
		@SuppressWarnings("static-access")
		public int Show() {			
			msg.showMessageDialog(getComponent(), getMessage(), getTitle().toString(), getType());
			return 0;
		}
	}
		
	private class Quest {								
//		DEFAULT_OPTION       = -1;
//		YES_NO_OPTION        = 0;
//		YES_NO_CANCEL_OPTION = 1;	    
//		OK_CANCEL_OPTION     = 2;			
		public int optionType = JOptionPane.DEFAULT_OPTION;
		public Icon icon = null;
		public Object[] options = {"Sim", "Não" };		
		
		public Quest() {			
			msg = new JOptionPane(); 
		}
		
		@SuppressWarnings("static-access")
		public int Show() {			
			return msg.showOptionDialog(getComponent(), getMessage(), getTitle().toString(), optionType, getType(), icon, options, options[0]);			 
		}				
		
	}
		
}
