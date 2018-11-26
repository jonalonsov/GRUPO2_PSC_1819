package grupo2.LP;

import javax.swing.*;
import javax.swing.table.*;

import grupo2.LN.Fecha;
import grupo2.LN.GestorConjuntos;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarProgram {

    private static JLabel lblMonth;
	private JLabel lblYear;
    private static JButton btnPrev;
	private static JButton btnNext;
	private JButton btnRegistrarFecha;
    private static JTable tblCalendar;
    private static JComboBox<String> cmbYear;
    private static JFrame frmMain;
    private Container pane;
    private static DefaultTableModel mtblCalendar; //Table model
    private JScrollPane stblCalendar; //The scrollpane
    private JPanel pnlCalendar; //The panel
    private static int realDay, realMonth;
	private static int realYear;
	private static int currentMonth;
	private static int currentYear;

    private static Fecha objFecha;
    private static Integer valueInCell;
    private static GestorConjuntos  objGestorConjunto;
    private int selectedRow;
    private int selectedColumn;



    public void CrearCalendario() {

    	try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}  
    	catch (ClassNotFoundException e) {}   
    	catch (InstantiationException e) {}   
    	catch (IllegalAccessException e) {}
    	catch (UnsupportedLookAndFeelException e) {}
    	
    	
    	frmMain = new JFrame("Calendar application");   	
    	frmMain.setSize(330, 375); //Two arguments: width and height
    	pane = frmMain.getContentPane();
    	pane.setLayout(null); //Apply the null layout
    	frmMain.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    	
    	
    	
    	//Crear controles
    	lblMonth = new JLabel ("January");
    	lblMonth.setFont(new Font("Century Gothic", Font.PLAIN, 14));
    	lblMonth.setBackground(Color.CYAN);
    	lblYear = new JLabel ("Escoja el año");
    	lblYear.setFont(new Font("Century Gothic", Font.PLAIN, 11));
    	lblYear.setBackground(Color.WHITE);
    	cmbYear = new JComboBox<String>();
    	btnPrev = new JButton ("<<");
    	btnPrev.setBackground(Color.CYAN);
     	btnNext = new JButton (">>");
     	mtblCalendar = new DefaultTableModel(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
/*
		public boolean isCellEditable(int rowIndex, int mColIndex){return false;}  
		 	
	*/	
		};
		
		

     	tblCalendar = new JTable(mtblCalendar); //Table using the above model
    	stblCalendar = new JScrollPane(tblCalendar); //The scrollpane of the above table
    	
    	//Activamos la selección de la tabla
    	tblCalendar.setColumnSelectionAllowed(true);
    	tblCalendar.setRowSelectionAllowed(true);

    	tblCalendar.addMouseListener(new MouseAdapter() {
    	    @Override
    	    public void mouseClicked(final MouseEvent e) {
    	        if (e.getClickCount() == 1) {
    	            final JTable jTable= (JTable)e.getSource();
    	            selectedRow = jTable.getSelectedRow();
    	            selectedColumn = jTable.getSelectedColumn();
    	            valueInCell = (Integer)jTable.getValueAt(selectedRow, selectedColumn);
    	            
    	            System.out.println("ESTA ES LA FILAAA" + selectedRow);
    			    System.out.println("ESTA ES LA COLUMNAA" + selectedColumn);
    			    System.out.println("VALOOOOOOR" + valueInCell);
    			     
    			 
    			     
    	        }
    	    }
    	});
    	
    	
    	pnlCalendar = new JPanel(null); //Create the "panel" to place components
    	pnlCalendar.setBackground(Color.LIGHT_GRAY);
    	pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar")); //Set bord
    	
    	//Add controls to pane
    	pane.add(pnlCalendar);
    	pnlCalendar.add(lblMonth);
    	pnlCalendar.add(lblYear);
    	pnlCalendar.add(cmbYear);
    	pnlCalendar.add(btnPrev);
    	pnlCalendar.add(btnNext);
    	pnlCalendar.add(stblCalendar);
    	
    	//Set bounds
    	pnlCalendar.setBounds(0, 0, 320, 335);
    	lblMonth.setBounds(102, 23, 126, 25);
    	lblYear.setBounds(153, 304, 80, 20);
    	cmbYear.setBounds(230, 305, 80, 20);
    	btnPrev.setBounds(10, 25, 50, 25);
    	btnNext.setBounds(260, 25, 50, 25);
    	stblCalendar.setBounds(10, 50, 300, 250);

    	

		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		//Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month and year
		currentYear = realYear;
		
		//Populate combo box
		for (int i=realYear-100; i<=realYear+100; i++){
		    cmbYear.addItem(String.valueOf(i));
		}
		
		//Add headers
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
		    mtblCalendar.addColumn(headers[i]);
		}
		
		tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
		
		//No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);
		
		//Single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Set row/column count
		tblCalendar.setRowHeight(38);
		
		btnRegistrarFecha = new JButton("Registrar fecha");
		btnRegistrarFecha.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRegistrarFecha.setBounds(20, 304, 113, 23);
		pnlCalendar.add(btnRegistrarFecha);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);
		
		//Prepare calendar
		for (int i=realYear-100; i<=realYear+100; i++){
		    cmbYear.addItem(String.valueOf(i));
		}
		
		refreshCalendar (realMonth, realYear); //Refresh calendar
		
		//Register action listeners
		btnRegistrarFecha.addActionListener(new btnRegistrar_Action());
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());
			
		
		
    }
    
    public static void refreshCalendar(int month, int year){
    	 String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    	     int nod, som; //Number Of Days, Start Of Month

    	     btnPrev.setEnabled(true); //Enable buttons at first
    	     btnNext.setEnabled(true);
    	     if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
    	     if (month == 11 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
    	     lblMonth.setText(months[month]); //Refresh the month label (at the top)
    	     lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
    	     cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
   
    	   //Get first day of month and number of days
    	     GregorianCalendar cal = new GregorianCalendar(year, month, 1);
    	     nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    	     som = cal.get(GregorianCalendar.DAY_OF_WEEK);
    	     
    	   //Clear table
    	     for (int i=0; i<6; i++){
    	         for (int j=0; j<7; j++){
    	             mtblCalendar.setValueAt(null, i, j);
    	         }
    	     }
    	     
    	     for (int i=1; i<=nod; i++){
    	    	 int row = new Integer((i+som-2)/7);
    	    	 int column  =  (i+som-2)%7;
    	    	         mtblCalendar.setValueAt(i, row, column);
    	    	        
    	     }
    	     tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer()); //Apply renderer
    	     System.out.println(currentYear);
    	     System.out.println(currentMonth);
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{

    	
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
    		            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
    		            if (column == 0 || column == 6){ //Week-end
    		                setBackground(new Color(150, 150, 150));
    		            }
    		            else{ //Week
    		                setBackground(new Color(255, 255, 255));
    		            }
    		            if (value != null){
    		               
    		            	System.out.println(realDay);
    		            	System.out.println(valueInCell);
    						if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
    		                    setBackground(new Color(220, 220, 255));
    		                }
    		            }

    		            setBorder(null);
    		            setForeground(Color.black);
    		            return this;  

			}
    }
	class lvwCalendarRenderer extends DefaultTableCellRenderer{
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
		        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
		        return this;  
		    }
	}
	
	 static class btnPrev_Action implements ActionListener{
		         public void actionPerformed (ActionEvent e){
		             if (currentMonth == 0){ //Back one year
		                 currentMonth = 11;
		                 currentYear -= 1;
		             }
		             else{ //Back one month
		                 currentMonth -= 1;
		             }
		             refreshCalendar(currentMonth, currentYear);
		         }
		     }
	 
	 static class btnNext_Action implements ActionListener{
		         public void actionPerformed (ActionEvent e){
		             if (currentMonth == 11){ //Foward one year
		                 currentMonth = 0;
		                 currentYear += 1;
		             }
		             else{ //Foward one month
		                 currentMonth += 1;
		             }
		             refreshCalendar(currentMonth, currentYear);
		         }
		     }
	 static class cmbYear_Action implements ActionListener{
		         public void actionPerformed (ActionEvent e){
		             if (cmbYear.getSelectedItem() != null){
		                 String b = cmbYear.getSelectedItem().toString();
		                 currentYear = Integer.parseInt(b);
		                 refreshCalendar(currentMonth, currentYear);
		             }
		         }
	 }
	 static class btnRegistrar_Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			objGestorConjunto = new GestorConjuntos();			
			objFecha = new Fecha(currentYear, currentMonth, valueInCell);					
			boolean semaforo = objGestorConjunto.anyadriFechaCalendario(objFecha.getAño(), objFecha.getMes(), objFecha.getDia());
			
			if(semaforo==true) {
				JOptionPane.showMessageDialog(null, "Conjunto añadido al calendario con éxito","Correcto",JOptionPane.INFORMATION_MESSAGE);
								
				//frmMain.dispatchEvent(new WindowEvent(frmMain, WindowEvent.WINDOW_CLOSING));
					frmMain.dispose(); //Destroy the JFrame object		
			} else {
				JOptionPane.showMessageDialog(null, "El conjunto no ha podido ser añadido al calendario, vuelva a intentarlo. ","Incorrecto",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		 
	 }


}
	 
	 
	 
	 

    
    


