package modelo;

import java.util.List;

import dto.ContactoDTO;
import persistencia.dao.ContactoDAO;

public class Contacto {
	
private ContactoDAO contacto; 
	
	public Contacto()
	{
		this.contacto = new ContactoDAO();
	}
	
	public List<ContactoDTO> BuscarLocalidades()
	{
		return contacto.readAll();		
	}
	
	public void insertLocalidad(ContactoDTO agregarContacto)
	{
		contacto.insert(agregarContacto);
	}
	
	public void updateLocalidad(ContactoDTO editarContacto) {
		contacto.update(editarContacto);
	}
}
