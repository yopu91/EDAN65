/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**************************************************************
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:25
 * @production Expr : {@link ASTNode};

 */
public abstract class Expr extends ASTNode<ASTNode> implements Cloneable {
  /**
   * Generate code to evaluate the expression and
   * store the result in RAX.
   * 
   * This must be implemented for every subclass of Expr!
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:126
   */
  public void genCode(PrintStream out){
		out.println("Missing code gen for "+ this.toString());
	}
  /**
   * @declaredat ASTNode:1
   */
  public Expr() {
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
  public Expr clone() throws CloneNotSupportedException {
    Expr node = (Expr) super.clone();
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
  public abstract Expr fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:52
   */
  public abstract Expr treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:60
   */
  public abstract Expr treeCopy();
  /**
   * @apilevel internal
   */
  protected boolean type_visited = false;
  @ASTNodeAnnotation.Attribute
  public TypeId type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attr: type in class: org.jastadd.ast.AST.SynDecl");
    }
    type_visited = true;
    TypeId type_value = new UnknownType();

    type_visited = false;
    return type_value;
  }
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:179
   */
  @ASTNodeAnnotation.Attribute
  public TypeId expectedType() {
    if (expectedType_visited) {
      throw new RuntimeException("Circular definition of attr: expectedType in class: org.jastadd.ast.AST.InhDecl");
    }
    expectedType_visited = true;
    TypeId expectedType_value = getParent().Define_expectedType(this, null);

    expectedType_visited = false;
    return expectedType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean expectedType_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:181
   */
  @ASTNodeAnnotation.Attribute
  public boolean checkComp(TypeId t) {
    Object _parameters = t;
    if (checkComp_TypeId_visited == null) checkComp_TypeId_visited = new java.util.HashSet(4);
    if (checkComp_TypeId_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attr: checkComp in class: org.jastadd.ast.AST.InhDecl");
    }
    checkComp_TypeId_visited.add(_parameters);
    boolean checkComp_TypeId_value = getParent().Define_checkComp(this, null, t);

    checkComp_TypeId_visited.remove(_parameters);
    return checkComp_TypeId_value;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set checkComp_TypeId_visited;
}
