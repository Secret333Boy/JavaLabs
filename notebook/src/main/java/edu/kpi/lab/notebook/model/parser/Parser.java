package edu.kpi.lab.notebook.model.parser;

import edu.kpi.lab.notebook.model.exceptions.ParserException;

public interface Parser {
	Object parse(String str) throws ParserException;
}
