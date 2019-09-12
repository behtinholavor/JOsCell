package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {		
	private static final String DRIVER 			= "org.postgresql.Driver";
    private static final String DATABASE_URL	= "jdbc:postgresql://localhost:5432/db_oscell";
    private static final String USERNAME 		= "sysoss";
    private static final String PASSWORD 		= "oss123";
	private static Connection connection        = null;    		
	
    public static Connection createConnectionToPostgres() {
        try {        	
        	Class.forName(DRIVER);                    	
        	connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);        	
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO ao conectar a base de dados!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                		
		return connection;
    }
    
	   
}
