package edu.kpi.lab.notebook.controller;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.NotebookItem;
import edu.kpi.lab.notebook.view.InputView;
import edu.kpi.lab.notebook.view.NotebookView;

public class NotebookController implements INotebookController {
	private final Notebook notebook;

	public NotebookController() {
		this.notebook = new Notebook();
		boolean finished = false;
		while (!finished) {
			NotebookView view = new NotebookView();
			InputView input = new InputView(view);
			view.clearConsole();
			view.printMenu();
			int chosenOption = input.getMenuOptionInput();
			switch (chosenOption) {
				case 1:
					view.printResult(this.notebook.getArrayOfItems());
					input.waitUntilKeyIsPressed();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					if (input.getInputSureExit()) {
						finished = true;
					}
					break;
			}
		}
	}

	@Override
	public Notebook getNotebookInstance() {
		return this.notebook;
	}

	@Override
	public NotebookItem[] findByFirstLetterOfSurname(String letter) {
		return this.notebook.findByFirstLetterOfSurname(letter);
	}

	@Override
	public NotebookItem[] filterByTelephoneExistence() {
		return this.notebook.filterByTelephoneExistence();
	}
}
