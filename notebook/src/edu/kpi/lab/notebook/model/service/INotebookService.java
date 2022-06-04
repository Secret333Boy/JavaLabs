package edu.kpi.lab.notebook.model.service;

import edu.kpi.lab.notebook.model.entity.NotebookItem;
import edu.kpi.lab.notebook.model.exceptions.ParserException;

import java.io.IOException;
import java.util.List;

public interface INotebookService {
	List<NotebookItem> getListOfItems();

	void addItem(NotebookItem item);

	void removeItem(int index);

	void removeItem(NotebookItem item);

	List<NotebookItem> findByFirstLetterOfSurname(String letter);

	List<NotebookItem> filterByTelephoneExistence();

	void loadFromFile() throws IOException, ParserException;

	void saveToFile() throws IOException;
}
