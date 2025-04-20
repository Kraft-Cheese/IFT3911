package Application;

import java.util.ArrayList;

// concrete iterator class (collection here is always an arraylist)
public class CollectionIterator implements Iterator {

	private int current;
	private ArrayList<Entity> collection;

	@Override
	public Entity add(Entity e) {

		// check if the entity is already in the collection
		for (int i = 0; i < current; i++) {
			if (e.equals(collection[i])) {
				throw new IllegalArgumentException("Entité existe déjà dans la collection");
			}
		}

		// add the entity to the collection
		collection.add(e);
		current++;
	}

	@Override
	public Entity next() {
		// check if the current index is within bounds
		if (current < collection.size()) {
			current++;
			return collection.get(current-1);
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
	}

	@Override
	public void previous() {
		// check if the current index is within bounds
		if (current > 0) {
			current--;
			return collection.get(current+1);
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
	}

	@Override
	public Entity getCurrent() {
		return collection.get(current);
	}

	@Override
	public void remove(Entity e) {
		// check if the entity is in the collection
		if (!collection.contains(e)) {
			throw new IllegalArgumentException("Entité n'existe pas dans la collection");
		}

		// remove the entity from the collection
		collection.remove(e);
		current--;
	}

	@Override
	public void first() {
		// check if the collection is not empty
		if (collection.isEmpty()) {
			throw new IllegalStateException("Collection is empty");
		}

		current = 0;
		return collection.get(current);

	}

	@Override
	public void isDone() {
		// check if the current index is within bounds
		if (current >= collection.size()) {
			return true;
		} else {
			return false;
		}
	}
}