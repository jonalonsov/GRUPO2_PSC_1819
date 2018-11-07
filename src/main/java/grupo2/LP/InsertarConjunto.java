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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.Conjunto;
import grupo2.LN.GestorComplemento;
import grupo2.LN.GestorConjuntos;
import grupo2.LN.GestorPrendas;
import grupo2.LN.GestorUsuario;
import grupo2.LN.Prenda;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InsertarConjunto extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelIzquierda;
	private JLabel textC;
	private JLabel textP;
		
	private JButton btnAcep;
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	private File imagen;
	JFileChooser fc;
	
	private GestorPrendas gprenda; 
	private grupo2.LN.Prenda prenda;
	private GestorUsuario gusuarios;
	private JScrollPane scrollPrenda1;
	private JScrollPane scrollPrenda2;
	
	private GestorPrendas gprendas;
	private  String[] dato;
	private  String[] datop2;
	private  JTable tablep1;
	private  JTable tablep2;
	private int indice1;
	private int indice2;
	private Conjunto objconjunto;
	private GestorConjuntos gconjunto;
	
	//private Reloj reloj;
	
	public InsertarConjunto(){
		gprendas = new GestorPrendas();
		
		textC = new JLabel();
		textC.setText("Seleccione la segunda prenda");
		textC.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textC.setBounds(10, 196, 250, 29);
		textC.setOpaque(false);
				
		textP = new JLabel();
		textP.setVerticalAlignment(SwingConstants.TOP);
		textP.setText("Seleccione la primera prenda");
		textP.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textP.setBounds(10, 11, 231, 20);
			
		
		
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
				PanelIzquierda.add(textC);
				PanelIzquierda.add(textP);
				
				btnAcep = new JButton("Aceptar");
				btnAcep.setForeground(Color.BLACK);
				btnAcep.setAlignmentY(Component.CENTER_ALIGNMENT);
				btnAcep.setAlignmentX(Component.LEFT_ALIGNMENT);
				btnAcep.setSize(113, 31);
				btnAcep.setLocation(304, 389);
				btnAcep.setFont(new Font("Century Gothic", Font.BOLD, 16));
				//		BSalir.setBounds(100, 103, 150, 30);
				btnAcep.addActionListener(this);
						PanelIzquierda.setLayout(null);
						btnAcep.setActionCommand("Aceptar");
						PanelIzquierda.add(btnAcep);
	
	//PRENDA 1
						  tablep1 = new JTable();
						  tablep1.setEnabled(true);
						
						 DefaultTableModel model1= new DefaultTableModel();
						 model1.addColumn("Id");
						 model1.addColumn("Tipo");
						 model1.addColumn("Color");
						 model1.addColumn("Tejido");   
			            	
			                
						scrollPrenda1 = new JScrollPane(tablep1);
						scrollPrenda1.setBounds(10, 29, 413, 156);
						PanelIzquierda.add(scrollPrenda1);
						
						Prenda objPrenda;

			       		for (int i = 0; i < gprendas.selectPrendas().length; i++){
		                	dato = new String[75];
		                	objPrenda= gprendas.selectPrendas()[i];
		                	
		                	dato[0]=Integer.toString(objPrenda.getId());
		                	dato[1]=objPrenda.getNombre();
		                	dato[2]=objPrenda.getColor();
		                	dato[3]=objPrenda.getTejido();
		                
		                	model1.addRow(dato);
		 
		                }
			       		
			       	 		         
			       	tablep1.setCellSelectionEnabled(true);
	                ListSelectionModel cellSelectionModel = tablep1.getSelectionModel();
	                cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	                
	                tablep1.setModel(model1);
	                
	              
	              //Aquí recoge el número de fila de la prenda seleccionada
	                cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	          		  public void valueChanged(ListSelectionEvent e) {
	          		        String selectedDataID = null;
	          	
	          		        int selectedRow = tablep1.getSelectedRow();
	      
	          		            selectedDataID = (String) tablep1.getValueAt(selectedRow,0);
	          		            indice1=Integer.parseInt(selectedDataID);
	          		        
	          		        System.out.println("Selected: " + indice1);
	          		        
	  	          		 }
	       		 });

	                
	
	//PRENDA 2
			       	 tablep2 = new JTable();
			       	tablep2.setEnabled(true);
					
					 DefaultTableModel model2= new DefaultTableModel();
					 model2.addColumn("Id");
					 model2.addColumn("Tipo");
					 model2.addColumn("Color");
					 model2.addColumn("Tejido");   
					 
					 
						scrollPrenda2 = new JScrollPane(tablep2);
						scrollPrenda2.setBounds(10, 220, 413, 156);
						PanelIzquierda.add(scrollPrenda2);
						
						Prenda objPrenda2;

			       		for (int i = 0; i < gprendas.selectPrendas().length; i++){
		                	datop2 = new String[75];
		                	objPrenda2= gprendas.selectPrendas()[i];
		                	
		                	datop2[0]=Integer.toString(objPrenda2.getId());
		                	datop2[1]=objPrenda2.getNombre();
		                	datop2[2]=objPrenda2.getColor();
		                	datop2[3]=objPrenda2.getTejido();
		                
		                	model2.addRow(datop2);
		 
		                }
			       		
			       		       		
			       		tablep2.setCellSelectionEnabled(true);
		                ListSelectionModel cellSelectionModel2 = tablep2.getSelectionModel();
		                cellSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		               
		                tablep2.setModel(model2);
		                
		              //Aquí recoge el número de fila de la prenda seleccionada
		                cellSelectionModel2.addListSelectionListener(new ListSelectionListener() {
		          		  public void valueChanged(ListSelectionEvent e) {
		          		        String selectedDataID = null;
		          	

		          		        
		          		      int selectedRow2 = tablep2.getSelectedRow();
		          		      
	        		            selectedDataID = (String) tablep1.getValueAt(selectedRow2,0);
	        		            indice2=Integer.parseInt(selectedDataID);
	        		            
	        		            System.out.println("Selected: " + indice2);
		          		 }
		       		 });

		                

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnAcep){
	            
			if(indice1==0 || indice2==0){
				JOptionPane.showMessageDialog(null, "Debe seleccionar dos prendas.", "CUIDADO",JOptionPane.INFORMATION_MESSAGE);
			} else {
					gusuarios = new GestorUsuario();
					System.out.println(gusuarios.nombreUsuario());			
					objconjunto = new Conjunto(0, indice1, indice2,  gusuarios.nombreUsuario(), 0);	
					

					gconjunto = new GestorConjuntos();
					
					
					boolean semaforo = gconjunto.anyadirConjunto( objconjunto);
							
					if(semaforo==true) {
						JOptionPane.showMessageDialog(null, "Conjunto introducida con éxito","Correcto",JOptionPane.INFORMATION_MESSAGE);
							dispose();
					} else {
						JOptionPane.showMessageDialog(null, "El conjunto no ha podido introducirse, vuelva a intentarlo. ","Incorrecto",JOptionPane.INFORMATION_MESSAGE);
					}
			} 				
		}
	}
}
