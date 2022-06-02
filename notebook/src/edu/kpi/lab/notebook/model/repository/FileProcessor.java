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

	public void writeFile(String str) {
		try (PrintWriter printWriter = new PrintWriter(this.file)) {
			printWriter.print(str);
		} catch (IOException e) {
			System.exit(2612);
		}
	}

	public String readFile() {
		StringBuilder stringBuilder = new StringBuilder();
		try (FileReader fileReader = new FileReader(this.file); Scanner scanner = new Scanner(fileReader)) {
			while (scanner.hasNextLine()) {
				stringBuilder.append(scanner.nextLine());
				stringBuilder.append("\n");
			}
		} catch (IOException e) {
			System.exit(2612);
		}
		return stringBuilder.toString();
	}
}
