package guilayoutdialog;


import java.awt.BorderLayout;   
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Dialogadd extends JDialog implements ActionListener {
	

	
	private gldBeispiel mainframe ; //把gldb作为一个属性  供下面方法引用

	
    private String[] texte = { "true", "false" }; //cbox中的两个选项
	
	
	private JLabel Num = new JLabel ("Nummer"); 
	private JLabel Name = new JLabel ("Name");
	private JLabel Preis = new JLabel ("Preis");
	private JLabel Lage = new JLabel ("Lage");
	
	private JTextField tfnum = new JTextField (10);  
	private JTextField tfnam = new JTextField (10);
	private JTextField tfpre = new JTextField (10);
	
	private JComboBox<String> cbox	= new JComboBox<String> (texte); 
	
	private JButton neubt1 = new JButton ("Add");     
	private JButton neubt2 = new JButton ("Abbrechen");
	
	public Dialogadd(Window parent, String title , gldBeispiel a ) { 
		
		
		this.mainframe = a ;
		
		tfnum.addActionListener(this); 
		tfnam.addActionListener(this);
		tfpre.addActionListener(this);
		cbox.addActionListener(this); 
		
		neubt1.addActionListener(this); 
		neubt2.addActionListener(this);
		
		cbox.setSelectedIndex(0); 
	
		JPanel panel1 = new JPanel (new GridLayout(2,4,3,3)); 
		JPanel panel2 = new JPanel (new GridLayout(1,2,3,3)); 
		
		panel1.add(Num);
		panel1.add(Name);
		panel1.add(Preis);
		panel1.add(Lage);
		panel1.add(tfnum);
		panel1.add(tfnam);
		panel1.add(tfpre);
		panel1.add(cbox);
		
		
		panel2.add(neubt1);
		panel2.add(neubt2);
	
		setLayout (new BorderLayout ()); 
		
		
		this.getContentPane().add(panel2,BorderLayout.SOUTH); 
		this.getContentPane().add(panel1,BorderLayout.CENTER);
		
		this.setTitle(title);
		
		
		
		Point ownerPosition = parent.getLocation();    
		setLocation (ownerPosition.x+200, ownerPosition.y+300);
		
		pack();
		
		setVisible (true); 
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(neubt1)) {  
			addneu () ;
        }
		if(arg0.getSource().equals(neubt2)) { 
			System.out.println("exit");
			setVisible (false);
        }
		
	
	}
private boolean inputOKnum (String text) {
		
		int zahl = Integer.parseInt (text);
		return zahl <= 2147483647;	
	}                               
	
	
	public void addneu () {
	/*
		
			if(inputOKnum(tfnum.getText()))
				tfnum.setBackground(new Color(250, 150, 150));
			if(tfnam.getText().equals(null))
				tfnam.setBackground(new Color(250, 150, 150));
			if(tfpre.getText().equals(null))
				tfpre.setBackground(new Color(250, 150, 150));
			if(tflag.getText().equals(null))
				tflag.setBackground(new Color(250, 150, 150));
			
	
		}*/  
		//else {
		 
		
            int  num = Integer.parseInt(tfnum.getText());     
			String name = tfnam.getText() ;
			double preis = Double.parseDouble(tfpre.getText());
			boolean lage ;
			int index = cbox.getSelectedIndex();               
			   if(index == 0)
				   lage = true ;
			   else
				   lage = false ;
		    Ware zwischenwert = new Ware (name,num,lage,preis) ;  
		    
		    mainframe.warenforlist.add(zwischenwert);            
		    
		    mainframe.getGuilist().setWaren(mainframe.warenforlist); 
		 	    
			setVisible (false);                                      
		}
	
	
	
	
	

}
