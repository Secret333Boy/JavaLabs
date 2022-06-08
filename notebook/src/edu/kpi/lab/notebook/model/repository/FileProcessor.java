package edu.kpi.lab.notebook.model.repository;

import java.io.*;
import java.util.Scanner;

public class FileProcessor {
	private final File file;

	public FileProcessor(File file) {
		this.file = file;
	}

	public void writeFile(String str) throws IOException {
		FileWriter writer = new FileWriter(this.file);
		writer.write(str);
		writer.close();
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
