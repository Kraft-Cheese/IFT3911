package Transport;

public class Reserved implements IPlaceState {
    @Override
    public void reserve(Place place) {
        // already reserved → error
        throw new IllegalStateException("Cannot reserve: already reserved.");
    }
}