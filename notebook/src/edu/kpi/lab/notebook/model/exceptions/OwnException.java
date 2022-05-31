package edu.kpi.lab.notebook.model.exceptions;

public class OwnException extends Throwable {
	public OwnException(String message) {
		super("Exception was thrown: " + message);
	}
}
