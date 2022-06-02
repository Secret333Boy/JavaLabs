package edu.kpi.lab.notebook.view;

import edu.kpi.lab.notebook.model.entity.NotebookItem;

import java.util.List;

public interface INotebookView {
	void clearConsole();
	void printMenu();
	void printMessage(String message);

	void printResult(List<NotebookItem> result);
}
