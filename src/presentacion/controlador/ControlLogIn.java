package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import Utils.XMLGenerator;
import dto.LogInDTO;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Localidad;
import modelo.LogIn;
import presentacion.vista.VentanaLogIn;
import presentacion.vista.Vista;


public class ControlLogIn implements ActionListener{

	private VentanaLogIn ventana;
	private LogInDTO logInDTO;
	private LogIn logIn = new LogIn();


	public ControlLogIn(VentanaLogIn vistaLogIn, LogIn logIn) {

		this.ventana = vistaLogIn;
		this.logInDTO = new LogInDTO();

		this.ventana.getbtn_LogIn().addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(this.ventana != null && e.getSource() == this.ventana.getbtn_LogIn())
		{
			this.logInDTO.setPuerto(this.ventana.getEntrada().getText());
			this.logInDTO.setUser(this.ventana.getUsuario().getText());
			this.logInDTO.setPass(this.ventana.getClave().getText());

			try {
				XMLGenerator.generate("conexion", this.logInDTO);	
				
				logIn.CreateSchema();
				
				
				Vista vista = new Vista();
				Agenda modelo = new Agenda();
				Localidad localidad = new Localidad();
				Contacto contacto = new Contacto();
				Controlador controlador = new Controlador(vista, modelo, localidad, contacto);
				JOptionPane.showMessageDialog(null, "Bienvenido			: "+  this.logInDTO.getUser() );
				controlador.inicializar();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}
