/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:13
 * @production FuncCall : {@link Expr} ::= <span class="component">Name:{@link IdUse}</span> <span class="component">E:{@link Expr}*</span>;

 */
public class FuncCall extends Expr implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:192
   */
  public void genCode(PrintStream out){
		for(int i = getNumE()-1; i >= 0; i--){
			Expr arg = getE(i);
			arg.genCode(out);
			out.println(		"pushq %rax");	
		}
		out.println(		"call "+getName().getID());
		out.println(		"addq $" + 8*getNumE()+",%rsp");
	
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PrettyPrint.jrag:150
   */
  public void prettyPrint(PrintStream out, String ind) {
		getName().prettyPrint(out, ind+"  ");
		out.append("(");
		for (int i = 0; i<getNumE(); ++i){
			getE(i).prettyPrint(out, ind);
			if(i!=getNumE()-1){
				out.append(", ");
			}
		}
		out.append(")");
	}
  /**
   * @declaredat ASTNode:1
   */
  public FuncCall() {
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
    children = new ASTNode[2];
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public FuncCall(IdUse p0, List<Expr> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:21
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:39
   */
  public FuncCall clone() throws CloneNotSupportedException {
    FuncCall node = (FuncCall) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
   */
  public FuncCall copy() {
    try {
      FuncCall node = (FuncCall) clone();
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
   * @declaredat ASTNode:65
   */
  @Deprecated
  public FuncCall fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:75
   */
  public FuncCall treeCopyNoTransform() {
    FuncCall tree = (FuncCall) copy();
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
   * @declaredat ASTNode:95
   */
  public FuncCall treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:102
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Name child.
   * @param node The new node to replace the Name child.
   * @apilevel high-level
   */
  public void setName(IdUse node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Name child.
   * @return The current node used as the Name child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Name")
  public IdUse getName() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the Name child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Name child.
   * @apilevel low-level
   */
  public IdUse getNameNoTransform() {
    return (IdUse) getChildNoTransform(0);
  }
  /**
   * Replaces the E list.
   * @param list The new list node to be used as the E list.
   * @apilevel high-level
   */
  public void setEList(List<Expr> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the E list.
   * @return Number of children in the E list.
   * @apilevel high-level
   */
  public int getNumE() {
    return getEList().getNumChild();
  }
  /**
   * Retrieves the number of children in the E list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the E list.
   * @apilevel low-level
   */
  public int getNumENoTransform() {
    return getEListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the E list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the E list.
   * @apilevel high-level
   */
  public Expr getE(int i) {
    return (Expr) getEList().getChild(i);
  }
  /**
   * Check whether the E list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasE() {
    return getEList().getNumChild() != 0;
  }
  /**
   * Append an element to the E list.
   * @param node The element to append to the E list.
   * @apilevel high-level
   */
  public void addE(Expr node) {
    List<Expr> list = (parent == null) ? getEListNoTransform() : getEList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addENoTransform(Expr node) {
    List<Expr> list = getEListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the E list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setE(Expr node, int i) {
    List<Expr> list = getEList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the E list.
   * @return The node representing the E list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="E")
  public List<Expr> getEList() {
    List<Expr> list = (List<Expr>) getChild(1);
    return list;
  }
  /**
   * Retrieves the E list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the E list.
   * @apilevel low-level
   */
  public List<Expr> getEListNoTransform() {
    return (List<Expr>) getChildNoTransform(1);
  }
  /**
   * Retrieves the E list.
   * @return The node representing the E list.
   * @apilevel high-level
   */
  public List<Expr> getEs() {
    return getEList();
  }
  /**
   * Retrieves the E list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the E list.
   * @apilevel low-level
   */
  public List<Expr> getEsNoTransform() {
    return getEListNoTransform();
  }
  /**
   * @apilevel internal
   */
  protected boolean type_visited = false;
  @ASTNodeAnnotation.Attribute
  public TypeId type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attr: type in class: org.jastadd.ast.AST.SynDecl");
    }
    type_visited = true;
    TypeId type_value = new IntType();

    type_visited = false;
    return type_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean callVariableError_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean callVariableError() {
    if (callVariableError_visited) {
      throw new RuntimeException("Circular definition of attr: callVariableError in class: org.jastadd.ast.AST.SynDecl");
    }
    callVariableError_visited = true;
    boolean callVariableError_value = !getName().decl().isFunction();

    callVariableError_visited = false;
    return callVariableError_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean paramError_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean paramError() {
    if (paramError_visited) {
      throw new RuntimeException("Circular definition of attr: paramError in class: org.jastadd.ast.AST.SynDecl");
    }
    paramError_visited = true;
    boolean paramError_value = getNumE() != getName().function().getNumParams();

    paramError_visited = false;
    return paramError_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean paramTypeError_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:279
   */
  @ASTNodeAnnotation.Attribute
  public boolean paramTypeError() {
    if (paramTypeError_visited) {
      throw new RuntimeException("Circular definition of attr: paramTypeError in class: org.jastadd.ast.AST.SynDecl");
    }
    paramTypeError_visited = true;
    try {
    	        ParamFunc func = getName().function();
            	for(int i = 0; i < getNumE(); i++) {
                		if (!getE(i).type().comp(func.getParams(i).getIdDecl().type()))
                    		return true;
            	}
            	return false;
        	}
    finally {
      paramTypeError_visited = false;
    }
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:181
   * @apilevel internal
   */
  public boolean Define_checkComp(ASTNode caller, ASTNode child, TypeId t) {
    if (caller == getEListNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:196
      int childIndex = caller.getIndexOfChild(child);
      return t.comp(expectedType());
    }
    else {
      return getParent().Define_checkComp(this, caller, t);
    }
  }
  protected void collect_contributors_Program_errors() {
  /**
   * @attribute coll
   * @aspect ErrorContributions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:83
   */
    if (getName().isFunction() && paramError()) {
      {
        Program ref = (Program) (program());
        if (ref != null) {
          ref.Program_errors_contributors().add(this);
        }
      }
    }
  /**
   * @attribute coll
   * @aspect ErrorContributions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:87
   */
    if (getName().isFunction() && !paramError() && paramTypeError()) {
      {
        Program ref = (Program) (program());
        if (ref != null) {
          ref.Program_errors_contributors().add(this);
        }
      }
    }
  /**
   * @attribute coll
   * @aspect ErrorContributions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:91
   */
    if (callVariableError()) {
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
    if (getName().isFunction() && paramError())
      collection.add(error("cannot call '" + getName().getID() + "': expected " + getName().function().getNumParams() + " arguments, but was " + getNumE()));
    if (getName().isFunction() && !paramError() && paramTypeError())
      collection.add(error("cannot call '" + getName().getID() + "': parameter type mismatch" ));
    if (callVariableError())
      collection.add(error("cannot call '" + getName().getID() + "' because it's a variable!"));
  }

}
