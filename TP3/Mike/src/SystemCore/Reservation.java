package SystemCore;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

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

	public Reservation(Section section, String parcoursId, Place place, LocalDateTime date, float total) {
		this.section = section;
		this.parcoursId = parcoursId;
		this.place = place;
		this.date = date;
		this.total = total;
		genererId();
	}

	public void setStatus(boolean statut) {
		// TODO - implement Reservation.setValid
		this.statut = statut;
	}

	public boolean getStatut() {
		return statut;
	}

	private void genererId() {
		// TODO - implement Reservation.genererId
		 reservationNo = UUID.randomUUID().toString();
	}

	public String getReservationId() {
		return reservationNo;
	}

	public String getTotal() {
		return String.valueOf(total);
	}

	public Date getDate() {
		return Date.valueOf(date.toLocalDate());
	}

	public String getParcoursId() {
		return parcoursId;
	}

	public Section getSection() {
		return section;
	}

	public Place getPlace() {
		return place;
	}
}