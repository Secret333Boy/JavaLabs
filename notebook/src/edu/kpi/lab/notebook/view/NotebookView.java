package edu.kpi.lab.notebook.view;

import edu.kpi.lab.notebook.model.entity.NotebookItem;

import java.util.List;

public class NotebookView implements INotebookView {
	public static final String[] MAIN_MENU = {"Show all items in notebook", "Find by first letter of surname", "Filter by telephone existence", "Exit"};
	public static final int MAIN_MENU_ITEMS_COUNT = NotebookView.MAIN_MENU.length;
	public static final String CHOOSE_MESSAGE = "Choose one option from above (1-#): ".replace("#", Integer.toString(NotebookView.MAIN_MENU_ITEMS_COUNT));
	public static final String FIRST_LETTER_INPUT_NEEDED = "Please, type in first letter of surname: ";
	public static final String ARE_YOU_SURE = "Are you sure you want to exit? (y/n): ";
	public static final String WRONG_INPUT_MESSAGE = "Wrong input! Try again.";


	@Override
	public void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	@Override
	public void printMenu() {
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= NotebookView.MAIN_MENU.length; i++) {
			result.append(i).append(". ").append(NotebookView.MAIN_MENU[i - 1]).append("\n");
		}
		this.printMessage(result.toString());
	}

	@Override
	public void printMessage(String message) {
		System.out.print(message);
	}

	@Override
	public void printResult(List<NotebookItem> result) {
		if(result.isEmpty()) {
			this.printMessage("Result is empty!\n");
			return;
		}
		for (NotebookItem item : result) {
			this.printMessage(item.toString() + "\n");
		}
	}
}