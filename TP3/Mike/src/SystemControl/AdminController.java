package SystemControl;
import Application.Entity;
import SystemCore.SysModel;
import Transport.*;


public class AdminController {
	private final SysModel model;
	private final CommandManager commandManager;
	private int currMenu;
	private int commandHistory;

	public AdminController(SysModel model) {
		this.model = model;
		this.commandManager = new CommandManager();
	}

	public void handleInput(int currMenuMap) {
		this.currMenu = currMenuMap;
		// Additional menu handling logic can be added here
	}

	public void pushComm(ICommand c) {
		commandManager.executeCommand(c);
		commandHistory++;
	}

	public void popComm(ICommand c) {
		commandManager.undoLast();
		commandHistory = Math.max(0, commandHistory - 1);
	}

	public void selectEntity(Entity entity) {
//		ICommand cmd = new ChoixEntity(model, entity);
//		commandManager.executeCommand(cmd);
	}

	public void createEntity(String name, String description) {
//		ICommand cmd = new MakeNewEntity(model, name, description);
//		commandManager.executeCommand(cmd);
	}

	public void modifyEntity(String id, String name, String description) {
		ICommand cmd = new ModEntity(model, id, name, description);
		commandManager.executeCommand(cmd);
	}

	public void removeEntity(String id) {
		ICommand cmd = new DeleteEntity(model, id);
		commandManager.executeCommand(cmd);
	}

	public void undo() {
		commandManager.undoLast();
	}
}