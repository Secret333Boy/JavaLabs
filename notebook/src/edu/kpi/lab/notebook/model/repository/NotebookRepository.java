package edu.kpi.lab.notebook.model.repository;

import edu.kpi.lab.notebook.model.entity.Notebook;
import edu.kpi.lab.notebook.model.exceptions.ParserException;
import edu.kpi.lab.notebook.model.parser.NotebookParser;

import java.io.File;
import java.io.IOException;

public class NotebookRepository {
	private final File file = new File("repository.dat");
	private final FileProcessor fileProcessor = new FileProcessor(file);

	public NotebookRepository() {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Error: " + e);
			System.exit(2612);
		}
	}

	public void save(Notebook notebook) throws IOException {
		NotebookParser parser = new NotebookParser();
		this.fileProcessor.writeFile(parser.justify(notebook));
	}

	public Notebook load() throws IOException, ParserException {
		NotebookParser parser = new NotebookParser();
		return parser.parse(this.fileProcessor.readFile());
	}
}
