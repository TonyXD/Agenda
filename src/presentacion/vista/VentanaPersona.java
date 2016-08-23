package presentacion.vista;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private JButton btnAgregarEditarLocalidad;
	private JButton btnAgregarEditarContacto;
	private Controlador controlador;
	private JTextField txtDireccion;
	private JTextField txtNroCalle;
	private JTextField txtNroPiso;
	private JTextField txtNroDpto;
	private JTextField txtMail;
	private JTextField txtDiaCumpleanios;
	private JTextField txtMesCumpleanios;
	private JTextField txtAnioCumpleanios;
	private JComboBox<String> ddlLocalidad;
	private JComboBox<String> ddlTipoContacto;
	private DefaultComboBoxModel<String> model;
	
	public VentanaPersona(Controlador controlador) 
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 674, 410);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(20, 46, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(20, 320, 113, 14);
		panel.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(20, 69, 130, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(20, 345, 130, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(250, 380, 80, 20);
		panel.add(btnAgregarPersona);

		btnAgregarEditarLocalidad = new JButton("Agregar/Editar Localidad");
		btnAgregarEditarLocalidad.addActionListener(this.controlador);
		btnAgregarEditarLocalidad.setBounds(330, 380, 160, 20);
		panel.add(btnAgregarEditarLocalidad);
		
		btnAgregarEditarContacto = new JButton("Agregar/Editar Contacto");
		btnAgregarEditarContacto.addActionListener(this.controlador);
		btnAgregarEditarContacto.setBounds(490, 380, 180, 20);
		panel.add(btnAgregarEditarContacto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 654, 2);
		panel.add(separator);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setBounds(10, 11, 98, 14);
		panel.add(lblDatosPersonales);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 307, 644, 2);
		panel.add(separator_1);
		
		JLabel lblDatosDeContacto = new JLabel("Datos de contacto");
		lblDatosDeContacto.setBounds(20, 282, 113, 14);
		panel.add(lblDatosDeContacto);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(20, 116, 59, 14);
		panel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(20, 141, 130, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNumeroCalle = new JLabel("Numero calle");
		lblNumeroCalle.setBounds(20, 199, 75, 14);
		panel.add(lblNumeroCalle);
		
		txtNroCalle = new JTextField();
		txtNroCalle.setBounds(20, 224, 130, 20);
		panel.add(txtNroCalle);
		txtNroCalle.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(185, 46, 130, 14);
		panel.add(lblFechaDeNacimiento);
		
		txtDiaCumpleanios = new JTextField();
		txtDiaCumpleanios.setBounds(185, 69, 40, 20);
		panel.add(txtDiaCumpleanios);
		txtDiaCumpleanios.setColumns(10);
		
		txtMesCumpleanios = new JTextField();
		txtMesCumpleanios.setBounds(230, 69, 40, 20);
		panel.add(txtMesCumpleanios);
		txtMesCumpleanios.setColumns(10);
		
		txtAnioCumpleanios = new JTextField();
		txtAnioCumpleanios.setBounds(280, 69, 50, 20);
		panel.add(txtAnioCumpleanios);
		txtAnioCumpleanios.setColumns(10);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de contacto");
		lblTipoDeContacto.setBounds(350, 46, 113, 14);
		panel.add(lblTipoDeContacto);
		
		ddlTipoContacto = new JComboBox<String>();
		ddlTipoContacto.setBounds(350, 69, 130, 20);
		panel.add(ddlTipoContacto);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(185, 199, 46, 14);
		panel.add(lblPiso);
		
		txtNroPiso = new JTextField();
		txtNroPiso.setBounds(185, 224, 130, 20);
		panel.add(txtNroPiso);
		txtNroPiso.setColumns(10);
		
		JLabel lblDpto = new JLabel("Dpto");
		lblDpto.setBounds(338, 199, 46, 14);
		panel.add(lblDpto);
		
		txtNroDpto = new JTextField();
		txtNroDpto.setBounds(338, 224, 130, 20);
		panel.add(txtNroDpto);
		txtNroDpto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mail");
		lblNewLabel.setBounds(185, 320, 46, 14);
		panel.add(lblNewLabel);
		
		txtMail = new JTextField();
		txtMail.setBounds(185, 345, 130, 20);
		panel.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(185, 116, 75, 14);
		panel.add(lblLocalidad);
		
	
		ddlLocalidad = new JComboBox<>();
		ddlLocalidad.setBounds(185, 141, 130, 20);
		panel.add(ddlLocalidad);
		
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
	
	public JButton getBtnAgregarEditarLocalidad() 
	{
		return btnAgregarEditarLocalidad;
	}
	
	public JButton getBtnAgregarEditarContacto() 
	{
		return btnAgregarEditarContacto;
	}
	
	public JTextField getTxtDireccion() 
	{
		return txtDireccion;
	}
	
	public JTextField getTxtMail() 
	{
		return txtMail;
	}
	
	public JTextField getTxtNroDpto() 
	{
		return txtNroDpto;
	}
	
	public JTextField getTxtNroCalle() 
	{
		return txtNroCalle;
	}
	
	public JTextField getTxtNroPiso() 
	{
		return txtNroPiso;
	}
	
	public String getLocalidad()
	{
		return ddlLocalidad.getSelectedItem().toString();
	}
	
	public String getTipoContacto()
	{
		return ddlTipoContacto.getSelectedItem().toString();
	}

	public void setComboBoxLocalidad(List<String> list) {
		String[] comboBoxModel = list.toArray(new String[0]);
	    model = new DefaultComboBoxModel<String>(comboBoxModel);
	    ddlLocalidad.setModel(model);
	}
	
	public void setComboBoxContacto(List<String> list) {
		String[] comboBoxModel = list.toArray(new String[0]);
	    model = new DefaultComboBoxModel<String>(comboBoxModel);
	    ddlTipoContacto.setModel(model);
	}
	
	public void cargarPantalla(String nombre, String telefono, String direccion, String nroCalle, String nroPiso,
			String nroDpto, String localidad, String dirEmail, LocalDate cumpleaños, String tipoContacto)
	{
		this.txtNombre.setText(nombre);
		this.txtTelefono.setText(telefono);
		this.txtDireccion.setText(direccion);
		this.txtNroCalle.setText(nroCalle);
		this.txtNroPiso.setText(nroPiso);
		this.txtNroDpto.setText(nroDpto);
		this.ddlLocalidad.setSelectedItem(localidad);
		this.txtMail.setText(dirEmail);
		this.ddlTipoContacto.setSelectedItem(tipoContacto);
		
		this.txtDiaCumpleanios.setText(Integer.toString(cumpleaños.getDayOfMonth()));
		this.txtMesCumpleanios.setText(Integer.toString(cumpleaños.getMonthValue()));
		this.txtAnioCumpleanios.setText(Integer.toString(cumpleaños.getYear()));
	}

	
	public LocalDate getTextFechaCumpleanios() {
		return LocalDate.of(Integer.parseInt(txtAnioCumpleanios.getText()), Integer.parseInt(txtMesCumpleanios.getText()), Integer.parseInt(txtDiaCumpleanios.getText()));
	}
	
	
}

