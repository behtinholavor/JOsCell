package util;

public class Data {
	private static Data instance;
	private String dataformat = "dd/MM/yyyy";
	private String datahoraformat = "dd/MM/yyyy hh:mm:ss";
	
	public Data() {

	}

	public static Data getInstance() {
		if (instance == null)
            instance = new Data();   
		return instance;
	}

	public static void setInstance(Data instance) {
		Data.instance = instance;
	}

	public String getDataformat() {
		return dataformat;
	}

	public String getDatahoraformat() {
		return datahoraformat;
	}

	
	
}
