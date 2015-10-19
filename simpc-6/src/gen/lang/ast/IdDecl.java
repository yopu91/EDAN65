/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:28
 * @production IdDecl : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span>;

 */
public class IdDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:211
   */
  public void genCode(PrintStream out) {
		out.println("        movq " + address() + ", %rax");
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PrettyPrint.jrag:216
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(getID());
	}
  /**
   * @declaredat ASTNode:1
   */
  public IdDecl() {
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
  public IdDecl(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public IdDecl(beaver.Symbol p0) {
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
  public IdDecl clone() throws CloneNotSupportedException {
    IdDecl node = (IdDecl) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
   */
  public IdDecl copy() {
    try {
      IdDecl node = (IdDecl) clone();
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
  public IdDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:75
   */
  public IdDecl treeCopyNoTransform() {
    IdDecl tree = (IdDecl) copy();
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
  public IdDecl treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:102
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((IdDecl)node).tokenString_ID);    
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
  protected boolean address_visited = false;
  /**
   * Address of local variable variable in the current stack frame.
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:226
   */
  @ASTNodeAnnotation.Attribute
  public String address() {
    if (address_visited) {
      throw new RuntimeException("Circular definition of attr: address in class: org.jastadd.ast.AST.SynDecl");
    }
    address_visited = true;
    try { 
    		if(!isLocalVariable()){
    			return (paramIndex()*8)+"(%rbp)";
    		}
    		return "-"+(localIndex()*8)+"(%rbp)";
    	}
    finally {
      address_visited = false;
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean localIndex_visited = false;
  @ASTNodeAnnotation.Attribute
  public int localIndex() {
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attr: localIndex in class: org.jastadd.ast.AST.SynDecl");
    }
    localIndex_visited = true;
    int localIndex_value = prevNode().localIndex() + 1;

    localIndex_visited = false;
    return localIndex_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean paramIndex_visited = false;
  @ASTNodeAnnotation.Attribute
  public int paramIndex() {
    if (paramIndex_visited) {
      throw new RuntimeException("Circular definition of attr: paramIndex in class: org.jastadd.ast.AST.SynDecl");
    }
    paramIndex_visited = true;
    int paramIndex_value = prevNode().paramIndex()+1;

    paramIndex_visited = false;
    return paramIndex_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean isMultiplyDeclared_visited = false;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/NameAnalysis.jrag:132
   */
  @ASTNodeAnnotation.Attribute
  public boolean isMultiplyDeclared() {
    if (isMultiplyDeclared_visited) {
      throw new RuntimeException("Circular definition of attr: isMultiplyDeclared in class: org.jastadd.ast.AST.SynDecl");
    }
    isMultiplyDeclared_visited = true;
    try {
    		IdDecl decl = lookup(getID());
    		if(decl.isUnknown()){
    			return false;
    		}
    		return decl != this;
    	}
    finally {
      isMultiplyDeclared_visited = false;
    }
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
    TypeId type_value = new IntType();

    type_visited = false;
    return type_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean isUnknown_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean isUnknown() {
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attr: isUnknown in class: org.jastadd.ast.AST.SynDecl");
    }
    isUnknown_visited = true;
    boolean isUnknown_value = false;

    isUnknown_visited = false;
    return isUnknown_value;
  }
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:216
   */
  @ASTNodeAnnotation.Attribute
  public boolean isLocalVariable() {
    if (isLocalVariable_visited) {
      throw new RuntimeException("Circular definition of attr: isLocalVariable in class: org.jastadd.ast.AST.InhDecl");
    }
    isLocalVariable_visited = true;
    boolean isLocalVariable_value = getParent().Define_isLocalVariable(this, null);

    isLocalVariable_visited = false;
    return isLocalVariable_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean isLocalVariable_visited = false;
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/NameAnalysis.jrag:35
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
  /******************************* FUNCTIONS 
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:59
   */
  @ASTNodeAnnotation.Attribute
  public boolean isVariable() {
    if (isVariable_visited) {
      throw new RuntimeException("Circular definition of attr: isVariable in class: org.jastadd.ast.AST.InhDecl");
    }
    isVariable_visited = true;
    boolean isVariable_value = getParent().Define_isVariable(this, null);

    isVariable_visited = false;
    return isVariable_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean isVariable_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:69
   */
  @ASTNodeAnnotation.Attribute
  public boolean isFunction() {
    if (isFunction_visited) {
      throw new RuntimeException("Circular definition of attr: isFunction in class: org.jastadd.ast.AST.InhDecl");
    }
    isFunction_visited = true;
    boolean isFunction_value = getParent().Define_isFunction(this, null);

    isFunction_visited = false;
    return isFunction_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean isFunction_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:70
   */
  @ASTNodeAnnotation.Attribute
  public ParamFunc function() {
    if (function_visited) {
      throw new RuntimeException("Circular definition of attr: function in class: org.jastadd.ast.AST.InhDecl");
    }
    function_visited = true;
    ParamFunc function_value = getParent().Define_function(this, null);

    function_visited = false;
    return function_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean function_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:138
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
  protected void collect_contributors_Program_errors() {
  /**
   * @attribute coll
   * @aspect ErrorContributions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:38
   */
    if (isMultiplyDeclared()) {
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
    if (isMultiplyDeclared())
      collection.add(error("symbol '" + getID() + "' is already declared!"));
  }

}
