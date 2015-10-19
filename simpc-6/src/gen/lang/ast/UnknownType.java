/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:33
 * @production UnknownType : {@link TypeId};

 */
public class UnknownType extends TypeId implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public UnknownType() {
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
   * @declaredat ASTNode:12
   */
  public UnknownType(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public UnknownType(beaver.Symbol p0) {
    setID(p0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:21
   */
  protected int numChildren() {
    return 0;
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
  public UnknownType clone() throws CloneNotSupportedException {
    UnknownType node = (UnknownType) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
   */
  public UnknownType copy() {
    try {
      UnknownType node = (UnknownType) clone();
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
  public UnknownType fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:75
   */
  public UnknownType treeCopyNoTransform() {
    UnknownType tree = (UnknownType) copy();
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
  public UnknownType treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:102
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((UnknownType)node).tokenString_ID);    
  }
  /**
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
  /**
   * @apilevel internal
   */
  protected boolean isUnknownType_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean isUnknownType() {
    if (isUnknownType_visited) {
      throw new RuntimeException("Circular definition of attr: isUnknownType in class: org.jastadd.ast.AST.SynDecl");
    }
    isUnknownType_visited = true;
    boolean isUnknownType_value = true;

    isUnknownType_visited = false;
    return isUnknownType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean toString_visited = false;
  @ASTNodeAnnotation.Attribute
  public String toString() {
    if (toString_visited) {
      throw new RuntimeException("Circular definition of attr: toString in class: org.jastadd.ast.AST.SynDecl");
    }
    toString_visited = true;
    String toString_value = "<UnknownType>";

    toString_visited = false;
    return toString_value;
  }
}
