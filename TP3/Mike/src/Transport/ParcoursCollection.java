package Transport;

import Application.CollectionIterator;
import Application.IterableCollection;
import Application.Iterator;

import java.util.ArrayList;

public class ParcoursCollection implements IterableCollection {

	private ArrayList<Parcours> parcoursList;

	@Override
	public Iterator createIterator() {
		return new CollectionIterator();
	}
}