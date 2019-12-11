package guilayoutdialog;

import java.io.IOException;



/**
 * Data Access Object f�r die Klasse Studenten.
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
			
			Warenforlist waren = (Warenforlist)obj; //��objת����ƷArrayList
			// Anzahl Studenten speichern:
			out.writeInt(waren.size());     //��������ļ�����ǰд��Ҫ��������ݵ�����  ����֮��Ҫ��ȡ����ʱȷ����ȡ����
			
			// Nun die einzelnen Studenten speichern:
			WareDAO wDAO = new WareDAO (null, out);  //ʵ�������DAO
			
			for (Ware w: waren) {     //����Ʒ����һ��һ������ƷArrayList��������ļ���
				
				wDAO.write(w);
			}
		}
	}
	
	
	public void read (Object obj) throws IOException {
		
		if (in != null) {
			
			Warenforlist waren = (Warenforlist)obj;
			
			// Anzahl Studenten lesen:
			int nWare = in.readInt();               //��ȡ�ļ������ݵ���������֮ǰ���ʱд��ģ�
			
			// Nun die einzelnen Studenten lesen:
			WareDAO wDAO = new WareDAO (in, null);  //�����ȡDAO
			for (int i=0; i<nWare; ++i) {           //����������ȷ����ȡ���� 
				Ware w = new Ware();                //�½�һ���յ���Ʒ����
				wDAO.read(w);                       //��һ���ļ��е����ݸ�ֵ��һ���յ���Ʒ������
				waren.add(w);                       //�������Ʒ���ݼӵ���ƷArrayList ��
			}
		}
	}
	
}
