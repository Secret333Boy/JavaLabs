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
		return this.itemList.stream().filter(item -> item.getSurname().startsWith(letter)).collect(Collectors.toList());
	}

	@Override
	public List<NotebookItem> filterByTelephoneExistence() {
		return this.itemList.stream().filter(item -> !item.getTelephone().equals("")).collect(Collectors.toList());
	}
}
