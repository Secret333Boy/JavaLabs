package edu.kpi.lab.notebook.view;

import edu.kpi.lab.notebook.model.exceptions.InputException;

public interface IInputView {
	int getInputInt();

	int getInputInt(int from);

	int getInputInt(int from, int to);

	int getMenuOptionInput();

	String getInputString();

	String getInputLetter() throws InputException;

	boolean getInputSureExit();

	void waitUntilKeyIsPressed();
}
