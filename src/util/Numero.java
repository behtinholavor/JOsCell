package util;

import java.text.DecimalFormat;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class Numero {
	private static Numero instance;
	public static NumeroFormato numeroformato;	
	public static NumeroLimite numerolimite;
	
	public Numero() {
		Numero.numeroformato = new NumeroFormato();
		Numero.numerolimite = new NumeroLimite();		
	}	
	
	public static Numero getInstance() {
        if (instance == null)
            instance = new Numero();        	
        return instance;
    }	

	public static void setInstance(Numero instance) {
		Numero.instance = instance;
	}	

	public DefaultFormatterFactory numberFormat(NumeroFormato formato, NumeroLimite limite) {							
		DecimalFormat decimal = new DecimalFormat(formato != null ? formato.getFormatoCustom() : "0.00");		
		NumberFormatter number = new NumberFormatter(decimal);
		
		if (limite != null) {
			number.setMinimum(limite.getLimiteMinimo());
			number.setMaximum(limite.getLimiteMaximo());
		} else {
			number.setMinimum(numerolimite.getLimiteMinimo());
			number.setMaximum(numerolimite.getLimiteMaximo());
		}
		
		number.setFormat(decimal) ;
		number.setAllowsInvalid(false) ; 		
        DefaultFormatterFactory dff = new DefaultFormatterFactory(number);             
		return dff; 
	}
	
	
//	public void numberTyped(KeyEvent e) {
//		char c = e.getKeyChar();
//        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == ','))) {
//             e.consume();
//        }
//		
//	}
	
	public static class NumeroFormato {
		private String formatoOne;
		private String formatoTwo;
		private String formatoThree;	
		private String formatoCustom;
					
		public NumeroFormato() {
			this.formatoOne = "0";
			this.formatoTwo = "0.00";
			this.formatoThree = "0.000";
			this.formatoCustom = "#.##";
		}
				
		public NumeroFormato(String formatoCustom) {
			super();
			this.formatoCustom = formatoCustom;
		}

		public String getFormatoOne() {
			return formatoOne;
		}
		public String getFormatoTwo() {
			return formatoTwo;
		}
		public String getFormatoThree() {
			return formatoThree;
		}
		public String getFormatoCustom() {
			return formatoCustom;
		}
				
	}
	
	
	public static class NumeroLimite {  
		private double limiteMinimo;
		private double limiteMaximo;		
		
		public NumeroLimite() {		
			this.limiteMinimo = 0;
			this.limiteMaximo = 999999;
		}
		
		public NumeroLimite(double limiteMinimo, double limiteMaximo) {
			super();
			this.limiteMinimo = limiteMinimo;
			this.limiteMaximo = limiteMaximo;
		}

		public double getLimiteMinimo() {
			return limiteMinimo;
		}
		
		
		public double getLimiteMaximo() {
			return limiteMaximo;
		}
		
		
	} 
	
}






