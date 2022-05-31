package edu.kpi.lab.notebook.controller;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.NotebookItem;
import edu.kpi.lab.notebook.view.InputView;
import edu.kpi.lab.notebook.view.NotebookView;

import java.util.ArrayList;

public class NotebookController implements INotebookController {
	private final Notebook notebook;

	public NotebookController() {
		this.notebook = new Notebook();
		this.notebook.addItem(new NotebookItem("Pashkovsky", "Eugene", "Serhiyovich", "??", "+3333", "-"));
		boolean finished = false;
		while (!finished) {
			NotebookView view = new NotebookView();
			InputView input = new InputView(view);
			view.clearConsole();
			view.printMenu();
			int chosenOption = input.getMenuOptionInput();
			switch (chosenOption) {
				case 1:
					view.printResult(this.notebook.getListOfItems());
					input.waitUntilKeyIsPressed();
					break;
				case 2:
					String letter = input.getInputLetter();
					view.printResult(this.notebook.findByFirstLetterOfSurname(letter));
					input.waitUntilKeyIsPressed();
					break;
				case 3:
					view.printResult(this.notebook.filterByTelephoneExistence());
					input.waitUntilKeyIsPressed();
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
	public ArrayList<NotebookItem> findByFirstLetterOfSurname(String letter) {
		return this.notebook.findByFirstLetterOfSurname(letter);
	}

	@Override
	public ArrayList<NotebookItem> filterByTelephoneExistence() {
		return this.notebook.filterByTelephoneExistence();
	}
}
