package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import presentacion.controlador.Controlador;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;



public class Localidad extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Controlador Controlador;
	
	//BOTONES
	private JButton btnAgregar;
	private JButton btnEditar;

	//TABLA
	private JTable tbl_Localidades;
	private DefaultTableModel modelLocalidad;
	private  String[] nombreColumnas = {"#","Localidad", "Codigo postal"};
	
	//TEXT FIELDS
	private JTextField txt_Descripcion;
	private JTextField txt_CodigoPostal;
	
	
	public Localidad(Controlador controlador) 
	{
		super();
		this.Controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 817, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollBarLocalidad = new JScrollPane();
		scrollBarLocalidad.setBounds(10, 65, 464, 312);
		getContentPane().add(scrollBarLocalidad);
		
		modelLocalidad = new DefaultTableModel(null,nombreColumnas);
		tbl_Localidades = new JTable(modelLocalidad);
		
		tbl_Localidades.getColumnModel().getColumn(0).setPreferredWidth(10);
		tbl_Localidades.getColumnModel().getColumn(0).setResizable(false);
		tbl_Localidades.getColumnModel().getColumn(1).setPreferredWidth(100);
		tbl_Localidades.getColumnModel().getColumn(1).setResizable(false);
		tbl_Localidades.getColumnModel().getColumn(2).setPreferredWidth(100);
		tbl_Localidades.getColumnModel().getColumn(2).setResizable(false);
		
		scrollBarLocalidad.setViewportView(tbl_Localidades);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(373, 528, 89, 23);
		btnAgregar.addActionListener(this.Controlador);
		getContentPane().setLayout(null);
		getContentPane().add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(274, 528, 89, 23);
		getContentPane().add(btnEditar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 464, 2);
		getContentPane().add(separator);
		
		JLabel lblLocalidades = new JLabel("Localidades");
		lblLocalidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalidades.setFont(lblLocalidades.getFont().deriveFont(lblLocalidades.getFont().getSize() + 8f));
		lblLocalidades.setBounds(10, 11, 464, 30);
		getContentPane().add(lblLocalidades);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 388, 464, 2);
		getContentPane().add(separator_1);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 407, 89, 23);
		getContentPane().add(lblDescripcion);
		
		JLabel lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoPostal.setBounds(274, 411, 89, 23);
		getContentPane().add(lblCodigoPostal);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 512, 464, 2);
		getContentPane().add(separator_2);
		
		txt_Descripcion = new JTextField();
		txt_Descripcion.setEnabled(false);
		txt_Descripcion.setBounds(20, 441, 170, 20);
		getContentPane().add(txt_Descripcion);
		txt_Descripcion.setColumns(10);
		
		txt_CodigoPostal = new JTextField();
		txt_CodigoPostal.setEnabled(false);
		txt_CodigoPostal.setBounds(277, 441, 170, 20);
		getContentPane().add(txt_CodigoPostal);
		txt_CodigoPostal.setColumns(10);
		
		JLabel lblParaRealizarUna = new JLabel("[ Para realizar una edicion seleccione primero un campo de la tabla ]");
		lblParaRealizarUna.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaRealizarUna.setForeground(new Color(0, 0, 139));
		lblParaRealizarUna.setBounds(10, 497, 464, 14);
		getContentPane().add(lblParaRealizarUna);
		
		this.setVisible(true);
	}

	
	//Getters
	public JButton getBtnAgregar()
	{
		return this.btnAgregar;
	}
	public JButton getBtnEditad()
	{
		return this.btnEditar;
	}
	public JTextField getDescripcion()
	{
		return this.txt_Descripcion;
	}
	public JTextField getCodigoPostar()
	{
		return this.txt_CodigoPostal;
	}
	public JTable getTablaLocalidades()
	{
		return this.tbl_Localidades;
	}
	
}
