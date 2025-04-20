package Transport;

import Application.Entity;

import java.util.ArrayList;

public abstract class ModeTransport extends Entity {

	protected ArrayList<String> sections;
	protected String modele;

	public ModeTransport(String sections, String modele, String ID)
	{
		// create sections
		this.modele = modele;
		this.ID = ID;
	}

	// TODO
	private ArrayList<Section> parseSections(String str)
	{
		// PS(0/12)474.00|AM(5/16)355.50|EL(150/200)237.00

		String[] strSections = str.split("|");
		for (String strSection : strSections)
		{
			String[] elems = strSection.split("[(\\/\\)]");
			//Section section = new Section(elems[2], elems[0].charAt(0),
			// elems[0].length() == 2 ? elems[0].charAt(1) : null, Float.parseFloat(elems[3]), )
		}
	}
}