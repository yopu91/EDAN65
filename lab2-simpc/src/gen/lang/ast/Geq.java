/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/lab2-simpc/src/jastadd/lang.ast:32
 * @production Geq : {@link Expr} ::= <span class="component">Left:{@link Expr}</span> <span class="component">Right:{@link Expr}</span>;

 */
public class Geq extends Expr implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Geq() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  public Geq(Expr p0, Expr p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:20
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:26
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:38
   */
  public Geq clone() throws CloneNotSupportedException {
    Geq node = (Geq) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:45
   */
  public Geq copy() {
    try {
      Geq node = (Geq) clone();
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
   * @declaredat ASTNode:64
   */
  @Deprecated
  public Geq fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:74
   */
  public Geq treeCopyNoTransform() {
    Geq tree = (Geq) copy();
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
   * @declaredat ASTNode:94
   */
  public Geq treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:101
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Left child.
   * @param node The new node to replace the Left child.
   * @apilevel high-level
   */
  public void setLeft(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Left")
  public Expr getLeft() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   */
  public Expr getLeftNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Right child.
   * @param node The new node to replace the Right child.
   * @apilevel high-level
   */
  public void setRight(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Right child.
   * @return The current node used as the Right child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Right")
  public Expr getRight() {
    return (Expr) getChild(1);
  }
  /**
   * Retrieves the Right child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Right child.
   * @apilevel low-level
   */
  public Expr getRightNoTransform() {
    return (Expr) getChildNoTransform(1);
  }
}
