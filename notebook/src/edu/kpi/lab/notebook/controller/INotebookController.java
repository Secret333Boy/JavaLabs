package edu.kpi.lab.notebook.controller;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.NotebookItem;

import java.util.ArrayList;

public interface INotebookController {
	Notebook getNotebookInstance();
	ArrayList<NotebookItem> findByFirstLetterOfSurname(String letter);
	ArrayList<NotebookItem> filterByTelephoneExistence();
}
