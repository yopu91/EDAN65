/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/lab2-simpc/src/jastadd/lang.ast:10
 * @production IfStmt : {@link Stmt} ::= <span class="component">Cond:{@link Expr}</span> <span class="component">Then:{@link Stmt}*</span>;

 */
public class IfStmt extends Stmt implements Cloneable {
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
    children = new ASTNode[2];
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public IfStmt(Expr p0, List<Stmt> p1) {
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
  public IfStmt clone() throws CloneNotSupportedException {
    IfStmt node = (IfStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
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
   * @declaredat ASTNode:65
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
   * @declaredat ASTNode:75
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
   * @declaredat ASTNode:95
   */
  public IfStmt treeCopy() {
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
}
