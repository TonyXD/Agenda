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

public class VentanaLogIn extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton btn_LogIn;

	//TEXT FIELDS
	private JTextField txt_Usuario;
	private JPasswordField txt_Contraseña;
	private JTextField txt_Entrada;


	public VentanaLogIn() 
	{
		super();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);

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
		lblUsuario.setBounds(20, 136, 89, 23);
		getContentPane().add(lblUsuario);

		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(20, 181, 89, 23);
		getContentPane().add(lblContrasenia);
		getContentPane().setLayout(null);

		txt_Usuario = new JTextField();
		txt_Usuario.setBounds(119, 139, 170, 20);
		getContentPane().add(txt_Usuario);
		txt_Usuario.setColumns(10);

		btn_LogIn = new JButton("Conectar");
		btn_LogIn.setBounds(385, 228, 89, 23);
		getContentPane().add(btn_LogIn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 215, 464, 2);
		getContentPane().add(separator_1);
		
		txt_Contraseña = new JPasswordField();
		txt_Contraseña.setBounds(119, 184, 170, 20);
		getContentPane().add(txt_Contraseña);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEntrada.setBounds(20, 89, 71, 23);
		getContentPane().add(lblEntrada);
		
		txt_Entrada = new JTextField();
		txt_Entrada.setBounds(119, 90, 170, 20);
		getContentPane().add(txt_Entrada);
		txt_Entrada.setColumns(10);

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
	public JTextField getUsuario()
	{
		return txt_Usuario;
	}
	public JTextField getClave()
	{
		return txt_Contraseña;
	}
	public JTextField getEntrada()
	{
		return txt_Entrada;
	}
}
