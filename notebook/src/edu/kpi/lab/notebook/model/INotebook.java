package edu.kpi.lab.notebook.model;

import java.util.ArrayList;

public interface INotebook {
	ArrayList<NotebookItem> getListOfItems();

	void addItem(NotebookItem item);

	void removeItem(int index);
	void removeItem(NotebookItem item);

	ArrayList<NotebookItem> findByFirstLetterOfSurname(String letter);

	ArrayList<NotebookItem> filterByTelephoneExistence();
}
