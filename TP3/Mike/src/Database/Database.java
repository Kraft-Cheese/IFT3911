package Database;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

public class Database
{
	private final String filePath = "./data/parcours.csv";
	private String[] header;

	public Database() { }

	public ArrayList<String[]> readCSV()
	{
		try (CSVReader reader = new CSVReader(new FileReader(this.filePath)))
		{
			ArrayList<String[]> lines = new ArrayList<>(reader.readAll());
			this.header = lines.remove(0);
			return lines;

		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void writeCSV(ArrayList<String[]> parcours)
	{
		File file = new File(this.filePath);
		try (FileWriter output = new FileWriter(file);
			 CSVWriter writer = new CSVWriter(output, ICSVWriter.DEFAULT_SEPARATOR, ICSVWriter.NO_QUOTE_CHARACTER,
					 ICSVWriter.DEFAULT_ESCAPE_CHARACTER, ICSVWriter.RFC4180_LINE_END))
		{
			writer.writeNext(this.header);
			writer.writeAll(parcours);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}