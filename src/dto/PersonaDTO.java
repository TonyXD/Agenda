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
	private int IdLocalidad;
	private String DescripcionLocalidad;
	private String EMail;
	private LocalDate FechaCumpleanios;
	private int IdContacto;
	private String DescripcionContacto;

	public PersonaDTO(int idPersona, String nombre, String telefono, String domicilio, 
			int nroCalle, int nroPiso, String nroDpto, int idLocalidad, String localidad,
			String mail, LocalDate fechaCumpleanios,int idContacto, String tipoContacto)
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
		this.IdLocalidad = idLocalidad;
		this.DescripcionLocalidad = localidad;
		this.IdContacto = idContacto;
		this.DescripcionContacto = tipoContacto;		
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

	public String getDescripcionLocalidad() 
	{
		return this.DescripcionLocalidad;
	}
	
	public String getDescripcionContacto() 
	{
		return this.DescripcionContacto;
	}

	public String getMail() {
		return this.EMail;
	}
	
	public LocalDate getFechaCumpleanios() {
		return this.FechaCumpleanios;
	}

	public int getIdContacto() {
		return this.IdContacto;
	}

	public int getIdLocalidad() {
		return this.IdLocalidad;
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

	public void setDescripcionLocalidad(String localidad) 
	{
		this.DescripcionLocalidad = localidad;
	}
	
	public void setDescripcionContacto(String tipoContacto) 
	{
		this.DescripcionContacto = tipoContacto;
	}

	public void setFechaCumpleaneos(LocalDate fechaCumpleanios) {
		this.FechaCumpleanios = fechaCumpleanios;
	}
	
	public void setEMail(String eMail) {
		this.EMail = eMail;
	}

	public void setIdContacto(int idContacto) {
		this.IdContacto = idContacto;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.IdLocalidad = idLocalidad;
	}
	
	
}
