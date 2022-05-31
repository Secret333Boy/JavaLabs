package edu.kpi.lab.notebook.controller;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.NotebookItem;
import edu.kpi.lab.notebook.view.InputView;
import edu.kpi.lab.notebook.view.NotebookView;

public class NotebookController {

	public NotebookController() {
		Notebook notebook = new Notebook();
		notebook.addItem(new NotebookItem("Pashkovsky", "Eugene", "Serhiyovich", "??", "+3333", "-"));
		boolean finished = false;
		while (!finished) {
			NotebookView view = new NotebookView();
			InputView input = new InputView(view);
			view.clearConsole();
			view.printMenu();
			int chosenOption = input.getMenuOptionInput();
			switch (chosenOption) {
				case 1:
					view.printResult(notebook.getListOfItems());
					input.waitUntilKeyIsPressed();
					break;
				case 2:
					String letter = input.getInputLetter();
					view.printResult(notebook.findByFirstLetterOfSurname(letter));
					input.waitUntilKeyIsPressed();
					break;
				case 3:
					view.printResult(notebook.filterByTelephoneExistence());
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
}
