package util;

public final class Funcao {
	private Numero numero;
	private Data data;
	private Msg msg;
	
	public Funcao() {
		numero = new Numero();
		data   = new Data();
		msg    = new Msg();
	}

	public Numero getNumero() {
		return numero;
	}

	public Data getData() {
		return data;
	}

	public Msg getMsg() {
		return msg;
	}
	
	

}
