package grupo2.LP;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class PanelMenu extends JFrame implements ActionListener {

    private JPanel PanelSuperior;
    private JPanel PanelInferior;
    private JPanel PanelCentro;
    
    
    private JButton Ver;
    private JButton Añadir;
    private JButton AñadirComp;
    private JButton Salir;
    private JButton Conjuntos;
    private JButton Fav;
    private JButton CrearCalendar;
    
    
    private JTextArea M, I, A, R, M2, A2, R2, I2, O;
    private JTextArea informacion;
    
    
    public PanelMenu(){
       
   //GOE --> Ponerle nombre de usuario arriba a la derecha
        
            
    
        this.setTitle("Bienvenido a tu armario");
        setLocationRelativeTo(null);  // Centra la ventana en la pantalla
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setBounds(250, 50, 450, 600); 
    
        
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
            //    PanelInferior.add(reloj);
                
            //PanelCentro    
                PanelCentro = new JPanel();
                //PanelIzquierda.setSize(400, 432);
                
                PanelCentro.setPreferredSize( new Dimension( 450,  450 ) );
                PanelCentro.setBackground(SystemColor.WHITE);
                                    
                getContentPane().add(PanelCentro, BorderLayout.WEST);
                
                CrearCalendar = new JButton("Ver calendario");
                CrearCalendar.setForeground(Color.BLACK);
                CrearCalendar.setAlignmentY(Component.CENTER_ALIGNMENT);
                CrearCalendar.setAlignmentX(Component.LEFT_ALIGNMENT);
                CrearCalendar.setSize(200, 29);
                CrearCalendar.setLocation(100, 155);
                CrearCalendar.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
                //        BSalir.setBounds(100, 103, 150, 30);
                CrearCalendar.addActionListener(this);
                        PanelCentro.setLayout(null);
                        CrearCalendar.setActionCommand("CrearCalendar");
                        PanelCentro.add(CrearCalendar);
                        
                Ver = new JButton("Ver mi armario");
                Ver.setForeground(Color.BLACK);
                Ver.setAlignmentY(Component.CENTER_ALIGNMENT);
                Ver.setAlignmentX(Component.LEFT_ALIGNMENT);
                Ver.setSize(200, 29);
                Ver.setLocation(100, 114);
                Ver.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
                //        BSalir.setBounds(100, 103, 150, 30);
                Ver.addActionListener(this);
                        PanelCentro.setLayout(null);
                        Ver.setActionCommand("Ver");
                        PanelCentro.add(Ver);
                
                Conjuntos = new JButton("Crear conjunto");
                Conjuntos.setForeground(Color.BLACK);
                Conjuntos.setAlignmentY(Component.CENTER_ALIGNMENT);
                Conjuntos.setAlignmentX(Component.LEFT_ALIGNMENT);
                Conjuntos.setSize(200, 29);
                Conjuntos.setLocation(100, 315);
                Conjuntos.setFont(new Font("Century Gothic", Font.BOLD, 15));
                //        BSalir.setBounds(100, 103, 150, 30);
                Conjuntos.addActionListener(this);
                        PanelCentro.setLayout(null);
                        Conjuntos.setActionCommand("Conjuntos");
                        PanelCentro.add(Conjuntos);
                        
                Fav = new JButton("Ver mis favoritos");
                Fav.setForeground(Color.BLACK);
                Fav.setAlignmentY(Component.CENTER_ALIGNMENT);
                Fav.setAlignmentX(Component.LEFT_ALIGNMENT);
                Fav.setSize(200, 29);
                Fav.setLocation(100, 195);
                Fav.setFont(new Font("Century Gothic", Font.BOLD, 15));
                Fav.addActionListener(this);
                        PanelCentro.setLayout(null);
                        Fav.setActionCommand("Fav");
                        PanelCentro.add(Fav);
                
                        
                Añadir = new JButton("Añadir prenda");
                Añadir.setForeground(Color.BLACK);
                Añadir.setAlignmentY(Component.CENTER_ALIGNMENT);
                Añadir.setAlignmentX(Component.LEFT_ALIGNMENT);
                Añadir.setSize(200, 29);
                Añadir.setLocation(100, 235);
                Añadir.setFont(new Font("Century Gothic", Font.BOLD, 15));
              
                Añadir.addActionListener(this);
                        PanelCentro.setLayout(null);
                        Añadir.setActionCommand("Añadir");
                        PanelCentro.add(Añadir);
                        
                AñadirComp = new JButton("Añadir complemento");
                AñadirComp.setForeground(Color.BLACK);
                AñadirComp.setAlignmentY(Component.CENTER_ALIGNMENT);
                AñadirComp.setAlignmentX(Component.LEFT_ALIGNMENT);
                AñadirComp.setSize(200, 29);
                AñadirComp.setLocation(100, 275);
                AñadirComp.setFont(new Font("Century Gothic", Font.BOLD, 15));
              
                AñadirComp.addActionListener(this);
                        PanelCentro.setLayout(null);
                        AñadirComp.setActionCommand("AñadirComp");
                        PanelCentro.add(AñadirComp);
                        
                Salir = new JButton("Cerrar sesion");
                Salir.setForeground(Color.BLACK);
                Salir.setAlignmentY(Component.CENTER_ALIGNMENT);
                Salir.setAlignmentX(Component.LEFT_ALIGNMENT);
                Salir.setSize(100, 15);
                Salir.setLocation(300, 400);
                Salir.setFont(new Font("Century Gothic", Font.BOLD, 10));
         
                Salir.addActionListener(this);
                        PanelCentro.setLayout(null);
                        Salir.setActionCommand("Salir");
                        PanelCentro.add(Salir);
                
                PanelCentro.add(Ver);
                PanelCentro.add(Añadir);
                PanelCentro.add(Salir);
                
                JTextPane txtpnHj = new JTextPane();
                txtpnHj.setForeground(SystemColor.desktop);
                txtpnHj.setFont(new Font("MS Mincho", Font.ITALIC, 26));
                txtpnHj.setText("¡Bienvenido a tu armario!");
                txtpnHj.setBounds(53, 43, 344, 60);
                PanelCentro.add(txtpnHj);
                
                        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        
        switch (e.getActionCommand()){
        
        case "Ver":
            
        	PanelArmario objpanePanel2;
			try {
				objpanePanel2 = new PanelArmario();
				objpanePanel2.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 
//>>>>>>> 92c4efe2d7a078211fe20179fe50fa0d48a76171
                        
            break;
        case "Añadir":
        	
        	InsertarPrenda objpanePanel = new InsertarPrenda();
        	objpanePanel.setVisible(true);
            
                                
                    
        break;
        case "Salir":
			JOptionPane.showMessageDialog( null, "¡Gracias por su visita, hasta pronto!" , "ADIOS", JOptionPane.INFORMATION_MESSAGE);

        	dispose();
            
            
            
        break;
        case "Fav":
        	
        	VerFavoritos objVerFavoritos = new VerFavoritos();
        	objVerFavoritos.setVisible(true);
            
                                    
        break;
        case "Conjuntos":
        	
        	InsertarConjunto objConj = new InsertarConjunto();
			objConj.setVisible(true);	
            
                                    
        break;
		case "AñadirComp":
		        	
			InsertarComplemento objComp = new InsertarComplemento();
			objComp.setVisible(true);	
		
		                                    
			break;
		case "CrearCalendar":
			
			CalendarProgram objCalendar = new CalendarProgram();
			objCalendar.CrearCalendario();
        
			break;
        }
        
    }
}
