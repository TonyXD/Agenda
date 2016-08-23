package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LocalidadDTO;
import persistencia.conexion.Conexion;

public class LocalidadDAO {

	
	private static final String selectAll = "SELECT * FROM localidad";
	private static final Conexion conexion = Conexion.getConexion();
	
	
	
	public List<LocalidadDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<LocalidadDTO> localidad = new ArrayList<LocalidadDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(selectAll);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				localidad.add(new LocalidadDTO(resultSet.getInt("idLocalidad"), resultSet.getString("Descripcion"), resultSet.getInt("CodigoPostal")));
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
		return localidad;
	}
}
