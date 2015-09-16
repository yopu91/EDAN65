package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles/parser");// where test input files are
	}

	@Test
	public void validSyntaxMethod() {
		testValidSyntax("method.lang");
	}

//	@Test
//	public void syntaxErrorMethod() {
//		testSyntaxError("error.lang");
//	}
}
