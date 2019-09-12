package model;

import java.util.Observable;

public class Pesquisa extends Observable {
	String retorno;

	public void setRetorno(String retorno) {			
		this.retorno = retorno;
		if (retorno != null) {
			setChanged();
			notifyObservers();
		}
	}
	
	public String getRetorno() {
		return this.retorno;
	}

		
}
