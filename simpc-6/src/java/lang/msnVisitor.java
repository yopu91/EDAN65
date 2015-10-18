package lang;

import lang.ast.*;

/**
 * Checks MSN in a SimpC program.
 */


public class msnVisitor extends TraversingVisitor {
    // client method
    public static int result(ASTNode n) {
        msnVisitor v = new msnVisitor();
        n.accept(v, 0);
        return v.max_depth;
    }

	    
	// state variables
	private int max_depth = 0;
	
	public Object visit(ParamFunc node, Object data) {
		int a = (Integer) data;
		a++;
		max_depth = Math.max(a,max_depth);
		return super.visit(node,a);
	}
	
	public Object visit(WhileStmt node, Object data) {
		int a = (Integer) data;
		a++;
		max_depth = Math.max(a,max_depth);
		return super.visit(node,a);
	}

	public Object visit(IfStmt node, Object data) {
		int a = (Integer) data;
		a++;
		max_depth = Math.max(a,max_depth);
		return super.visit(node,a);
	}

}


