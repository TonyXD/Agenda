package dto;

public class LocalidadDTO {
	
	private int IdLocalidad;
	private String Descripcion;
	private int CodigoPostal;
	
	public LocalidadDTO(int id, String descripcion, int CP)
	{
		this.IdLocalidad = id;
		this.Descripcion = descripcion;
		this.CodigoPostal = CP;
	}	
	
	public LocalidadDTO()
	{
		
	}	
	
	
	public int getIdLocalidad() {
		return IdLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		IdLocalidad = idLocalidad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getCodigoPostal() {
		return CodigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		CodigoPostal = codigoPostal;
	}

}
