package edu.kpi.lab.notebook.model;

public interface INotebook {
	NotebookItem[] getArrayOfItems();

	NotebookItem[] findByFirstLetterOfSurname(String letter);

	NotebookItem[] filterByTelephoneExistence();
}
