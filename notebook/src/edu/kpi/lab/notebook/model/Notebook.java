package edu.kpi.lab.notebook.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Notebook implements INotebook {
	private final ArrayList<NotebookItem> itemList;

	public Notebook() {
		this.itemList = new ArrayList<>(0);
	}

	public Notebook(NotebookItem[] arrayOfItems) {
		this.itemList = Arrays.stream(arrayOfItems).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public ArrayList<NotebookItem> getListOfItems() {
		return this.itemList;
	}

	@Override
	public void addItem(NotebookItem item) {
		this.itemList.add(item);
	}

	@Override
	public void removeItem(int index) {
		this.itemList.remove(index);
	}

	@Override
	public void removeItem(NotebookItem item) {
		this.itemList.remove(item);
	}

	@Override
	public ArrayList<NotebookItem> findByFirstLetterOfSurname(String letter) {
		ArrayList<NotebookItem> result = new ArrayList<>();
		for (NotebookItem item : this.itemList) {
			if (item.getSurname().startsWith(letter)) {
				result.add(item);
			}
		}
		return result;
	}

	@Override
	public ArrayList<NotebookItem> filterByTelephoneExistence() {
		ArrayList<NotebookItem> result = new ArrayList<>();
		for (NotebookItem item : this.itemList) {
			if (!item.getTelephone().equals("")) {
				result.add(item);
			}
		}
		return result;
	}
}
