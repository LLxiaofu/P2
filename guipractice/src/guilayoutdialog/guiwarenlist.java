package guilayoutdialog;

import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class guiwarenlist extends JList<String> { //�����б���ʾ��ģ̬MODAL


	private DefaultListModel<String> myListModel = new DefaultListModel<String> ();  //�½�DefaultListModel<String>��Ϊ����
	
	/* Hier definieren wir einen Eventhandler, um auf Mausereignisse zu reagieren.
	 */
	private class ListClickHandler extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			
			// Doppelklick mit linker Taste auf Liste?
			if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) { //e.getButton() == MouseEvent.BUTTON1 ˵����������
				// Ein vorhandener Student wird bearbeitet:
				int index = getSelectedIndex();
				if (index >= 0)	{
				//	String name = myListModel.get (index);
				//	JOptionPane.showMessageDialog(guiwarenlist.this, "Doppelklick auf " + name);
				//��黹Ҫ�޸�	
					
				}
			}
			
			
			
		}
		
	}


	public guiwarenlist () { 
		
		
		// Model und Liste verbinden:  ��DefaultListModel<String>��Arraylist������һ��
		setModel (myListModel);
		// Maushandler verbinden, um auf Doppelklick zu reagieren:
		addMouseListener (new ListClickHandler());  //ע������ж�������
	}
	
	public DefaultListModel<String> getMyListModel() {
		return myListModel;
	}

	public void setWaren (ArrayList<Ware> warenlist) { //��ģ̬MODALˢ���б���ʾ
		
		// Initialisierung der Studentenliste
		myListModel.removeAllElements();               //�Ȱ��б���ʾ�����������Ƴ�
		int nWare = warenlist.size() ;                 
		for (int i = 0 ; i < nWare ; ++i) {  
			
			myListModel.addElement(warenlist.get(i).getName());   //���°���ƷArrayList�е���ƷName���ݷŵ��б���ʾ��
		}
		
	}
}
