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
	private static final String update = "UPDATE contacto SET Descripcion= ? WHERE idContacto= ?";
	private static final String findByDescrip = "SELECT C.idContacto, C.Descripcion FROM contacto as C WHERE Descripcion = ?";
	private static final String findById = "SELECT * From contacto as C  join personas as P where P.IdContacto = ?";
	private static final String delete = "DELETE FROM contacto WHERE idContacto = ?";
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
				contacto.add(new ContactoDTO(resultSet.getInt("idContacto"), resultSet.getString("Descripcion")));
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
	
	public ContactoDTO findIdContactoByDescrip(String tipoContacto) {
		
		PreparedStatement statement;
		ResultSet resultSet; 
		ContactoDTO contacto = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(findByDescrip);			
			statement.setString(1, tipoContacto);
			resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				contacto = new ContactoDTO(resultSet.getInt("idContacto"), resultSet.getString("Descripcion"));
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

	public boolean findIfLocalidadIsAssing(int idContacto) {
		PreparedStatement statement;
		ResultSet resultSet; 
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(findById);			
			statement.setInt(1, idContacto);
			resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				return true;
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
		
		return false;
	}
	
	public boolean borrarContacto(ContactoDTO contacto) {

		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(contacto.getIdContacto()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecut� devuelvo true
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
