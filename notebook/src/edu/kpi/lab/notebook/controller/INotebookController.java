package edu.kpi.lab.notebook.controller;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.NotebookItem;

public interface INotebookController {
	Notebook getNotebookInstance();
	NotebookItem[] findByFirstLetterOfSurname(String letter);
	NotebookItem[] filterByTelephoneExistence();
}
