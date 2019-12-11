package guilayoutdialog;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;




/**
 * Oberklasse f黵 alle Data Access Object Klassen.
 *
 */
public abstract class DAO { //DAO拥有两个属性 数据输入流 和 数据输出流

	protected DataInputStream in;
	protected DataOutputStream out;
	
	
	/**
	 * Konstruktor um das Data Access Object mit einem Dateinamen zu initialisieren.
	 * 通过文件名 实例化的构造器
	 * @param dateiName Dateiname//dateiName 为数据的名字
	 * @param openForWrite true wenn geschrieben werden soll//openForWrite 在应该写入数据时设为真
	 */
	public DAO (String dateiName, boolean openForWrite) {   //第一个构造器  通过文件名 和 一个用来确定DAO是输出数据还是输入数据的布尔函数 构造DAO

		try {
			if (openForWrite) { //如果为true就新建一个输出流 
				//打开文件+实例化输出数据的数据流
				out =  new DataOutputStream (new FileOutputStream(dateiName)); 
			}
			else { //如果为false就新建一个输入流（读取流）
				//打开文件+实例化读取数据的数据流
				in = new DataInputStream (new FileInputStream(dateiName));
			}
		}
		catch (IOException e) {
			System.out.println (e.getMessage());	//报错信息				
		}
	}
	

	/**
	 * Konstruktor um das Data Access Object mit bereits vorhandenen Streams zu initialisieren.
	 * 通过已有的输出，读取数据流 实例化的构造器
	 * @param in InputStream oder null
	 * @param out OutputStream oder null
	 */
	public DAO (DataInputStream in, DataOutputStream out) { //这两个数据总要有一个为null
		
		this.in = in; //读取数据流
		this.out = out; //输出数据流
	}
	

	/**
	 * Schlie遝n der zugeordneten Streams.
	 */
	public void close () { //及时关闭读取,输出进程
		
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
	 * @param obj Referenz auf Objekt das die Daten enth鋖t.
	 * @throws IOException
	 */
	public abstract void write (Object obj) throws IOException; //输出方法

	/**
	 * Lesen der Daten eines Objekts.
	 * Muss von abgeleiteten Data Object Klassen implementiert werden.
	 * 
	 * @param obj Referenz auf Objekt das die Daten enth鋖t.
	 * @throws IOException
	 */
	public abstract void read (Object obj) throws IOException;//读取方法

}