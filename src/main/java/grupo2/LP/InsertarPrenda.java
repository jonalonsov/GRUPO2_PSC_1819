package grupo2.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.GestorPrendas;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

public class InsertarPrenda extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelIzquierda;
	private JLabel textC;
	private JLabel textP;
	private JLabel textT;
		
	private JButton btnAcep;
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	private JComboBox<String> comboBoxN;
	private JComboBox<String> comboBoxC;
	private JComboBox<String> comboBoxT;
	private JButton btnSeleccionar;
	private File imagen;
	JFileChooser fc;
	
	private GestorPrendas gprenda; 
	private grupo2.LN.prenda prenda;
	
	
	
	//private Reloj reloj;
	
	public InsertarPrenda(){
		
		textC = new JLabel();
		textC.setText("Inserte el color de la prenda \r\n");
		textC.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textC.setBounds(94, 119, 250, 29);
		textC.setOpaque(false);
				
		textP = new JLabel();
		textP.setVerticalAlignment(SwingConstants.TOP);
		textP.setText("Inserte la prenda \r\n");
		textP.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textP.setBounds(94, 60, 231, 20);
				
		textT = new JLabel();
		textT.setVerticalAlignment(SwingConstants.TOP);
		textT.setText("Inserte el tejido de la prenda \r\n");
		textT.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textT.setBounds(94, 196, 231, 20);
			
		
		
		setTitle("Bienvenido a tu armario");
		setLocationRelativeTo( null );  // Centra la ventana en la pantalla
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setBounds(250, 50, 450, 600); 
		//PanelSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(new BorderLayout());
		
		M = new JTextArea();
		M.setText("M");
		M.setForeground(new Color(0, 0, 0));
		M.setFont(new Font("Century Gothic", Font.BOLD, 30));
		M.setEnabled(false);
		M.setBackground(Color.GRAY);
		
		M2 = new JTextArea();
		M2.setText("M");
		M2.setForeground(new Color(0, 0, 0));
		M2.setFont(new Font("Century Gothic", Font.BOLD, 30));
		M2.setEnabled(false);
		M2.setBackground(Color.GRAY);
		
		I = new JTextArea();
		I.setText("I");
		I.setForeground(new Color(0, 0, 0));
		I.setFont(new Font("Century Gothic", Font.BOLD, 30));
		I.setEnabled(false);
		I.setBackground(Color.GRAY);
		
		I2 = new JTextArea();
		I2.setText("I");
		I2.setForeground(new Color(0, 0, 0));
		I2.setFont(new Font("Century Gothic", Font.BOLD, 30));
		I2.setEnabled(false);
		I2.setBackground(Color.GRAY);
		
		R = new JTextArea();
		R.setText("R");
		R.setForeground(new Color(0, 0, 0));
		R.setFont(new Font("Century Gothic", Font.BOLD, 30));
		R.setEnabled(false);
		R.setBackground(Color.GRAY);
		
		R2 = new JTextArea();
		R2.setText("R");
		R2.setForeground(new Color(0, 0, 0));
		R2.setFont(new Font("Century Gothic", Font.BOLD, 30));
		R2.setEnabled(false);
		R2.setBackground(Color.GRAY);
		
		A = new JTextArea();
		A.setText("A");
		A.setForeground(new Color(0, 0, 0));
		A.setFont(new Font("Century Gothic", Font.BOLD, 30));
		A.setEnabled(false);
		A.setBackground(Color.GRAY);
		
		A2 = new JTextArea();
		A2.setText("A");
		A2.setForeground(new Color(0, 0, 0));
		A2.setFont(new Font("Century Gothic", Font.BOLD, 30));
		A2.setEnabled(false);
		A2.setBackground(Color.GRAY);
		
		O = new JTextArea();
		O.setText("O");
		O.setForeground(new Color(0, 0, 0));
		O.setFont(new Font("Century Gothic", Font.BOLD, 30));
		O.setEnabled(false);
		O.setBackground(Color.GRAY);
		
		informacion = new JTextArea();
		informacion.setText("       Jon Alonso, Leire Jauregi y Gorka Otermin");
		informacion.setForeground(new Color(0, 0, 0));
		informacion.setFont(new Font("Century Gothic", Font.BOLD, 12));
		informacion.setEnabled(false);
		informacion.setBackground(Color.GRAY);
		
		
		//PANEL SUPERIOR
				PanelSuperior = new JPanel();
				
				PanelSuperior.setPreferredSize( new Dimension( 50,  80 ) );
				PanelSuperior.setBackground(Color.GRAY);
									
				getContentPane().add(PanelSuperior, BorderLayout.NORTH);
				
				
				PanelSuperior.add(M);
				PanelSuperior.add(I);
				PanelSuperior.add(A);
				PanelSuperior.add(R);
				PanelSuperior.add(M2);
				PanelSuperior.add(A2);
				PanelSuperior.add(R2);
				PanelSuperior.add(I2);
				PanelSuperior.add(O);
				
				
				
				
				//PANEL INFERIOR
				PanelInferior = new JPanel();
				
				PanelInferior.setPreferredSize( new Dimension( 50,  50 ) );
				PanelInferior.setBackground(Color.GRAY);
									
				getContentPane().add(PanelInferior, BorderLayout.SOUTH);
				PanelInferior.add(informacion);
			//	PanelInferior.add(reloj);
				
			//PANEL izquierda
				PanelIzquierda = new JPanel();
				//PanelIzquierda.setSize(400, 432);
				
				PanelIzquierda.setPreferredSize( new Dimension( 450,  450 ) );
				PanelIzquierda.setBackground(SystemColor.WHITE);
									
				getContentPane().add(PanelIzquierda, BorderLayout.WEST);
						PanelIzquierda.setLayout(null);
				PanelIzquierda.add(textT);
				PanelIzquierda.add(textC);
				PanelIzquierda.add(textP);
				
				btnAcep = new JButton("Aceptar");
				btnAcep.setForeground(Color.BLACK);
				btnAcep.setAlignmentY(Component.CENTER_ALIGNMENT);
				btnAcep.setAlignmentX(Component.LEFT_ALIGNMENT);
				btnAcep.setSize(113, 31);
				btnAcep.setLocation(90, 345);
				btnAcep.setFont(new Font("Century Gothic", Font.BOLD, 16));
				//		BSalir.setBounds(100, 103, 150, 30);
				btnAcep.addActionListener(this);
						PanelIzquierda.setLayout(null);
						btnAcep.setActionCommand("Aceptar");
						PanelIzquierda.add(btnAcep);
						
				comboBoxN = new JComboBox<String>();
				comboBoxN.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione tipo prenda...", "Camisa", "Camiseta", "Pantalones", "Jersey"}));
				comboBoxN.setBounds(93, 88, 180, 22);
				PanelIzquierda.add(comboBoxN);
				
				comboBoxC = new JComboBox<String>();
				comboBoxC.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione color...", "Rojo", "Verde", "Azul", "Blanco", "Morado", "Negro", "Amarillo", "Gris", "Rosa", "Marrón"}));
				comboBoxC.setBounds(94, 161, 180, 22);
				PanelIzquierda.add(comboBoxC);
				
				comboBoxT = new JComboBox<String>();
				comboBoxT.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione tejido...", "Algodón", "Vaquero", "Lino", "Poliester", "Piel"}));
				comboBoxT.setBounds(94, 229, 180, 22);
				PanelIzquierda.add(comboBoxT);
				
				btnSeleccionar =new JButton("Seleccionar imagen...");    
				btnSeleccionar.addActionListener(this);
		        btnSeleccionar.setBounds(94, 289, 187, 23);
		        PanelIzquierda.add(btnSeleccionar);
				
		      //Creamos el objeto JFileChooser
				fc=new JFileChooser();					
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//no sale
		if (e.getSource() == btnSeleccionar){
						
			//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			int seleccion=fc.showSaveDialog(PanelIzquierda);
			 
			//Si el usuario, pincha en aceptar
			if(seleccion==JFileChooser.APPROVE_OPTION){
			 
			    //Seleccionamos el fichero
			 imagen =fc.getSelectedFile();
			 System.out.println(imagen.getAbsolutePath());
//			    try(FileWriter fw=new FileWriter(fichero)){
//			 
//			        //Escribimos el texto en el fichero
//			        fw.write(textArea.getText());
//			 
//			    } catch (IOException e1) {
//			        e1.printStackTrace();
//			    }
//			 
			}
			
		}
		
		if (e.getSource() == btnAcep){
	            
			String nombre = (String)comboBoxN.getSelectedItem();
			String color = (String)comboBoxC.getSelectedItem();
			String tejido = (String)comboBoxT.getSelectedItem();
			
			if(nombre.equals("Seleccione tipo prenda...") || color.equals("Seleccione color...") || tejido.equals("Seleccione tejido...") || imagen ==null){
				JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "CUIDADO",JOptionPane.INFORMATION_MESSAGE);
			} else {
								
					prenda = new grupo2.LN.prenda(0, nombre, color, tejido, imagen.getAbsolutePath());	
					

					gprenda = new GestorPrendas();
					
					boolean semaforo = gprenda.anyadirPrenda( BaseDeDatos.getStatement(), prenda);
							
					if(semaforo==true) {
						JOptionPane.showMessageDialog(null, "Prenda introducida con éxito","Correcto",JOptionPane.INFORMATION_MESSAGE);
							dispose();
					} else {
						JOptionPane.showMessageDialog(null, "La prenda no ha podido introducirse, vuelva a intentarlo. ","Incorrecto",JOptionPane.INFORMATION_MESSAGE);
					}
			} 				
		}
	}
}
