package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dto.LocalidadDTO;
import presentacion.controlador.Controlador;

public class VentanaLogIn extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Controlador Controlador;
	private JButton btn_LogIn;

	//TEXT FIELDS
	private JTextField txt_Usuario;
	private JPasswordField txt_Contraseña;


	public VentanaLogIn(Controlador controlador) 
	{
		super();
		this.Controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 256);

		frame = new JFrame();
		frame.setBounds(100, 100, 817, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 464, 2);
		getContentPane().add(separator);

		JLabel lblAgenda = new JLabel("AGENDA");
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setFont(lblAgenda.getFont().deriveFont(lblAgenda.getFont().getSize() + 8f));
		lblAgenda.setBounds(10, 11, 464, 30);
		getContentPane().add(lblAgenda);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(20, 65, 89, 23);
		getContentPane().add(lblUsuario);

		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(20, 113, 89, 23);
		getContentPane().add(lblContrasenia);

		txt_Usuario = new JTextField();
		txt_Usuario.setBounds(119, 65, 170, 20);
		getContentPane().add(txt_Usuario);
		txt_Usuario.setColumns(10);
		getContentPane().setLayout(null);

		btn_LogIn = new JButton("Conectar");
		btn_LogIn.setBounds(385, 189, 89, 23);
		btn_LogIn.addActionListener(this.Controlador);
		getContentPane().add(btn_LogIn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 176, 464, 2);
		getContentPane().add(separator_1);
		
		txt_Contraseña = new JPasswordField();
		txt_Contraseña.setBounds(119, 116, 170, 20);
		getContentPane().add(txt_Contraseña);

		this.setVisible(true);
	}

	public void cargarTextBox(LocalidadDTO localidad)
	{
		txt_Usuario.setText(localidad.getDescripcion());
		txt_Contraseña.setText(Integer.toString(localidad.getCodigoPostal()));
	}
	public void limpiarTextBox()
	{
		txt_Usuario.setText("");
		txt_Contraseña.setText("");
	}

	//Getters
	public JButton getbtn_LogIn()
	{
		return this.btn_LogIn;
	}
	public JTextField getDescripcion()
	{
		return this.txt_Usuario;
	}
	public JTextField getCodigoPostar()
	{
		return this.txt_Contraseña;
	}
}
