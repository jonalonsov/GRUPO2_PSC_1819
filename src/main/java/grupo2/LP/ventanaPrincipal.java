package grupo2.LP;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Point;

import com.jgoodies.forms.factories.DefaultComponentFactory;


public class ventanaPrincipal extends JFrame implements ActionListener {

	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelIzquierda;
	private JPanel PanelDerecha;
	private JPanel panelRopa = new PanelRopa ();
	
	
	private JLabel textCont;
	private JTextField Contraseña;
	private JLabel textU;
	private JTextField Usuario;
		
	private JButton Aceptar;
	private JButton BEntrar;
	private JButton BMenu;
	
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	private JLabel lblNewLabel;
	private JLabel label;
	
	
	//private Reloj reloj;
	
	public ventanaPrincipal(){
		
		
//getContentPane().setLayout(null);
				

		Usuario = new JTextField();
		Usuario.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Usuario.setBounds(94, 94, 231, 20);
		Usuario.setEnabled(true);
		Usuario.setEditable(true);
		
		textU = new JLabel();
		textU.setText("Inserte el nombre de usuario \r\n");
		textU.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textU.setBounds(94, 54, 250, 29);
		textU.setOpaque(false);
		
						
		Contraseña = new JPasswordField();
		Contraseña.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Contraseña.setBounds(94, 159, 231, 20);
		Contraseña.setEnabled(true);
		Contraseña.setEditable(true);
				
		textCont = new JLabel();
		textCont.setVerticalAlignment(SwingConstants.TOP);
		textCont.setText("Inserte la contrasena \r\n");
		textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textCont.setBounds(94, 137, 231, 20);
		
		BEntrar = new JButton("Entrar"); //añadimos un boton
		BEntrar.setFont(new Font("Century Gothic", Font.BOLD, 12));
//		BEntrar.setBounds(324, 62, 300, 30);
		BEntrar.addActionListener(this);
		BEntrar.setActionCommand("Entrar");
		BEntrar.setOpaque(false);
		BEntrar.setContentAreaFilled(false);
		BEntrar.setBorderPainted(false);
		
		
		
		setTitle("Bienvenido a tu armario");
		setLocationRelativeTo( null );  // Centra la ventana en la pantalla
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setBounds(250, 50, 880, 600); 
		//PanelSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(new BorderLayout());
		
		M = new JTextArea();
		M.setText("M");
		M.setForeground(new Color(0, 0, 0));
		M.setFont(new Font("Century Gothic", Font.BOLD, 50));
		M.setEnabled(false);
		M.setBackground(Color.GRAY);
		
		I = new JTextArea();
		I.setText("I");
		I.setForeground(new Color(0, 0, 0));
		I.setFont(new Font("Century Gothic", Font.BOLD, 50));
		I.setEnabled(false);
		I.setBackground(Color.GRAY);
		
		R = new JTextArea();
		R.setText("R");
		R.setForeground(new Color(0, 0, 0));
		R.setFont(new Font("Century Gothic", Font.BOLD, 50));
		R.setEnabled(false);
		R.setBackground(Color.GRAY);
		
		A = new JTextArea();
		A.setText("A");
		A.setForeground(new Color(0, 0, 0));
		A.setFont(new Font("Century Gothic", Font.BOLD, 50));
		A.setEnabled(false);
		A.setBackground(Color.GRAY);
		
		O = new JTextArea();
		O.setText("O");
		O.setForeground(new Color(0, 0, 0));
		O.setFont(new Font("Century Gothic", Font.BOLD, 50));
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
				PanelSuperior.add(M);
				PanelSuperior.add(A);
				PanelSuperior.add(R);
				PanelSuperior.add(I);
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
				
				
							
				Aceptar = new JButton("Entrar");
				Aceptar.setHorizontalAlignment(SwingConstants.TRAILING);
				Aceptar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				Aceptar.setAlignmentX(Component.RIGHT_ALIGNMENT);
				Aceptar.setSize(91, 29);
				Aceptar.setLocation(171, 210);
				Aceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
				//		BSalir.setBounds(100, 103, 150, 30);
						Aceptar.addActionListener(this);
						PanelIzquierda.setLayout(null);
						Aceptar.setActionCommand("Entrar");
						PanelIzquierda.add(Aceptar);
				
				
				PanelIzquierda.add(Usuario);
				PanelIzquierda.add(Contraseña);
				PanelIzquierda.add(textCont);
				PanelIzquierda.add(textU);
			//	PanelInferior.add(reloj);
				
				//PANEL DERECHA
				
				PanelDerecha = new JPanel();
				//PanelIzquierda.setSize(400, 432);
				
				PanelDerecha.setPreferredSize( new Dimension( 450,  450 ) );
				PanelDerecha.setBackground(SystemColor.activeCaption);
									
				getContentPane().add(PanelDerecha, BorderLayout.EAST);
				
		        
			
				
						
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch (e.getActionCommand()){
		
		case "Entrar":
			
			/*String contraseña = Contraseña.getText();
			
			String usuario = Usuario.getText();
			
			try {
				
				comprobarUsu (usuario);
				
			
			//	PanelGestionContacto panelGestionCont = new PanelGestionContacto ();
				//panelGestionCont.setPreferredSize( new Dimension( 800,125 ) );
				//panelGestionCont.setBackground(SystemColor.activeCaption);
				//this.add(panelGestionCont, BorderLayout.CENTER);
			
				
				//JOptionPane.showInputDialog("Entrado bien");
			}
				
			catch (Exception e1) {
			
					// TODO Auto-generated catch block
				//	JOptionPane.showMessageDialog(this, e1.Informar());
			}
				
			try {
			comprobarCont(contraseña);
			}
			catch (Exception e1){
				
				//JOptionPane.showMessageDialog(this, e1.Informar());
			}*/
			
			panelRopa.setPreferredSize( new Dimension( 400,500 ) );
			panelRopa.setBackground(SystemColor.activeCaption);
			this.add(panelRopa, BorderLayout.WEST);
								
			panelRopa.setVisible(true);
			
			
			break;
		
		
		
		}
		
	}

	private void comprobarCont(String contraseña) throws Exception {
		// TODO Auto-generated method stub
		if(contraseña.isEmpty()){
			
			throw new Exception ();
			
		} //comprobar tambien si son los correctos
	}

	private void comprobarUsu(String usuario) throws Exception {
		// TODO Auto-generated method stub
		if(usuario.isEmpty()){
			
			throw new Exception ();
			
		}// mirar si existe el nombre de usuario
	}

	
	
	
	
	
	
	
	
	
}
