/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/lang.ast:3
 * @production Program : {@link ASTNode} ::= <span class="component">{@link ParamFunc}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @param err where to write error messages
   * @aspect NameAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/NameAnalysis.jrag:56
   */
  public void checkNames(PrintStream err) {
		SymbolTable symbols = new SymbolTable();
		for (int i=0; i<getNumParamFunc(); ++i){
			//Try adding/removing .push()
			getParamFunc(i).checkNames(err, symbols);
		}
	}
  /**
   * @aspect Visitor
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/Visitor.jrag:47
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Program(List<ParamFunc> p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:20
   */
  protected int numChildren() {
    return 1;
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
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:45
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
   * @declaredat ASTNode:64
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
   * @declaredat ASTNode:74
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
   * @declaredat ASTNode:94
   */
  public Program treeCopy() {
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
   * Replaces the ParamFunc list.
   * @param list The new list node to be used as the ParamFunc list.
   * @apilevel high-level
   */
  public void setParamFuncList(List<ParamFunc> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the ParamFunc list.
   * @return Number of children in the ParamFunc list.
   * @apilevel high-level
   */
  public int getNumParamFunc() {
    return getParamFuncList().getNumChild();
  }
  /**
   * Retrieves the number of children in the ParamFunc list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the ParamFunc list.
   * @apilevel low-level
   */
  public int getNumParamFuncNoTransform() {
    return getParamFuncListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the ParamFunc list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the ParamFunc list.
   * @apilevel high-level
   */
  public ParamFunc getParamFunc(int i) {
    return (ParamFunc) getParamFuncList().getChild(i);
  }
  /**
   * Check whether the ParamFunc list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasParamFunc() {
    return getParamFuncList().getNumChild() != 0;
  }
  /**
   * Append an element to the ParamFunc list.
   * @param node The element to append to the ParamFunc list.
   * @apilevel high-level
   */
  public void addParamFunc(ParamFunc node) {
    List<ParamFunc> list = (parent == null) ? getParamFuncListNoTransform() : getParamFuncList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addParamFuncNoTransform(ParamFunc node) {
    List<ParamFunc> list = getParamFuncListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the ParamFunc list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setParamFunc(ParamFunc node, int i) {
    List<ParamFunc> list = getParamFuncList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the ParamFunc list.
   * @return The node representing the ParamFunc list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="ParamFunc")
  public List<ParamFunc> getParamFuncList() {
    List<ParamFunc> list = (List<ParamFunc>) getChild(0);
    return list;
  }
  /**
   * Retrieves the ParamFunc list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the ParamFunc list.
   * @apilevel low-level
   */
  public List<ParamFunc> getParamFuncListNoTransform() {
    return (List<ParamFunc>) getChildNoTransform(0);
  }
  /**
   * Retrieves the ParamFunc list.
   * @return The node representing the ParamFunc list.
   * @apilevel high-level
   */
  public List<ParamFunc> getParamFuncs() {
    return getParamFuncList();
  }
  /**
   * Retrieves the ParamFunc list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the ParamFunc list.
   * @apilevel low-level
   */
  public List<ParamFunc> getParamFuncsNoTransform() {
    return getParamFuncListNoTransform();
  }
}
