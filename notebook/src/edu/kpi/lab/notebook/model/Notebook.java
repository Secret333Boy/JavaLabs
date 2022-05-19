package edu.kpi.lab.notebook.model;

public class Notebook implements INotebook {
	private final NotebookItem[] arrayOfItems;

	public Notebook() {
		this.arrayOfItems = new NotebookItem[0];
	}

	public Notebook(NotebookItem[] arrayOfItems) {
		this.arrayOfItems = arrayOfItems;
	}

	@Override
	public NotebookItem[] getArrayOfItems() {
		return this.arrayOfItems;
	}

	@Override
	public NotebookItem[] findByFirstLetterOfSurname(String letter) {
		NotebookItem[] rawResult = new NotebookItem[arrayOfItems.length];
		int n = 0;
		for (NotebookItem item : arrayOfItems) {
			if (item.getSurname().startsWith(letter)) {
				rawResult[n++] = item;
			}
		}
		NotebookItem[] result = new NotebookItem[n];
		System.arraycopy(rawResult, 0, result, 0, n);
		return result;
	}

	@Override
	public NotebookItem[] filterByTelephoneExistence() {
		NotebookItem[] rawResult = new NotebookItem[arrayOfItems.length];
		int n = 0;
		for (NotebookItem item : arrayOfItems) {
			if (!item.getTelephone().equals("")) {
				rawResult[n++] = item;
			}
		}
		NotebookItem[] result = new NotebookItem[n];
		System.arraycopy(rawResult, 0, result, 0, n);
		return result;
	}
}
