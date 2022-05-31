package edu.kpi.lab.notebook.model.repository;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.exceptions.ParserException;
import edu.kpi.lab.notebook.model.parser.NotebookParser;

import java.io.File;
import java.io.IOException;

public class NotebookRepository {
	private final File file = new File("repository.dat");
	private final FileProcessor fileProcessor = new FileProcessor(file);

	public NotebookRepository() {
		try {
			if (file.createNewFile()) {
				System.out.println("File created");
			} else {
				System.out.println("File loaded");
			}
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

	public void save(Notebook notebook) {
		NotebookParser parser = new NotebookParser();
		this.fileProcessor.writeFile(parser.justify(notebook));
	}

	public Notebook load() {
		NotebookParser parser = new NotebookParser();
		Notebook notebook = new Notebook();
		try {
			notebook = parser.parse(this.fileProcessor.readFile());
		} catch (ParserException e) {
			System.out.println("Error: " + e);
			System.exit(2612);
		}
		return notebook;
	}
}
