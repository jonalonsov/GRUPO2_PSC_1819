package grupo2.LP;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.GestorPrendas;

public class VerPrenda extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelCentro;
	    
	    
	    
	    private JButton Salir;
	
	
	
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	private JButton btnAadirAFavoritos;
	
	
	
	//private Reloj reloj;
	
	public VerPrenda(){
		
		
		
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
				PanelCentro = new JPanel();
				//PanelIzquierda.setSize(400, 432);
				
				PanelCentro.setPreferredSize( new Dimension( 450,  450 ) );
				PanelCentro.setBackground(SystemColor.WHITE);
									
				getContentPane().add(PanelCentro, BorderLayout.WEST);
				PanelCentro.setLayout(null);
				
				
						
			                        
			                Salir = new JButton("Cerrar sesion");
			                Salir.setForeground(Color.BLACK);
			                Salir.setHorizontalAlignment(SwingConstants.TRAILING);
			                Salir.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			                Salir.setAlignmentX(Component.RIGHT_ALIGNMENT);
			                Salir.setSize(151, 29);
			                Salir.setLocation(262, 380);
			                Salir.setFont(new Font("Century Gothic", Font.BOLD, 16));
			                //        BSalir.setBounds(100, 103, 150, 30);
			                Salir.addActionListener(this);
			                        PanelCentro.setLayout(null);
			                        
			                       
			                        Salir.setActionCommand("Salir");
			                        PanelCentro.add(Salir);
			                
			                             PanelCentro.add(Salir);
			                
			                JTextPane txtpnHj = new JTextPane();
			                txtpnHj.setForeground(SystemColor.desktop);
			                txtpnHj.setFont(new Font("MS Mincho", Font.ITALIC, 26));
			                txtpnHj.setText("¿Te gusta?");
			                txtpnHj.setBounds(136, 38, 161, 60);
			                PanelCentro.add(txtpnHj);
			                
			                btnAadirAFavoritos = new JButton("Añadir a Favoritos");
			                btnAadirAFavoritos.setHorizontalAlignment(SwingConstants.TRAILING);
			                btnAadirAFavoritos.setForeground(Color.BLACK);
			                btnAadirAFavoritos.setFont(new Font("Century Gothic", Font.BOLD, 16));
			                btnAadirAFavoritos.setAlignmentY(1.0f);
			                btnAadirAFavoritos.setAlignmentX(1.0f);
			                btnAadirAFavoritos.setActionCommand("Salir");
			                btnAadirAFavoritos.setBounds(262, 340, 151, 29);
			                PanelCentro.add(btnAadirAFavoritos);
			                
								
						
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		  switch (e.getActionCommand()){
	        
		  
	        case "Salir":
				JOptionPane.showMessageDialog( null, "¡Gracias por su visita, hasta pronto!" , "ADIOS", JOptionPane.INFORMATION_MESSAGE);

	        	dispose();
	            
	            
	            
	        break;
	       
	       	
		}
	}
}
