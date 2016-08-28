package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.PersonaDTO;
import persistencia.conexion.Conexion;

public class PersonaDAO 
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, direccion, NroCalle, NroPiso, NroDpto, idLocalidad, DirEmail, FechaCumpleaños, idContacto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT P.idPersona, P.Nombre, P.Telefono, P.Direccion, P.NroCalle, P.NroPiso, P.NroDpto, P.DirEmail, P.FechaCumpleaños, L.idLocalidad, L.Descripcion as DescripcionLocalidad, L.CodigoPostal,C.idContacto, C.Descripcion as DescripcionContacto FROM personas as P join localidad as L join contacto as C where P.IdLocalidad = L.idLocalidad  AND P.IdContacto = C.idContacto";
	private static final String update = "UPDATE agenda.personas SET Nombre= ?, Telefono= ?, Direccion= ?, NroCalle= ?, NroPiso= ?, NroDpto= ?, idLocalidad= ?, DirEmail= ?, FechaCumpleaños= ?, idContacto= ? WHERE idPersona= ?";
	private static final String selectById = "SELECT * FROM personas WHERE idPersona = ?";
	private static final Conexion conexion = Conexion.getConexion();
	
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getDomicilio());
			statement.setInt(5, persona.getNroCalle());
			statement.setInt(6, persona.getNroPiso());
			statement.setString(7, persona.getNroDpto());
			statement.setInt(8, persona.getIdLocalidad());
			statement.setString(9, persona.getMail());
			statement.setDate(10, Date.valueOf(persona.getFechaCumpleanios()));
			statement.setInt(11, persona.getIdContacto());
			if(statement.executeUpdate() > 0) //Si se ejecutï¿½ devuelvo true
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
	
	public boolean selectById(PersonaDTO persona)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(selectById);
			statement.setString(1, Integer.toString(persona.getIdPersona()));
			resultSet = statement.executeQuery();
			if(resultSet.next()) //Si se ejecutï¿½ devuelvo true
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
		
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutï¿½ devuelvo true
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
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				LocalDate date = resultSet.getDate("FechaCumpleaños").toLocalDate();
				
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"), 
						resultSet.getString("Direccion"), resultSet.getInt("NroCalle"), resultSet.getInt("NroPiso"),
						resultSet.getString("NroDpto"), resultSet.getInt("IdLocalidad"), resultSet.getString("DescripcionLocalidad"), resultSet.getString("DirEmail"),
						date, resultSet.getInt("IdContacto"), resultSet.getString("DescripcionContacto")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return personas;
	}

	public boolean update(PersonaDTO persona) {
		
		PreparedStatement statement;
		try 
		{
		    		    
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getDomicilio());
			statement.setInt(4, persona.getNroCalle());
			statement.setInt(5, persona.getNroPiso());
			statement.setString(6, persona.getNroDpto());
			statement.setInt(7, persona.getIdLocalidad());
			statement.setString(8, persona.getMail());
			statement.setDate(9, Date.valueOf(persona.getFechaCumpleanios()));
			statement.setInt(10, persona.getIdContacto());
			statement.setInt(11, persona.getIdPersona());
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
