/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/lab2-simpc/src/jastadd/lang.ast:1
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Function}</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
  public Program(Function p0) {
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
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:44
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
  public Program treeCopy() {
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
   * Replaces the Function child.
   * @param node The new node to replace the Function child.
   * @apilevel high-level
   */
  public void setFunction(Function node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Function child.
   * @return The current node used as the Function child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Function")
  public Function getFunction() {
    return (Function) getChild(0);
  }
  /**
   * Retrieves the Function child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Function child.
   * @apilevel low-level
   */
  public Function getFunctionNoTransform() {
    return (Function) getChildNoTransform(0);
  }
}
