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
	private static final String delete = "DELETE FROM localidad WHERE idLocalidad = ?";
	private static final String insert = "INSERT INTO localidad(Descripcion, CodigoPostal) VALUES(?, ?)";
	private static final String update = "UPDATE localidad SET Descripcion= ?, CodigoPostal= ? WHERE idLocalidad= ?";
	private static final String findByDescrip = "SELECT L.idLocalidad, L.Descripcion, L.CodigoPostal FROM localidad as L WHERE Descripcion = ?";
	private static final String findById = "SELECT * From localidad as L  join personas as P where P.IdLocalidad = ?";
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

	public boolean insert(LocalidadDTO agregarLocalidad) {
		PreparedStatement statement;
		try 
		{

			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setString(1, agregarLocalidad.getDescripcion());
			statement.setInt(2, agregarLocalidad.getCodigoPostal());
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

	public boolean update(LocalidadDTO editarLocalidad) {
		PreparedStatement statement;
		try 
		{

			statement = conexion.getSQLConexion().prepareStatement(update);			
			statement.setString(1, editarLocalidad.getDescripcion());
			statement.setInt(2, editarLocalidad.getCodigoPostal());
			statement.setInt(3, editarLocalidad.getIdLocalidad());
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

	public LocalidadDTO findByDescrip(String localidad) {

		PreparedStatement statement;
		ResultSet resultSet; 
		LocalidadDTO newLocalidad = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(findByDescrip);			
			statement.setString(1, localidad);
			resultSet = statement.executeQuery();

			if(resultSet.next())
			{
				newLocalidad = new LocalidadDTO(resultSet.getInt("idLocalidad"), resultSet.getString("Descripcion"), resultSet.getInt("CodigoPostal"));
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
		return newLocalidad;

	}

	public boolean findIfLocalidadIsAssing(int localidad) {

		PreparedStatement statement;
		ResultSet resultSet; 
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(findById);			
			statement.setInt(1, localidad);
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

	public boolean borrarLocalidad(LocalidadDTO localidadDTO) {

		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(localidadDTO.getIdLocalidad()));
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
