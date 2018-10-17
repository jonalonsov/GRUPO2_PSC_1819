package grupo2.LP;



import grupo2.LD.BaseDeDatos;

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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelRegistro extends JFrame implements ActionListener {
	
	
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelCentro;
	
	private JTextField Contraseña;
	private JLabel textCont;
	private JTextField Usuario;
	private JLabel textU;
	
	private JButton Aceptar;
	
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	
public PanelRegistro(){
	//setLayout(null);
	
	setTitle("Bienvenido a tu armario");
	setLocationRelativeTo( null );  // Centra la ventana en la pantalla
	setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	setBounds(250, 50, 450, 600); 
	//PanelSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().setLayout(new BorderLayout());
	
	textU = new JLabel();
	textU.setText("Nombre de usuario \r\n");
	textU.setFont(new Font("Century Gothic", Font.BOLD, 12));
	textU.setBounds(29, 59, 115, 16);
		
		
	Contraseña = new JPasswordField();
	//Contraseña.setFont(new Font("Century Gothic", Font.BOLD, 50));
	Contraseña.setBounds(29, 155, 115, 20);
	//Contraseña.setEnabled(true);
	Contraseña.setEditable(true);
	//this.add(Contraseña);
	
	textCont = new JLabel();
	textCont.setText("Contrasena \r\n");
	textCont.setSize(100, 32);
	textCont.setLocation(200, 100);
	textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
	textCont.setBounds(29, 125, 70, 16);
	//this.add(textCont);
		
	
	Aceptar = new JButton("Aceptar");
	Aceptar.setSize(95, 29);
	Aceptar.setLocation(105,207 );
	Aceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//	BSalir.setBounds(100, 103, 150, 30);
	Aceptar.addActionListener(this);
	Aceptar.setActionCommand("Aceptar");
	Aceptar.setBorderPainted(false);
	//this.add(Aceptar);
	
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
	
	//PanelCentro	
	PanelCentro = new JPanel();
	//PanelIzquierda.setSize(400, 432);
	
	PanelCentro.setPreferredSize( new Dimension( 450,  450 ) );
	PanelCentro.setBackground(SystemColor.WHITE);
						
	getContentPane().add(PanelCentro, BorderLayout.WEST);
	PanelCentro.setLayout(null);
	
	PanelCentro.add(textU);
	//this.add(textU);
	
	
	Usuario = new JTextField();
	//Usuario.setFont(new Font("Century Gothic", Font.BOLD, 50));
	Usuario.setBounds(29, 86, 115, 16);
	Usuario.setEditable(true);
	//this.add(Usuario);
	Usuario.setColumns(10);
	PanelCentro.add(Usuario);
	PanelCentro.add(textCont);
	PanelCentro.add(Contraseña);
	PanelCentro.add(Aceptar);
	
	
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	
	switch(e.getActionCommand()){
	
	case "Aceptar":
		
		String contraseña = Contraseña.getText();
		
		String usuario = Usuario.getText();
		
		/*boolean repetido = BaseDeDatos.chequearYaEnTabla(BaseDeDatos.getStatement(), usuario);
		
		
		if(repetido==false){
			BaseDeDatos.insertarUsuario(usuario, contraseña);
		}
		else {
			System.out.println("Usuario existe");
			JOptionPane.showMessageDialog( null, "Error!! el usuario existe" , "ERROR", JOptionPane.ERROR_MESSAGE );
		}
		*/
	/*	try {
			
			comprobarUsu (usuario);
			System.out.println("nombre");	
			
			//JOptionPane.showInputDialog("Entrado bien");
		}
			
		catch (Exception e1) {
		
				// TODO Auto-generated catch block
				//JOptionPane.showMessageDialog(this, e1.Informar());
			System.out.println("NO usuario");
		}
			
		try {
		comprobarCont(contraseña);
		}
		catch (Exception e1){
			
			//JOptionPane.showMessageDialog(this, e1.Informar());
			System.out.println("NO contraseña");
		}*/
			
	
		break;

	
}

}
}
