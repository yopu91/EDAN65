/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/lang.ast:4
 * @production ParamFunc : {@link ASTNode} ::= <span class="component">Name:{@link IdDecl}</span> <span class="component">Params:{@link Param}*</span> <span class="component">Stmts:{@link Stmt}*</span>;

 */
public class ParamFunc extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect NameAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/NameAnalysis.jrag:134
   */
  public void checkNames(PrintStream err, SymbolTable symbols){

		getName().checkNames(err,symbols);
		symbols = symbols.push(); //Nyskapat scope vilekt goer att referencing kan goras

		for(int i=0; i<getNumParams(); ++i){
			getParams(i).checkNames(err, symbols);
		}
		for(int i=0; i<getNumStmts(); ++i){
			getStmts(i).checkNames(err, symbols);
		}
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/PrettyPrint.jrag:177
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(ind + "int ");
		getName().prettyPrint(out, ind);
		out.append("("); 
		for(int i = 0; i<getNumParams(); ++i){
			getParams(i).prettyPrint(out, ind+"  ");
			if(i!=getNumParams()-1) {
				out.append(", ");
			}
		}
		out.println("){");

		 for(int i = 0; i<getNumStmts(); ++i) {
                        getStmts(i).prettyPrint(out, ind+"  ");
                }
		out.println("}");

	}
  /**
   * @aspect Visitor
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/Visitor.jrag:50
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public ParamFunc() {
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
    children = new ASTNode[3];
    setChild(new List(), 1);
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:15
   */
  public ParamFunc(IdDecl p0, List<Param> p1, List<Stmt> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 3;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:29
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:35
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:41
   */
  public ParamFunc clone() throws CloneNotSupportedException {
    ParamFunc node = (ParamFunc) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:48
   */
  public ParamFunc copy() {
    try {
      ParamFunc node = (ParamFunc) clone();
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
   * @declaredat ASTNode:67
   */
  @Deprecated
  public ParamFunc fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:77
   */
  public ParamFunc treeCopyNoTransform() {
    ParamFunc tree = (ParamFunc) copy();
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
   * @declaredat ASTNode:97
   */
  public ParamFunc treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:104
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Name child.
   * @param node The new node to replace the Name child.
   * @apilevel high-level
   */
  public void setName(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Name child.
   * @return The current node used as the Name child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Name")
  public IdDecl getName() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the Name child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Name child.
   * @apilevel low-level
   */
  public IdDecl getNameNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the Params list.
   * @param list The new list node to be used as the Params list.
   * @apilevel high-level
   */
  public void setParamsList(List<Param> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Params list.
   * @return Number of children in the Params list.
   * @apilevel high-level
   */
  public int getNumParams() {
    return getParamsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Params list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Params list.
   * @apilevel low-level
   */
  public int getNumParamsNoTransform() {
    return getParamsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Params list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Params list.
   * @apilevel high-level
   */
  public Param getParams(int i) {
    return (Param) getParamsList().getChild(i);
  }
  /**
   * Check whether the Params list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasParams() {
    return getParamsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Params list.
   * @param node The element to append to the Params list.
   * @apilevel high-level
   */
  public void addParams(Param node) {
    List<Param> list = (parent == null) ? getParamsListNoTransform() : getParamsList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addParamsNoTransform(Param node) {
    List<Param> list = getParamsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Params list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setParams(Param node, int i) {
    List<Param> list = getParamsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Params list.
   * @return The node representing the Params list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Params")
  public List<Param> getParamsList() {
    List<Param> list = (List<Param>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Params list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Params list.
   * @apilevel low-level
   */
  public List<Param> getParamsListNoTransform() {
    return (List<Param>) getChildNoTransform(1);
  }
  /**
   * Retrieves the Params list.
   * @return The node representing the Params list.
   * @apilevel high-level
   */
  public List<Param> getParamss() {
    return getParamsList();
  }
  /**
   * Retrieves the Params list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Params list.
   * @apilevel low-level
   */
  public List<Param> getParamssNoTransform() {
    return getParamsListNoTransform();
  }
  /**
   * Replaces the Stmts list.
   * @param list The new list node to be used as the Stmts list.
   * @apilevel high-level
   */
  public void setStmtsList(List<Stmt> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the Stmts list.
   * @return Number of children in the Stmts list.
   * @apilevel high-level
   */
  public int getNumStmts() {
    return getStmtsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Stmts list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Stmts list.
   * @apilevel low-level
   */
  public int getNumStmtsNoTransform() {
    return getStmtsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Stmts list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Stmts list.
   * @apilevel high-level
   */
  public Stmt getStmts(int i) {
    return (Stmt) getStmtsList().getChild(i);
  }
  /**
   * Check whether the Stmts list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasStmts() {
    return getStmtsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Stmts list.
   * @param node The element to append to the Stmts list.
   * @apilevel high-level
   */
  public void addStmts(Stmt node) {
    List<Stmt> list = (parent == null) ? getStmtsListNoTransform() : getStmtsList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addStmtsNoTransform(Stmt node) {
    List<Stmt> list = getStmtsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Stmts list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setStmts(Stmt node, int i) {
    List<Stmt> list = getStmtsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Stmts list.
   * @return The node representing the Stmts list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Stmts")
  public List<Stmt> getStmtsList() {
    List<Stmt> list = (List<Stmt>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Stmts list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmts list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtsListNoTransform() {
    return (List<Stmt>) getChildNoTransform(2);
  }
  /**
   * Retrieves the Stmts list.
   * @return The node representing the Stmts list.
   * @apilevel high-level
   */
  public List<Stmt> getStmtss() {
    return getStmtsList();
  }
  /**
   * Retrieves the Stmts list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmts list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtssNoTransform() {
    return getStmtsListNoTransform();
  }
}
