package edu.kpi.lab.notebook.model.repository;

import edu.kpi.lab.notebook.model.Notebook;
import edu.kpi.lab.notebook.model.exceptions.ParserException;
import edu.kpi.lab.notebook.model.parser.NotebookParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotebookRepository {
	private final File file;
	public NotebookRepository(File file) {
		this.file = file;
	}

	public void save(Notebook notebook) {
		NotebookParser parser = new NotebookParser();
		try(PrintWriter printWriter = new PrintWriter(this.file)) {
			printWriter.print(parser.justify(notebook));
		} catch (IOException e) {
			System.exit(1337);
		}
	}

	public Notebook load() {
		NotebookParser parser = new NotebookParser();
		Notebook notebook = new Notebook();
		try(FileReader fileReader = new FileReader(this.file)) {
			Scanner scanner = new Scanner(fileReader);
			StringBuilder stringBuilder = new StringBuilder();
			while (scanner.hasNextLine()) {
				stringBuilder.append(scanner.nextLine());
			}
			notebook = parser.parse(stringBuilder.toString());
		} catch (ParserException | IOException e) {
			System.exit(1337);
		}
		return notebook;
	}
}
