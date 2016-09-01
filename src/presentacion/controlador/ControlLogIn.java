package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import Utils.XMLGenerator;
import dto.LogInDTO;
import modelo.LogIn;
import presentacion.vista.VentanaLogIn;


public class ControlLogIn implements ActionListener{

	private VentanaLogIn ventana;
	private LogInDTO logInDTO;


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
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Puerto: "+ this.logInDTO.getPuerto() + "Usuario: "+ this.logInDTO.getUser() + "Clave: " + this.logInDTO.getPass());
		}

	}

}
