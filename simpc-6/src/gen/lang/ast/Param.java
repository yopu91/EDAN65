/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:5
 * @production Param : {@link ASTNode} ::= <span class="component">Type:{@link TypeId}</span> <span class="component">{@link IdDecl}</span>;

 */
public class Param extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PrettyPrint.jrag:197
   */
  public void prettyPrint(PrintStream out, String ind) {
		/*This seems funky. Should probably be "Declare" instead of "getIdDecl" but that goes against Abstract Grammar in jastAdd...?*/
		out.append("int ");
		getIdDecl().prettyPrint(out, ind);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Param() {
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
  public Param(TypeId p0, IdDecl p1) {
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
  public Param clone() throws CloneNotSupportedException {
    Param node = (Param) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:45
   */
  public Param copy() {
    try {
      Param node = (Param) clone();
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
  public Param fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:74
   */
  public Param treeCopyNoTransform() {
    Param tree = (Param) copy();
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
  public Param treeCopy() {
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
   * Replaces the IdDecl child.
   * @param node The new node to replace the IdDecl child.
   * @apilevel high-level
   */
  public void setIdDecl(IdDecl node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the IdDecl child.
   * @return The current node used as the IdDecl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdDecl")
  public IdDecl getIdDecl() {
    return (IdDecl) getChild(1);
  }
  /**
   * Retrieves the IdDecl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdDecl child.
   * @apilevel low-level
   */
  public IdDecl getIdDeclNoTransform() {
    return (IdDecl) getChildNoTransform(1);
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:216
   * @apilevel internal
   */
  public boolean Define_isLocalVariable(ASTNode caller, ASTNode child) {
    if (caller == getIdDeclNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:218
      return false;
    }
    else {
      return getParent().Define_isLocalVariable(this, caller);
    }
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:59
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode caller, ASTNode child) {
    if (caller == getIdDeclNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:65
      return true;
    }
    else {
      return getParent().Define_isVariable(this, caller);
    }
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:70
   * @apilevel internal
   */
  public ParamFunc Define_function(ASTNode caller, ASTNode child) {
    if (caller == getIdDeclNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:82
      return unknownFunc();
    }
    else {
      return getParent().Define_function(this, caller);
    }
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:69
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode caller, ASTNode child) {
    if (caller == getIdDeclNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:83
      return false;
    }
    else {
      return getParent().Define_isFunction(this, caller);
    }
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:138
   * @apilevel internal
   */
  public TypeId Define_expectedType(ASTNode caller, ASTNode child) {
    if (caller == getIdDeclNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:145
      return getIdDecl().type();
    }
    else {
      return getParent().Define_expectedType(this, caller);
    }
  }
}
