/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:15
 * @production FuncStmt : {@link Stmt} ::= <span class="component">{@link FuncCall}</span>;

 */
public class FuncStmt extends Stmt implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:102
   */
  public void genCode(PrintStream out){
		getFuncCall().genCode(out);	
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PrettyPrint.jrag:161
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.append(ind);
		getFuncCall().prettyPrint(out, ind);
		out.println(";");
	}
  /**
   * @declaredat ASTNode:1
   */
  public FuncStmt() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  public FuncStmt(FuncCall p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:19
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:25
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:37
   */
  public FuncStmt clone() throws CloneNotSupportedException {
    FuncStmt node = (FuncStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:44
   */
  public FuncStmt copy() {
    try {
      FuncStmt node = (FuncStmt) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:63
   */
  @Deprecated
  public FuncStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public FuncStmt treeCopyNoTransform() {
    FuncStmt tree = (FuncStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:93
   */
  public FuncStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:100
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the FuncCall child.
   * @param node The new node to replace the FuncCall child.
   * @apilevel high-level
   */
  public void setFuncCall(FuncCall node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FuncCall child.
   * @return The current node used as the FuncCall child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FuncCall")
  public FuncCall getFuncCall() {
    return (FuncCall) getChild(0);
  }
  /**
   * Retrieves the FuncCall child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FuncCall child.
   * @apilevel low-level
   */
  public FuncCall getFuncCallNoTransform() {
    return (FuncCall) getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected boolean typeError_visited = false;
  /******* Never called ???? 
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:266
   */
  @ASTNodeAnnotation.Attribute
  public boolean typeError() {
    if (typeError_visited) {
      throw new RuntimeException("Circular definition of attr: typeError in class: org.jastadd.ast.AST.SynDecl");
    }
    typeError_visited = true;
    try {
    		if(getFuncCall().getName().isVariable()){
    			return true;
    		}
    		return false;
    	}
    finally {
      typeError_visited = false;
    }
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:181
   * @apilevel internal
   */
  public boolean Define_checkComp(ASTNode caller, ASTNode child, TypeId t) {
    if (caller == getFuncCallNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:194
      return true;
    }
    else {
      return getParent().Define_checkComp(this, caller, t);
    }
  }
  protected void collect_contributors_Program_errors() {
  /**
   * @attribute coll
   * @aspect ErrorContributions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:78
   */
    if (typeError()) {
      {
        Program ref = (Program) (program());
        if (ref != null) {
          ref.Program_errors_contributors().add(this);
        }
      }
    }
    super.collect_contributors_Program_errors();
  }
  protected void contributeTo_Program_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_Program_errors(collection);
    if (typeError())
      collection.add(error("cannot call '" + getFuncCall().getName().getID() + "' because it is not a function!"));
  }

}
