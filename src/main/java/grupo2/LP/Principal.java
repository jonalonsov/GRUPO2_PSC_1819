package grupo2.LP;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import grupo2.LN.GestorUsuario;
import grupo2.LN.usuario;

public class Principal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelIzquierda;
	private JLabel textCont;
	private JTextField Contraseña;
	private JLabel textU;
	private JTextField Usuario;
	private JLabel textR;
		
	private JButton btnAceptar;
	private JButton btnRegistrar;
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	private JTextArea fechayhora;
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	private LocalDateTime now = LocalDateTime.now();

	private GestorUsuario jugador;
	private usuario objUsuario;
	
	public Principal(){

		
//getContentPane().setLayout(null);
				

		Usuario = new JTextField();
		Usuario.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Usuario.setBounds(94, 94, 231, 20);
		Usuario.setEnabled(true);
		Usuario.setEditable(true);
		
		textU = new JLabel();
		textU.setText("Inserte el nombre de usuario \r\n");
		textU.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textU.setBounds(94, 53, 250, 29);
		textU.setOpaque(false);
		
						
		Contraseña = new JPasswordField();
		Contraseña.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Contraseña.setBounds(94, 159, 231, 20);
		Contraseña.setEnabled(true);
		Contraseña.setEditable(true);
				
		textCont = new JLabel();
		textCont.setVerticalAlignment(SwingConstants.TOP);
		textCont.setText("Inserte la contraseña \r\n");
		textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textCont.setBounds(94, 137, 231, 20);
			
		
		
		setTitle("Bienvenido a tu armario");
		setLocationRelativeTo( null );  // Centra la ventana en la pantalla
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setBounds(400, 50, 700, 600); 
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
		
		fechayhora = new JTextArea();
		fechayhora.setText("      			      "+dtf.format(now));
		fechayhora.setForeground(new Color(0, 0, 0));
		fechayhora.setFont(new Font("Century Gothic", Font.BOLD, 12));
		fechayhora.setEnabled(false);
		fechayhora.setBackground(Color.GRAY);
		
		
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
				
				PanelInferior.add(fechayhora);
			
			//PANEL izquierda
				PanelIzquierda = new JPanel();
				//PanelIzquierda.setSize(400, 432);
				
				PanelIzquierda.setPreferredSize( new Dimension( 450,  450 ) );
				PanelIzquierda.setBackground(SystemColor.WHITE);
									
				getContentPane().add(PanelIzquierda, BorderLayout.WEST);
								
							
				btnAceptar = new JButton("Log In");
				btnAceptar.setHorizontalAlignment(SwingConstants.TRAILING);
				btnAceptar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				btnAceptar.setAlignmentX(Component.RIGHT_ALIGNMENT);
				btnAceptar.setSize(91, 29);
				btnAceptar.setLocation(172, 204);
				btnAceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
				//		BSalir.setBounds(100, 103, 150, 30);
						btnAceptar.addActionListener(this);
						PanelIzquierda.setLayout(null);
						btnAceptar.setActionCommand("Log In");
						PanelIzquierda.add(btnAceptar);
				
				
				PanelIzquierda.add(Usuario);
				PanelIzquierda.add(Contraseña);
				PanelIzquierda.add(textCont);
				PanelIzquierda.add(textU);
		
				
				
				textR = new JLabel();
				textR.setText("¿No esta registrado? \r\n");
				textR.setFont(new Font("Century Gothic", Font.BOLD, 12));
				textR.setBounds(172, 393, 129, 29);
				textR.setOpaque(false);
				PanelIzquierda.add(textR);
				
				btnRegistrar = new JButton("Registrarse");
				btnRegistrar.setForeground(Color.BLACK);
				btnRegistrar.setHorizontalAlignment(SwingConstants.TRAILING);
				btnRegistrar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				btnRegistrar.setAlignmentX(Component.RIGHT_ALIGNMENT);
				btnRegistrar.setSize(113, 31);
				btnRegistrar.setLocation(308, 390);
				btnRegistrar.setFont(new Font("Century Gothic", Font.BOLD, 16));
				//		BSalir.setBounds(100, 103, 150, 30);
				btnRegistrar.addActionListener(this);
						PanelIzquierda.setLayout(null);
						btnRegistrar.setActionCommand("Registrar");
						PanelIzquierda.add(btnRegistrar);
				
				//PANEL DERECHA
//GOE: Meterle alguna foto bonita	
						
						
						
				JPanel PanelDerecha = new JPanel();
				//PanelIzquierda.setSize(400, 432);
				
				PanelDerecha.setPreferredSize( new Dimension( 450,  450 ) );
				PanelDerecha.setBackground(SystemColor.activeCaption);
									
				getContentPane().add(PanelDerecha, BorderLayout.EAST);
				
				
				
						
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()){
		
		case "Log In":
			
			if(Contraseña.getText().length()==0 || Usuario.getText().length()==0){
				JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "CUIDADO",JOptionPane.INFORMATION_MESSAGE);

					} else {
			
					String contrasenya = Contraseña.getText();
					String usuario = Usuario.getText();
					
					
					jugador = new GestorUsuario();		
					
					
					boolean semaforo=jugador.chequearYaEnTablaLOGIN(usuario, contrasenya);
					objUsuario = new usuario(usuario,contrasenya);
					jugador.modificarUsuarioSistema(objUsuario);
					
								if(semaforo==true) {
									
									PanelMenu objpanelMP = new PanelMenu();
									objpanelMP.setVisible(true);
									dispose();
								} else {			
					
									int resp = JOptionPane.showConfirmDialog(null, "¿Quieres registrarte como nuevo usuario con los datos introducidos?", "Alerta!", JOptionPane.YES_NO_OPTION);
									if (resp==0) {
														
										//Si no existe, anyade fila con el usuario nuevo y sus respectivos atributos
										
										
										
										jugador.anyadirUsuario(objUsuario);
																						
										PanelMenu objpanelMP = new PanelMenu();
										objpanelMP.setVisible(true);
										dispose();	
									} 
						}
			
			}
			
			//PONER AQUÍ ENLACE AL MENÚ PRINCIPAL
			
			break;
			
		case "Registrar":
			
			//JOptionPane.showMessageDialog(null, "Registrarse"); 
			Registrarse objpanelR = new Registrarse();
			objpanelR.setVisible(true);
			
		break;
		
		}
		
	}
}
