package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.ParamFunc;
import lang.ast.Program;

@RunWith(Parameterized.class)
public class TestFuncCalls extends AbstractParameterizedTest {
    private static final String TEST_DIR = "testfiles/functioncalls";

    public TestFuncCalls(String filename) {
	super(TEST_DIR, filename);
    }

    @Test
    public void runTest() throws Exception {
	Program program = (Program) parse(inFile);
	StringBuilder sb = new StringBuilder();
	for (ParamFunc enclosing: program.getParamFuncList()) {
	    sb.append(enclosing.getName().getID() + " enclosing:\n");
	    for(ParamFunc f: enclosing.functionCalls()){
		sb.append("\t" + f.getName().getID() + "\n");
	    }
	}
	compareOutput(sb.toString(), outFile, expectedFile);
    }

    @SuppressWarnings("javadoc")
    @Parameters(name = "{0}")
    public static Iterable<Object[]> getTests() {
	return getTestParameters(TEST_DIR);
    }
}
