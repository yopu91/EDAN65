/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:27
 * @production IdUse : {@link Expr} ::= <span class="component">&lt;ID:String&gt;</span>;

 */
public class IdUse extends Expr implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:207
   */
  public void genCode(PrintStream out) {
	//	out.println("        movq " + address() + ", %rax");
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PrettyPrint.jrag:212
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(getID());
	}
  /**
   * @declaredat ASTNode:1
   */
  public IdUse() {
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
  public IdUse(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public IdUse(beaver.Symbol p0) {
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
  public IdUse clone() throws CloneNotSupportedException {
    IdUse node = (IdUse) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
   */
  public IdUse copy() {
    try {
      IdUse node = (IdUse) clone();
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
  public IdUse fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:75
   */
  public IdUse treeCopyNoTransform() {
    IdUse tree = (IdUse) copy();
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
  public IdUse treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:102
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((IdUse)node).tokenString_ID);    
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
   * @apilevel internal
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
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
  protected boolean decl_visited = false;
  @ASTNodeAnnotation.Attribute
  public IdDecl decl() {
    if (decl_visited) {
      throw new RuntimeException("Circular definition of attr: decl in class: org.jastadd.ast.AST.SynDecl");
    }
    decl_visited = true;
    IdDecl decl_value = lookup(getID());

    decl_visited = false;
    return decl_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean isCircular_visited = false;
  /**
   * @attribute syn
   * @aspect CircularDefinitions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/NameAnalysis.jrag:146
   */
  @ASTNodeAnnotation.Attribute
  public boolean isCircular() {
    if (isCircular_visited) {
      throw new RuntimeException("Circular definition of attr: isCircular in class: org.jastadd.ast.AST.SynDecl");
    }
    isCircular_visited = true;
    try { 
    		return inExprOf(decl());
    	}
    finally {
      isCircular_visited = false;
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean isVariable_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean isVariable() {
    if (isVariable_visited) {
      throw new RuntimeException("Circular definition of attr: isVariable in class: org.jastadd.ast.AST.SynDecl");
    }
    isVariable_visited = true;
    boolean isVariable_value = false;

    isVariable_visited = false;
    return isVariable_value;
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
    boolean isFunction_value = decl().isFunction();

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
    ParamFunc function_value = decl().function();

    function_visited = false;
    return function_value;
  }
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
    TypeId type_value = decl().type();

    type_visited = false;
    return type_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/NameAnalysis.jrag:33
   */
  @ASTNodeAnnotation.Attribute
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attr: lookup in class: org.jastadd.ast.AST.InhDecl");
    }
    lookup_String_visited.add(_parameters);
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);

    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set lookup_String_visited;
  /**
   * @attribute inh
   * @aspect CircularDefinitions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/NameAnalysis.jrag:149
   */
  @ASTNodeAnnotation.Attribute
  public boolean inExprOf(IdDecl decl) {
    Object _parameters = decl;
    if (inExprOf_IdDecl_visited == null) inExprOf_IdDecl_visited = new java.util.HashSet(4);
    if (inExprOf_IdDecl_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attr: inExprOf in class: org.jastadd.ast.AST.InhDecl");
    }
    inExprOf_IdDecl_visited.add(_parameters);
    boolean inExprOf_IdDecl_value = getParent().Define_inExprOf(this, null, decl);

    inExprOf_IdDecl_visited.remove(_parameters);
    return inExprOf_IdDecl_value;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set inExprOf_IdDecl_visited;
  protected void collect_contributors_Program_errors() {
  /**
   * @attribute coll
   * @aspect ErrorContributions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:34
   */
    if (decl().isUnknown()) {
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
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:42
   */
    if (isCircular()) {
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
    if (decl().isUnknown())
      collection.add(error("symbol '" + getID() + "' is not declared"));
    if (isCircular())
      collection.add(error("the definition of symbol '" + getID() + "' is circular"));
  }

}
