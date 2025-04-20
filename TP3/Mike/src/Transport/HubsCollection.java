package Transport;

import Application.CollectionIterator;
import Application.IterableCollection;
import Application.Iterator;

import java.util.ArrayList;

public class HubsCollection implements IterableCollection {

	private ArrayList<Hub> hubsList;

	@Override
	public CollectionIterator createIterator() {
		return new CollectionIterator(hubsList);
	}
}