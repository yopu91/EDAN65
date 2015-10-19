package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.io.*;


@RunWith(Parameterized.class)
public class TestReach extends AbstractParameterizedTest {
    private static final String TEST_DIR = "testfiles/reach";

    public TestReach(String filename) {
	super(TEST_DIR, filename);
    }

    @Test
    public void runTest() throws Exception {
	PrintStream out = System.out;
		try {
			Program program = (Program) parse(inFile);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			System.setOut(new PrintStream(baos));
			printReachable(program);
			compareOutput(baos.toString(), outFile, expectedFile);
		} finally {
			System.setOut(out);
		}			
	}
	
	private void printReachable(Program p) {
		for (ParamFunc f : p.getParamFuncList()) {
			System.out.print(f.getName().getID() + " = {");
			HashSet<ParamFunc> reachable = f.reachable();
			int size = reachable.size();
			
			TreeSet<String> tree = new TreeSet<String>();
			for (ParamFunc f1 : reachable) {
				tree.add(f1.getName().getID());
			}
			for (String s : tree) {
				if (--size == 0)
					System.out.print(s);
				else
					System.out.print(s + ", ");
			}

			System.out.println("}");
		}
	}
    

    @SuppressWarnings("javadoc")
    @Parameters(name = "{0}")
    public static Iterable<Object[]> getTests() {
	return getTestParameters(TEST_DIR);
    }
}
