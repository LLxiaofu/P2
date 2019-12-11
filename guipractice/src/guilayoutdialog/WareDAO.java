package guilayoutdialog;

import java.io.DataInputStream; 
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Data Access Object f�r die Klasse Student.
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
	 * Daten des �bergebenen Student-Objekts schreiben. Das Data Access Object muss dazu zum
	 * Schreiben bereit sein.
	 * 
	 * @param s Referenz auf Student-Objekt
	 * @throws IOException
	 */
	public void write (Object obj) throws IOException { //�������
		
		if (out != null) {             //���������Ϊnullʱ 
			
			Ware w = (Ware)obj;
			
			out.writeUTF	(w.getName()); //��ȡObj�����ݲ�д���ļ��������
			out.writeInt	(w.getNummer());
			out.writeBoolean(w.isLage());
			out.writeDouble	(w.getPreis());
		}
	}
	
	
	/**
	 * Daten des �bergebenen Student-Objekts lesen. Das Data Access Objekt muss dazu zum
	 * Lesen bereit sein.
	 * 
	 * @param s Referenz auf Student-Objekt
	 * @throws IOException
	 */
	public void read (Object obj) throws IOException {
		
		if (in != null) {      //����ȡ��������Ϊnull
			
			Ware w  = (Ware)obj;
			
			w.setName		(in.readUTF());  //ʹ�ö�ȡ��������ȡ�ļ��е����ݣ���ͨ��Ware�ķ��������ݶ�ȡ��Ware��
			w.setNummer		(in.readInt());
			w.setLage	(in.readBoolean());
			w.setPreis		(in.readDouble());
		}
	}
}
