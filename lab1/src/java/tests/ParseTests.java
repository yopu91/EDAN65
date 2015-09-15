package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles");// where test input files are
	}

	@Test
	public void shortest() {
		testValidSyntax("shortest.mini");
	}


	@Test
	public void almost_shortest() {
		testValidSyntax("almost_shortest.mini");
	}

	@Test
	public void parse_test() {
		testValidSyntax("parsing_error.mini");
	}

	@Test
	public void scanner_shortest() {
		testSyntaxError("scanner_error.mini");
	}
}
