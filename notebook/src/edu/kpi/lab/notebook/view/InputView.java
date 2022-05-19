package edu.kpi.lab.notebook.view;

import java.util.Scanner;

public class InputView implements IInputView {
	private final Scanner sc;
	private final NotebookView view;

	public InputView(NotebookView view) {
		this.sc = new Scanner(System.in);
		this.view = view;
	}

	@Override
	public int getInputInt() {
		while (!sc.hasNextInt()) {
			view.printMessage(NotebookView.WRONG_INPUT_MESSAGE);
			sc.next();
		}
		return sc.nextInt();
	}

	@Override
	public int getInputInt(int from) {
		int result = this.getInputInt();
		while (result < from) {
			view.printMessage(NotebookView.WRONG_INPUT_MESSAGE);
			result = this.getInputInt();
		}
		return result;
	}

	@Override
	public int getInputInt(int from, int to) {
		int result = this.getInputInt();
		while (result < from || result > to) {
			view.printMessage(NotebookView.WRONG_INPUT_MESSAGE);
			result = this.getInputInt();
		}
		return result;
	}

	@Override
	public int getMenuOptionInput() {
		view.printMessage(NotebookView.CHOOSE_MESSAGE);
		return this.getInputInt(1, NotebookView.MAIN_MENU_ITEMS_COUNT);
	}

	@Override
	public String getInputString() {
		return sc.next();
	}

	@Override
	public String getInputLetter() {
		view.printMessage(NotebookView.FIRST_LETTER_INPUT_NEEDED);
		String result = this.getInputString();
		while (result.length() != 1) {
			view.printMessage(NotebookView.WRONG_INPUT_MESSAGE);
			view.printMessage(NotebookView.FIRST_LETTER_INPUT_NEEDED);
			result = this.getInputString();
		}
		return result;
	}

	@Override
	public boolean getInputSureExit() {
		view.printMessage(NotebookView.ARE_YOU_SURE);
		String result = this.getInputString().toLowerCase();
		return result.equals("y");
	}

	@Override
	public void waitUntilKeyIsPressed() {
		System.out.println("Press Any Key To Continue...");
		new java.util.Scanner(System.in).nextLine();
	}
}
