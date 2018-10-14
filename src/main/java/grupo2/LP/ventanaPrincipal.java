package grupo2.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ventanaPrincipal extends JFrame implements ActionListener {

	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelIzquierda;
	private JPanel PanelDerecha;
	
	
	private JLabel textCont;
	private JTextField Contraseña;
	private JLabel textU;
	private JTextField Usuario;
		
	private JButton Aceptar;
	
	private JTextArea H, O, L, A;
	private JTextArea informacion;
	
	
	//private Reloj reloj;
	
	public ventanaPrincipal(){
		
		
setLayout(null);

		Usuario = new JTextField();
		Usuario.setFont(new Font("Century Gothic", Font.BOLD, 50));
		//Usuario.setBounds(94, 75, 231, 20);
		Usuario.setEnabled(true);
		Usuario.setEditable(true);
		

		textU = new JLabel();
		textU.setText("Inserte el nombre de usuario \r\n");
		textU.setFont(new Font("Century Gothic", Font.BOLD, 12));
		//textU.setBounds(94, 45, 231, 20);
		textU.setOpaque(false);
		
		
				
		Contraseña = new JPasswordField();
		Contraseña.setFont(new Font("Century Gothic", Font.BOLD, 50));
		//Contraseña.setBounds(94, 159, 231, 20);
		Contraseña.setEnabled(true);
		Contraseña.setEditable(true);
		
		
		textCont = new JLabel();
		textCont.setText("Inserte la contrasena \r\n");
		//textCont.setSize(100, 32);
		//textCont.setLocation(200, 100);
		textCont.setOpaque(false);
		textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textCont.setBounds(94, 125, 231, 20);
		
					
		Aceptar = new JButton("Entrar");
		Aceptar.setSize(100, 32);
		Aceptar.setLocation(156, 215);
		Aceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//		BSalir.setBounds(100, 103, 150, 30);
		Aceptar.addActionListener(this);
		Aceptar.setActionCommand("Entrar");
		Aceptar.setContentAreaFilled(false);
		Aceptar.setBorderPainted(false);
		
		
		
		setTitle("Bienvenido a tu armario");
		setLocationRelativeTo( null );  // Centra la ventana en la pantalla
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setBounds(250, 50, 880, 600); 
		//PanelSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout());
		
		H = new JTextArea();
		H.setText("H");
		H.setForeground(new Color(0, 0, 0));
		H.setFont(new Font("Century Gothic", Font.BOLD, 50));
		H.setEnabled(false);
		H.setBackground(Color.GRAY);
		
		O = new JTextArea();
		O.setText("O");
		O.setForeground(new Color(0, 0, 0));
		O.setFont(new Font("Century Gothic", Font.BOLD, 50));
		O.setEnabled(false);
		O.setBackground(Color.GRAY);
		
		L = new JTextArea();
		L.setText("L");
		L.setForeground(new Color(0, 0, 0));
		L.setFont(new Font("Century Gothic", Font.BOLD, 50));
		L.setEnabled(false);
		L.setBackground(Color.GRAY);
		
		A = new JTextArea();
		A.setText("A");
		A.setForeground(new Color(0, 0, 0));
		A.setFont(new Font("Century Gothic", Font.BOLD, 50));
		A.setEnabled(false);
		A.setBackground(Color.GRAY);
		
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
									
				this.add(PanelSuperior, BorderLayout.NORTH);
				
				
				PanelSuperior.add(H);
				PanelSuperior.add(O);
				PanelSuperior.add(L);
				PanelSuperior.add(A);
				
				
				
				
				//PANEL INFERIOR
				PanelInferior = new JPanel();
				
				PanelInferior.setPreferredSize( new Dimension( 50,  50 ) );
				PanelInferior.setBackground(Color.GRAY);
									
				this.add(PanelInferior, BorderLayout.SOUTH);
				PanelInferior.add(informacion);
			//	PanelInferior.add(reloj);
				
			//PANEL izquierda
				PanelIzquierda = new JPanel();
				
				PanelIzquierda.setPreferredSize( new Dimension( 450,  450 ) );
				PanelIzquierda.setBackground(Color.WHITE);
									
				this.add(PanelIzquierda, BorderLayout.WEST);
				PanelIzquierda.add(Usuario);
				PanelIzquierda.add(Contraseña);
				PanelIzquierda.add(textCont);
				PanelIzquierda.add(textU);
			//	PanelInferior.add(reloj);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch (e.getActionCommand()){
		
		case "Entrar":
			
			
		break;
		
		}
		
	}

	
	
	
	
	
	
	
	
	
}
