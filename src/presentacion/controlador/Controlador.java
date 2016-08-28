package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import dto.ContactoDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Localidad;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import presentacion.vista.ventanaContacto;;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		

		private VentanaLocalidad ventanaLocalidad;
		private List<LocalidadDTO> ListaDeLocalidades;
		private Localidad localidad;
		private LocalidadDTO localidadSeleccionada;
		
		
		private ventanaContacto ventanaContacto;
		private List<ContactoDTO> ListaDeContactos;
		private Contacto contacto;
		private ContactoDTO contactoSeleccionada;
		
		public Controlador(Vista vista, Agenda agenda, Localidad localidad, Contacto contacto)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnEditar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.agenda = agenda;
			this.personas_en_tabla = null;
			
			this.localidad = localidad;
			this.ListaDeLocalidades = null;	
			
			this.contacto = contacto;
			this.ListaDeContactos = null;
		}
		
		public void inicializar()
		{
			this.llenarTabla();
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = {this.personas_en_tabla.get(i).getNombre(), this.personas_en_tabla.get(i).getTelefono(),
						this.personas_en_tabla.get(i).getDomicilio(), this.personas_en_tabla.get(i).getNroCalle(),
						this.personas_en_tabla.get(i).getNroPiso(), this.personas_en_tabla.get(i).getNroDpto(), this.personas_en_tabla.get(i).getDescripcionLocalidad(),
						this.personas_en_tabla.get(i).getMail(), this.personas_en_tabla.get(i).getFechaCumpleanios(), this.personas_en_tabla.get(i).getDescripcionContacto()};
				this.vista.getModelPersonas().addRow(fila);
			}
			this.vista.show();
		}
		
		private void llenarDdlLocalidades()
		{
			this.ListaDeLocalidades = localidad.BuscarLocalidades();
			
			List<String> DescripcionesList = ListaDeLocalidades.stream().map(x -> x.getDescripcion()).collect(Collectors.toList()); 
			this.ventanaPersona.setComboBoxLocalidad(DescripcionesList);
		}
		
		private void llenarDdlContactos()
		{
			this.ListaDeContactos = contacto.BuscarContactos();
			
			List<String> DescripcionesList = ListaDeContactos.stream().map(x -> x.getDescripcion()).collect(Collectors.toList()); 
			this.ventanaPersona.setComboBoxContacto(DescripcionesList);
		}


		private void llenarTablaLocalidades()
		{
			this.ventanaLocalidad.getTablaModel().setRowCount(0);
			this.ventanaLocalidad.getTablaModel().setColumnCount(0);
			this.ventanaLocalidad.getTablaModel().setColumnIdentifiers(this.ventanaLocalidad.getNombreColumnas());
			
			this.ListaDeLocalidades = localidad.BuscarLocalidades();
			if(this.ListaDeLocalidades != null)
			{				
				for (int i = 0; i < this.ListaDeLocalidades.size(); i ++)
				{
					Object[] fila = {this.ListaDeLocalidades.get(i).getIdLocalidad(), this.ListaDeLocalidades.get(i).getDescripcion(),
							this.ListaDeLocalidades.get(i).getCodigoPostal()};
					this.ventanaLocalidad.getTablaModel().addRow(fila);
				}	
			}
			
		}
		
		private void llenarTablaContacto()
		{
			this.ventanaContacto.getTablaModel().setRowCount(0);
			this.ventanaContacto.getTablaModel().setColumnCount(0);
			this.ventanaContacto.getTablaModel().setColumnIdentifiers(this.ventanaContacto.getNombreColumnas());
			
			this.ListaDeContactos = contacto.BuscarContactos();
			if(this.ListaDeContactos != null)
			{				
				for (int i = 0; i < this.ListaDeContactos.size(); i ++)
				{
					Object[] fila = {this.ListaDeContactos.get(i).getIdContacto(), this.ListaDeContactos.get(i).getDescripcion()};
					this.ventanaContacto.getTablaModel().addRow(fila);
				}	
			}
			
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				this.ventanaPersona = new VentanaPersona(this);
				this.llenarDdlLocalidades();
				this.llenarDdlContactos();
			}
			else if(e.getSource() == this.vista.getBtnEditar())
			{
				
				this.ventanaPersona = new VentanaPersona(this);
				this.llenarDdlLocalidades();
				this.llenarDdlContactos();
				
				int fila = this.vista.getTablaPersonas().getSelectedRow();
				if(fila != -1){
				JTable tabla =  this.vista.getTablaPersonas();
				String nombre = (String) tabla.getValueAt(fila, 0);
				String telefono = (String) tabla.getValueAt(fila, 1);
				String Direccion = (String) tabla.getValueAt(fila, 2);
				int NroCalle = (int) tabla.getValueAt(fila, 3);
				int NroPiso = (int) tabla.getValueAt(fila, 4);
				String NroDpto = (String) tabla.getValueAt(fila, 5);
				String Localidad = (String) tabla.getValueAt(fila, 6);
				String DirEmail = (String) tabla.getValueAt(fila, 7);
				LocalDate Cumpleaños = (LocalDate) tabla.getValueAt(fila, 8);
				String TipoContacto = (String) tabla.getValueAt(fila, 9);
				
				this.ventanaPersona.cargarPantalla(nombre, telefono, Direccion, Integer.toString(NroCalle), 
						Integer.toString(NroPiso), NroDpto, Localidad, DirEmail, Cumpleaños, TipoContacto);	
				}				
			}
			else if(e.getSource() == this.vista.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
				}
				
				this.llenarTabla();
				
			}
			else if(e.getSource() == this.vista.getBtnReporte())
			{				
				ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
				reporte.mostrar();				
			}
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{
				int fila = this.vista.getTablaPersonas().getSelectedRow();
				if(ejecurtarValidacioneVentanaPersona(this.ventanaPersona))
				{					
					//TODO GET ID LOCALIDAD Y CONTACTO DE BD
					int idLocalidad = this.localidad.findIdLocalidadByDescrip(this.ventanaPersona.getLocalidad());
					int idContacto = this.contacto.findIdContactoByDescrip(this.ventanaPersona.getTipoContacto());
					
					PersonaDTO nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText(), 
							ventanaPersona.getTxtDireccion().getText(), Integer.parseInt(ventanaPersona.getTxtNroCalle().getText()),
							Integer.parseInt(ventanaPersona.getTxtNroPiso().getText()),
							ventanaPersona.getTxtNroDpto().getText(), idLocalidad, ventanaPersona.getLocalidad(),
							ventanaPersona.getTxtMail().getText(), ventanaPersona.getTextFechaCumpleanios(), idContacto, 
							ventanaPersona.getTipoContacto());
					if(fila != -1)
					{
						if(this.agenda.selectPersona(this.personas_en_tabla.get(fila)))
						{
							nuevaPersona.setIdPersona(this.personas_en_tabla.get(fila).getIdPersona());
							this.agenda.updatePersona(nuevaPersona);					
						}
						else
						{
							this.agenda.agregarPersona(nuevaPersona);
						}
					}
					else
					{
						this.agenda.agregarPersona(nuevaPersona);
					}

					this.llenarTabla();
					this.ventanaPersona.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Los datos que esta pasando no son validos");
				}				
			}
			//Funcionalidad botones Ventana Localidad
			else if(this.ventanaPersona!= null && e.getSource() == this.ventanaPersona.getBtnAgregarEditarLocalidad())
			{
				this.ventanaLocalidad = new VentanaLocalidad(this);
				this.llenarTablaLocalidades();
			}
			else if(this.ventanaLocalidad!= null && e.getSource() == this.ventanaLocalidad.getBtnAgregar())
			{
				LocalidadDTO newLocalidad = new LocalidadDTO();			
				newLocalidad.setDescripcion(this.ventanaLocalidad.getDescripcion().getText());
				if(isNumeric(this.ventanaLocalidad.getCodigoPostar().getText()))
				{					
					newLocalidad.setCodigoPostal(Integer.parseInt(this.ventanaLocalidad.getCodigoPostar().getText()));
					this.localidad.insertLocalidad(newLocalidad);
					this.ventanaLocalidad.limpiarTextBox();
					this.llenarTablaLocalidades();
					this.llenarDdlLocalidades();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Los datos que esta pasando no son validos");
				}
				
			}
			else if(this.ventanaLocalidad!= null && e.getSource() == this.ventanaLocalidad.getBtnEditar())
			{			
				if( this.localidadSeleccionada != null)
				{
					if(isNumeric(this.ventanaLocalidad.getCodigoPostar().getText()) && this.ventanaLocalidad.getDescripcion().getText().length() > 0)
					{	
						this.localidadSeleccionada.setDescripcion(this.ventanaLocalidad.getDescripcion().getText());
						this.localidadSeleccionada.setCodigoPostal(Integer.parseInt(this.ventanaLocalidad.getCodigoPostar().getText()));
						this.localidad.updateLocalidad(this.localidadSeleccionada);
						this.ventanaLocalidad.limpiarTextBox();
						this.llenarTablaLocalidades();
						this.llenarDdlLocalidades();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Los datos que esta pasando no son validos");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe cargar una localidad");
				}
				
			}
			else if(this.ventanaLocalidad!= null && e.getSource() == this.ventanaLocalidad.getBtnCargar())
			{
				int fila = this.ventanaLocalidad.getTablaLocalidades().getSelectedRow();
				if(fila != -1){
				JTable tabla =  this.ventanaLocalidad.getTablaLocalidades();
				int id = (int) tabla.getValueAt(fila, 0);
				String Descripcion = (String) tabla.getValueAt(fila, 1);
				int codigoPostal = (int) tabla.getValueAt(fila, 2);
				
				this.localidadSeleccionada = new LocalidadDTO(id, Descripcion, codigoPostal);
				
				this.ventanaLocalidad.cargarTextBox(localidadSeleccionada);					
				}				
			}
			//Funcionalidad botones Ventana Contacto
			else if(this.ventanaPersona!= null && e.getSource() == this.ventanaPersona.getBtnAgregarEditarContacto())
			{
				this.ventanaContacto = new ventanaContacto(this);
				this.llenarTablaContacto();
			}
			else if(this.ventanaContacto!= null && e.getSource() == this.ventanaContacto.getBtnAgregar())
			{
				ContactoDTO newContacto = new ContactoDTO();
				if(this.ventanaContacto.getDescripcion().getText().length() > 0)
				{
					newContacto.setDescripcion(this.ventanaContacto.getDescripcion().getText());
					this.contacto.insertContacto(newContacto);
					this.ventanaContacto.limpiarTextBox();
					this.llenarTablaContacto();
					this.llenarDdlContactos();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Los datos que esta pasando no son validos");
				}
			}
			else if(this.ventanaContacto!= null && e.getSource() == this.ventanaContacto.getBtnEditar())
			{
				if( this.contactoSeleccionada != null)
				{
					if(this.ventanaContacto.getDescripcion().getText().length() > 0)
					{
						this.contactoSeleccionada.setDescripcion(this.ventanaContacto.getDescripcion().getText());
						this.contacto.updateContacto(this.contactoSeleccionada);
						this.ventanaContacto.limpiarTextBox();
						this.llenarTablaContacto();
						this.llenarDdlContactos();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Los datos que esta pasando no son validos");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Debe cargar un Contacto");
				}
				
				
			}
			else if(this.ventanaContacto!= null && e.getSource() == this.ventanaContacto.getBtnCargar())
			{
				int fila = this.ventanaContacto.getTablaLocalidades().getSelectedRow();
				if(fila != -1){
				JTable tabla =  this.ventanaContacto.getTablaLocalidades();
				int id = (int) tabla.getValueAt(fila, 0);
				String Descripcion = (String) tabla.getValueAt(fila, 1);
				
				this.contactoSeleccionada = new ContactoDTO(id, Descripcion);
				
				this.ventanaContacto.cargarTextBox(contactoSeleccionada);					
				}				
			}
		}

		private boolean ejecurtarValidacioneVentanaPersona(VentanaPersona ventana) {
			
			if(validarFecha(ventana.getTextFechaCumpleanios()) && isNumeric(ventana.getTxtNroCalle().getText()) 
					&& isNumeric(ventana.getTxtNroPiso().getText()) && isNumeric(ventana.getTxtTelefono().getText()))
			{
				return true;
			}
						
			return false;
		}
		
		private boolean validarFecha(LocalDate textFechaCumpleanios) {
			if(textFechaCumpleanios.getDayOfMonth() > 0 && textFechaCumpleanios.getMonthValue() > 0 && textFechaCumpleanios.getYear() > 0)
			{
				return true;
			}
			return false;
		}

		public boolean isNumeric(String s) {  
		    return s.matches("[-+]?\\d*\\.?\\d+");  
		}
}
