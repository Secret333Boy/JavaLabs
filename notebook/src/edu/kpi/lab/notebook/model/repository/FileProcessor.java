package edu.kpi.lab.notebook.model.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor {
	private final File file;

	public FileProcessor(File file) {
		this.file = file;
	}

	public void writeFile(String str) throws IOException {
		new PrintWriter(this.file).print(str);
	}

	public String readFile() throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		FileReader fileReader = new FileReader(this.file);
		Scanner scanner = new Scanner(fileReader);
		while (scanner.hasNextLine()) {
			stringBuilder.append(scanner.nextLine());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
