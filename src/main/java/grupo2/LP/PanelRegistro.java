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

public class PanelRegistro extends JPanel implements ActionListener {
	
	
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JTextField Contraseña;
	private JLabel textCont;
	
	private JTextField Usuario;
	private JLabel textU;
	
	private JButton Aceptar;
	
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	
public PanelRegistro(){
	setLayout(null);
	
	textU = new JLabel();
	textU.setText("Nombre de usuario \r\n");
	textU.setFont(new Font("Century Gothic", Font.BOLD, 12));
	textU.setBounds(126, 89, 115, 16);
	this.add(textU);
	
	
	
	
	
	Usuario = new JTextField();
	//Usuario.setFont(new Font("Century Gothic", Font.BOLD, 50));
	Usuario.setBounds(126, 116, 86, 20);
	Usuario.setEditable(true);
	this.add(Usuario);
	Usuario.setColumns(10);
		
		
	Contraseña = new JPasswordField();
	//Contraseña.setFont(new Font("Century Gothic", Font.BOLD, 50));
	Contraseña.setBounds(126, 180, 86, 20);
	//Contraseña.setEnabled(true);
	Contraseña.setEditable(true);
	this.add(Contraseña);
	
	textCont = new JLabel();
	textCont.setText("Contrasena \r\n");
	textCont.setSize(100, 32);
	textCont.setLocation(200, 100);
	textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
	textCont.setBounds(126, 154, 110, 16);
	this.add(textCont);
		
	
	Aceptar = new JButton("Aceptar");
	Aceptar.setSize(95, 29);
	Aceptar.setLocation(209,212 );
	Aceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//	BSalir.setBounds(100, 103, 150, 30);
	Aceptar.addActionListener(this);
	Aceptar.setActionCommand("Aceptar");
	Aceptar.setBorderPainted(false);
	this.add(Aceptar);
	
	
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
