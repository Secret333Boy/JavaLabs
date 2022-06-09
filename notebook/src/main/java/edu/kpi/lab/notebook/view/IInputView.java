package edu.kpi.lab.notebook.view;

public interface IInputView {
	int getInputInt();

	int getInputInt(int from);

	int getInputInt(int from, int to);

	MenuOption getMenuOptionInput();

	String getInputString();

	String getInputLetter();

	boolean getInputSureExit();

	void waitUntilKeyIsPressed();
}
