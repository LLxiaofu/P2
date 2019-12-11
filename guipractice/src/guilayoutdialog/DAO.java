package guilayoutdialog;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;




/**
 * Oberklasse f�r alle Data Access Object Klassen.
 *
 */
public abstract class DAO { //DAOӵ���������� ���������� �� ���������

	protected DataInputStream in;
	protected DataOutputStream out;
	
	
	/**
	 * Konstruktor um das Data Access Object mit einem Dateinamen zu initialisieren.
	 * ͨ���ļ��� ʵ�����Ĺ�����
	 * @param dateiName Dateiname//dateiName Ϊ���ݵ�����
	 * @param openForWrite true wenn geschrieben werden soll//openForWrite ��Ӧ��д������ʱ��Ϊ��
	 */
	public DAO (String dateiName, boolean openForWrite) {   //��һ��������  ͨ���ļ��� �� һ������ȷ��DAO��������ݻ����������ݵĲ������� ����DAO

		try {
			if (openForWrite) { //���Ϊtrue���½�һ������� 
				//���ļ�+ʵ����������ݵ�������
				out =  new DataOutputStream (new FileOutputStream(dateiName)); 
			}
			else { //���Ϊfalse���½�һ������������ȡ����
				//���ļ�+ʵ������ȡ���ݵ�������
				in = new DataInputStream (new FileInputStream(dateiName));
			}
		}
		catch (IOException e) {
			System.out.println (e.getMessage());	//������Ϣ				
		}
	}
	

	/**
	 * Konstruktor um das Data Access Object mit bereits vorhandenen Streams zu initialisieren.
	 * ͨ�����е��������ȡ������ ʵ�����Ĺ�����
	 * @param in InputStream oder null
	 * @param out OutputStream oder null
	 */
	public DAO (DataInputStream in, DataOutputStream out) { //������������Ҫ��һ��Ϊnull
		
		this.in = in; //��ȡ������
		this.out = out; //���������
	}
	

	/**
	 * Schlie�en der zugeordneten Streams.
	 */
	public void close () { //��ʱ�رն�ȡ,�������
		
		try {
			if (in != null) in.close(); 
			if (out != null) out.close();
		}
		catch (IOException e) {
			
		}
	}
	
	/**
	 * Schreiben der Daten eines Objekts.
	 * Muss von abgeleiteten Data Object Klassen implementiert werden.
	 * 
	 * @param obj Referenz auf Objekt das die Daten enth�lt.
	 * @throws IOException
	 */
	public abstract void write (Object obj) throws IOException; //�������

	/**
	 * Lesen der Daten eines Objekts.
	 * Muss von abgeleiteten Data Object Klassen implementiert werden.
	 * 
	 * @param obj Referenz auf Objekt das die Daten enth�lt.
	 * @throws IOException
	 */
	public abstract void read (Object obj) throws IOException;//��ȡ����

}