package edu.kpi.lab.notebook.model.service;

import edu.kpi.lab.notebook.model.entity.NotebookItem;
import edu.kpi.lab.notebook.model.exceptions.ParserException;
import edu.kpi.lab.notebook.model.repository.NotebookRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotebookService implements INotebookService {
	private final NotebookRepository repository = new NotebookRepository();
	private List<NotebookItem> itemList;

	public NotebookService() throws IOException {
		this.itemList = new ArrayList<>(0);
	}

	public NotebookService(NotebookItem[] arrayOfItems) throws IOException {
		this.itemList = Arrays.stream(arrayOfItems).collect(Collectors.toList());
	}

	public NotebookService(List<NotebookItem> itemList) throws IOException {
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

	@Override
	public void loadFromFile() throws IOException, ParserException {
		this.itemList = repository.load();
	}

	@Override
	public void saveToFile() throws IOException {
		repository.save(this.itemList);
	}
}
