package SystemView;
import SystemCore.SysModel;

public abstract class View {

	protected final SysModel model;

	public View(SysModel m){
		this.model = m;
		attach();
	}
	public abstract void updateView();

	public void attach() {
		model.addObserver(this);
	}

	public void detach() {
		model.removeObserver(this);
	}
}