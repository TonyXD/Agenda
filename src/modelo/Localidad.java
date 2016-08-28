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


	public int findIdLocalidadByDescrip(String localidad) {

		int idLocalidad = this.localidad.findByDescrip(localidad).getIdLocalidad() ;
		return idLocalidad;
	}

	public boolean findIfLocalidadIsAssing(int localidad) {
		
		return this.localidad.findIfLocalidadIsAssing(localidad);
	}

	public void borrarLocalidad(LocalidadDTO localidadDTO) {
		this.localidad.borrarLocalidad(localidadDTO);
	}
}
