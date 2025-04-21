package Transport;

import Application.Entity;
import Application.Visitor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ModeTransport extends Entity {

	protected ArrayList<Section> sections;
	protected String modele;

	public ModeTransport(String sections, String modele, String ID)
	{
		// create sections
		this.modele = modele;
		this.ID = ID;

		this.sections = parseSections(sections);

	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

//	private ArrayList<Section> parseSections(String str) {
//
//		// PS(0/12)474.00|AM(5/16)355.50|EL(150/200)237.00
//
//		String[] strSections = str.split("\\|");
//		ArrayList<Section> sections = new ArrayList<>();
//		for (String strSection : strSections) {
//
//			String input = "PS(0/12)474.00";
//			String regex = "([A-Z]+)\\((\\d+)/(\\d+)\\)(\\d+\\.\\d+)";
//			Pattern pattern = Pattern.compile(regex);
//			Matcher matcher = pattern.matcher(input);
//
//			if (matcher.matches()) {
//				String type = matcher.group(1); // PS
//				String occupied = matcher.group(2); // 0
//				String capacity = matcher.group(3); // 12
//				String price = matcher.group(4); // 474.00
//
//				sections.add(new Section(
//						Integer.parseInt(capacity),
//						type,
//						Transport.Org_sieges.valueOf(type),
//						Float.parseFloat(price),
//						new ArrayList<>()
//				));
//
//			}
//
//		}
//		return sections;
//	}

private ArrayList<Section> parseSections(String str) {
	// e.g. "PS(0/12)474.00|AM(5/16)355.50|EL(150/200)237.00"
	String[] strSections = str.split("\\|");
	ArrayList<Section> sections = new ArrayList<>();
	Pattern pattern = Pattern.compile("([A-Z]+)\\((\\d+)/(\\d+)\\)(\\d+\\.\\d+)");
	for (String strSection : strSections) {
		Matcher matcher = pattern.matcher(strSection);
		if (matcher.matches()) {
			String type      = matcher.group(1); // e.g. "PS"
			int occupied     = Integer.parseInt(matcher.group(2));
			int capacity     = Integer.parseInt(matcher.group(3));
			float price      = Float.parseFloat(matcher.group(4));

			sections.add(new Section(
					capacity,
					type,
					Org_sieges.valueOf(type),  // see enum below
					price,
					new ArrayList<>()
			));
		} else {
			throw new IllegalArgumentException(
					"Bad section format: " + strSection
			);
		}
	}
	return sections;
}


	public ArrayList<Section> getSections() {
		return sections;
	}
}