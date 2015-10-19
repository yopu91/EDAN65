/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @production ASTNode;

 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol implements Cloneable, Iterable<T> {
  /**
   * @aspect DumpTree
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/DumpTree.jrag:6
   */
  private String DUMP_TREE_INDENT = "  ";
  /**
   * @aspect DumpTree
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/DumpTree.jrag:8
   */
  public String dumpTree() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		dumpTree(new PrintStream(bytes));
		return bytes.toString();
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/DumpTree.jrag:14
   */
  public void dumpTree(PrintStream out) {
		dumpTree(out, 0);
		out.flush();
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/DumpTree.jrag:19
   */
  public void dumpTree(PrintStream out, int indent) {
		for (int i = 0; i < indent; i++) {
			out.print(DUMP_TREE_INDENT);
		}
		out.println(getClass().getSimpleName());
		for (ASTNode child: this) {
			if (child == null) {
				for (int i = 0; i < indent+1; i++) {
					out.print(DUMP_TREE_INDENT);
				}
				out.println("null");
			} else {
				child.dumpTree(out, indent+1);
			}
		}
	}
  /**
   * @aspect Errors
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:22
   */
  protected ErrorMessage error(String message) {
		return new ErrorMessage(message, getLine(getStart()));
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PrettyPrint.jrag:4
   */
  public void prettyPrint(PrintStream out) {
		prettyPrint(out, "");
		out.println();
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PrettyPrint.jrag:9
   */
  public void prettyPrint(PrintStream out, String ind) {
		for (int i = 0; i < getNumChild(); ++i) {
			getChild(i).prettyPrint(out, ind);
		}
	}
  /**
   * @aspect Visitor
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Visitor.jrag:12
   */
  public Object accept(Visitor visitor, Object data) {
		throw new Error("Visitor: accept method not available for " + getClass().getName());
	}
  /**
   * @declaredat ASTNode:1
   */
  public ASTNode() {
    super();
    init$Children();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:11
   */
  public void init$Children() {
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:16
   */
  private int childIndex;
  /**
   * @apilevel low-level
   * @declaredat ASTNode:21
   */
  public int getIndexOfChild(ASTNode node) {
    if (node == null) {
      return -1;
    }
    if (node.childIndex < numChildren && node == children[node.childIndex]) {
      return node.childIndex;
    }
    for(int i = 0; children != null && i < children.length; i++) {
      if (children[i] == node) {
        node.childIndex = i;
        return i;
      }
    }
    return -1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:40
   */
  public static final boolean generatedWithCacheCycle = true;
  /**
   * @apilevel internal
   * @declaredat ASTNode:44
   */
  public static final boolean generatedWithComponentCheck = false;
  /**
   * Parent pointer
   * @apilevel low-level
   * @declaredat ASTNode:50
   */
  protected ASTNode parent;
  /**
   * Child array
   * @apilevel low-level
   * @declaredat ASTNode:56
   */
  protected ASTNode[] children;
  /**
   * @apilevel internal
   * @declaredat ASTNode:62
   */
  private static ASTNode$State state = new ASTNode$State();
  /**
   * @apilevel internal
   * @declaredat ASTNode:67
   */
  public final ASTNode$State state() {
    return state;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:75
   */
  public T getChild(int i) {

    // No rewrites
    ASTNode child = getChildNoTransform(i);
    return (T) child;

  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:85
   */
  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }
  /**
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @apilevel low-level
   * @declaredat ASTNode:92
   */
  public final T getChildNoTransform(int i) {
    if (children == null) {
      return null;
    }
    T child = (T)children[i];
    return child;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:102
   */
  protected int numChildren;
  /**
   * @apilevel low-level
   * @declaredat ASTNode:107
   */
  protected int numChildren() {
    return numChildren;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:114
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @apilevel low-level
   * @declaredat ASTNode:122
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:128
   */
  public void setChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i+1>4 || !(this instanceof List))?i+1:4];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if (i >= numChildren) {
      numChildren = i+1;
    }
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:148
   */
  public void insertChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i+1>4 || !(this instanceof List))?i+1:4];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if (i < children.length) {
        System.arraycopy(children, i, c, i+1, children.length-i);
        for(int j = i+1; j < c.length; ++j) {
          if (c[j] != null) {
            c[j].childIndex = j;
          }
        }
      }
      children = c;
    }
    numChildren++;
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:175
   */
  public void removeChild(int i) {
    if (children != null) {
      ASTNode child = (ASTNode) children[i];
      if (child != null) {
        child.parent = null;
        child.childIndex = -1;
      }
      // Adding a check of this instance to make sure its a List, a move of children doesn't make
      // any sense for a node unless its a list. Also, there is a problem if a child of a non-List node is removed
      // and siblings are moved one step to the right, with null at the end.
      if (this instanceof List || this instanceof Opt) {
        System.arraycopy(children, i+1, children, i, children.length-i-1);
        children[children.length-1] = null;
        numChildren--;
        // fix child indices
        for(int j = i; j < numChildren; ++j) {
          if (children[j] != null) {
            child = (ASTNode) children[j];
            child.childIndex = j;
          }
        }
      } else {
        children[i] = null;
      }
    }
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:204
   */
  public ASTNode getParent() {
    return (ASTNode) parent;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:210
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:260
   */
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      private int counter = 0;
      public boolean hasNext() {
        return counter < getNumChild();
      }
      public T next() {
        if (hasNext())
          return (T)getChild(counter++);
        else
          return null;
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:280
   */
  public void flushTreeCache() {
    flushCache();
    if (children == null) {
      return;
    }
    for (int i = 0; i < children.length; i++) {
      if (children[i] != null) {
        ((ASTNode)children[i]).flushTreeCache();
      }
    }
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:294
   */
  public void flushCache() {
    flushAttrAndCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:300
   */
  public void flushAttrAndCollectionCache() {
    flushAttrCache();
    flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:307
   */
  public void flushAttrCache() {
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:312
   */
  public void flushCollectionCache() {
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:317
   */
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode) super.clone();
    node.flushAttrAndCollectionCache();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:325
   */
  public ASTNode<T> copy() {
    try {
      ASTNode node = (ASTNode) clone();
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
   * @declaredat ASTNode:344
   */
  @Deprecated
  public ASTNode<T> fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:354
   */
  public ASTNode<T> treeCopyNoTransform() {
    ASTNode tree = (ASTNode) copy();
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
   * @declaredat ASTNode:374
   */
  public ASTNode<T> treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * Performs a full traversal of the tree using getChild to trigger rewrites
   * @apilevel low-level
   * @declaredat ASTNode:382
   */
  public void doFullTraversal() {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).doFullTraversal();
    }
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:390
   */
  protected boolean is$Equal(ASTNode n1, ASTNode n2) {
    if (n1 == null && n2 == null) return true;
    if (n1 == null || n2 == null) return false;
    return n1.is$Equal(n2);
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:398
   */
  protected boolean is$Equal(ASTNode node) {
    if (getClass() != node.getClass()) {
      return false;
    }
    if (numChildren != node.numChildren) {
      return false;
    }
    for (int i = 0; i < numChildren; i++) {
      if (children[i] == null && node.children[i] != null) {
        return false;
      }
      if (!((ASTNode)children[i]).is$Equal(((ASTNode)node.children[i]))) {
        return false;
      }
    }
    return true;
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:26
   */
    protected void collect_contributors_Program_errors() {
    for(int i = 0; i < getNumChild(); i++) {
      getChild(i).collect_contributors_Program_errors();
    }
  }
  protected void contributeTo_Program_Program_errors(Set<ErrorMessage> collection) {
  }

  /**
   * @apilevel internal
   */
  protected boolean numLocals_visited = false;
  @ASTNodeAnnotation.Attribute
  public int numLocals() {
    if (numLocals_visited) {
      throw new RuntimeException("Circular definition of attr: numLocals in class: org.jastadd.ast.AST.SynDecl");
    }
    numLocals_visited = true;
    int numLocals_value = lastNode().localIndex() - localIndex();

    numLocals_visited = false;
    return numLocals_value;
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
    int localIndex_value = prevNode().localIndex();

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
    int paramIndex_value = prevNode().paramIndex();

    paramIndex_visited = false;
    return paramIndex_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean lastNode_visited = false;
  @ASTNodeAnnotation.Attribute
  public ASTNode lastNode() {
    if (lastNode_visited) {
      throw new RuntimeException("Circular definition of attr: lastNode in class: org.jastadd.ast.AST.SynDecl");
    }
    lastNode_visited = true;
    ASTNode lastNode_value = prevNode(getNumChild());

    lastNode_visited = false;
    return lastNode_value;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Set prevNode_int_visited;
  @ASTNodeAnnotation.Attribute
  public ASTNode prevNode(int i) {
    Object _parameters = i;
    if (prevNode_int_visited == null) prevNode_int_visited = new java.util.HashSet(4);
    if (prevNode_int_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attr: prevNode in class: org.jastadd.ast.AST.SynDecl");
    }
    prevNode_int_visited.add(_parameters);
    ASTNode prevNode_int_value = i>0 ? getChild(i-1).lastNode() : this;

    prevNode_int_visited.remove(_parameters);
    return prevNode_int_value;
  }
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:249
   */
  @ASTNodeAnnotation.Attribute
  public ASTNode prevNode() {
    if (prevNode_visited) {
      throw new RuntimeException("Circular definition of attr: prevNode in class: org.jastadd.ast.AST.InhDecl");
    }
    prevNode_visited = true;
    ASTNode prevNode_value = getParent().Define_prevNode(this, null);

    prevNode_visited = false;
    return prevNode_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean prevNode_visited = false;
  /**
   * @attribute inh
   * @aspect Errors
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:28
   */
  @ASTNodeAnnotation.Attribute
  public Program program() {
    if (program_visited) {
      throw new RuntimeException("Circular definition of attr: program in class: org.jastadd.ast.AST.InhDecl");
    }
    program_visited = true;
    Program program_value = getParent().Define_program(this, null);

    program_visited = false;
    return program_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean program_visited = false;
  /**
   * @attribute inh
   * @aspect PredefinedFunctions
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PredefinedFunctions.jrag:21
   */
  @ASTNodeAnnotation.Attribute
  public List<ParamFunc> PredefinedFunctions() {
    if (PredefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attr: PredefinedFunctions in class: org.jastadd.ast.AST.InhDecl");
    }
    PredefinedFunctions_visited = true;
    List<ParamFunc> PredefinedFunctions_value = getParent().Define_PredefinedFunctions(this, null);

    PredefinedFunctions_visited = false;
    return PredefinedFunctions_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean PredefinedFunctions_visited = false;
  /********************************** INT 
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:22
   */
  @ASTNodeAnnotation.Attribute
  public IntType IntType() {
    if (IntType_visited) {
      throw new RuntimeException("Circular definition of attr: IntType in class: org.jastadd.ast.AST.InhDecl");
    }
    IntType_visited = true;
    IntType IntType_value = getParent().Define_IntType(this, null);

    IntType_visited = false;
    return IntType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean IntType_visited = false;
  /********************************* UnknownType 
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:30
   */
  @ASTNodeAnnotation.Attribute
  public UnknownType unknownType() {
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attr: unknownType in class: org.jastadd.ast.AST.InhDecl");
    }
    unknownType_visited = true;
    UnknownType unknownType_value = getParent().Define_unknownType(this, null);

    unknownType_visited = false;
    return unknownType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean unknownType_visited = false;
  /********************************* BoolType 
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:47
   */
  @ASTNodeAnnotation.Attribute
  public BoolType BoolType() {
    if (BoolType_visited) {
      throw new RuntimeException("Circular definition of attr: BoolType in class: org.jastadd.ast.AST.InhDecl");
    }
    BoolType_visited = true;
    BoolType BoolType_value = getParent().Define_BoolType(this, null);

    BoolType_visited = false;
    return BoolType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean BoolType_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:72
   */
  @ASTNodeAnnotation.Attribute
  public UnknownFunc unknownFunc() {
    if (unknownFunc_visited) {
      throw new RuntimeException("Circular definition of attr: unknownFunc in class: org.jastadd.ast.AST.InhDecl");
    }
    unknownFunc_visited = true;
    UnknownFunc unknownFunc_value = getParent().Define_unknownFunc(this, null);

    unknownFunc_visited = false;
    return unknownFunc_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean unknownFunc_visited = false;
  /**
   * @attribute inh
   * @aspect UnknownDecl
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/UnknownDecl.jrag:4
   */
  @ASTNodeAnnotation.Attribute
  public UnknownDecl unknownDecl() {
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attr: unknownDecl in class: org.jastadd.ast.AST.InhDecl");
    }
    unknownDecl_visited = true;
    UnknownDecl unknownDecl_value = getParent().Define_unknownDecl(this, null);

    unknownDecl_visited = false;
    return unknownDecl_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean unknownDecl_visited = false;
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:249
   * @apilevel internal
   */
  public ASTNode Define_prevNode(ASTNode caller, ASTNode child) {
    int i = this.getIndexOfChild(caller);
    return prevNode(i);
  }
  /**
   * @apilevel internal
   */
  public Program Define_program(ASTNode caller, ASTNode child) {
    return getParent().Define_program(this, caller);
  }
  /**
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode caller, ASTNode child, String name) {
    return getParent().Define_lookup(this, caller, name);
  }
  /**
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode caller, ASTNode child, IdDecl decl) {
    return getParent().Define_inExprOf(this, caller, decl);
  }
  /**
   * @apilevel internal
   */
  public List<ParamFunc> Define_PredefinedFunctions(ASTNode caller, ASTNode child) {
    return getParent().Define_PredefinedFunctions(this, caller);
  }
  /**
   * @apilevel internal
   */
  public IntType Define_IntType(ASTNode caller, ASTNode child) {
    return getParent().Define_IntType(this, caller);
  }
  /**
   * @apilevel internal
   */
  public UnknownType Define_unknownType(ASTNode caller, ASTNode child) {
    return getParent().Define_unknownType(this, caller);
  }
  /**
   * @apilevel internal
   */
  public BoolType Define_BoolType(ASTNode caller, ASTNode child) {
    return getParent().Define_BoolType(this, caller);
  }
  /**
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode caller, ASTNode child) {
    return getParent().Define_isVariable(this, caller);
  }
  /**
   * @apilevel internal
   */
  public UnknownFunc Define_unknownFunc(ASTNode caller, ASTNode child) {
    return getParent().Define_unknownFunc(this, caller);
  }
  /**
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode caller, ASTNode child) {
    return getParent().Define_isFunction(this, caller);
  }
  /**
   * @apilevel internal
   */
  public ParamFunc Define_function(ASTNode caller, ASTNode child) {
    return getParent().Define_function(this, caller);
  }
  /**
   * @apilevel internal
   */
  public TypeId Define_expectedType(ASTNode caller, ASTNode child) {
    return getParent().Define_expectedType(this, caller);
  }
  /**
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode caller, ASTNode child) {
    return getParent().Define_unknownDecl(this, caller);
  }
  /**
   * @apilevel internal
   */
  public boolean Define_isLocalVariable(ASTNode caller, ASTNode child) {
    return getParent().Define_isLocalVariable(this, caller);
  }
  /**
   * @apilevel internal
   */
  public boolean Define_checkComp(ASTNode caller, ASTNode child, TypeId t) {
    return getParent().Define_checkComp(this, caller, t);
  }
}
