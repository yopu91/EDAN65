package lang;

import lang.ast.*;

/**
 * Checks MSN in a SimpC program.
 */


public class msnVisitor extends TraversingVisitor {
    // client method
    public static int result(ASTNode n) {
        msnVisitor v = new msnVisitor();
        n.accept(v, null);
        return v.counter;
    }

	    
	// state variables
    private int counter = 0;

	public Object visit(ParamFunc node, Object data) {
		counter++;
		return data;
	}

	
	public Object visit(Stmt node, Object data) {
		counter++;
		return data;
	}
	
}


