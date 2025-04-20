package SystemControl;
import java.util.ArrayDeque;
import java.util.Deque;
public class CommandManager {
    private final Deque<ICommand> history = new ArrayDeque<>();

    public void executeCommand(ICommand cmd) {
        cmd.execute();
        history.push(cmd);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            history.pop().undo();
        } else System.out.println("Nothing to undo.");
    }
}
