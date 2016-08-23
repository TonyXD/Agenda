package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JTable;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import modelo.Agenda;
import modelo.Localidad;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;;

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
		
		public Controlador(Vista vista, Agenda agenda, Localidad localidad)
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
						this.personas_en_tabla.get(i).getNroPiso(), this.personas_en_tabla.get(i).getNroDpto(), this.personas_en_tabla.get(i).getLocalidad(),
						this.personas_en_tabla.get(i).getMail(), this.personas_en_tabla.get(i).getFechaCumpleanios(), this.personas_en_tabla.get(i).getTipoContacto()};
				this.vista.getModelPersonas().addRow(fila);
			}
			this.vista.show();
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
		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				this.ventanaPersona = new VentanaPersona(this);
			}
			else if(e.getSource() == this.vista.getBtnEditar())
			{
				
				this.ventanaPersona = new VentanaPersona(this);
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
				PersonaDTO nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText(), 
						ventanaPersona.getTxtDireccion().getText(), Integer.parseInt(ventanaPersona.getTxtNroCalle().getText()),
						Integer.parseInt(ventanaPersona.getTxtNroPiso().getText()),
						ventanaPersona.getTxtNroDpto().getText(), ventanaPersona.getLocalidad(),
						ventanaPersona.getTxtMail().getText(), ventanaPersona.getTextFechaCumpleanios(), 
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
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarEditarLocalidad())
			{
				this.ventanaLocalidad = new VentanaLocalidad(this);
				this.llenarTablaLocalidades();
			}
			//Funcionalidad botones Ventana Localidad
			else if(e.getSource() == this.ventanaLocalidad.getBtnAgregar())
			{
				LocalidadDTO newLocalidad = new LocalidadDTO();
				newLocalidad.setDescripcion(this.ventanaLocalidad.getDescripcion().getText());
				newLocalidad.setCodigoPostal(Integer.parseInt(this.ventanaLocalidad.getCodigoPostar().getText()));
				this.localidad.insertLocalidad(newLocalidad);
				this.ventanaLocalidad.limpiarTextBox();
				this.llenarTablaLocalidades();
			}
			else if(e.getSource() == this.ventanaLocalidad.getBtnEditar())
			{
				this.localidadSeleccionada.setDescripcion(this.ventanaLocalidad.getDescripcion().getText());
				this.localidadSeleccionada.setCodigoPostal(Integer.parseInt(this.ventanaLocalidad.getCodigoPostar().getText()));
				this.localidad.updateLocalidad(this.localidadSeleccionada);
				this.ventanaLocalidad.limpiarTextBox();
				this.llenarTablaLocalidades();
			}
			else if(e.getSource() == this.ventanaLocalidad.getBtnCargar())
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
		}

}
