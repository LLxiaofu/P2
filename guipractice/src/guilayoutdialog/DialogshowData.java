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



public class DialogshowData extends JDialog implements ActionListener { //这个
	

	
	private gldBeispiel mainframe ;

	
    private String[] texte = { "true", "false" };
	
	
	private JLabel Num = new JLabel ("Nummer");
	private JLabel Name = new JLabel ("Name");
	private JLabel Preis = new JLabel ("Preis");
	private JLabel Lage = new JLabel ("Lage");
	
	private JTextField tfnum = new JTextField (10);
	private JTextField tfnam = new JTextField (10);
	private JTextField tfpre = new JTextField (10);
	
	private JComboBox<String> cbox	= new JComboBox<String> (texte);
	
	private JButton neubt1 = new JButton ("aendern");
	private JButton neubt2 = new JButton ("Abbrechen");
	
	
	
	public DialogshowData(Window parent, String title , gldBeispiel a ) {
		
		this.mainframe = a ;
		
		int select =  mainframe.getGuilist().getSelectedIndex() ;
		
		tfnum.addActionListener(this);
		tfnam.addActionListener(this);
		tfpre.addActionListener(this);
		cbox.addActionListener(this); //cbox是否需要监听器
		
		neubt1.addActionListener(this);
		neubt2.addActionListener(this);
		
		cbox.setSelectedIndex(0);
	    
	    
		tfnum.setText(mainframe.warenforlist.get(select).getNummer()+"");
		tfnam.setText(mainframe.warenforlist.get(select).getName());
		tfpre.setText(mainframe.warenforlist.get(select).getPreis()+"");
		if(mainframe.warenforlist.get(select).isLage() == true)
			   cbox.setSelectedIndex(0);    
		   else
			   cbox.setSelectedIndex(1); 
		
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
			aendern();
        }
		if(arg0.getSource().equals(neubt2)) {
			System.out.println("exit");
			setVisible (false);
        }
		
	
	}

	
	
	public void aendern () {
	
		 
		    int select =  mainframe.getGuilist().getSelectedIndex() ;
            
		    
		   
			String name = tfnam.getText() ;
			int  num = Integer.parseInt(tfnum.getText());
			
			boolean lage ;
			int index = cbox.getSelectedIndex();
			   if(index == 0)
				   lage = true ;
			   else
				   lage = false ;
			   
			double preis = Double.parseDouble(tfpre.getText());
		    
			Ware zwischenwert = new Ware (name,num,lage,preis) ;
		    
		   
		    
		    mainframe.warenforlist.set(select, zwischenwert);   //实际在ArrayList 上更改数据
		    
		    mainframe.getGuilist().setWaren(mainframe.warenforlist); //重新刷新首页布局
		 
			setVisible (false);   
		}
	
	
	
	
	

}
