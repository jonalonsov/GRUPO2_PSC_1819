package grupo2.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import grupo2.LN.Calendario;
import grupo2.LN.GestorConjuntos;
import grupo2.LN.GestorPrendas;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class VerCalendario extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelIzquierda;
		
	private JButton btnBorrarRegistro;
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	JFileChooser fc;
	
	private GestorPrendas gprendas;
	private  JTable tableConj;
	private  String[] datoConj;
	private GestorConjuntos gconjuntos;
	private int indice3;
	private JScrollPane scrollConj;

	
	//private Reloj reloj;
	
	public VerCalendario(){
		gprendas = new GestorPrendas();
		gconjuntos = new GestorConjuntos();

		
		
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
				PanelIzquierda.setBackground(UIManager.getColor("Button.light"));
									
				getContentPane().add(PanelIzquierda, BorderLayout.WEST);
						PanelIzquierda.setLayout(null);
				
				btnBorrarRegistro = new JButton("Quitar del calendario");
				btnBorrarRegistro.setForeground(Color.BLACK);
				btnBorrarRegistro.setAlignmentY(Component.CENTER_ALIGNMENT);
				btnBorrarRegistro.setAlignmentX(Component.LEFT_ALIGNMENT);
				btnBorrarRegistro.setSize(192, 31);
				btnBorrarRegistro.setLocation(140, 374);
				btnBorrarRegistro.setFont(new Font("Century Gothic", Font.BOLD, 14));
				//		BSalir.setBounds(100, 103, 150, 30);
				btnBorrarRegistro.addActionListener(this);
						PanelIzquierda.setLayout(null);
						btnBorrarRegistro.setActionCommand("QuitarRegistro");
						PanelIzquierda.add(btnBorrarRegistro);
					
						tableConj = new JTable();
						 tableConj.setEnabled(true);
						
						//Cargamos la tabla con los datos de la BD de prendas
				        DefaultTableModel model3= new DefaultTableModel();
				        model3.addColumn("Id");
				        model3.addColumn("Fecha");
				        model3.addColumn("Prenda 1");
				        model3.addColumn("Prenda 2");
				        
				        
						
						scrollConj = new JScrollPane(tableConj);
						scrollConj.setBounds(23, 52, 397, 297);
						PanelIzquierda.add(scrollConj);
						
						Calendario objCalendario = null;
						String fecha;
						String prenda1;
						String prenda2;
				   		for (int i = 0; i < gconjuntos.selectCalendario().length; i++){
				        	datoConj = new String[75];
				        	
				        	objCalendario= gconjuntos.selectCalendario()[i];
				        	prenda1 = gprendas.nombrePrendaconID(objCalendario.getConjunto().getPrenda1());
				        	prenda2 = gprendas.nombrePrendaconID(objCalendario.getConjunto().getPrenda2());
				        	fecha = objCalendario.getFecha().getDia() + " de " + objCalendario.getFecha().getMes() + " del " +objCalendario.getFecha().getAño();
				        	datoConj[0]=Integer.toString(objCalendario.getId());
				        	
				        	datoConj[1]=fecha;
				        	
				        	datoConj[2]=prenda1;
				        	datoConj[3]=prenda2;
				        
				        
				        	model3.addRow(datoConj);

				        }
				   					       
				           
				   		 tableConj.setCellSelectionEnabled(true);
					     ListSelectionModel cellSelectionModel4 = tableConj.getSelectionModel();
					     cellSelectionModel4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					        
				        tableConj.setModel(model3);
				        
				        cellSelectionModel4.addListSelectionListener(new ListSelectionListener() {
				    		  public void valueChanged(ListSelectionEvent e) {
				    		        String selectedDataID = null;
				    	

				    		      int selectedRow3 = tableConj.getSelectedRow();

						            selectedDataID = (String) tableConj.getValueAt(selectedRow3,0);
						            indice3=Integer.parseInt(selectedDataID);
						            
						            System.out.println("Selected: " + indice3);
				    		 }
				 		 });
				        
				   
						

		                

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		  switch (e.getActionCommand()){
		  case "QuitarRegistro":
			  
	        	gconjuntos.deleteCalendario(indice3);
				dispose();
				
				VerCalendario objVerCalendario = new VerCalendario();
				objVerCalendario.setVisible(true);
	            
				 break;
			       
			       	
			}
		
	}
}
