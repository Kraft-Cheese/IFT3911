package SystemControl;

public class RequestClient implements ICommand {

    private final String clientId;
    private final String requestType;
    private final String requestDetails;

    public RequestClient(String clientId, String requestType, String requestDetails) {
        this.clientId = clientId;
        this.requestType = requestType;
        this.requestDetails = requestDetails;
    }

    @Override
    public void execute() {
        // Handle the client's request based on the type and details
        System.out.println("Processing request from client " + clientId + ": " + requestType + " - " + requestDetails);
    }

    @Override
    public void undo() {
        // Logic to undo the client's request if necessary
        System.out.println("Undoing request from client " + clientId);
    }
}
