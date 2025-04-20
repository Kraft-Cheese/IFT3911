package Transport;

public abstract class Place {

	private IPlaceState state;
	private final int row;
	private final char col;

	public Place(int row, char col) {
		this.row = row;
		this.col = col;
		this.state = new Disponible();
	}

	public void reserve() {
		changeState(state);
	}

	void setState(IPlaceState state) {
		this.state = state;
	}

	public IPlaceState getState() {
		return state;
	}

	public String getRow(){
		return String.valueOf(row);
	}

	public String getCol(){
		return String.valueOf(col);
	}


	/**
	 * 
	 * @param state
	 */
	public void changeState(IPlaceState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return String.format("[%d%c]", row, col);
	}

}