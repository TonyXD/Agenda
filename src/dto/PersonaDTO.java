package dto;
import java.time.LocalDate;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String Domicilio;
	private int NroCalle;
	private int NroPiso;
	private String NroDpto;
	private String Localidad;
	private String EMail;
	private LocalDate FechaCumpleanios;
	private String TipoContacto;

	public PersonaDTO(int idPersona, String nombre, String telefono, String domicilio, 
			int nroCalle, int nroPiso, String nroDpto, String localidad,
			String mail, LocalDate fechaCumpleanios, String tipoContacto)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.Domicilio = domicilio;
		this.NroCalle = nroCalle;
		this.NroDpto = nroDpto;
		this.NroPiso = nroPiso;
		this.EMail = mail;		
		this.FechaCumpleanios = fechaCumpleanios;
		this.Localidad = localidad;
		
		this.TipoContacto = tipoContacto;		
	}
	
	//Geters
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public String getDomicilio() 
	{
		return this.Domicilio;
	}

	public int getNroCalle() 
	{
		return this.NroCalle;
	}

	public int getNroPiso() 
	{
		return this.NroPiso;
	}

	public String getNroDpto() 
	{
		return this.NroDpto;
	}

	public String getLocalidad() 
	{
		return this.Localidad;
	}
	
	public String getTipoContacto() 
	{
		return this.TipoContacto;
	}

	public String getMail() {
		return this.EMail;
	}
	
	public LocalDate getFechaCumpleanios() {
		return this.FechaCumpleanios;
	}

	//Seters
	
	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public void setNroPiso(int nroPiso) 
	{
		this.NroPiso = nroPiso;
	}

	public void setNroCalle(int nroCalle) 
	{
		this.NroCalle = nroCalle;
	}
	
	public void setDomicilio(String domicilio) 
	{
		this.Domicilio = domicilio;
	}

	public void setNroDpto(String nroDpto) 
	{
		this.NroDpto = nroDpto;
	}

	public void setLocalidad(String localidad) 
	{
		this.Localidad = localidad;
	}
	
	public void setTipoContacto(String tipoContacto) 
	{
		this.TipoContacto = tipoContacto;
	}

	public void setFechaCumpleaneos(LocalDate fechaCumpleanios) {
		this.FechaCumpleanios = fechaCumpleanios;
	}
	
	public void setEMail(String eMail) {
		this.EMail = eMail;
	}
	
	
}
