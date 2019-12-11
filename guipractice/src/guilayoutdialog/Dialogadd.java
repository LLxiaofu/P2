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
	
	
	private JLabel Num = new JLabel ("Nummer"); //新建四个标签
	private JLabel Name = new JLabel ("Name");
	private JLabel Preis = new JLabel ("Preis");
	private JLabel Lage = new JLabel ("Lage");
	
	private JTextField tfnum = new JTextField (10);  //新建三个文本框
	private JTextField tfnam = new JTextField (10);
	private JTextField tfpre = new JTextField (10);
	
	private JComboBox<String> cbox	= new JComboBox<String> (texte); //新建一个有“true”和“false”两个选项的cbox
	
	private JButton neubt1 = new JButton ("Add");      //新建两个按钮
	private JButton neubt2 = new JButton ("Abbrechen");
	
	public Dialogadd(Window parent, String title , gldBeispiel a ) { //构造器
		//Window parent 用来确定对话框在哪个窗口上显示
		//gldBeispiel a 供引用
		
		
		this.mainframe = a ;
		
		tfnum.addActionListener(this); //注册动作监听器
		tfnam.addActionListener(this);
		tfpre.addActionListener(this);
		cbox.addActionListener(this); //cbox是否需要监听器？
		
		neubt1.addActionListener(this); 
		neubt2.addActionListener(this);
		
		cbox.setSelectedIndex(0); //设定cbox初始选项为“true”
	
		JPanel panel1 = new JPanel (new GridLayout(2,4,3,3)); //新建Panel 2行4列 上下间距为3
		JPanel panel2 = new JPanel (new GridLayout(1,2,3,3)); //新建Panel 1行2列 上下间距为3
		
		panel1.add(Num);//把部件放置在Panel上
		panel1.add(Name);
		panel1.add(Preis);
		panel1.add(Lage);
		panel1.add(tfnum);
		panel1.add(tfnam);
		panel1.add(tfpre);
		panel1.add(cbox);
		
		
		panel2.add(neubt1);
		panel2.add(neubt2);
	
		setLayout (new BorderLayout ()); //设定对话框窗口布局为BorderLayout
		
		
		this.getContentPane().add(panel2,BorderLayout.SOUTH); //把panel2放在下方
		this.getContentPane().add(panel1,BorderLayout.CENTER);//把panel1放在上方（看起来
		
		this.setTitle(title);
		
		
		
		Point ownerPosition = parent.getLocation();    //使对话框窗口弹出时在主窗口相对中间的地方
		setLocation (ownerPosition.x+200, ownerPosition.y+300);
		
		pack();  //使所有部件都为最合适的大小
		
		setVisible (true); //使窗口可见
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(neubt1)) {  //添加新数据
			addneu () ;
        }
		if(arg0.getSource().equals(neubt2)) { //退出对话框窗口
			System.out.println("exit");
			setVisible (false);
        }
		
	
	}
private boolean inputOKnum (String text) {
		
		int zahl = Integer.parseInt (text);
		return zahl <= 2147483647;	// true wenn zahl kleiner als 100. So soll es sein.
	}                               //还要修改
	
	
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
			
	
		}*/  //还要修改
		//else {
		 
		
            int  num = Integer.parseInt(tfnum.getText());      //获取在文本框中输入的数据
			String name = tfnam.getText() ;
			double preis = Double.parseDouble(tfpre.getText());
			boolean lage ;
			int index = cbox.getSelectedIndex();               //获取在cbox中选择的选项
			   if(index == 0)
				   lage = true ;
			   else
				   lage = false ;
		    Ware zwischenwert = new Ware (name,num,lage,preis) ;   //把这些数据放到一个商品数据里
		    
		    mainframe.warenforlist.add(zwischenwert);             //把这个商品数据加入商品ArrayList 
		    
		    mainframe.getGuilist().setWaren(mainframe.warenforlist); //刷新列表显示 使新家的数据也显示在列表显示中
		 	    
			setVisible (false);                                      //使对话框窗口不可见（视觉上关闭了
		}
	
	
	
	
	

}
