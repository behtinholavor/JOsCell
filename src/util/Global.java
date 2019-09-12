package util;

import java.awt.Image;
import java.awt.Toolkit;

public class Global {
	private static Global instance;
	public static Sessao sessao;
	public static Funcao funcao;
	public static String path = System.getProperty("user.dir");
	public static String pathgrc = path+"\\grc";
	
	public Global() {
		
	}
	
	public static Global getInstance() {
        if (instance == null)
            instance = new Global();        	
        return instance;
    }
	
	public static void setInstance(Global instance) {
		Global.instance = instance;
	}

	public static String getPath() {
		return path;
	}

	public static String getPathgrc() {
		return pathgrc;
	}
	
	public Image getImageIcon(String name) {
		Image img = Toolkit.getDefaultToolkit().getImage((getPathgrc()+"\\png\\"+name));		
		return img;
	}
	
	public String getImagePath(String name) {
		String str = getPathgrc()+"\\png\\"+name;		
		return str;
	}
	
}
