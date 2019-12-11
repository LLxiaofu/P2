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
	

	
	private gldBeispiel mainframe ; //��gldb��Ϊһ������  �����淽������

	
    private String[] texte = { "true", "false" }; //cbox�е�����ѡ��
	
	
	private JLabel Num = new JLabel ("Nummer"); //�½��ĸ���ǩ
	private JLabel Name = new JLabel ("Name");
	private JLabel Preis = new JLabel ("Preis");
	private JLabel Lage = new JLabel ("Lage");
	
	private JTextField tfnum = new JTextField (10);  //�½������ı���
	private JTextField tfnam = new JTextField (10);
	private JTextField tfpre = new JTextField (10);
	
	private JComboBox<String> cbox	= new JComboBox<String> (texte); //�½�һ���С�true���͡�false������ѡ���cbox
	
	private JButton neubt1 = new JButton ("Add");      //�½�������ť
	private JButton neubt2 = new JButton ("Abbrechen");
	
	public Dialogadd(Window parent, String title , gldBeispiel a ) { //������
		//Window parent ����ȷ���Ի������ĸ���������ʾ
		//gldBeispiel a ������
		
		
		this.mainframe = a ;
		
		tfnum.addActionListener(this); //ע�ᶯ��������
		tfnam.addActionListener(this);
		tfpre.addActionListener(this);
		cbox.addActionListener(this); //cbox�Ƿ���Ҫ��������
		
		neubt1.addActionListener(this); 
		neubt2.addActionListener(this);
		
		cbox.setSelectedIndex(0); //�趨cbox��ʼѡ��Ϊ��true��
	
		JPanel panel1 = new JPanel (new GridLayout(2,4,3,3)); //�½�Panel 2��4�� ���¼��Ϊ3
		JPanel panel2 = new JPanel (new GridLayout(1,2,3,3)); //�½�Panel 1��2�� ���¼��Ϊ3
		
		panel1.add(Num);//�Ѳ���������Panel��
		panel1.add(Name);
		panel1.add(Preis);
		panel1.add(Lage);
		panel1.add(tfnum);
		panel1.add(tfnam);
		panel1.add(tfpre);
		panel1.add(cbox);
		
		
		panel2.add(neubt1);
		panel2.add(neubt2);
	
		setLayout (new BorderLayout ()); //�趨�Ի��򴰿ڲ���ΪBorderLayout
		
		
		this.getContentPane().add(panel2,BorderLayout.SOUTH); //��panel2�����·�
		this.getContentPane().add(panel1,BorderLayout.CENTER);//��panel1�����Ϸ���������
		
		this.setTitle(title);
		
		
		
		Point ownerPosition = parent.getLocation();    //ʹ�Ի��򴰿ڵ���ʱ������������м�ĵط�
		setLocation (ownerPosition.x+200, ownerPosition.y+300);
		
		pack();  //ʹ���в�����Ϊ����ʵĴ�С
		
		setVisible (true); //ʹ���ڿɼ�
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(neubt1)) {  //���������
			addneu () ;
        }
		if(arg0.getSource().equals(neubt2)) { //�˳��Ի��򴰿�
			System.out.println("exit");
			setVisible (false);
        }
		
	
	}
private boolean inputOKnum (String text) {
		
		int zahl = Integer.parseInt (text);
		return zahl <= 2147483647;	// true wenn zahl kleiner als 100. So soll es sein.
	}                               //��Ҫ�޸�
	
	
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
			
	
		}*/  //��Ҫ�޸�
		//else {
		 
		
            int  num = Integer.parseInt(tfnum.getText());      //��ȡ���ı��������������
			String name = tfnam.getText() ;
			double preis = Double.parseDouble(tfpre.getText());
			boolean lage ;
			int index = cbox.getSelectedIndex();               //��ȡ��cbox��ѡ���ѡ��
			   if(index == 0)
				   lage = true ;
			   else
				   lage = false ;
		    Ware zwischenwert = new Ware (name,num,lage,preis) ;   //����Щ���ݷŵ�һ����Ʒ������
		    
		    mainframe.warenforlist.add(zwischenwert);             //�������Ʒ���ݼ�����ƷArrayList 
		    
		    mainframe.getGuilist().setWaren(mainframe.warenforlist); //ˢ���б���ʾ ʹ�¼ҵ�����Ҳ��ʾ���б���ʾ��
		 	    
			setVisible (false);                                      //ʹ�Ի��򴰿ڲ��ɼ����Ӿ��Ϲر���
		}
	
	
	
	
	

}
