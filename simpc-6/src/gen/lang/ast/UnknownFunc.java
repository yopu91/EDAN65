/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:23
 * @production UnknownFunc : {@link ParamFunc};

 */
public class UnknownFunc extends ParamFunc implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public UnknownFunc() {
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
    children = new ASTNode[4];
    setChild(new List(), 2);
    setChild(new List(), 3);
  }
  /**
   * @declaredat ASTNode:15
   */
  public UnknownFunc(TypeId p0, IdDecl p1, List<Param> p2, List<Stmt> p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 4;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:30
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:36
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:42
   */
  public UnknownFunc clone() throws CloneNotSupportedException {
    UnknownFunc node = (UnknownFunc) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:49
   */
  public UnknownFunc copy() {
    try {
      UnknownFunc node = (UnknownFunc) clone();
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
   * @declaredat ASTNode:68
   */
  @Deprecated
  public UnknownFunc fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:78
   */
  public UnknownFunc treeCopyNoTransform() {
    UnknownFunc tree = (UnknownFunc) copy();
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
   * @declaredat ASTNode:98
   */
  public UnknownFunc treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:105
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Type child.
   * @param node The new node to replace the Type child.
   * @apilevel high-level
   */
  public void setType(TypeId node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Type child.
   * @return The current node used as the Type child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Type")
  public TypeId getType() {
    return (TypeId) getChild(0);
  }
  /**
   * Retrieves the Type child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Type child.
   * @apilevel low-level
   */
  public TypeId getTypeNoTransform() {
    return (TypeId) getChildNoTransform(0);
  }
  /**
   * Replaces the Name child.
   * @param node The new node to replace the Name child.
   * @apilevel high-level
   */
  public void setName(IdDecl node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Name child.
   * @return The current node used as the Name child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Name")
  public IdDecl getName() {
    return (IdDecl) getChild(1);
  }
  /**
   * Retrieves the Name child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Name child.
   * @apilevel low-level
   */
  public IdDecl getNameNoTransform() {
    return (IdDecl) getChildNoTransform(1);
  }
  /**
   * Replaces the Params list.
   * @param list The new list node to be used as the Params list.
   * @apilevel high-level
   */
  public void setParamsList(List<Param> list) {
    setChild(list, 2);
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
    List<Param> list = (List<Param>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Params list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Params list.
   * @apilevel low-level
   */
  public List<Param> getParamsListNoTransform() {
    return (List<Param>) getChildNoTransform(2);
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
    setChild(list, 3);
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
    List<Stmt> list = (List<Stmt>) getChild(3);
    return list;
  }
  /**
   * Retrieves the Stmts list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmts list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtsListNoTransform() {
    return (List<Stmt>) getChildNoTransform(3);
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
  /**
   * @apilevel internal
   */
  protected boolean isFunction_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean isFunction() {
    if (isFunction_visited) {
      throw new RuntimeException("Circular definition of attr: isFunction in class: org.jastadd.ast.AST.SynDecl");
    }
    isFunction_visited = true;
    boolean isFunction_value = true;

    isFunction_visited = false;
    return isFunction_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean function_visited = false;
  @ASTNodeAnnotation.Attribute
  public ParamFunc function() {
    if (function_visited) {
      throw new RuntimeException("Circular definition of attr: function in class: org.jastadd.ast.AST.SynDecl");
    }
    function_visited = true;
    ParamFunc function_value = unknownFunc();

    function_visited = false;
    return function_value;
  }
}
