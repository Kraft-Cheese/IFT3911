package Transport;

import java.util.ArrayList;

import Application.CollectionIterator;
import Application.IterableCollection;
import Application.Iterator;

// container for iterator
public class CiesCollection implements IterableCollection {

	private ArrayList<Cie> ciesList;

	@Override
	public CollectionIterator createIterator() {
		return new CollectionIterator(ciesList);
	}
}