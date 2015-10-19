/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:30
 * @production TypeId : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span>;

 */
public abstract class TypeId extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public TypeId() {
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
  public TypeId(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public TypeId(beaver.Symbol p0) {
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
  public TypeId clone() throws CloneNotSupportedException {
    TypeId node = (TypeId) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:50
   */
  @Deprecated
  public abstract TypeId fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:58
   */
  public abstract TypeId treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:66
   */
  public abstract TypeId treeCopy();
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
  protected boolean isUnknownType_visited = false;
  @ASTNodeAnnotation.Attribute
  public boolean isUnknownType() {
    if (isUnknownType_visited) {
      throw new RuntimeException("Circular definition of attr: isUnknownType in class: org.jastadd.ast.AST.SynDecl");
    }
    isUnknownType_visited = true;
    boolean isUnknownType_value = false;

    isUnknownType_visited = false;
    return isUnknownType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean type_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:102
   */
  @ASTNodeAnnotation.Attribute
  public TypeId type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attr: type in class: org.jastadd.ast.AST.SynDecl");
    }
    type_visited = true;
    try {
    		switch(getID()) {
               		case "int": return new IntType();
                		case "bool": return new BoolType();
            	}
            	return new UnknownType();
    	}
    finally {
      type_visited = false;
    }
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set comp_TypeId_visited;
  /***********************************************
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:114
   */
  @ASTNodeAnnotation.Attribute
  public boolean comp(TypeId toMatch) {
    Object _parameters = toMatch;
    if (comp_TypeId_visited == null) comp_TypeId_visited = new java.util.HashSet(4);
    if (comp_TypeId_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attr: comp in class: org.jastadd.ast.AST.SynDecl");
    }
    comp_TypeId_visited.add(_parameters);
    try {
    		if(toString().equals("<UnknownType>")
    		|| toMatch.getID().equals("<UnknownType>") ){
    			return true; //UnknownType compatible with all!
    		}else if(toString().equals(toMatch.toString())){
    			return true; // equal types are compatible!
    		}
    		return false;
    			
    	}
    finally {
      comp_TypeId_visited.remove(_parameters);
    }
  }
}
