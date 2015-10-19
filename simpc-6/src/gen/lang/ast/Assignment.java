/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:18
 * @production Assignment : {@link Stmt} ::= <span class="component">Identifier:{@link IdUse}</span> <span class="component">Expression:{@link Expr}</span>;

 */
public class Assignment extends Stmt implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:106
   */
  public void genCode(PrintStream out){
		getExpression().genCode(out);
		out.println("		movq %rax, "+getIdentifier().decl().address());	
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PrettyPrint.jrag:93
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(ind);
                getIdentifier().prettyPrint(out, ind);
                out.append(" = ");
                getExpression().prettyPrint(out, ind+"  ");
		out.println(";");
        }
  /**
   * @declaredat ASTNode:1
   */
  public Assignment() {
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
  public Assignment(IdUse p0, Expr p1) {
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
  public Assignment clone() throws CloneNotSupportedException {
    Assignment node = (Assignment) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:45
   */
  public Assignment copy() {
    try {
      Assignment node = (Assignment) clone();
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
  public Assignment fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:74
   */
  public Assignment treeCopyNoTransform() {
    Assignment tree = (Assignment) copy();
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
  public Assignment treeCopy() {
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
   * Replaces the Identifier child.
   * @param node The new node to replace the Identifier child.
   * @apilevel high-level
   */
  public void setIdentifier(IdUse node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Identifier child.
   * @return The current node used as the Identifier child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Identifier")
  public IdUse getIdentifier() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the Identifier child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Identifier child.
   * @apilevel low-level
   */
  public IdUse getIdentifierNoTransform() {
    return (IdUse) getChildNoTransform(0);
  }
  /**
   * Replaces the Expression child.
   * @param node The new node to replace the Expression child.
   * @apilevel high-level
   */
  public void setExpression(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Expression child.
   * @return The current node used as the Expression child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expression")
  public Expr getExpression() {
    return (Expr) getChild(1);
  }
  /**
   * Retrieves the Expression child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expression child.
   * @apilevel low-level
   */
  public Expr getExpressionNoTransform() {
    return (Expr) getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  protected boolean assignFuncError_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean assignFuncError() {
    if (assignFuncError_visited) {
      throw new RuntimeException("Circular definition of attr: assignFuncError in class: org.jastadd.ast.AST.SynDecl");
    }
    assignFuncError_visited = true;
    boolean assignFuncError_value = getIdentifier().isFunction();

    assignFuncError_visited = false;
    return assignFuncError_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeError_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean typeError() {
    if (typeError_visited) {
      throw new RuntimeException("Circular definition of attr: typeError in class: org.jastadd.ast.AST.SynDecl");
    }
    typeError_visited = true;
    boolean typeError_value = !getIdentifier().type().comp(getExpression().type());

    typeError_visited = false;
    return typeError_value;
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:181
   * @apilevel internal
   */
  public boolean Define_checkComp(ASTNode caller, ASTNode child, TypeId t) {
    if (caller == getIdentifierNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:184
      return true;
    }
    else if (caller == getExpressionNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:183
      return t.comp(getIdentifier().decl().type());
    }
    else {
      return getParent().Define_checkComp(this, caller, t);
    }
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:138
   * @apilevel internal
   */
  public TypeId Define_expectedType(ASTNode caller, ASTNode child) {
    if (caller == getExpressionNoTransform()) {
      // @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:220
      return getIdentifier().type();
    }
    else {
      return getParent().Define_expectedType(this, caller);
    }
  }
  protected void collect_contributors_Program_errors() {
  /**
   * @attribute coll
   * @aspect ErrorContributions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:50
   */
    if (typeError()) {
      {
        Program ref = (Program) (program());
        if (ref != null) {
          ref.Program_errors_contributors().add(this);
        }
      }
    }
  /**
   * @attribute coll
   * @aspect ErrorContributions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:54
   */
    if (assignFuncError()) {
      {
        Program ref = (Program) (program());
        if (ref != null) {
          ref.Program_errors_contributors().add(this);
        }
      }
    }
    super.collect_contributors_Program_errors();
  }
  protected void contributeTo_Program_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_Program_errors(collection);
    if (typeError())
      collection.add(error(getIdentifier().getID() + " must be assigned of the type " + getIdentifier().type().toString() + ", but was " + getExpression().type().toString()));
    if (assignFuncError())
      collection.add(error("cannot assign '" + getIdentifier().getID() + "' because it is a function!"));
  }

}
