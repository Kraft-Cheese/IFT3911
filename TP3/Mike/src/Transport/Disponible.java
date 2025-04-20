package Transport;

public class Disponible implements IPlaceState {

	@Override
	public void reserve(Place place) {
		// switch to ReservedState
		place.changeState(new Reserved());
		System.out.printf("Place %s reserved.%n", place);
	}

}