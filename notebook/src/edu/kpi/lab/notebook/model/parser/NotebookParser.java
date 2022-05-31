package edu.kpi.lab.notebook.model.parser;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.NotebookItem;
import edu.kpi.lab.notebook.model.exceptions.ParserException;

public class NotebookParser {
	public Notebook parse(String str) throws ParserException {
		String[] lines = str.split("\n");
		NotebookItem[] items = new NotebookItem[lines.length];
		for (int i = 0; i < lines.length; i++) {
			String[] properties = lines[i].split("\\|");
			if (properties.length != 6) {
				throw new ParserException();
			}
			items[i] = new NotebookItem(properties[0], properties[1], properties[2], properties[3], properties[4], properties[5]);
		}
		return new Notebook(items);
	}

	public String justify(Notebook notebook) {
		StringBuilder stringBuilder = new StringBuilder();
		for (NotebookItem item : notebook.getListOfItems()) {
			stringBuilder.append(item.toString());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
