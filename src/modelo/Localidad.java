package modelo;

import java.util.List;

import dto.LocalidadDTO;
import persistencia.dao.LocalidadDAO;

public class Localidad {
	
	private LocalidadDAO localidad; 
	
	public Localidad()
	{
		this.localidad = new LocalidadDAO();
	}
	
	public List<LocalidadDTO> BuscarLocalidades()
	{
		return localidad.readAll();		
	}
	
	public void insertLocalidad(LocalidadDTO agregarLocalidad)
	{
		localidad.insert(agregarLocalidad);
	}
	
	public void updateLocalidad(LocalidadDTO editarLocalidad) {
		localidad.update(editarLocalidad);
	}
	
}
