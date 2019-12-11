package guilayoutdialog;

import java.awt.BorderLayout;     

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;










public class gldBeispiel extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*为了调用gldb.add(dateiNeuPanel) 硬加的，JFrame是窗体的基础，只有用JFrame调用add方法才能把Panel加到窗体上
	 * 所以在类的最前面先 定义 一个 gldBeispiel 方便在后面写的调用
	 * 这种方法可以成功是因为 定义 和 调用 不紧挨在一起，在实际调用之前 gldb 已经实例化了，所以程序不会报错
	 * 例：在这个程序中 一定是gldBeispiel先被实例化 产生窗口，才有可能对JMenuItem 产生动作，然后激发对gldb.add(dateiNeuPanel)*/
	
	static gldBeispiel gldb ;
	
	
	private JMenuBar mb = new JMenuBar () ; //新建菜单横栏 备用
	
	
	private JMenu dateiMenu = new JMenu("Datei"); //新建菜单横栏里选项 备用 显示为“Datei"
	
	private JMenu hilfeMenu = new JMenu ("?"); //新建菜单横栏里选项 备用  显示为”?"
	
	
	private JMenuItem dateoeffnen = new JMenuItem ("Oeffnen"); //新建菜单横栏选项“Datei”的子选项 备用
	private JMenuItem datenew = new JMenuItem ("Neu");         //新建菜单横栏选项“Datei”的子选项 备用
	private JMenuItem speichernunter = new JMenuItem ("Speichern unter");  //新建菜单横栏选项“Datei”的子选项 备用
	private JMenuItem datebeenden = new JMenuItem ("Beenden");  //新建菜单横栏选项“Datei”的子选项 备用
	
	
	private JMenuItem hilfeh = new JMenuItem ("Hilfe");  //新建菜单横栏选项“？”的子选项 备用
	
	
	private JButton add = new JButton ("add");// *            //新建窗口左侧按钮 备用
	private JButton delet = new JButton ("delet");//*         //新建窗口左侧按钮 备用
	private JButton aendern  = new JButton ("aendern");//*    //新建窗口左侧按钮 备用
	private JButton speichern = new JButton ("speichern") ; //*//新建窗口左侧按钮 备用
	
	private guiwarenlist guilist = new guiwarenlist();      //新建 模态MODAL 用来控制窗口右侧列表的显示
	
	
	private JPanel westpanel = new JPanel();    //新建Panel 用于1.承接窗口左侧按钮 2.作为窗口布局的组件
	private JPanel eastpanel = new JPanel ();   //新建Panel 用于1.承接窗口右侧列表 2.作为窗口布局的组件
	
    Warenforlist warenforlist = new Warenforlist(); // package Sichtbarkeit, damit GUIMusiksliste zugreifen kann
	                                                //作为储存数据 在列表中显示数据的重要媒介
	 
	
	
	class MeinWListener extends WindowAdapter { //内部类 窗口监听器 在这里用于控制窗口在“x” 被点击后关闭
		
		void Windowclosing () {
		System.out.println("exit");
		System.exit(0);
		}
		
			
	}
	
    public gldBeispiel (String a ){
	   super( a );
	   
	   this.addWindowListener(new MeinWListener());
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);//不知道啥用
	   
	   this.setJMenuBar(mb); //在窗体上加入菜单栏
	   
	   mb.add(dateiMenu); //在菜单栏上加入菜单选项“Datei”
	   mb.add(hilfeMenu); //在菜单栏上加入菜单选项"?"
	   
	   dateoeffnen.addActionListener(this); //给“Datei” 的四个子选项相互测上动作监听器    动作监听器：是个接口 用于检测按钮是否被按下并设置按下之后执行的动作
	   datenew.addActionListener(this);
	   speichernunter.addActionListener(this);
	   datebeenden.addActionListener(this);
	   
	   dateiMenu.add(dateoeffnen); //把四个子选项加到“Datei”下面
	   dateiMenu.add(datenew);    
	   dateiMenu.add(speichernunter);
	   dateiMenu.addSeparator();   //加一个分割线
	   dateiMenu.add(datebeenden);
	   
	   hilfeh.addActionListener(this); //注册动作监听器
	   hilfeMenu.add(hilfeh);          //把子选项加到“？”下面
	   
	   
	   add.addActionListener(this);          //左侧四个按钮注册动作监听器
	   delet.addActionListener(this);
	   aendern.addActionListener(this);
	   speichern.addActionListener(this);
	   
	   westpanel.setLayout(new GridLayout(4,1));  //设置放置在窗口左侧的Panel的布局  为GridLayout 一列四行
	   westpanel.add(add);                        //在左侧Panel上放置四个按钮
	   westpanel.add(delet);
	   westpanel.add(aendern );
	   westpanel.add(speichern);
	 
	   guilist.setWaren(warenforlist);            //先通过 模态MODAL的setWaren 方法使列表能够在窗口上显示（初始化的过程）
	   eastpanel.add(guilist);                    //在右侧Panel上放置列表
		

	   this.setSize(900, 800);                    //设置窗口大小
	   this.setVisible(true);                     //设置窗口为可见
	   
	  
	   this.add(westpanel,BorderLayout.WEST);     //把左侧Panel按BoderLayout（窗口）的方位放在西边（左边）
	   this.add(guilist,BorderLayout.CENTER);     //把右侧Panel按BoderLayout（窗口）的方位放在中间（看起来像占据了除了西面的所有方向的位置）
		
		   
	   
   }
	
   public static void main(String[] args) { //主方法  实例化窗口  使窗口存在并显示出来
		// TODO Auto-generated method stub
		 gldb = new gldBeispiel("Laden");
	}
	
	
	
	
	
	
	
	public guiwarenlist getGuilist() {   //获取控制列表显示的MODAL的方法
		
	return guilist;
	
}

	@Override   //这一整块是对动作监听器接口中的方法的实现，
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getSource().equals(add)) { //当“add”按钮被按下   会弹出一个添加商品的对话框
			Dialogadd dia = new Dialogadd (this,"Add",this) ;
		}
		
    
		if(arg0.getSource().equals(delet)) {   //当单击选中列表中商品并按下“delet”按钮时 该商品被删除并从列表中消失
			int index = guilist.getSelectedIndex();   //获取选中的商品在商品ArrayLit中的位置
			if(index >= 0 ) {
				guilist.getMyListModel().removeElementAt(index); //在模态MODAL中删除选中的数据(表面上 ，使其不再列表中显示
		        warenforlist.remove(index); //在真正储存商品的商品ArrayList中删除数据
			}
		}
		
		if(arg0.getSource().equals(aendern)) {  //当单击选中列表中商品并按下“aendern”按钮时 弹出一个“andern”窗口
			int index = guilist.getSelectedIndex();
			if(index >= 0 ) {
				DialogshowData show = new DialogshowData (this,"aendern" , this) ;
			}
        }


		if(arg0.getSource().equals(speichern)) { //当“speichern”按钮被按下   会把列表中的数据暂时存储在一个设定好的临时文件里
			
			String dateiName = "Data/voruebergehend.dat";    //临时文件的位置
			
			WarenDAO dao = new WarenDAO (dateiName, true); // WarenDAO用来输入和输出列表数据   在这里用于输出数据并将数据写入临时文件
			try {
				dao.write(warenforlist);
			}
			catch (IOException e) {
				System.out.println (e.getMessage());	  //捕捉程序错误
			}
			dao.close();                                 //关闭WarenDAO以避免出错
			
			guilist.setWaren(warenforlist);              //刷新列表显示  使列表显示与商品ArrayList中的数据同步
	         
		}
		
		
		
		if(arg0.getSource().equals(dateoeffnen)) { //当菜单中“oeffnen”按钮被按下   打开文件选择器Filechooser
			dateiOeffnen() ;
		}
		
		if( arg0.getSource().equals(datenew)) { //把列表显示和商品ArrayList 中的数据全部删除
			dateineu();	
			
		}
		
	
		if(arg0.getSource().equals( speichernunter )) {  //另存为
			JFileChooser chooser = new JFileChooser();

		    int returnVal = chooser.showOpenDialog(null);

		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       String dateiName = chooser.getSelectedFile().getAbsolutePath() ;
		    
			
					WarenDAO dao = new WarenDAO (dateiName, true); // 謋fnen zum Schreiben
			try {
				dao.write(warenforlist);
			}
			catch (IOException e) {
				System.out.println (e.getMessage());	
			}
			dao.close();
			
			guilist.setWaren(warenforlist);
		    } 
		}
		
		
		if( arg0.getSource().equals(datebeenden)) { // 关闭窗口
			System.out.println("exit");
			System.exit(0);
		}
		

	}
	
      public void dateineu () {
	
	
	    warenforlist.removeAll(warenforlist) ; //把商品ArrayList中的数据全部移除
	    guilist.setWaren(warenforlist);        //用模态MODAL刷新列表显示
	
     }
	

	
      public void dateiOeffnen(){
	    JFileChooser chooser = new JFileChooser();

	    int returnVal = chooser.showOpenDialog(null);

	    if(returnVal == JFileChooser.APPROVE_OPTION) { //获取所选文件的绝对路径和文件名
	       String dateiName = chooser.getSelectedFile().getAbsolutePath() ;
	    
	  
		WarenDAO dao2 = new WarenDAO (dateiName, false); // 謋fnen zum Lesen
		try {
			dao2.read(warenforlist);
		}
		catch (IOException e) {
			System.out.println (e.getMessage());			
		}
		dao2.close();
		
		guilist.setWaren(warenforlist);
		
		for (Ware w: warenforlist) {
			System.out.println (w.getName());
			System.out.println (w.getNummer());
			System.out.println (w.isLage());
			System.out.println (w.getPreis());
			System.out.println("-------"); //*
		}
	    }
	 
}
 
}