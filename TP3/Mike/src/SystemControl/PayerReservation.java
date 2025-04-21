package SystemControl;
import SystemCore.SysModel;

public class PayerReservation implements ICommand {
    private final SysModel model;
    private final String reservationId;
    private boolean paymentSuccess;

    public PayerReservation(SysModel model, String reservationId) {
        this.model = model;
        this.reservationId = reservationId;
    }

    @Override
    public void execute() {
        // Simulate payment processing
        paymentSuccess = true;
        if (paymentSuccess) {
            System.out.println("Payment successful for " + reservationId);
        } else {
            System.out.println("Payment failed for " + reservationId);
        }
    }

    @Override
    public void undo() {
       if (paymentSuccess) {
           System.out.println("Refunding payment for " + reservationId);
       }
    }
}