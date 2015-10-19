/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/lang.ast:10
 * @production IfStmt : {@link Stmt} ::= <span class="component">Cond:{@link Expr}</span> <span class="component">Then:{@link Stmt}*</span> <span class="component">[{@link ElseStmt}]</span>;

 */
public class IfStmt extends Stmt implements Cloneable {
  /**
   * @aspect NameAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/NameAnalysis.jrag:93
   */
  public void checkNames(PrintStream err, SymbolTable symbols){
		getCond().checkNames(err, symbols);
		SymbolTable ThenSymbols = symbols.push();

                for(int i = 0; i < getNumThen(); ++i){
                        getThen(i).checkNames(err, ThenSymbols);
                }
		if(hasElseStmt() && getElseStmt() != null){
			getElseStmt().checkNames(err, symbols.push());
		}
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/PrettyPrint.jrag:117
   */
  public void prettyPrint(PrintStream out, String ind) {

		out.print(ind + "if (");
                getCond().prettyPrint(out, ind);
                out.println("){");		

		 for(int i = 0; i<getNumThen(); ++i) {
                        getThen(i).prettyPrint(out, ind+"  ");
                }
		out.println(ind + "}");
	
		if(hasElseStmt() && getElseStmt() != null){

			out.println(ind + "else {");
			getElseStmt().prettyPrint(out, ind);
			out.println(ind + "}");
		}
	}
  /**
   * @aspect Visitor
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/Visitor.jrag:57
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public IfStmt() {
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
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:15
   */
  public IfStmt(Expr p0, List<Stmt> p1, Opt<ElseStmt> p2) {
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
  public IfStmt clone() throws CloneNotSupportedException {
    IfStmt node = (IfStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:48
   */
  public IfStmt copy() {
    try {
      IfStmt node = (IfStmt) clone();
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
  public IfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:77
   */
  public IfStmt treeCopyNoTransform() {
    IfStmt tree = (IfStmt) copy();
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
  public IfStmt treeCopy() {
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
   * Replaces the Cond child.
   * @param node The new node to replace the Cond child.
   * @apilevel high-level
   */
  public void setCond(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Cond child.
   * @return The current node used as the Cond child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Cond")
  public Expr getCond() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Cond child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Cond child.
   * @apilevel low-level
   */
  public Expr getCondNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Then list.
   * @param list The new list node to be used as the Then list.
   * @apilevel high-level
   */
  public void setThenList(List<Stmt> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Then list.
   * @return Number of children in the Then list.
   * @apilevel high-level
   */
  public int getNumThen() {
    return getThenList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Then list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Then list.
   * @apilevel low-level
   */
  public int getNumThenNoTransform() {
    return getThenListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Then list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Then list.
   * @apilevel high-level
   */
  public Stmt getThen(int i) {
    return (Stmt) getThenList().getChild(i);
  }
  /**
   * Check whether the Then list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasThen() {
    return getThenList().getNumChild() != 0;
  }
  /**
   * Append an element to the Then list.
   * @param node The element to append to the Then list.
   * @apilevel high-level
   */
  public void addThen(Stmt node) {
    List<Stmt> list = (parent == null) ? getThenListNoTransform() : getThenList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addThenNoTransform(Stmt node) {
    List<Stmt> list = getThenListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Then list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setThen(Stmt node, int i) {
    List<Stmt> list = getThenList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Then list.
   * @return The node representing the Then list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Then")
  public List<Stmt> getThenList() {
    List<Stmt> list = (List<Stmt>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Then list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Then list.
   * @apilevel low-level
   */
  public List<Stmt> getThenListNoTransform() {
    return (List<Stmt>) getChildNoTransform(1);
  }
  /**
   * Retrieves the Then list.
   * @return The node representing the Then list.
   * @apilevel high-level
   */
  public List<Stmt> getThens() {
    return getThenList();
  }
  /**
   * Retrieves the Then list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Then list.
   * @apilevel low-level
   */
  public List<Stmt> getThensNoTransform() {
    return getThenListNoTransform();
  }
  /**
   * Replaces the optional node for the ElseStmt child. This is the <code>Opt</code>
   * node containing the child ElseStmt, not the actual child!
   * @param opt The new node to be used as the optional node for the ElseStmt child.
   * @apilevel low-level
   */
  public void setElseStmtOpt(Opt<ElseStmt> opt) {
    setChild(opt, 2);
  }
  /**
   * Replaces the (optional) ElseStmt child.
   * @param node The new node to be used as the ElseStmt child.
   * @apilevel high-level
   */
  public void setElseStmt(ElseStmt node) {
    getElseStmtOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional ElseStmt child exists.
   * @return {@code true} if the optional ElseStmt child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasElseStmt() {
    return getElseStmtOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) ElseStmt child.
   * @return The ElseStmt child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public ElseStmt getElseStmt() {
    return (ElseStmt) getElseStmtOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the ElseStmt child. This is the <code>Opt</code> node containing the child ElseStmt, not the actual child!
   * @return The optional node for child the ElseStmt child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="ElseStmt")
  public Opt<ElseStmt> getElseStmtOpt() {
    return (Opt<ElseStmt>) getChild(2);
  }
  /**
   * Retrieves the optional node for child ElseStmt. This is the <code>Opt</code> node containing the child ElseStmt, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ElseStmt.
   * @apilevel low-level
   */
  public Opt<ElseStmt> getElseStmtOptNoTransform() {
    return (Opt<ElseStmt>) getChildNoTransform(2);
  }
}
