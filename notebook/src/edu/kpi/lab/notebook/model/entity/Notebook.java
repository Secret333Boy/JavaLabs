package edu.kpi.lab.notebook.model.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook implements INotebook {
	private final List<NotebookItem> itemList;

	public Notebook() {
		this.itemList = new ArrayList<>(0);
	}

	public Notebook(NotebookItem[] arrayOfItems) {
		this.itemList = Arrays.stream(arrayOfItems).collect(Collectors.toList());
	}

	public Notebook(List<NotebookItem> itemList) {
		this.itemList = itemList;
	}

	@Override
	public List<NotebookItem> getListOfItems() {
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
	public List<NotebookItem> findByFirstLetterOfSurname(String letter) {
		List<NotebookItem> result = new ArrayList<>();
		for (NotebookItem item : this.itemList) {
			if (item.getSurname().startsWith(letter)) {
				result.add(item);
			}
		}
		return result;
	}

	@Override
	public List<NotebookItem> filterByTelephoneExistence() {
		List<NotebookItem> result = new ArrayList<>();
		for (NotebookItem item : this.itemList) {
			if (!item.getTelephone().equals("")) {
				result.add(item);
			}
		}
		return result;
	}
}
