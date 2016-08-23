package main;

import modelo.Agenda;
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
		Controlador controlador = new Controlador(vista, modelo, localidad);
		controlador.inicializar();
	}
}
