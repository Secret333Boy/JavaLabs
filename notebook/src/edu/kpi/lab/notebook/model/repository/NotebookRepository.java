package edu.kpi.lab.notebook.model.repository;

import edu.kpi.lab.notebook.model.entity.Notebook;
import edu.kpi.lab.notebook.model.entity.NotebookItem;
import edu.kpi.lab.notebook.model.exceptions.ParserException;
import edu.kpi.lab.notebook.model.parser.NotebookParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

	public void save(List<NotebookItem> notebook) throws IOException {
		NotebookParser parser = new NotebookParser();
		this.fileProcessor.writeFile(parser.justify(notebook));
	}

	public List<NotebookItem> load() throws IOException, ParserException {
		NotebookParser parser = new NotebookParser();
		return parser.parse(this.fileProcessor.readFile());
	}
}
