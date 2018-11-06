package grupo2.LP;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.GestorPrendas;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;
import javax.swing.JTabbedPane;

public class PanelArmario extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelCentro;
	JTabbedPane panelPestaña = new JTabbedPane ();
	    
	    private JButton Añadir;
	    private JButton AñadirC;
	    private JButton Salir;
	
	
	
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	private JTable table;
	private JPanel panel;
	private JLabel label;
	private JLabel lblLabelImagen;
	private  JTable table_1;
	
	
	
	//private Reloj reloj;
	
	public PanelArmario() throws SQLException{
		
		
		
		setTitle("Bienvenido a tu armario");
		setLocationRelativeTo( null );  // Centra la ventana en la pantalla
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setBounds(250, 50, 758, 600);
		
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
				getContentPane().setLayout(null);
		
		
		//PANEL SUPERIOR
				PanelSuperior = new JPanel();
				PanelSuperior.setBounds(0, 0, 740, 80);
				
				PanelSuperior.setPreferredSize( new Dimension( 50,  80 ) );
				PanelSuperior.setBackground(Color.GRAY);
									
				getContentPane().add(PanelSuperior);
				
				
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
				PanelInferior.setBounds(0, 512, 740, 50);
				
				PanelInferior.setPreferredSize( new Dimension( 50,  50 ) );
				PanelInferior.setBackground(Color.GRAY);
									
				getContentPane().add(PanelInferior);
				PanelInferior.add(informacion);
			//	PanelInferior.add(reloj);
				
			//PANEL izquierda
				panelPestaña.setBounds(0, 80, 434, 432);
				panelPestaña.setVisible(true);
				panelPestaña.setPreferredSize( new Dimension( 450,  450 ) );
				getContentPane().add(panelPestaña);
	                       // PanelCentro.setLayout(null);
	                        
	                        JButton Ver = new JButton("Ver la prenda seleccionada");
	                        Ver.setHorizontalAlignment(SwingConstants.TRAILING);
	                        Ver.setForeground(Color.BLACK);
	                        Ver.setFont(new Font("Century Gothic", Font.BOLD, 16));
	                        Ver.setAlignmentY(1.0f);
	                        Ver.setAlignmentX(1.0f);
	                        Ver.setActionCommand("Ver");
	                        Ver.setBounds(99, 67, 251, 29);
	                
	            //TABLA PRENDAS    
                //Aqui se muestra la pestaña sobre las prendas que contiene el armario; sus carateristicas principales. 
                
	            table_1 = new JTable();
	       		table_1.setEnabled(true);
	       		       		   
	       		
	       		   
	       		JScrollPane scroll = new JScrollPane (table_1);
	       		scroll.setEnabled(false);
	       		scroll.setBounds(22, 92, 397, 297);
	       		
	       		   
	       		lblLabelImagen = new JLabel("New label");
	       		lblLabelImagen.setBounds(446, 202, 282, 297);
	       		getContentPane().add(lblLabelImagen);
	       		   
//				       		lblLabelImagen.setIcon(new ImageIcon (alquilarCoche.class.getResource(c.getImagen())));	                
                String sql="SELECT * FROM PRENDA";
                		
                Statement st;
                DefaultTableModel model= new DefaultTableModel();
                model.addColumn("Id");
                model.addColumn("Tipo");
                model.addColumn("Color");
                model.addColumn("Tejido");
                String[] dato =new String[30];
                
               
                
                st=BaseDeDatos.getStatement();
                
                ResultSet result =st.executeQuery(sql);
                
                while(result.next()){
                	dato[0]=result.getString(1);
                	dato[1]=result.getString(2);
                	dato[2]=result.getString(3);
                	dato[3]=result.getString(4);
                	model.addRow(dato);
                }
	               
                table_1.setCellSelectionEnabled(true);
                ListSelectionModel cellSelectionModel = table_1.getSelectionModel();
                cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
                table_1.setModel (model);
				
				//Aqui se muestra la Pestaña de los Complementos, con sus caracteristicas principales
				JPanel complemento = new JPanel ();
				complemento.setLayout(null);
				JLabel l2 = new JLabel ("Complemento");
				l2.setBounds(182, 5,65,14);
				complemento.add(l2);
				panelPestaña.addTab("Complemento",null,complemento, "Complemento");
				getContentPane().add(panelPestaña);
			                        
				 Salir = new JButton("Atras");
	                Salir.setForeground(Color.BLACK);
	                Salir.setHorizontalAlignment(SwingConstants.TRAILING);
	                Salir.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	                Salir.setAlignmentX(Component.RIGHT_ALIGNMENT);
	                Salir.setSize(71, 29);
	                Salir.setLocation(320, 62);
	                Salir.setFont(new Font("Century Gothic", Font.BOLD, 16));
	                //        BSalir.setBounds(100, 103, 150, 30);
	                Salir.addActionListener(this);
	                       // PanelCentro.setLayout(null);   
	                                    
                     JTextPane texto2 = new JTextPane();
                     texto2.setForeground(SystemColor.desktop);
                     texto2.setFont(new Font("MS Mincho", Font.ITALIC, 26));
                     texto2.setText("¡Aqui estan tus complementos!");
                     texto2.setBounds(23, 24, 383, 33);
                     complemento.add(texto2);
                    //     PanelCentro.setLayout(null);
                         
             		 AñadirC = new JButton("Añadir un nuevo complemento");
             		 complemento.add(AñadirC);
             		AñadirC.setForeground(Color.BLACK);
             		AñadirC.setHorizontalAlignment(SwingConstants.TRAILING);
             		AñadirC.setAlignmentY(Component.BOTTOM_ALIGNMENT);
             		AñadirC.setAlignmentX(Component.RIGHT_ALIGNMENT);
             		AñadirC.setSize(277, 29);
             		AñadirC.setLocation(38, 62);
             		AñadirC.setFont(new Font("Century Gothic", Font.BOLD, 16));
             		 //        BSalir.setBounds(100, 103, 150, 30);
             		AñadirC.addActionListener(this);
             		 //  PanelCentro.setLayout(null);
             		AñadirC.setActionCommand("AñadirC");
                       Salir.setActionCommand("Salir");
               complemento.add(Salir);
           
               
              //tabla Complemento
	          String sqlC="SELECT * FROM COMPLEMENTO";	
               Statement stC;
               
               JTable tableC = new JTable();
               tableC.setEnabled(false);
               DefaultTableModel modelC= new DefaultTableModel();
               modelC.addColumn("color");
               modelC.addColumn("nombre");
               
               tableC.setModel (modelC);
               String[] datoC =new String[30];
               
               stC=BaseDeDatos.getStatement();
               
               ResultSet resultC =stC.executeQuery(sqlC);
               
               while(resultC.next()){
               	datoC[0]=resultC.getString(1);
               	datoC[1]=resultC.getString(2);
               	modelC.addRow(datoC);
               }
               JScrollPane scrollC = new JScrollPane (tableC);
               scrollC.setBounds(23, 104, 383, 285);
			complemento.add(scrollC);
			
			
			//panelPestaña.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			//PestañaArmario
			JPanel armario = new JPanel ();
			panelPestaña.addTab("Armario",null,armario, "Armario");
			
			 Salir = new JButton("Atras");
			 Salir.setForeground(Color.BLACK);
			 Salir.setHorizontalAlignment(SwingConstants.TRAILING);
			 Salir.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			 Salir.setAlignmentX(Component.RIGHT_ALIGNMENT);
			 Salir.setSize(100, 29);
			 Salir.setLocation(300, 43);
			 Salir.setFont(new Font("Century Gothic", Font.BOLD, 16));
			 //        BSalir.setBounds(100, 103, 150, 30);
			 Salir.addActionListener(this);
			 armario.setLayout(null);
			 armario.add(scroll);
			 // PanelCentro.add(Salir);
			  
			  JTextPane txtpnHj = new JTextPane();
			  txtpnHj.setForeground(SystemColor.desktop);
			  txtpnHj.setFont(new Font("MS Mincho", Font.ITALIC, 26));
			  txtpnHj.setText("¡Ya estas dentro de tu armario!");
			  txtpnHj.setBounds(10, 5, 409, 33);
			  armario.add(txtpnHj);
			  //     PanelCentro.setLayout(null);
			       
			       		 Añadir = new JButton("Añadir una nueva prenda");
			       		 armario.add(Añadir);
			       		 Añadir.setForeground(Color.BLACK);
			       		 Añadir.setHorizontalAlignment(SwingConstants.TRAILING);
			       		 Añadir.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			       		 Añadir.setAlignmentX(Component.RIGHT_ALIGNMENT);
			       		 Añadir.setSize(237, 29);
			       		 Añadir.setLocation(58, 43);
			       		 Añadir.setFont(new Font("Century Gothic", Font.BOLD, 16));
			       		 //        BSalir.setBounds(100, 103, 150, 30);
			       		 Añadir.addActionListener(this);
			       		 //  PanelCentro.setLayout(null);
			       		   Añadir.setActionCommand("Añadir");
			       		   Salir.setActionCommand("Salir");
			       		   armario.add(Salir);
			       		   
			       		  
			       	
          
	
		
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		  public void valueChanged(ListSelectionEvent e) {
		        String selectedDataID = null;
	
		        int selectedRow = table_1.getSelectedRow();
		  
	
		      
		            selectedDataID = (String) table_1.getValueAt(selectedRow,0);
		        
		        System.out.println("Selected: " + selectedDataID);
		        
	       		
		        
		                      
                String sql="SELECT imagen FROM PRENDA WHERE id = '"+ selectedDataID + "'";
                System.out.println(sql);		
                Statement st2=BaseDeDatos.getStatement();
                ResultSet result2 = null;
                
                
				try {
					result2 = st2.executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
                String imagePath = null;
				try {
					imagePath = result2.getString(1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(imagePath);
                lblLabelImagen.setIcon(new ImageIcon(imagePath));
          
		        
		        
		      }
		 });
	
	}
	  

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		  switch (e.getActionCommand()){
	        
		  case "Ver":
	        	
	        //	VerPrenda objpanePanel2 = new VerPrenda();
	        	//objpanePanel2.setVisible(true);
	            
	                                
	                    
	        break;
		  case "Complemento":
	        	
		        //	VerComplemento objpanePanel2 = new VerComplemento();
		        	//objpanePanel2.setVisible(true);
		            
		                                
		                    
		        break;
	        case "Añadir":
	        	
	        	InsertarPrenda objpanePanel = new InsertarPrenda();
	        	objpanePanel.setVisible(true);
	            
	                                
	                    
	        break;
	        case "AñadirC":
	        	
	        	InsertarComplemento objpanePanelC = new InsertarComplemento();
	        	objpanePanelC.setVisible(true);
	            
	                                
	                    
	        break;
	        case "Salir":
				JOptionPane.showMessageDialog( null, "¡Gracias por su visita, hasta pronto!" , "ADIOS", JOptionPane.INFORMATION_MESSAGE);

	        	dispose();
	            
	            
	            
	        break;
	       
	       	
		}
	}
}
