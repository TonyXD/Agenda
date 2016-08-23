package presentacion.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dto.ContactoDTO;
import presentacion.controlador.Controlador;

public class ventanaContacto  extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Controlador Controlador;
	
	//BOTONES
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnCargar;

	//TABLA
	private JTable tbl_Contacto;
	private DefaultTableModel modelLocalidad;
	private  String[] nombreColumnas = {"#","Tipo de Contacto"};
	
	//TEXT FIELDS
	private JTextField txt_Descripcion;

	public ventanaContacto(Controlador controlador) 
	{
		super();
		this.Controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 817, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollBarContacto = new JScrollPane();
		scrollBarContacto.setBounds(10, 65, 464, 290);
		getContentPane().add(scrollBarContacto);
		
		modelLocalidad = new DefaultTableModel(null,nombreColumnas);
		tbl_Contacto = new JTable(modelLocalidad);
		
		tbl_Contacto.getColumnModel().getColumn(0).setPreferredWidth(10);
		tbl_Contacto.getColumnModel().getColumn(0).setResizable(false);
		tbl_Contacto.getColumnModel().getColumn(1).setPreferredWidth(100);
		tbl_Contacto.getColumnModel().getColumn(1).setResizable(false);
		
		scrollBarContacto.setViewportView(tbl_Contacto);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(373, 528, 89, 23);
		btnAgregar.addActionListener(this.Controlador);
		getContentPane().setLayout(null);
		getContentPane().add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(274, 528, 89, 23);
		btnEditar.addActionListener(this.Controlador);
		getContentPane().setLayout(null);
		getContentPane().add(btnEditar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 464, 2);
		getContentPane().add(separator);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto.setFont(lblContacto.getFont().deriveFont(lblContacto.getFont().getSize() + 8f));
		lblContacto.setBounds(10, 11, 464, 30);
		getContentPane().add(lblContacto);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 400, 464, 2);
		getContentPane().add(separator_1);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 407, 89, 23);
		getContentPane().add(lblDescripcion);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 512, 464, 2);
		getContentPane().add(separator_2);
		
		txt_Descripcion = new JTextField();
		txt_Descripcion.setBounds(20, 441, 170, 20);
		getContentPane().add(txt_Descripcion);
		txt_Descripcion.setColumns(10);
		
		JLabel lblParaRealizarUna = new JLabel("[ Para realizar una edicion seleccione primero un campo de la tabla y cargar los campos ]");
		lblParaRealizarUna.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaRealizarUna.setForeground(new Color(0, 0, 139));
		lblParaRealizarUna.setBounds(10, 497, 464, 14);
		getContentPane().add(lblParaRealizarUna);
		
		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(373, 366, 89, 23);
		btnCargar.addActionListener(this.Controlador);
		getContentPane().setLayout(null);
		getContentPane().add(btnCargar);
		
		this.setVisible(true);
	}
	
	public void cargarTextBox(ContactoDTO contactoSeleccionada)
	{
		txt_Descripcion.setText(contactoSeleccionada.getDescripcion());		
	}
	public void limpiarTextBox()
	{
		txt_Descripcion.setText("");
	}
	
	//Getters
	public JButton getBtnAgregar()
	{
		return this.btnAgregar;
	}
	public JButton getBtnEditar()
	{
		return this.btnEditar;
	}
	public JButton getBtnCargar()
	{
		return this.btnCargar;
	}
	public JTextField getDescripcion()
	{
		return this.txt_Descripcion;
	}
	public JTable getTablaLocalidades()
	{
		return this.tbl_Contacto;
	}
	public DefaultTableModel getTablaModel()
	{
		return this.modelLocalidad;
	}
	public String[] getNombreColumnas() {
		return this.nombreColumnas;
	}
}
