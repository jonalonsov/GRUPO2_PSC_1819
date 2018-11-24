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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.Conjunto;
import grupo2.LN.GestorComplemento;
import grupo2.LN.GestorConjuntos;
import grupo2.LN.GestorPrendas;
import grupo2.LN.GestorUsuario;
import grupo2.LN.Prenda;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;

public class InsertarConjuntoAleatorio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelIzquierda;
	private JLabel textP;
	private JLabel textT;
		
	
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	JFileChooser fc;
	
	private GestorPrendas gprendas;
	private grupo2.LN.Prenda prenda;
	private GestorUsuario gusuarios;
	private JButton btnEstilo;
	private JButton btnTiempo;
	private JButton btnAcep;
	
	private Conjunto objconjunto;
	private Prenda objprenda;
	private GestorConjuntos gconjuntos;
	
	private JRadioButton rdbtnLluvia;
	private JRadioButton rdbtnFrio;
	private JRadioButton rdbtnCalor;

	
	
	
	//private Reloj reloj;
	
	public InsertarConjuntoAleatorio(){
				
		textP = new JLabel();
		textP.setVerticalAlignment(SwingConstants.TOP);
		textP.setText("Elija el tiempo \r\n");
		textP.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textP.setBounds(94, 60, 231, 20);
				
		textT = new JLabel();
		textT.setVerticalAlignment(SwingConstants.TOP);
		textT.setText("Elija estilo");
		textT.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textT.setBounds(94, 174, 231, 20);
			
		
		
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
				PanelIzquierda.add(textP);
				
				btnAcep = new JButton("Crear conjunto sin filtros");
				btnAcep.setForeground(Color.BLACK);
				btnAcep.setAlignmentY(Component.CENTER_ALIGNMENT);
				btnAcep.setAlignmentX(Component.LEFT_ALIGNMENT);
				btnAcep.setSize(231, 31);
				btnAcep.setLocation(94, 328);
				btnAcep.setFont(new Font("Century Gothic", Font.BOLD, 16));
				//		BSalir.setBounds(100, 103, 150, 30);
				btnAcep.addActionListener(this);
						PanelIzquierda.setLayout(null);
						btnAcep.setActionCommand("Aceptar");
						PanelIzquierda.add(btnAcep);
		        
		        rdbtnLluvia = new JRadioButton("lluvia");
		        rdbtnLluvia.setBounds(94, 85, 69, 25);
		        PanelIzquierda.add(rdbtnLluvia);
		        
		        rdbtnFrio = new JRadioButton("frio");
		        rdbtnFrio.setBounds(179, 85, 69, 25);
		        PanelIzquierda.add(rdbtnFrio);
		        
		        rdbtnCalor = new JRadioButton("calor");
		        rdbtnCalor.setBounds(264, 85, 69, 25);
		        PanelIzquierda.add(rdbtnCalor);
		        
		        ButtonGroup group = new ButtonGroup();
		        group.add(rdbtnLluvia);
		        group.add(rdbtnFrio);
		        group.add(rdbtnCalor);
		        
		        rdbtnLluvia.addActionListener(this);
		        rdbtnFrio.addActionListener(this);
		        rdbtnCalor.addActionListener(this);
		        
		        
		        
		        btnTiempo = new JButton("Aplicar filtro de tiempo");
		        btnTiempo.addActionListener(this);
		        btnTiempo.setForeground(Color.BLACK);
		        btnTiempo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		        btnTiempo.setAlignmentY(0.5f);
		        btnTiempo.setAlignmentX(0.0f);
		        btnTiempo.setActionCommand("Tiempo");
		        btnTiempo.setBounds(90, 119, 243, 31);
		        PanelIzquierda.add(btnTiempo);
		        
		        JRadioButton rdbtnFormal = new JRadioButton("Formal");
		        rdbtnFormal.setBounds(94, 203, 69, 25);
		        PanelIzquierda.add(rdbtnFormal);
		        
		        JRadioButton rdbtnUrbano = new JRadioButton("Informal");
		        rdbtnUrbano.setBounds(179, 203, 69, 25);
		        PanelIzquierda.add(rdbtnUrbano);
		        
		        btnEstilo = new JButton("Aplicar filtro de estilo");
		        btnEstilo.setForeground(Color.BLACK);
		        btnEstilo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		        btnEstilo.setAlignmentY(0.5f);
		        btnEstilo.setAlignmentX(0.0f);
		        btnEstilo.setActionCommand("Estilo");
		        btnEstilo.setBounds(94, 237, 231, 31);
		        PanelIzquierda.add(btnEstilo);
		        
		        JLabel lblSiNoQuieres = new JLabel();
		        lblSiNoQuieres.setVerticalAlignment(SwingConstants.TOP);
		        lblSiNoQuieres.setText("Si no quieres ningún filtro...");
		        lblSiNoQuieres.setFont(new Font("Century Gothic", Font.BOLD, 12));
		        lblSiNoQuieres.setBounds(94, 295, 231, 20);
		        PanelIzquierda.add(lblSiNoQuieres);
		        
		        JLabel lblElegirUnaDe = new JLabel();
		        lblElegirUnaDe.setVerticalAlignment(SwingConstants.TOP);
		        lblElegirUnaDe.setText("ELEGIR UNA DE LAS TRES OPCIONES");
		        lblElegirUnaDe.setFont(new Font("Century Gothic", Font.BOLD, 12));
		        lblElegirUnaDe.setBounds(94, 13, 231, 20);
		        PanelIzquierda.add(lblElegirUnaDe);
				
		      //Creamos el objeto JFileChooser
				fc=new JFileChooser();					
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnAcep){
			//aleatorio
			
			gusuarios = new GestorUsuario();
        	gprendas = new GestorPrendas();
        	gconjuntos = new GestorConjuntos();
        
        	int a1= gconjuntos.crearAleatorio1();
        	int a2 = gconjuntos.crearAleatorio2();

        	gestionar(a1, a2);
			
			dispose();
		}
		
		if (e.getSource() == btnEstilo){
			//filtro estilo
		}
		
		if (e.getSource() == btnTiempo){
			
			if (rdbtnLluvia.isSelected() ){
				
				gusuarios = new GestorUsuario();
	        	gprendas = new GestorPrendas();
	        	gconjuntos = new GestorConjuntos();
	        
	        	int a1= gconjuntos.crearLluvia1();
	        	int a2 = gconjuntos.crearLluvia2();
	        	
	        	gestionar(a1, a2);
				
				dispose();
				
			}
			
			if (rdbtnCalor.isSelected() ){
				
			}
			
			if (rdbtnFrio.isSelected() ){
				
			}
			
//			group.add(rdbtnLluvia);
//	        group.add(rdbtnFrio);
//	        group.add(rdbtnCalor);
		}
	}
	
	
	
	
	
	
	
	
	public void gestionar(int a1, int a2){
		
		
		boolean semaforo = false;
    	
		gusuarios = new GestorUsuario();
		System.out.println(gusuarios.nombreUsuario());	
			
			if(a1 != 0 && a2 != 0){
		
			objconjunto = new Conjunto(0, a1, a2,  gusuarios.nombreUsuario(), 0);	
			
			gconjuntos = new GestorConjuntos();
			
			semaforo = gconjuntos.anyadirConjuntoA(objconjunto);
			}		
			if(semaforo==true) {
				JOptionPane.showMessageDialog(null, "Conjunto aleatorio introducida con éxito","Correcto",JOptionPane.INFORMATION_MESSAGE);
					dispose();
			} else {
				JOptionPane.showMessageDialog(null, "El conjunto no ha podido introducirse, vuelva a intentarlo. ","Incorrecto",JOptionPane.ERROR_MESSAGE);
		
	}
			
	PanelArmario objPanelArmario11 = null;
	try {
		dispose();
		objPanelArmario11 = new PanelArmario();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		objPanelArmario11.setVisible(true);
		
		
		
	}
}
