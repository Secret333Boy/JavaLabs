package edu.kpi.lab.notebook.controller;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.repository.NotebookRepository;
import edu.kpi.lab.notebook.view.InputView;
import edu.kpi.lab.notebook.view.NotebookView;

public class NotebookController {
	private final NotebookRepository repository = new NotebookRepository();
	private final NotebookView view = new NotebookView();
	private final InputView input = new InputView(view);

	public void start() {
		final Notebook notebook = repository.load();
		boolean finished = false;
		while (!finished) {
			this.view.clearConsole();
			this.view.printMenu();
			int chosenOption = this.input.getMenuOptionInput();
			switch (chosenOption) {
				case 1 -> {
					this.view.printResult(notebook.getListOfItems());
					this.input.waitUntilKeyIsPressed();
				}
				case 2 -> {
					String letter = this.input.getInputLetter();
					this.view.printResult(notebook.findByFirstLetterOfSurname(letter));
					this.input.waitUntilKeyIsPressed();
				}
				case 3 -> {
					this.view.printResult(notebook.filterByTelephoneExistence());
					this.input.waitUntilKeyIsPressed();
				}
				case 4 -> {
					if (this.input.getInputSureExit()) {
						finished = true;
					}
				}
			}
		}
	}
}
