package guilayoutdialog;

import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class guiwarenlist extends JList<String> { //控制列表显示的模态MODAL


	private DefaultListModel<String> myListModel = new DefaultListModel<String> ();  //新建DefaultListModel<String>作为属性
	
	/* Hier definieren wir einen Eventhandler, um auf Mausereignisse zu reagieren.
	 */
	private class ListClickHandler extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			
			// Doppelklick mit linker Taste auf Liste?
			if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) { //e.getButton() == MouseEvent.BUTTON1 说明点击了左键
				// Ein vorhandener Student wird bearbeitet:
				int index = getSelectedIndex();
				if (index >= 0)	{
				//	String name = myListModel.get (index);
				//	JOptionPane.showMessageDialog(guiwarenlist.this, "Doppelklick auf " + name);
				//这块还要修改	
					
				}
			}
			
			
			
		}
		
	}


	public guiwarenlist () { 
		
		
		// Model und Liste verbinden:  把DefaultListModel<String>和Arraylist连接在一起
		setModel (myListModel);
		// Maushandler verbinden, um auf Doppelklick zu reagieren:
		addMouseListener (new ListClickHandler());  //注册鼠标行动监视器
	}
	
	public DefaultListModel<String> getMyListModel() {
		return myListModel;
	}

	public void setWaren (ArrayList<Ware> warenlist) { //用模态MODAL刷新列表显示
		
		// Initialisierung der Studentenliste
		myListModel.removeAllElements();               //先把列表显示里所有数据移除
		int nWare = warenlist.size() ;                 
		for (int i = 0 ; i < nWare ; ++i) {  
			
			myListModel.addElement(warenlist.get(i).getName());   //重新把商品ArrayList中的商品Name数据放到列表显示中
		}
		
	}
}
