package main;

import java.io.File;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Localidad;
import modelo.LogIn;
import presentacion.controlador.Controlador;
import presentacion.controlador.ControlLogIn;
import presentacion.vista.VentanaLogIn;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		File f = new File("conexion.xml");
		if(f.exists() && !f.isDirectory()) { 
			Vista vista = new Vista();
			Agenda modelo = new Agenda();
			Localidad localidad = new Localidad();
			Contacto contacto = new Contacto();
			Controlador controlador = new Controlador(vista, modelo, localidad, contacto);
			controlador.inicializar();
		}
		else
		{
			VentanaLogIn vistaLogIn = new VentanaLogIn();
			LogIn logIn = new LogIn();			
			@SuppressWarnings("unused")
			ControlLogIn logControler = new ControlLogIn(vistaLogIn, logIn);
		}
	}
}
