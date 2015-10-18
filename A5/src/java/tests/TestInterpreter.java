package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.ErrorMessage;
import lang.ast.Program;
import java.io.*;

/**
 * Tests name analysis
 */
@RunWith(Parameterized.class)
public class TestInterpreter extends AbstractParameterizedTest {
	/**
	 * Directory where test files live
	 */
	private static final String TEST_DIR = "testfiles/interpreter";

	/**
	 * Construct a new JastAdd test
	 * @param filename filename of test input file
	 */
	public TestInterpreter(String filename) {
		super(TEST_DIR, filename);
	}

	/**
	 * Run the JastAdd test
	 */
	@Test
	public void runTest() throws Exception {
        PrintStream out = System.out;
        try {
            Program program = (Program) parse(inFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
/* Any errors?*/  
            boolean error = false;
            for (ErrorMessage m: program.errors()) {
                System.out.println(m);
                error = true;
            }
/*Makes sure that only "ok" syntax is evaluated*/
            if (!error)
                program.eval();
            
            compareOutput(baos.toString(), outFile, expectedFile);
        } finally {
            System.setOut(out);
        }
    }

	@SuppressWarnings("javadoc")
	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return getTestParameters(TEST_DIR);
	}
}
