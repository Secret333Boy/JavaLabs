package edu.kpi.lab.notebook.view;

import edu.kpi.lab.notebook.model.NotebookItem;

public interface INotebookView {
	void clearConsole();
	void printMenu();
	void printMessage(String message);

	void printResult(NotebookItem[] result);
}
