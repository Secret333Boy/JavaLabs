package model;

public interface INotebook {
	NotebookItem[] getArrayOfItems();
	NotebookItem[] findByFirstLetterOfSurname(String letter);
	NotebookItem[] filterByTelephoneExistence();
}
