package edu.kpi.lab.notebook.controller;

import edu.kpi.lab.notebook.model.service.NotebookService;
import edu.kpi.lab.notebook.model.exceptions.ParserException;
import edu.kpi.lab.notebook.view.InputView;
import edu.kpi.lab.notebook.view.NotebookView;

import java.io.IOException;

public class NotebookController {
	private final NotebookView view = new NotebookView();
	private final InputView input = new InputView(view);

	public void start() {
		final NotebookService notebookService;
		try {
			notebookService = new NotebookService();
			notebookService.loadFromFile();
		} catch (IOException e) {
			view.printError(e);
			input.waitUntilKeyIsPressed();
			System.exit(8888);
			return;
		} catch (ParserException e) {
			view.printError(e);
			input.waitUntilKeyIsPressed();
			System.exit(8881);
			return;
		}
		boolean finished = false;
		while (!finished) {
			this.view.clearConsole();
			this.view.printMenu();
			int chosenOption = this.input.getMenuOptionInput();
			switch (chosenOption) {
				case 1 -> {
					this.view.printResult(notebookService.getListOfItems());
					this.input.waitUntilKeyIsPressed();
				}
				case 2 -> {
					String letter = this.input.getInputLetter();
					this.view.printResult(notebookService.findByFirstLetterOfSurname(letter));
					this.input.waitUntilKeyIsPressed();
				}
				case 3 -> {
					this.view.printResult(notebookService.filterByTelephoneExistence());
					this.input.waitUntilKeyIsPressed();
				}
				case 4 -> {
					if (this.input.getInputSureExit()) {
						finished = true;
						try {
							notebookService.saveToFile();
						} catch (IOException e) {
							view.printError(e);
						}
					}
				}
			}
		}
	}
}
