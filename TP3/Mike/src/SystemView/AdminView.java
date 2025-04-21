package SystemView;

import SystemControl.AdminController;
import SystemCore.SysModel;
import java.util.Scanner;

/**
 * Administrative view: integrates with AdminController to manage entities.
 */
public class AdminView extends View {
	private final AdminController controller;

	public AdminView(SysModel model) {
		super(model);
		this.controller = new AdminController(model);
	}

	/**
	 * Main loop for admin actions.
	 */
	public void adminInput() {
		Scanner in = new Scanner(System.in);
		boolean back = false;
		while (!back) {
			affMenuPrincipal();
			System.out.print("  Admin> ");
			int cmd;
			try {
				cmd = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
				continue;
			}
			switch (cmd) {
				case 1:
					System.out.println("    --- List of Entities ---");
					try{
						controller.requestEntities(this);
					} catch (Exception e) {
						System.out.println("Error retrieving entities: " + e.getMessage());
					}
					break;
				case 2:
					try{
					System.out.print("    Entity ID to modify: ");
					String mid = in.nextLine();
					System.out.print("    New name: ");
					String mname = in.nextLine();
					System.out.print("    New description: ");
					String mdesc = in.nextLine();
					controller.modifyEntity(mid, mname, mdesc);
					} catch (Exception e) {
						System.out.println("Error modifying entity: " + e.getMessage());
					}
					break;
				case 3:
					try {
						System.out.print("    Entity name: ");
						String cname = in.nextLine();
						System.out.print("    Entity description: ");
						String cdesc = in.nextLine();
						controller.createEntity(cname, cdesc);
					} catch (Exception e) {
						System.out.println("Error creating entity: " + e.getMessage());
					}
					break;
				case 4:
					try{
						System.out.print("    Entity ID to remove: ");
						String rid = in.nextLine();
						controller.removeEntity(rid);
					} catch (Exception e) {
						System.out.println("Error removing entity: " + e.getMessage());
					}
					break;
				case 5:
					controller.undo();
					break;
				case 6:
					back = true;
					break;
				default:
					System.out.println("Unknown option.");
			}
		}
	}

	public void affMenuPrincipal() {
		System.out.println("\n--- Admin Menu ---");
		System.out.println("1. List all entities");
		System.out.println("2. Modify an entity");
		System.out.println("3. Create a new entity");
		System.out.println("4. Delete an entity");
		System.out.println("5. Undo last action");
		System.out.println("6. Back to Main Menu");
	}

	public void affEntityList() {
		System.out.println("\n--- Entity List ---");
		System.out.println("(Not yet implemented retrieval in menu)");
	}

	public void affEntityInfo() {
		System.out.println("\n--- Entity Details ---");
		System.out.println("(Not yet implemented in menu)");
	}

	public void affNewEntityForm() {
		System.out.println("\n--- New Entity Form ---");
		System.out.println("(Not yet implemented in menu)");
	}

	@Override
	public void updateView() {
		// This method should be called to update the view after any changes
		// made to the model.
		System.out.println("View updated.");
	}
}
