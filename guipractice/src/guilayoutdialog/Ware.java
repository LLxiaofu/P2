package guilayoutdialog;

public class Ware {
	
	private String Name ;
	private int Nummer ;
	private boolean Lage ;
	private double Preis ;
	
	public Ware ( String name ,int num , boolean lage ,double preis ) {
		this.Nummer = num ;
		this.Name = name ;
		this.Preis = preis ;
		this.Lage  = lage ;		
	}

	public Ware() {
		// TODO Auto-generated constructor stub
	}

	public int getNummer() {
		return Nummer;
	}

	public void setNummer(int nummer) {
		Nummer = nummer;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPreis() {
		return Preis;
	}

	public void setPreis(double preis) {
		Preis = preis;
	}

	public boolean isLage() {
		return Lage;
	}

	public void setLage(boolean lage) {
		Lage = lage;
	}
	
	
}
