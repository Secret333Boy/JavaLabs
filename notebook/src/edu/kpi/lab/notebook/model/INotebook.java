package edu.kpi.lab.notebook.model;

import java.util.List;

public interface INotebook {
	List<NotebookItem> getListOfItems();

	void addItem(NotebookItem item);

	void removeItem(int index);
	void removeItem(NotebookItem item);

	List<NotebookItem> findByFirstLetterOfSurname(String letter);

	List<NotebookItem> filterByTelephoneExistence();
}
