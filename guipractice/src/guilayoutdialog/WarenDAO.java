package guilayoutdialog;

import java.io.IOException;



/**
 * Data Access Object f黵 die Klasse Studenten.
 */
public class WarenDAO  extends DAO {
	
	
	/**
	 * Konstruktor um das Data Access Object mit einem Dateinamen zu initialisieren.
	 * 
	 * @param dateiName Dateiname
	 * @param openForWrite true wenn geschrieben werden soll
	 */
	public WarenDAO (String dateiName, boolean openForWrite) {

		super (dateiName, openForWrite);
	}
	
	
	public void write (Object obj) throws IOException {
		
		if (out != null) {
			
			Warenforlist waren = (Warenforlist)obj; //把obj转成商品ArrayList
			// Anzahl Studenten speichern:
			out.writeInt(waren.size());     //在输出的文件中提前写入要输出的数据的数量  方便之后要读取数据时确定读取次数
			
			// Nun die einzelnen Studenten speichern:
			WareDAO wDAO = new WareDAO (null, out);  //实例化输出DAO
			
			for (Ware w: waren) {     //把商品数据一个一个从商品ArrayList中输出到文件里
				
				wDAO.write(w);
			}
		}
	}
	
	
	public void read (Object obj) throws IOException {
		
		if (in != null) {
			
			Warenforlist waren = (Warenforlist)obj;
			
			// Anzahl Studenten lesen:
			int nWare = in.readInt();               //读取文件中数据的数量（在之前输出时写入的）
			
			// Nun die einzelnen Studenten lesen:
			WareDAO wDAO = new WareDAO (in, null);  //构造读取DAO
			for (int i=0; i<nWare; ++i) {           //按数据数量确定读取次数 
				Ware w = new Ware();                //新建一个空的商品数据
				wDAO.read(w);                       //把一个文件中的数据赋值到一个空的商品数据里
				waren.add(w);                       //把这个商品数据加到商品ArrayList 中
			}
		}
	}
	
}
