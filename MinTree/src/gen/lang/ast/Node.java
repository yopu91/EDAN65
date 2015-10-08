/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/MinTree/src/jastadd/Lang.ast:3
 * @production Node : {@link ASTNode};

 */
public abstract class Node extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Node() {
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
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:15
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:21
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:27
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:33
   */
  public Node clone() throws CloneNotSupportedException {
    Node node = (Node) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:44
   */
  @Deprecated
  public abstract Node fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:52
   */
  public abstract Node treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:60
   */
  public abstract Node treeCopy();
  /**
   * @apilevel internal
   */
  protected boolean localMin_visited = false;
  @ASTNodeAnnotation.Attribute
  public int localMin() {
    if (localMin_visited) {
      throw new RuntimeException("Circular definition of attr: localMin in class: org.jastadd.ast.AST.SynDecl");
    }
    localMin_visited = true;
    int localMin_value = 0;

    localMin_visited = false;
    return localMin_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean nbrOfMinValues_visited = false;
  @ASTNodeAnnotation.Attribute
  public int nbrOfMinValues() {
    if (nbrOfMinValues_visited) {
      throw new RuntimeException("Circular definition of attr: nbrOfMinValues in class: org.jastadd.ast.AST.SynDecl");
    }
    nbrOfMinValues_visited = true;
    int nbrOfMinValues_value = 0;

    nbrOfMinValues_visited = false;
    return nbrOfMinValues_value;
  }
  /**
   * @attribute inh
   * @aspect MinValue
   * @declaredat /h/dk/r/ada10dlu/edan65/MinTree/src/jastadd/MinValue.jrag:6
   */
  @ASTNodeAnnotation.Attribute
  public int globalMin() {
    if (globalMin_visited) {
      throw new RuntimeException("Circular definition of attr: globalMin in class: org.jastadd.ast.AST.InhDecl");
    }
    globalMin_visited = true;
    int globalMin_value = getParent().Define_globalMin(this, null);

    globalMin_visited = false;
    return globalMin_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean globalMin_visited = false;
}
