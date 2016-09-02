package persistencia.conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Utils.XMLGenerator;
import dto.LogInDTO;

public class Conexion 
{
	public static Conexion instancia;
	private final static String driver = "com.mysql.jdbc.Driver";
	private Connection conexion;
	public Conexion()
	{
		try
		{
			LogInDTO log = XMLGenerator.ParseXmlToLogIn();			
			
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://" + log.getIpLocal() + ":" + log.getPuerto() + "/" + log.getSchema(), log.getUser(), log.getPass());
			System.out.println("Conexion exitosa");
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
	}	
	
	 public static void CreateSchema()
	    {
	        String s            = new String();
	        StringBuffer sb = new StringBuffer();
	 
	        try
	        {
	        	Class.forName(driver).newInstance();
	        	LogInDTO log = XMLGenerator.ParseXmlToLogIn();					
	            FileReader fr = new FileReader(new File("sql/Queries.sql"));
	            // be sure to not have line starting with "--" or "/*" or any other non aplhabetical character
	 
	            BufferedReader br = new BufferedReader(fr);
	 
	            while((s = br.readLine()) != null)
	            {
	                sb.append(s);
	            }
	            br.close();
	 
	            // here is our splitter ! We use ";" as a delimiter for each request
	            // then we are sure to have well formed statements
	            String[] inst = sb.toString().split(";");
	 
	            Connection c = DriverManager.getConnection("jdbc:mysql://" + log.getIpLocal() + ":" + log.getPuerto() + "/mysql", log.getUser(), log.getPass());
	            Statement st = c.createStatement();
	 
	            for(int i = 0; i<inst.length; i++)
	            {
	                // we ensure that there is no spaces before or after the request string
	                // in order to not execute empty statements
	                if(!inst[i].trim().equals(""))
	                {
	                    st.executeUpdate(inst[i]);
	                    System.out.println(">>"+inst[i]);
	                }
	            }
	   
	        }
	        catch(Exception e)
	        {
	            System.out.println("*** Error : "+e.toString());
	            System.out.println("*** ");
	            System.out.println("*** Error : ");
	            e.printStackTrace();
	            System.out.println("################################################");
	            System.out.println(sb.toString());
	        }
	 
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return conexion;
	}

	public void cerrarConexion()
	{
		instancia = null;
	}
}
