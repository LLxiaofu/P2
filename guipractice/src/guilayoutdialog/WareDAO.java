package guilayoutdialog;

import java.io.DataInputStream; 
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Data Access Object f黵 die Klasse Student.
 */
public class WareDAO extends DAO {

	
	/**
	 * Konstruktor um das Data Access Object mit einem Dateinamen zu initialisieren.
	 * 
	 * @param dateiName Dateiname
	 * @param openForWrite true wenn geschrieben werden soll
	 */
	public WareDAO (String dateiName, boolean openForWrite) {
		
		super (dateiName, openForWrite);
	}
	
	
	/**
	 * Konstruktor um das Data Access Object mit bereits vorhandenen Streams zu initialisieren.
	 * 
	 * @param in InputStream oder null
	 * @param out OutputStream oder null
	 */
	public WareDAO (DataInputStream in, DataOutputStream out) {
		
		super (in, out);
	}
	
	
	/**
	 * Daten des 黚ergebenen Student-Objekts schreiben. Das Data Access Object muss dazu zum
	 * Schreiben bereit sein.
	 * 
	 * @param s Referenz auf Student-Objekt
	 * @throws IOException
	 */
	public void write (Object obj) throws IOException { //输出方法
		
		if (out != null) {             //当输出流不为null时 
			
			Ware w = (Ware)obj;
			
			out.writeUTF	(w.getName()); //获取Obj的数据并写入文件（输出）
			out.writeInt	(w.getNummer());
			out.writeBoolean(w.isLage());
			out.writeDouble	(w.getPreis());
		}
	}
	
	
	/**
	 * Daten des 黚ergebenen Student-Objekts lesen. Das Data Access Objekt muss dazu zum
	 * Lesen bereit sein.
	 * 
	 * @param s Referenz auf Student-Objekt
	 * @throws IOException
	 */
	public void read (Object obj) throws IOException {
		
		if (in != null) {      //当读取数据流不为null
			
			Ware w  = (Ware)obj;
			
			w.setName		(in.readUTF());  //使用读取数据流读取文件中的数据，再通过Ware的方法把数据读取到Ware中
			w.setNummer		(in.readInt());
			w.setLage	(in.readBoolean());
			w.setPreis		(in.readDouble());
		}
	}
}
