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

	public int findIdContactoByDescrip(String tipoContacto) {
		
		int IdContacto = this.contacto.findIdContactoByDescrip(tipoContacto).getIdContacto();		
		return IdContacto;
	}
}
