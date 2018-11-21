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
import java.util.Random;

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

public class PanelArmario extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JTable tableC;
	private JTable tablePropu;
	private JTextPane texto2;
	private JPanel complemento;
	private JPanel armario;
	private JPanel conjunto;
	private JPanel propuestas;
	private  JTextPane txtpnHj;
	private  JTextPane txtPropu;
	private JScrollPane scroll;
	
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
	private int indice3;
	private int indice4;
	private JButton CrearC;
	
	private Conjunto objconjunto;
	private Prenda objprenda;
	private GestorConjuntos gconjuntos;
	private GestorUsuario gusuarios;
		
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
			panelPestaña.addTab("Complemento",null,complemento, "Complemento");
	        complemento.setLayout(null);
            
	                                    
	        texto2 = new JTextPane();
	        texto2.setForeground(SystemColor.desktop);
	        texto2.setBackground(Color.lightGray);
	        texto2.setFont(new Font("MS Mincho", Font.ITALIC, 23));
	        texto2.setText("¡Aqui estan tus complementos!");
	        texto2.setBounds(52, 11, 324, 36);
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
      		         System.out.println("Selected: " + selectedDataID1);
      		        
      	       		      		        
      		 //<--GOR--> ESTO NO SE DEBERÍA PONER AQUÍ, LD                     
                      String sql="SELECT imagen FROM COMPLEMENTO1 WHERE id = '"+ selectedDataID1 + "'";
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
		panelPestaña.addTab("Armario",null,armario, "Armario");
		 armario.setLayout(null);

		
			  
		  txtpnHj = new JTextPane();
		  txtpnHj.setForeground(SystemColor.desktop);
		  txtpnHj.setBackground(Color.lightGray);
		  txtpnHj.setFont(new Font("MS Mincho", Font.ITALIC, 23));
		  txtpnHj.setText("¡Ya estas dentro de tu armario!");
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
	       		lblLabelImagen = new JLabel("Imagen prenda");
	       		lblLabelImagen.setBounds(458, 215, 270, 263);
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
		
	cellSelectionModel1.addListSelectionListener(new ListSelectionListener() {
		  public void valueChanged(ListSelectionEvent e) {
		        String selectedDataID = null;
	
		        int selectedRow = table_1.getSelectedRow();
		  
	
		      
		            selectedDataID = (String) table_1.getValueAt(selectedRow,0);
		        
		        System.out.println("Selected: " + selectedDataID);
		        
	       		
		        
		 //<--GOR--> ESTO NO SE DEBERÍA PONER AQUÍ, LD                     
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
		panelPestaña.addTab("Conjunto",null,conjunto, "Conjunto");
		conjunto.setLayout(null);
		
		txtpnEstosSonTus = new JTextPane();
		txtpnEstosSonTus.setBounds(91, 5, 263, 36);
		txtpnEstosSonTus.setText("Estos son tus conjuntos: ");
		txtpnEstosSonTus.setForeground(Color.BLACK);
		txtpnEstosSonTus.setFont(new Font("Dialog", Font.ITALIC, 23));
		txtpnEstosSonTus.setBackground(Color.LIGHT_GRAY);
		conjunto.add(txtpnEstosSonTus);
		
 		complemento.add(AñadirC);
 		       	
 		 		
		btnMarcarFavorito = new JButton("Marcar como favorito");
		btnMarcarFavorito.setBounds(250, 364, 185, 27);
		btnMarcarFavorito.setForeground(Color.BLACK);
		btnMarcarFavorito.setFont(new Font("Century Gothic", Font.BOLD, 14));
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
		CrearC.setBounds(10, 364, 230, 27);
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
        
        cellSelectionModel4.addListSelectionListener(new ListSelectionListener() {
    		  public void valueChanged(ListSelectionEvent e1) {
    		        String selectedDataID3 = null;
    	

    		      int selectedRow3 = tableConj.getSelectedRow();

		            selectedDataID3 = (String) tableConj.getValueAt(selectedRow3,0);
		            indice3=Integer.parseInt(selectedDataID3);
		            
		            System.out.println("Selected: " + indice3);
		            
		            
		            
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
     		txtPropu.setText("¡Estos son las propuestas en tu armario!");
     		txtPropu.setBounds(56, 11, 334, 33);
    		propuestas.add(txtPropu);
      		    		
    		//propuestas.add(AñadirC);
		     	
    		btnMarcarFavoritoA = new JButton("Marcar como favorito");
    		btnMarcarFavoritoA.setBounds(250, 364, 185, 27);
    		btnMarcarFavoritoA.setForeground(Color.BLACK);
    		btnMarcarFavoritoA.setFont(new Font("Century Gothic", Font.BOLD, 14));
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
    		
    		CrearC = new JButton("Crear Conjunto Aleatorio");
    		CrearC.setForeground(Color.BLACK);
    		CrearC.setFont(new Font("Century Gothic", Font.BOLD, 14));
    		CrearC.setAlignmentY(0.5f);
    		CrearC.setAlignmentX(0.5f);
    		CrearC.addActionListener(this);
    		CrearC.setActionCommand("CrearC");
    		CrearC.setBounds(10, 364, 230, 27);
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
            
            cellSelectionModel5.addListSelectionListener(new ListSelectionListener() {
      		  public void valueChanged(ListSelectionEvent e2) {
      		        String selectedDataID4 = null;
      	

      		      int selectedRow4 = tablePropu.getSelectedRow();

  		            selectedDataID4 = (String) tableConj.getValueAt(selectedRow4,0);
  		            indice4=Integer.parseInt(selectedDataID4);
  		            
  		            System.out.println("Selected: " + indice4);
    
   
      		  }
      	});	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		  int aleatorio1;
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
	        	gconjuntos.modifFavAleatorio(indice3);
				JOptionPane.showMessageDialog( null, "Ha marcado como favorito este conjunto. ", null, JOptionPane.INFORMATION_MESSAGE);
				
			                       
	                    
	        break;   

	        case "Añadir":
	        	
	        	InsertarPrenda objpanePanel = new InsertarPrenda();
	        	objpanePanel.setVisible(true);
	            
	                                
	                    
	        break;
	        case "AñadirC":
	        	
	        	InsertarComplemento objpanePanelC = new InsertarComplemento();
	        	objpanePanelC.setVisible(true);
	            
	                                
	                    
	        break;
	        
	        case "CrearC":
	        	gusuarios = new GestorUsuario();
	        	gprendas = new GestorPrendas();
	        
	        	int a1= gconjuntos.crearAleatorio1();
	        	int a2 = gconjuntos.crearAleatorio2();
	        	
	        	//if(a1!=0){
	        	//	if(a2!=0){
	        			gusuarios = new GestorUsuario();
						System.out.println(gusuarios.nombreUsuario());	
						
						
						objconjunto = new Conjunto(0, a1, a2,  gusuarios.nombreUsuario(), 0);	
						

						gconjuntos = new GestorConjuntos();
						
						
						boolean semaforo = gconjuntos.anyadirConjuntoA(objconjunto);
								
						if(semaforo==true) {
							JOptionPane.showMessageDialog(null, "Conjunto aleatorio introducida con éxito","Correcto",JOptionPane.INFORMATION_MESSAGE);
								dispose();
						} else {
							JOptionPane.showMessageDialog(null, "El conjunto no ha podido introducirse, vuelva a intentarlo. ","Incorrecto",JOptionPane.INFORMATION_MESSAGE);
						
		        	//}	    		
	        		//}
	        		
	        	}
	        /*	//gconjuntos.crearconjuntoA(a);
	        	
	        		
    				gusuarios = new GestorUsuario();
					System.out.println(gusuarios.nombreUsuario());	
					
					
				//	objconjunto = new Conjunto(0, aleatorio, aleatorio11,  gusuarios.nombreUsuario(), 0);	
					

					gconjuntos = new GestorConjuntos();
					
					
					boolean semaforo = gconjuntos.anyadirConjuntoA(objconjunto);
							
					if(semaforo==true) {
						JOptionPane.showMessageDialog(null, "Conjunto aleatorio introducida con éxito","Correcto",JOptionPane.INFORMATION_MESSAGE);
							dispose();
					} else {
						JOptionPane.showMessageDialog(null, "El conjunto no ha podido introducirse, vuelva a intentarlo. ","Incorrecto",JOptionPane.INFORMATION_MESSAGE);
					
	        	}	 */   
	        	
         
	        break;
	        
	        case "Salir":
	        	dispose();

	            
	        break;	       
	       	
	}
 				
	}
}
