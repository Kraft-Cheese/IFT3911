package SystemControl;

public class RequestEntities implements ICommand {

    public RequestEntities(String entityName, String entityType, String entityId, String entityValue, String entityTypeId) {

    }
    @Override
    public void execute() {
        // Request the list of all specific entities?
        // Form field what are you undoing?
        // Filling in form, last thing wrote , goes back to previous element in the command



    }

    @Override
    public void undo() {

    }
}