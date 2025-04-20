package SystemCore;
import java.time.LocalDateTime;
import Transport.Section;
import Transport.Place;

public class Reservation {

	private boolean statut = false;
	private String reservationNo;
	private Section section;
	private String parcoursId;
	private Place place;
	private LocalDateTime date;
	private float total;

	public boolean setValid() {
		// TODO - implement Reservation.setValid
		throw new UnsupportedOperationException();
	}

	private void genererId() {
		// TODO - implement Reservation.genererId
		throw new UnsupportedOperationException();
	}

}