package edu.kpi.lab.notebook.model.parser;

import edu.kpi.lab.notebook.model.entity.NotebookItem;

import java.util.List;

public interface NotebookSerializer {
	String justify(List<NotebookItem> notebook);
}
