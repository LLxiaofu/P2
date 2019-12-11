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

	/*Ϊ�˵���gldb.add(dateiNeuPanel) Ӳ�ӵģ�JFrame�Ǵ���Ļ�����ֻ����JFrame����add�������ܰ�Panel�ӵ�������
	 * �����������ǰ���� ���� һ�� gldBeispiel �����ں���д�ĵ���
	 * ���ַ������Գɹ�����Ϊ ���� �� ���� ��������һ����ʵ�ʵ���֮ǰ gldb �Ѿ�ʵ�����ˣ����Գ��򲻻ᱨ��
	 * ��������������� һ����gldBeispiel�ȱ�ʵ���� �������ڣ����п��ܶ�JMenuItem ����������Ȼ�󼤷���gldb.add(dateiNeuPanel)*/
	
	static gldBeispiel gldb ;
	
	
	private JMenuBar mb = new JMenuBar () ; //�½��˵����� ����
	
	
	private JMenu dateiMenu = new JMenu("Datei"); //�½��˵�������ѡ�� ���� ��ʾΪ��Datei"
	
	private JMenu hilfeMenu = new JMenu ("?"); //�½��˵�������ѡ�� ����  ��ʾΪ��?"
	
	
	private JMenuItem dateoeffnen = new JMenuItem ("Oeffnen"); //�½��˵�����ѡ�Datei������ѡ�� ����
	private JMenuItem datenew = new JMenuItem ("Neu");         //�½��˵�����ѡ�Datei������ѡ�� ����
	private JMenuItem speichernunter = new JMenuItem ("Speichern unter");  //�½��˵�����ѡ�Datei������ѡ�� ����
	private JMenuItem datebeenden = new JMenuItem ("Beenden");  //�½��˵�����ѡ�Datei������ѡ�� ����
	
	
	private JMenuItem hilfeh = new JMenuItem ("Hilfe");  //�½��˵�����ѡ���������ѡ�� ����
	
	
	private JButton add = new JButton ("add");// *            //�½�������ఴť ����
	private JButton delet = new JButton ("delet");//*         //�½�������ఴť ����
	private JButton aendern  = new JButton ("aendern");//*    //�½�������ఴť ����
	private JButton speichern = new JButton ("speichern") ; //*//�½�������ఴť ����
	
	private guiwarenlist guilist = new guiwarenlist();      //�½� ģ̬MODAL �������ƴ����Ҳ��б����ʾ
	
	
	private JPanel westpanel = new JPanel();    //�½�Panel ����1.�нӴ�����ఴť 2.��Ϊ���ڲ��ֵ����
	private JPanel eastpanel = new JPanel ();   //�½�Panel ����1.�нӴ����Ҳ��б� 2.��Ϊ���ڲ��ֵ����
	
    Warenforlist warenforlist = new Warenforlist(); // package Sichtbarkeit, damit GUIMusiksliste zugreifen kann
	                                                //��Ϊ�������� ���б�����ʾ���ݵ���Ҫý��
	 
	
	
	class MeinWListener extends WindowAdapter { //�ڲ��� ���ڼ����� ���������ڿ��ƴ����ڡ�x�� �������ر�
		
		void Windowclosing () {
		System.out.println("exit");
		System.exit(0);
		}
		
			
	}
	
    public gldBeispiel (String a ){
	   super( a );
	   
	   this.addWindowListener(new MeinWListener());
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);//��֪��ɶ��
	   
	   this.setJMenuBar(mb); //�ڴ����ϼ���˵���
	   
	   mb.add(dateiMenu); //�ڲ˵����ϼ���˵�ѡ�Datei��
	   mb.add(hilfeMenu); //�ڲ˵����ϼ���˵�ѡ��"?"
	   
	   dateoeffnen.addActionListener(this); //����Datei�� ���ĸ���ѡ���໥���϶���������    �������������Ǹ��ӿ� ���ڼ�ⰴť�Ƿ񱻰��²����ð���֮��ִ�еĶ���
	   datenew.addActionListener(this);
	   speichernunter.addActionListener(this);
	   datebeenden.addActionListener(this);
	   
	   dateiMenu.add(dateoeffnen); //���ĸ���ѡ��ӵ���Datei������
	   dateiMenu.add(datenew);    
	   dateiMenu.add(speichernunter);
	   dateiMenu.addSeparator();   //��һ���ָ���
	   dateiMenu.add(datebeenden);
	   
	   hilfeh.addActionListener(this); //ע�ᶯ��������
	   hilfeMenu.add(hilfeh);          //����ѡ��ӵ�����������
	   
	   
	   add.addActionListener(this);          //����ĸ���ťע�ᶯ��������
	   delet.addActionListener(this);
	   aendern.addActionListener(this);
	   speichern.addActionListener(this);
	   
	   westpanel.setLayout(new GridLayout(4,1));  //���÷����ڴ�������Panel�Ĳ���  ΪGridLayout һ������
	   westpanel.add(add);                        //�����Panel�Ϸ����ĸ���ť
	   westpanel.add(delet);
	   westpanel.add(aendern );
	   westpanel.add(speichern);
	 
	   guilist.setWaren(warenforlist);            //��ͨ�� ģ̬MODAL��setWaren ����ʹ�б��ܹ��ڴ�������ʾ����ʼ���Ĺ��̣�
	   eastpanel.add(guilist);                    //���Ҳ�Panel�Ϸ����б�
		

	   this.setSize(900, 800);                    //���ô��ڴ�С
	   this.setVisible(true);                     //���ô���Ϊ�ɼ�
	   
	  
	   this.add(westpanel,BorderLayout.WEST);     //�����Panel��BoderLayout�����ڣ��ķ�λ�������ߣ���ߣ�
	   this.add(guilist,BorderLayout.CENTER);     //���Ҳ�Panel��BoderLayout�����ڣ��ķ�λ�����м䣨��������ռ���˳�����������з����λ�ã�
		
		   
	   
   }
	
   public static void main(String[] args) { //������  ʵ��������  ʹ���ڴ��ڲ���ʾ����
		// TODO Auto-generated method stub
		 gldb = new gldBeispiel("Laden");
	}
	
	
	
	
	
	
	
	public guiwarenlist getGuilist() {   //��ȡ�����б���ʾ��MODAL�ķ���
		
	return guilist;
	
}

	@Override   //��һ�����ǶԶ����������ӿ��еķ�����ʵ�֣�
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getSource().equals(add)) { //����add����ť������   �ᵯ��һ�������Ʒ�ĶԻ���
			Dialogadd dia = new Dialogadd (this,"Add",this) ;
		}
		
    
		if(arg0.getSource().equals(delet)) {   //������ѡ���б�����Ʒ�����¡�delet����ťʱ ����Ʒ��ɾ�������б�����ʧ
			int index = guilist.getSelectedIndex();   //��ȡѡ�е���Ʒ����ƷArrayLit�е�λ��
			if(index >= 0 ) {
				guilist.getMyListModel().removeElementAt(index); //��ģ̬MODAL��ɾ��ѡ�е�����(������ ��ʹ�䲻���б�����ʾ
		        warenforlist.remove(index); //������������Ʒ����ƷArrayList��ɾ������
			}
		}
		
		if(arg0.getSource().equals(aendern)) {  //������ѡ���б�����Ʒ�����¡�aendern����ťʱ ����һ����andern������
			int index = guilist.getSelectedIndex();
			if(index >= 0 ) {
				DialogshowData show = new DialogshowData (this,"aendern" , this) ;
			}
        }


		if(arg0.getSource().equals(speichern)) { //����speichern����ť������   ����б��е�������ʱ�洢��һ���趨�õ���ʱ�ļ���
			
			String dateiName = "Data/voruebergehend.dat";    //��ʱ�ļ���λ��
			
			WarenDAO dao = new WarenDAO (dateiName, true); // WarenDAO�������������б�����   ����������������ݲ�������д����ʱ�ļ�
			try {
				dao.write(warenforlist);
			}
			catch (IOException e) {
				System.out.println (e.getMessage());	  //��׽�������
			}
			dao.close();                                 //�ر�WarenDAO�Ա������
			
			guilist.setWaren(warenforlist);              //ˢ���б���ʾ  ʹ�б���ʾ����ƷArrayList�е�����ͬ��
	         
		}
		
		
		
		if(arg0.getSource().equals(dateoeffnen)) { //���˵��С�oeffnen����ť������   ���ļ�ѡ����Filechooser
			dateiOeffnen() ;
		}
		
		if( arg0.getSource().equals(datenew)) { //���б���ʾ����ƷArrayList �е�����ȫ��ɾ��
			dateineu();	
			
		}
		
	
		if(arg0.getSource().equals( speichernunter )) {  //���Ϊ
			JFileChooser chooser = new JFileChooser();

		    int returnVal = chooser.showOpenDialog(null);

		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       String dateiName = chooser.getSelectedFile().getAbsolutePath() ;
		    
			
					WarenDAO dao = new WarenDAO (dateiName, true); // �ffnen zum Schreiben
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
		
		
		if( arg0.getSource().equals(datebeenden)) { // �رմ���
			System.out.println("exit");
			System.exit(0);
		}
		

	}
	
      public void dateineu () {
	
	
	    warenforlist.removeAll(warenforlist) ; //����ƷArrayList�е�����ȫ���Ƴ�
	    guilist.setWaren(warenforlist);        //��ģ̬MODALˢ���б���ʾ
	
     }
	

	
      public void dateiOeffnen(){
	    JFileChooser chooser = new JFileChooser();

	    int returnVal = chooser.showOpenDialog(null);

	    if(returnVal == JFileChooser.APPROVE_OPTION) { //��ȡ��ѡ�ļ��ľ���·�����ļ���
	       String dateiName = chooser.getSelectedFile().getAbsolutePath() ;
	    
	  
		WarenDAO dao2 = new WarenDAO (dateiName, false); // �ffnen zum Lesen
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