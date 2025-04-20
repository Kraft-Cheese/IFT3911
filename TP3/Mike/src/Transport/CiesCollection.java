package Transport;

import java.util.ArrayList;

import Application.CollectionIterator;
import Application.IterableCollection;
import Application.Iterator;

public class CiesCollection implements IterableCollection {

	private ArrayList<Cie> ciesList;

	@Override
	public Iterator createIterator() {
		return new CollectionIterator();
	}
}