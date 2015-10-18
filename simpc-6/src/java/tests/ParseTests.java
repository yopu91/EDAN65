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

	@Test
	public void validSyntaxMethodIf() {
		testValidSyntax("method_if.lang");
	}

	
	@Test
	public void validSyntaxManyIf() {
		testValidSyntax("many_if.lang");
	}

	@Test
	public void validSyntaxWhile() {
		testValidSyntax("while.lang");
	}

	@Test
        public void validSyntaxbigtest() {
                testValidSyntax("main.lang");
        }


	@Test
	public void validSyntaxIfElse() {
		testValidSyntax("ifelse.c");
	}
	
	@Test
	public void validSyntaxDeclare() {
		testValidSyntax("declare.c");
	}
	 @Test
        public void validSyntaxManyFunc() {
                testValidSyntax("manyFunc.c");
        }


	@Test
	public void validSyntaxIf() {
		testValidSyntax("if.c");
	}
//	public void syntaxErrorMethod() {
//		testSyntaxError("error.lang");
//	}
}
