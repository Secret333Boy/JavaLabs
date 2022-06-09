package edu.kpi.lab.notebook.model.repository;

import edu.kpi.lab.notebook.model.entity.NotebookItem;
import edu.kpi.lab.notebook.model.exceptions.ParserException;
import edu.kpi.lab.notebook.model.parser.NotebookParser;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class NotebookRepository {
	private final File file = new File("src/main/resources/repository.dat");
	private final FileProcessor fileProcessor = new FileProcessor(file);

	public NotebookRepository() throws IOException {
		if (file.createNewFile()) {
			Logger logger = Logger.getLogger(NotebookRepository.class);
			logger.info("File " + file.getAbsolutePath() + " has not been found. Blank file has been created successfully");
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
