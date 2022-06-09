package edu.kpi.lab.notebook.model.parser;

import edu.kpi.lab.notebook.model.entity.NotebookItem;
import edu.kpi.lab.notebook.model.exceptions.ParserException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotebookParser implements Parser, NotebookSerializer {
	@Override
	public List<NotebookItem> parse(String str) throws ParserException {
		if (str.length() == 0) return new ArrayList<>();
		String[] lines = str.split("\n");
		NotebookItem[] items = new NotebookItem[lines.length];
		for (int i = 0; i < lines.length; i++) {
			String[] properties = lines[i].split("\\|");
			if (properties.length != 6) {
				throw new ParserException();
			}
			items[i] = new NotebookItem(properties[0], properties[1], properties[2], properties[3], properties[4], properties[5]);
		}
		return Arrays.stream(items).collect(Collectors.toList());
	}

	@Override
	public String justify(List<NotebookItem> itemList) {
		StringBuilder stringBuilder = new StringBuilder();
		for (NotebookItem item : itemList) {
			stringBuilder.append(item.toString());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
