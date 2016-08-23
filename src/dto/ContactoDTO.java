package dto;

public class ContactoDTO {

	private int IdContacto;
	private String Descripcion;
	
	public ContactoDTO(int id, String descripcion)
	{
		this.IdContacto = id;
		this.Descripcion = descripcion;
	}	
	
	public ContactoDTO()
	{
		
	}	
	
	
	public int getIdContacto() {
		return IdContacto;
	}
	public void setIdContacto(int idContacto) {
		IdContacto = idContacto;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}	
}
