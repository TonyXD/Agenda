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
	
	public List<ContactoDTO> BuscarContactos()
	{
		return contacto.readAll();		
	}
	
	public void insertContacto(ContactoDTO agregarContacto)
	{
		contacto.insert(agregarContacto);
	}
	
	public void updateContacto(ContactoDTO editarContacto) {
		contacto.update(editarContacto);
	}

	public void borrarContacto(ContactoDTO contacto) {
		this.contacto.borrarContacto(contacto);
	}

	
	public int findIdContactoByDescrip(String tipoContacto) {
		
		int IdContacto = this.contacto.findIdContactoByDescrip(tipoContacto).getIdContacto();		
		return IdContacto;
	}
	
	public boolean findIfLocalidadIsAssing(int tipoContacto) {
		
		return this.contacto.findIfLocalidadIsAssing(tipoContacto);
	}
}
