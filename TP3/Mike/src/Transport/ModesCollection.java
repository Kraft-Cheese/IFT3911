package Transport;

import Application.CollectionIterator;
import Application.IterableCollection;
import Application.Iterator;

import java.util.ArrayList;

public class ModesCollection implements IterableCollection {

	private ArrayList<ModeTransport> modesList;

	@Override
	public CollectionIterator createIterator() {
		return new CollectionIterator(modesList);
	}

	public ModeTransport getMode(String code) {
		for (ModeTransport mode : modesList) {
			if (mode.getID().equals(code)) {
				return mode;
			}
		}
		return null;
	}
}