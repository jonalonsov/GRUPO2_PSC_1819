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
import javax.swing.SwingConstants;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.GestorComplemento;
import grupo2.LN.GestorPrendas;

public class InsertarComplemento extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelIzquierda;
	
	private JLabel textC;
	private JTextField Complemento;
	private JLabel textColor;
	private JTextField Color1;
	
	
	
	private JButton btnAcep;
	private JTextArea M, I, A, R, M2, A2, R2, I2, O;
	private JTextArea informacion;
	
	
	
	//private Reloj reloj;
	
	public InsertarComplemento(){
		
		
				

		Complemento = new JTextField();
		Complemento.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Complemento.setBounds(94, 147, 231, 20);
		Complemento.setEnabled(true);
		Complemento.setEditable(true);
		
		textC = new JLabel();
		textC.setText("Inserte el Complemento\r\n");
		textC.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textC.setBounds(94, 119, 250, 29);
		textC.setOpaque(false);
		
						
		Color1 = new JTextField();
		Color1.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Color1.setBounds(94, 91, 231, 20);
		Color1.setEnabled(true);
		Color1.setEditable(true);
				
		textColor = new JLabel();
		textColor.setVerticalAlignment(SwingConstants.TOP);
		textColor.setText("Inserte el color \r\n");
		textColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textColor.setBounds(94, 60, 231, 20);
		
		
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
				PanelIzquierda.setBackground(SystemColor.WHITE);
									
				getContentPane().add(PanelIzquierda, BorderLayout.WEST);
						PanelIzquierda.setLayout(null);
				
				
				PanelIzquierda.add(textC);
				PanelIzquierda.add(Complemento);
				PanelIzquierda.add(Color1);
				PanelIzquierda.add(textColor);
								
				btnAcep = new JButton("Aceptar");
				btnAcep.setForeground(Color.BLACK);
				btnAcep.setHorizontalAlignment(SwingConstants.TRAILING);
				btnAcep.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				btnAcep.setAlignmentX(Component.RIGHT_ALIGNMENT);
				btnAcep.setSize(113, 31);
				btnAcep.setLocation(105, 290);
				btnAcep.setFont(new Font("Century Gothic", Font.BOLD, 16));
				//		BSalir.setBounds(100, 103, 150, 30);
				btnAcep.addActionListener(this);
						PanelIzquierda.setLayout(null);
						btnAcep.setActionCommand("Aceptar");
						PanelIzquierda.add(btnAcep);
								
						
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnAcep){
	            
			if(Color1.getText().length()==0 || Complemento.getText().length()==0){
				JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "CUIDADO",JOptionPane.INFORMATION_MESSAGE);
			} else {
	
						String nombre = Color1.getText();
						String color = Complemento.getText();
												
						GestorComplemento complemento = new GestorComplemento (nombre, color);		
							
						complemento.anyadirComplemento( BaseDeDatos.getStatement(), nombre, color);
						
						boolean semaforo=complemento.anyadirComplemento(BaseDeDatos.getStatement(), nombre, color);
						
						if(semaforo==true) {
							JOptionPane.showMessageDialog(null, "Prenda introducida con éxito","Correcto",JOptionPane.INFORMATION_MESSAGE);
								dispose();
						}
			} 				
		//}
//	}
	
}
}}