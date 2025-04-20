package Transport;

public class Siege extends Place {

	private int No_rangee;
	private char Colonne;
	private int id;

	public Siege(int row, char col, int id) {
		super(row, col);
		this.No_rangee = row;
		this.Colonne = col;
		this.id = id;
	}
	@Override
	public String toString() {
		return String.format("Siege %d : %s", id, super.toString());
	}

}