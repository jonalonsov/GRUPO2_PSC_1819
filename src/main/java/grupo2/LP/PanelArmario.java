package grupo2.LP;



import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.GestorPrendas;
import grupo2.LN.GestorUsuario;
import grupo2.LN.Prenda;
import grupo2.LN.Complemento;
import grupo2.LN.Conjunto;
import grupo2.LN.GestorComplemento;
import grupo2.LN.GestorConjuntos;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;

public class PanelArmario extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	JTabbedPane panelPestaña = new JTabbedPane ();
	    
	    private JButton Añadir;
	    private JButton AñadirC;
	    private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	private JLabel lblLabelImagen;
	private JTable table_1;
	private JTable table_2;
	private JTable tableConj;
	private JTable tablePropu;
	private JTextPane texto2;
	private JPanel complemento;
	private JPanel armario;
	private JPanel conjunto;
	private JPanel propuestas;
	private  JTextPane txtpnHj;
	private  JTextPane txtPropu;
	private JScrollPane scroll;
	private InsertarPrenda objpanePanel;
	private CalendarProgram objCalendar;
	private PanelMenu objPanelMenu;
	
	private GestorPrendas gprendas;
	private GestorComplemento gcomplementos;
	private  String[] dato;
	private  String[] datoC;
	private  String[] datoConj;
	private  String[] datoPropu;
	private JTextPane txtpnEstosSonTus;
	private JButton btnMarcarFavorito;
	private JButton btnMarcarFavoritoA;
	private JScrollPane scrollC;
	private JScrollPane scrollConj;
	private JScrollPane scrollPropu;
	private int indice1;
	private int indice2;
	private int indice3;
	private int indice4;
	private JButton CrearC;
	
	private Conjunto objconjunto;
	private GestorConjuntos gconjuntos;
	private GestorUsuario gusuarios;
	private  JButton btnAadirFecha;
		
	public PanelArmario() throws SQLException{
		
	gprendas = new GestorPrendas();
	gcomplementos = new GestorComplemento();
	gconjuntos = new GestorConjuntos();
		
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
				panelPestaña.setBounds(0, 80, 450, 450);
				panelPestaña.setVisible(true);
				panelPestaña.setPreferredSize( new Dimension( 450,  450 ) );
				getContentPane().add(panelPestaña);
			

   //TABLA COMPLEMENTOS
		//Aqui se muestra la Pestaña de los Complementos, con sus caracteristicas principales
			complemento = new JPanel ();
			panelPestaña.addTab("Complementos",null,complemento, "Complemento");
	        complemento.setLayout(null);
            
	                                    
	        texto2 = new JTextPane();
	        texto2.setForeground(SystemColor.desktop);
	        texto2.setBackground(Color.lightGray);
	        texto2.setFont(new Font("MS Mincho", Font.ITALIC, 23));
	        texto2.setText("¡TUS COMPLEMENTOS!");
	        texto2.setBounds(56, 11, 334, 33);
	        complemento.add(texto2);
	        
	                               
     		AñadirC = new JButton("Añadir complemento");
     		complemento.add(AñadirC);
     		AñadirC.setForeground(Color.BLACK);             	
     		AñadirC.setAlignmentY(Component.CENTER_ALIGNMENT);
     		AñadirC.setAlignmentX(Component.CENTER_ALIGNMENT);
     		AñadirC.setSize(201, 29);
     		AñadirC.setLocation(234, 370);
     		AñadirC.setFont(new Font("Century Gothic", Font.BOLD, 14));
     		AñadirC.addActionListener(this);
     		AñadirC.setActionCommand("AñadirC");
    		
    		table_2 = new JTable();
       		table_2.setEnabled(true);
    		
    		scrollC = new JScrollPane(table_2);
    		scrollC.setBounds(24, 64, 397, 297);
    		complemento.add(scrollC);
          
            DefaultTableModel modelC= new DefaultTableModel();
            modelC.addColumn("Id");
            modelC.addColumn("Color");
            modelC.addColumn("Nombre");
            
			
            Complemento objcomplemento;
		       
            for (int i = 0; i < gcomplementos.selectComplementos().length; i++){
            	datoC = new String[75];
            	objcomplemento = gcomplementos.selectComplementos()[i];
            	
            	datoC[0]=Integer.toString(objcomplemento.getId());
            	datoC[1]=objcomplemento.getNombre();
            	datoC[2]=objcomplemento.getColor();
            	modelC.addRow(datoC);
            }
            
            
            table_2.setCellSelectionEnabled(true);
            ListSelectionModel cellSelectionModel2 = table_2.getSelectionModel();
            cellSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                                    
            table_2.setModel(modelC);
            
            cellSelectionModel2.addListSelectionListener(new ListSelectionListener() {
      		  public void valueChanged(ListSelectionEvent e) {
      		        String selectedDataID1 = null;
      	
      		        int selectedRow1 = table_2.getSelectedRow();
      		       	  selectedDataID1 = (String) table_2.getValueAt(selectedRow1,0);
      		       	indice2=Integer.parseInt(selectedDataID1);
      		      log.trace("Id seleecionado: "+ indice2); 
      		        
      	       		      		        
      		 //<--GOR--> ESTO NO SE DEBERÍA PONER AQUÍ, LD                     
                      String sql="SELECT imagen FROM COMPLEMENTO1 WHERE id = '"+ selectedDataID1 + "'";
                     // System.out.println(sql);		
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
      				//System.out.println(imagePath);
      				//ImageIcon imagen = new ImageIcon(imagePath).getScaledInstance(lblLabelImagen.getWidth(), lblLabelImagen.getHeight(),imagen.SCALE_SMOOTH);
      				ImageIcon imagenIcono = new ImageIcon(imagePath);
      				Image imagen = imagenIcono.getImage(); // transform it 
      				Image newimg = imagen.getScaledInstance(lblLabelImagen.getWidth(), lblLabelImagen.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      				ImageIcon nuevo = new ImageIcon(newimg); 
      				lblLabelImagen.setIcon(nuevo);		        
      		     }
            });
			
  //TABLA PRENDAS          
		//PestañaArmario
		armario = new JPanel ();
		panelPestaña.addTab("Prendas",null,armario, "Armario");
		 armario.setLayout(null);

		
			  
		  txtpnHj = new JTextPane();
		  txtpnHj.setForeground(SystemColor.desktop);
		  txtpnHj.setBackground(Color.lightGray);
		  txtpnHj.setFont(new Font("MS Mincho", Font.ITALIC, 23));
		  txtpnHj.setText("¡Ya estas entu armario!");
		  txtpnHj.setBounds(56, 11, 334, 33);
		  armario.add(txtpnHj);
			  

			       
   		 Añadir = new JButton("Añadir una nueva prenda");
   		 armario.add(Añadir);
   		 Añadir.setForeground(Color.BLACK);
   		
   		 Añadir.setAlignmentY(Component.CENTER_ALIGNMENT);
   		 Añadir.setAlignmentX(Component.CENTER_ALIGNMENT);
   		 Añadir.setSize(237, 29);
   		 Añadir.setLocation(198, 366);
   		 Añadir.setFont(new Font("Century Gothic", Font.BOLD, 14));
   		 //        BSalir.setBounds(100, 103, 150, 30);
   		 Añadir.addActionListener(this);
   		 //  PanelCentro.setLayout(null);
   		   Añadir.setActionCommand("Añadir");
			       	
		
   		   
                //Aqui se muestra la pestaña sobre las prendas que contiene el armario; sus carateristicas principales.  
	            table_1 = new JTable();
	       		table_1.setEnabled(true);

	       		//El label en el que meteremos la imagen de la prenda
	       		//<--GOE-->SE DEBERÍA CAMBIAR EL TAMAÑO Y UBICACIÓN
	       		lblLabelImagen = new JLabel("");
	       		lblLabelImagen.setBounds(458, 196, 270, 263);
	       		getContentPane().add(lblLabelImagen);
	       	
	       		
	       		//Cargamos la tabla con los datos de la BD de prendas
                DefaultTableModel model= new DefaultTableModel();
                model.addColumn("Id");
                model.addColumn("Tipo");
                model.addColumn("Color");
                model.addColumn("Tejido");   
            	
	       		scroll = new JScrollPane (table_1);
	       		scroll.setBounds(25, 58, 397, 297);
	       		armario.add(scroll);

	       		
	       		Prenda objPrenda;

	       		for (int i = 0; i < gprendas.selectPrendas().length; i++){
                	dato = new String[75];
                	objPrenda= gprendas.selectPrendas()[i];
                	
                	dato[0]=Integer.toString(objPrenda.getId());
                	dato[1]=objPrenda.getNombre();
                	dato[2]=objPrenda.getColor();
                	dato[3]=objPrenda.getTejido();
                
                	model.addRow(dato);
 
                }
	               
                
                table_1.setCellSelectionEnabled(true);
                ListSelectionModel cellSelectionModel1 = table_1.getSelectionModel();
                cellSelectionModel1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
                table_1.setModel(model);
                
                JButton btnEliminarPrenda = new JButton("Eliminar prenda");
                btnEliminarPrenda.setForeground(Color.BLACK);
                btnEliminarPrenda.setFont(new Font("Century Gothic", Font.BOLD, 14));
                btnEliminarPrenda.setAlignmentY(0.5f);
                btnEliminarPrenda.setAlignmentX(0.5f);
                btnEliminarPrenda.setActionCommand("EliminarP");
                btnEliminarPrenda.addActionListener(this);
                btnEliminarPrenda.setBounds(10, 366, 178, 29);
                armario.add(btnEliminarPrenda);
		
	cellSelectionModel1.addListSelectionListener(new ListSelectionListener() {
		  public void valueChanged(ListSelectionEvent e) {
		        String selectedDataID = null;
	
		        int selectedRow = table_1.getSelectedRow();
		  
			      
		            selectedDataID = (String) table_1.getValueAt(selectedRow,0);
		            indice1=Integer.parseInt(selectedDataID);
		           
		        
		            log.trace("Id seleecionado: "+ indice1); 
		        
	       		
		        
		 //<--GOR--> ESTO NO SE DEBERÍA PONER AQUÍ, LD                     
                String sql="SELECT imagen FROM PRENDA WHERE id = '"+ selectedDataID + "'";
               // System.out.println(sql);		
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
				//System.out.println(imagePath);
				//ImageIcon imagen = new ImageIcon(imagePath).getScaledInstance(lblLabelImagen.getWidth(), lblLabelImagen.getHeight(),imagen.SCALE_SMOOTH);
				ImageIcon imagenIcono = new ImageIcon(imagePath);
				Image imagen = imagenIcono.getImage(); // transform it 
				Image newimg = imagen.getScaledInstance(lblLabelImagen.getWidth(), lblLabelImagen.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				ImageIcon nuevo = new ImageIcon(newimg); 
				lblLabelImagen.setIcon(nuevo);		        
		      }
		 });
	
	//Panel conjuntos
		conjunto = new JPanel ();
		panelPestaña.addTab("Conjuntos",null,conjunto, "Conjunto");
		conjunto.setLayout(null);
		
		txtpnEstosSonTus = new JTextPane();
		txtpnEstosSonTus.setBounds(56, 11, 230, 36);
		txtpnEstosSonTus.setText("¡TUS CONJUNTOS! ");
		txtpnEstosSonTus.setForeground(SystemColor.desktop);
		txtpnEstosSonTus.setFont(new Font("MS Mincho", Font.ITALIC, 23));
		txtpnEstosSonTus.setBackground(Color.LIGHT_GRAY);
		conjunto.add(txtpnEstosSonTus);
		
		 
		
 		complemento.add(AñadirC);
 		
 		JButton btnEliminarComplemento = new JButton("Eliminar complemento");
 		btnEliminarComplemento.setForeground(Color.BLACK);
 		btnEliminarComplemento.setFont(new Font("Century Gothic", Font.BOLD, 14));
 		btnEliminarComplemento.setAlignmentY(0.5f);
 		btnEliminarComplemento.setAlignmentX(0.5f);
 		btnEliminarComplemento.setActionCommand("EliminarC");
 		btnEliminarComplemento.addActionListener(this);
 		btnEliminarComplemento.setBounds(24, 370, 201, 29);
 		complemento.add(btnEliminarComplemento);
 		       	
 		 		
		btnMarcarFavorito = new JButton("Marcar Favorito");
		btnMarcarFavorito.setBounds(298, 5, 137, 23);
		btnMarcarFavorito.setForeground(Color.BLACK);
		btnMarcarFavorito.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnMarcarFavorito.setAlignmentY(0.5f);
		btnMarcarFavorito.setAlignmentX(0.5f);
		btnMarcarFavorito.addActionListener(this);
		btnMarcarFavorito.setActionCommand("Favorito");
		conjunto.add(btnMarcarFavorito);
		
		 tableConj = new JTable();
		 tableConj.setEnabled(true);
		
		//Cargamos la tabla con los datos de la BD de prendas
        DefaultTableModel model3= new DefaultTableModel();
        model3.addColumn("Id");
        model3.addColumn("Prenda 1");
        model3.addColumn("Prenda 2");
        model3.addColumn("Favorito");   
		
		CrearC = new JButton("Crear Conjunto Aleatorio");
		CrearC.setForeground(Color.BLACK);
		CrearC.setFont(new Font("Century Gothic", Font.BOLD, 14));
		CrearC.setAlignmentY(0.5f);
		CrearC.setAlignmentX(0.5f);
		CrearC.addActionListener(this);
		CrearC.setActionCommand("CrearC");
		CrearC.setBounds(21, 364, 201, 27);
		conjunto.add(CrearC);
        
		
		scrollConj = new JScrollPane(tableConj);
		scrollConj.setBounds(23, 52, 397, 297);
		conjunto.add(scrollConj);
		
		Conjunto objconjunto;
		String mensaje;
   		for (int i = 0; i < gconjuntos.selectConjuntos().length; i++){
        	datoConj = new String[75];
        	objconjunto= gconjuntos.selectConjuntos()[i];
        	if (objconjunto.getFavorito()==0) {
        		mensaje ="NO";
        	} else mensaje ="SI";
        	datoConj[0]=Integer.toString(objconjunto.getId());
        	datoConj[1]=gprendas.nombrePrendaconID(objconjunto.getPrenda1());
        	datoConj[2]=gprendas.nombrePrendaconID(objconjunto.getPrenda2());
        	datoConj[3]=mensaje;
        
        	model3.addRow(datoConj);

        }
       
           
   		 tableConj.setCellSelectionEnabled(true);
	     ListSelectionModel cellSelectionModel4 = tableConj.getSelectionModel();
	     cellSelectionModel4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        
        tableConj.setModel(model3);
        
        btnAadirFecha = new JButton("Añadir al calendario");
        btnAadirFecha.setFont(new Font("Century Gothic", Font.BOLD, 10));
        btnAadirFecha.setBounds(296, 28, 137, 23);
        btnAadirFecha.addActionListener(this);
        btnAadirFecha.setActionCommand("AñadirFecha");
        conjunto.add(btnAadirFecha);
        
        JButton btnBorrarConjunto = new JButton("Eliminar Conjunto");
        btnBorrarConjunto.setForeground(Color.BLACK);
        btnBorrarConjunto.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnBorrarConjunto.setAlignmentY(0.5f);
        btnBorrarConjunto.setAlignmentX(0.5f);
        btnBorrarConjunto.setActionCommand("EliminarConj");
        btnBorrarConjunto.addActionListener(this);
        btnBorrarConjunto.setBounds(232, 364, 201, 27);
        conjunto.add(btnBorrarConjunto);
        
        cellSelectionModel4.addListSelectionListener(new ListSelectionListener() {
    		  public void valueChanged(ListSelectionEvent e1) {
    		        String selectedDataID3 = null;
    	

    		      int selectedRow3 = tableConj.getSelectedRow();

		            selectedDataID3 = (String) tableConj.getValueAt(selectedRow3,0);
		            indice3=Integer.parseInt(selectedDataID3);
		            
		            log.trace("Id seleecionado: "+ indice3); 
		            
		            
		            
		      /*      //<--GOR--> ESTO NO SE DEBERÍA PONER AQUÍ, LD                     
	                String sql="SELECT imagen FROM CONJUNTO WHERE id = '"+ indice3 + "'";
	                System.out.println(sql);		
	                Statement st2=BaseDeDatos.getStatement();
	                ResultSet result2 = null;
	                
	                
					try {
						result2 = st2.executeQuery(sql);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
	                String imagePath = null;
					try {
						imagePath = result2.getString(1);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println(imagePath);
					//ImageIcon imagen = new ImageIcon(imagePath).getScaledInstance(lblLabelImagen.getWidth(), lblLabelImagen.getHeight(),imagen.SCALE_SMOOTH);
					ImageIcon imagenIcono = new ImageIcon(imagePath);
					Image imagen = imagenIcono.getImage(); // transform it 
					Image newimg = imagen.getScaledInstance(lblLabelImagen.getWidth(), lblLabelImagen.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					ImageIcon nuevo = new ImageIcon(newimg); 
					lblLabelImagen.setIcon(nuevo);	*/
    		 }
    		  
        });	
        
      //Panel propuestas
      		propuestas = new JPanel ();
      		panelPestaña.addTab("Propuestas",null,propuestas, "Propuestas");
      		propuestas.setLayout(null);
      		
      		txtPropu = new JTextPane();
     		txtPropu.setForeground(SystemColor.desktop);
     		txtPropu.setBackground(Color.lightGray);
     		txtPropu.setFont(new Font("MS Mincho", Font.ITALIC, 23));
     		txtPropu.setText("¡Las propuestas!");
     		txtPropu.setBounds(56, 11, 230, 36);
    		propuestas.add(txtPropu);
    		
    		      		    		
    		//propuestas.add(AñadirC);
		     	
    		btnMarcarFavoritoA = new JButton("Marcar Favorito");
    		btnMarcarFavoritoA.setBounds(315, 14, 120, 27);
    		btnMarcarFavoritoA.setForeground(Color.BLACK);
    		btnMarcarFavoritoA.setFont(new Font("Century Gothic", Font.BOLD, 10));
    		btnMarcarFavoritoA.setAlignmentY(0.5f);
    		btnMarcarFavoritoA.setAlignmentX(0.5f);
    		btnMarcarFavoritoA.addActionListener(this);
    		btnMarcarFavoritoA.setActionCommand("FavoritoA");
    		propuestas.add(btnMarcarFavoritoA);
    		
    		 tablePropu = new JTable();
    		 tablePropu.setEnabled(true);
    		
    		//Cargamos la tabla con los datos de la BD de propuestas
            DefaultTableModel model4= new DefaultTableModel();
            model4.addColumn("Id");
            model4.addColumn("Prenda 1");
            model4.addColumn("Prenda 2");
            model4.addColumn("Favorito");   
    		
    		CrearC = new JButton("Crear Aleatorio");
    		CrearC.setForeground(Color.BLACK);
    		CrearC.setFont(new Font("Century Gothic", Font.BOLD, 14));
    		CrearC.setAlignmentY(0.5f);
    		CrearC.setAlignmentX(0.5f);
    		CrearC.addActionListener(this);
    		CrearC.setActionCommand("CrearC");
    		CrearC.setBounds(10, 364, 135, 27);
    		propuestas.add(CrearC);
            
    		
    		scrollPropu = new JScrollPane(tablePropu);
    		scrollPropu.setBounds(23, 52, 397, 297);
    		propuestas.add(scrollPropu);
    		
    		//Conjunto objconjunto;
    		//String mensaje;
       		for (int i = 0; i < gconjuntos.selectPropuestas().length; i++){
            	datoPropu = new String[75];
            	objconjunto= gconjuntos.selectPropuestas()[i];
            	if (objconjunto.getFavorito()==0) {
            		mensaje ="NO";
            	} else mensaje ="SI";
            	datoPropu[0]=Integer.toString(objconjunto.getId());
            	datoPropu[1]=gprendas.nombrePrendaconID(objconjunto.getPrenda1());
            	datoPropu[2]=gprendas.nombrePrendaconID(objconjunto.getPrenda2());
            	datoPropu[3]=mensaje;
            
            	model4.addRow(datoPropu);

            }
           
               
       		 tablePropu.setCellSelectionEnabled(true);
    	     ListSelectionModel cellSelectionModel5 = tablePropu.getSelectionModel();
    	     cellSelectionModel5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	        
    	     tablePropu.setModel(model4);
    	     
    	     JButton btnEliminarPropuesta = new JButton("Eliminar");
    	     btnEliminarPropuesta.setForeground(Color.BLACK);
    	     btnEliminarPropuesta.setFont(new Font("Century Gothic", Font.BOLD, 14));
    	     btnEliminarPropuesta.setAlignmentY(0.5f);
    	     btnEliminarPropuesta.setAlignmentX(0.5f);
    	     btnEliminarPropuesta.setActionCommand("EliminarPropu");
    	     btnEliminarPropuesta.addActionListener(this);
    	     btnEliminarPropuesta.setBounds(155, 364, 120, 27);
    	     propuestas.add(btnEliminarPropuesta);
    	     
    	     JButton btnMarcarConjunto = new JButton("Marcar Conjunto");
    	     btnMarcarConjunto.setForeground(Color.BLACK);
    	     btnMarcarConjunto.setFont(new Font("Century Gothic", Font.BOLD, 14));
    	     btnMarcarConjunto.setAlignmentY(0.5f);
    	     btnMarcarConjunto.setAlignmentX(0.5f);
    	     btnMarcarConjunto.setActionCommand("MarcarConj");
    	     btnMarcarConjunto.addActionListener(this);
    	     btnMarcarConjunto.setBounds(285, 364, 135, 27);
    	     propuestas.add(btnMarcarConjunto);
            
            cellSelectionModel5.addListSelectionListener(new ListSelectionListener() {
      		  public void valueChanged(ListSelectionEvent e2) {
      		        String selectedDataID4 = null;
      	

      		      int selectedRow4 = tablePropu.getSelectedRow();

  		            selectedDataID4 = (String) tablePropu.getValueAt(selectedRow4,0);
  		            indice4=Integer.parseInt(selectedDataID4);
  		            
  		          log.trace("Id seleecionado: "+ indice4); 
    
   
      		  }
      	});	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		  
		switch (e.getActionCommand()){
		  case "Favorito":
	        	gconjuntos.modifFavConjunto(indice3);
				JOptionPane.showMessageDialog( null, "Ha marcado como favorito este conjunto. ", null, JOptionPane.INFORMATION_MESSAGE);
				
			PanelArmario objPanelArmario = null;
			try {
				dispose();
				objPanelArmario = new PanelArmario();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				objPanelArmario.setVisible(true);
	            
	                                
	                    
	        break;  
		  case "FavoritoA":
	        	gconjuntos.modifFavAleatorio(indice4);
				JOptionPane.showMessageDialog( null, "Ha marcado como favorito este conjunto. ", null, JOptionPane.INFORMATION_MESSAGE);
			
				PanelArmario objPanelArmario1 = null;
				try {
					dispose();
					objPanelArmario1 = new PanelArmario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					objPanelArmario1.setVisible(true);
		            
			                       
	                    
	        break;   

	        case "Añadir":
	        	
	        	objpanePanel = new InsertarPrenda();
	        	objpanePanel.setVisible(true);
	            
	                                
	                    
	        break;
	        case "AñadirC":
	        	
	        	InsertarComplemento objpanePanelC = new InsertarComplemento();
	        	objpanePanelC.setVisible(true);
	        	
	            
	                                
	                    
	        break;
	        case "AñadirFecha":
	        	
	        	if(indice3==0) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar el conjunto para poder vincularlo a una fecha, clique un conjunto de la tabla","Correcto",JOptionPane.INFORMATION_MESSAGE);
	        	} else {	        	
		        	gconjuntos.anyadirConjuntoCalendario(indice3);
		        	
		        	objCalendar = new CalendarProgram();
					objCalendar.CrearCalendario();
	        	}
	        	
	        break;	        
	        case "CrearC":
	        	
	        	InsertarConjuntoAleatorio objpanePanelCA = new InsertarConjuntoAleatorio();
	        	objpanePanelCA.setVisible(true);
	        	dispose();
         
	        break;
	        case "EliminarC":
	        	
	        	gcomplementos.EliminarComplemento(indice2);
				JOptionPane.showMessageDialog( null, "Has eliminado el complemento del armario. ", null, JOptionPane.INFORMATION_MESSAGE);
				
			//PanelArmario objPanelArmario2 = null;
			try {
				dispose();
				objPanelArmario = new PanelArmario();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				//objPanelArmario2.setVisible(true);
	            
	                                
	                    
	        break;
	        case "EliminarP":
	        	
	        	gprendas.EliminarPrenda(indice1);
				JOptionPane.showMessageDialog( null, "Has eliminado la prenda del armario. ", null, JOptionPane.INFORMATION_MESSAGE);
				
			//PanelArmario objPanelArmario2 = null;
			try {
				dispose();
				objPanelArmario = new PanelArmario();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				//objPanelArmario2.setVisible(true);
	        	
	        	
	            
	                                
	                    
	        break;
	        case "EliminarConj":
	        	
	        	gconjuntos.EliminarConjunto(indice3);
				JOptionPane.showMessageDialog( null, "Has eliminado el conjunto del armario. ", null, JOptionPane.INFORMATION_MESSAGE);
				
			//PanelArmario objPanelArmario2 = null;
			try {
				dispose();
				objPanelArmario = new PanelArmario();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				//objPanelArmario2.setVisible(true);
	            
	                                
	                    
	        break;
	        case "EliminarPropu":
	        	
	        	gconjuntos.EliminarPropuesta(indice4);
				JOptionPane.showMessageDialog( null, "Has eliminado la propuesta del armario. ", null, JOptionPane.INFORMATION_MESSAGE);
				
			//PanelArmario objPanelArmario2 = null;
			try {
				dispose();
				objPanelArmario = new PanelArmario();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				//objPanelArmario2.setVisible(true);
	            
	                                
	                    
	        break;
	        case "MarcarConj":
	        	gconjuntos.modifConjAleatorio(indice4);
				JOptionPane.showMessageDialog( null, "Ha marcado como un conjunto de tu armario esta propuesta. ", null, JOptionPane.INFORMATION_MESSAGE);
			
				      
						PanelArmario objPanelArmario111 = null;
						try {
							dispose();
							objPanelArmario111 = new PanelArmario();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							objPanelArmario111.setVisible(true);
				            
			                       
	                    
	        break; 
	        case "Salir":
	        	dispose();

	            
	        break;	 
	        
	        case "X":
	        	objCalendar = null;
	        
	        	dispose();
	        	objPanelMenu = new PanelMenu();
	        	objPanelMenu.setVisible(true);
	            
	        break;	 
	       	
	}
 				
	}
}
