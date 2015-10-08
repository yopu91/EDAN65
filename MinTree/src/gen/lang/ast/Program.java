/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/MinTree/src/jastadd/Lang.ast:1
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Node}</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/MinTree/src/jastadd/PrettyPrint.jadd:17
   */
  public void prettyPrint(PrintStream out, String ind) {
		getNode().prettyPrint(out, ind);
	}
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
  public Program(Node p0) {
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
   * Replaces the Node child.
   * @param node The new node to replace the Node child.
   * @apilevel high-level
   */
  public void setNode(Node node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Node child.
   * @return The current node used as the Node child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Node")
  public Node getNode() {
    return (Node) getChild(0);
  }
  /**
   * Retrieves the Node child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Node child.
   * @apilevel low-level
   */
  public Node getNodeNoTransform() {
    return (Node) getChildNoTransform(0);
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
   * @declaredat /h/dk/r/ada10dlu/edan65/MinTree/src/jastadd/MinValue.jrag:6
   * @apilevel internal
   */
  public int Define_globalMin(ASTNode caller, ASTNode child) {
    if (caller == getNodeNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/MinTree/src/jastadd/MinValue.jrag:7
      return 0;
    }
    else {
      return getParent().Define_globalMin(this, caller);
    }
  }
}
