package SystemView;

import SystemCore.SysModel;

public class AdminView extends View {

	public AdminView(SysModel m) {
		super(m);
	}

	public void adminInput() {
		// TODO - implement SystemView.AdminView.adminInput
		throw new UnsupportedOperationException();
	}

	public void affEntityList() {
		// TODO - implement SystemView.AdminView.affEntityList
		throw new UnsupportedOperationException();
	}

	public void affMenuPrincipal() {
		// TODO - implement SystemView.AdminView.affMenuPrincipal
		throw new UnsupportedOperationException();
	}

	public void affEntityInfo() {
		// TODO - implement SystemView.AdminView.affEntityInfo
		throw new UnsupportedOperationException();
	}

	public void affNewEntityForm() {
		// TODO - implement SystemView.AdminView.affNewEntityForm
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateView() {

		// Update the view with the latest data
		// TODO - implement SystemView.AdminView.updateView

		ArrayList<Entity> searchResults = model.getCurrSearchResults();
		// Display the updated search results
		// use visitor to construct the string
		ConcreteAdminVisitor visitor = new ConcreteAdminVisitor();
		String results = "";
		for (Parcours parcours : searchResults) {
			System.out.println(parcours.accept(visitor)+"\n");
		}
	}

}