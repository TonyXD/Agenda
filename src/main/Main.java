package main;

import modelo.Agenda;
import modelo.Contacto;
import modelo.Localidad;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Agenda modelo = new Agenda();
		Localidad localidad = new Localidad();
		Contacto contacto = new Contacto();
		Controlador controlador = new Controlador(vista, modelo, localidad, contacto);
		controlador.inicializar();
	}
}
