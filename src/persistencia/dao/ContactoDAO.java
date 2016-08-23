package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ContactoDTO;
import persistencia.conexion.Conexion;

public class ContactoDAO
{

	private static final String selectAll = "SELECT * FROM contacto";
	private static final String insert = "INSERT INTO contacto(Descripcion) VALUES(?)";
	private static final String update = "UPDATE contacto SET Descripcion= ? WHERE idLocalidad= ?";
	private static final Conexion conexion = Conexion.getConexion();
	
	public List<ContactoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<ContactoDTO> contacto = new ArrayList<ContactoDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(selectAll);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				contacto.add(new ContactoDTO(resultSet.getInt("idLocalidad"), resultSet.getString("Descripcion")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.cerrarConexion();
		}
		return contacto;
	}

	public boolean insert(ContactoDTO agregarContacto) {
		PreparedStatement statement;
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setString(1, agregarContacto.getDescripcion());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;	
	}

	public boolean update(ContactoDTO editarContacto) {
		PreparedStatement statement;
		try 
		{
		    		    
			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setString(1, editarContacto.getDescripcion());
			statement.setInt(2, editarContacto.getIdContacto());
			if(statement.executeUpdate() > 0) 
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
		
	}

}
