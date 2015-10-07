/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/CalcRag/src/jastadd/calc.ast:1
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Expr}</span>;

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
  public Program(Expr p0) {
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
    unknownDecl_reset();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    Program_errors_value = null;
    Program_errors_contributors = null;
    collect_contributors_Program_errors = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:43
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:50
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
   * @declaredat ASTNode:69
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
   * @declaredat ASTNode:79
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
   * @declaredat ASTNode:99
   */
  public Program treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:106
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expr")
  public Expr getExpr() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/CalcRag/src/jastadd/Errors.jrag:26
   */
    private boolean collect_contributors_Program_errors = false;
  protected void collect_contributors_Program_errors() {
    if (collect_contributors_Program_errors) return;
    super.collect_contributors_Program_errors();
    collect_contributors_Program_errors = true;
  }

  /**
   * @apilevel internal
   */
  protected boolean unknownDecl_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean unknownDecl_computed = false;
  /**
   * @apilevel internal
   */
  protected UnknownDecl unknownDecl_value;
  /**
   * @apilevel internal
   */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  @ASTNodeAnnotation.Attribute
  public UnknownDecl unknownDecl() {
    ASTNode$State state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attr: unknownDecl in class: org.jastadd.ast.AST.SynDecl");
    }
    unknownDecl_visited = true;
    boolean intermediate = state.INTERMEDIATE_VALUE;
    state.INTERMEDIATE_VALUE = false;
    unknownDecl_value = new UnknownDecl("<unknown>");
    unknownDecl_value.setParent(this);
    if (true) {
      unknownDecl_computed = true;
    } else {
    }
    state.INTERMEDIATE_VALUE |= intermediate;

    unknownDecl_visited = false;
    return unknownDecl_value;
  }
  /**
   * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/CalcRag/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return this;
  }
  /**
   * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/CalcRag/src/jastadd/NameAnalysis.jrag:10
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode caller, ASTNode child, String name) {
    int childIndex = this.getIndexOfChild(caller);
    return unknownDecl();
  }
  /**
   * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/CalcRag/src/jastadd/NameAnalysis.jrag:34
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode caller, ASTNode child, IdDecl decl) {
    int childIndex = this.getIndexOfChild(caller);
    return false;
  }
  /**
   * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/CalcRag/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return unknownDecl();
  }
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /h/dc/y/zba08ath/EDAN65/A2/EDAN65/CalcRag/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute
  public Set<ErrorMessage> errors() {
    ASTNode$State state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attr: errors in class: org.jastadd.ast.AST.CollDecl");
    }
    Program_errors_visited = true;
    boolean intermediate = state.INTERMEDIATE_VALUE;
    state.INTERMEDIATE_VALUE = false;
    Program_errors_value = errors_compute();
    if (true) {
      Program_errors_computed = true;
    } else {
    }
    state.INTERMEDIATE_VALUE |= intermediate;

    Program_errors_visited = false;
    return Program_errors_value;
  }
  java.util.Collection Program_errors_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for errors
   */
  public java.util.Collection Program_errors_contributors() {
    if (Program_errors_contributors == null)
      Program_errors_contributors  = new java.util.LinkedList();
    return Program_errors_contributors;
  }

  /**
   * @apilevel internal
   */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.collect_contributors_Program_errors();
    Program_errors_value = new TreeSet<ErrorMessage>();
    if (Program_errors_contributors != null) {
      for (java.util.Iterator iter = Program_errors_contributors.iterator(); iter.hasNext(); ) {
        ASTNode contributor = (ASTNode) iter.next();
        contributor.contributeTo_Program_Program_errors(Program_errors_value);
      }
    }
    // TODO: disabled temporarily since collections may not be cached
    //Program_errors_contributors = null;
    return Program_errors_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean Program_errors_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean Program_errors_computed = false;
  /**
   * @apilevel internal
   */
  protected Set<ErrorMessage> Program_errors_value;
  /**
   * @apilevel internal
   */
  private void Program_errors_reset() {
    Program_errors_computed = false;
    Program_errors_value = null;
    Program_errors_visited = false;
  }
}
