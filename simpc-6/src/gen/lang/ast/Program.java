/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.13 */
package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/lang.ast:3
 * @production Program : {@link ASTNode} ::= <span class="component">{@link ParamFunc}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:5
   */
  private static int next_label = 1;
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:7
   */
  public static int nextCounter(){
		return Program.next_label++;
	}
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:11
   */
  public void genCode(PrintStream out) {
		//START OF PROGRAM
		out.println(		".global _start");
		out.println(		".data");
		out.println(		"buf: .skip 1024");
		out.println(		".text");	
		out.println(		"_start:");
		out.println(		"");	
		//call main function	
		out.println(		"call main");	
		//call sys_exit and helper function
		out.println(		"exit:");
		out.println(		"movq $0, %rdi");
		out.println(		"movq $60, %rax");
		out.println(		"syscall");
		out.println(		"");
		//END OF PROGRAM

		for(ParamFunc paFu: getParamFuncList()){
			paFu.genCode(out);
		}
		//ADD THE HELPER FUNCTIONS
		printHelper(out);
	}
  /**
   * @aspect CodeGen
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/CodeGen.jrag:255
   */
  public static void printHelper(PrintStream out){
		// helper functions
		out.println("# Procedure to read number from stdin");
		out.println("# C signature: long int read(void)");
		out.println("read:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        movq $0, %rdi");
		out.println("        movq $buf, %rsi");
		out.println("        movq $1024, %rdx");
		out.println("        movq $0, %rax");
		out.println("        syscall                 # %rax = sys_read(0, buf, 1024)");
		out.println("        ### convert string to integer:");
		out.println("        ### %rax contains nchar");
		out.println("        ### %rsi contains ptr");
		out.println("        movq $0, %rdx           # sum = 0");
		out.println("atoi_loop:");
		out.println("        cmpq $0, %rax           # while (nchar > 0)");
		out.println("        jle atoi_done           # leave loop if nchar <= 0");
		out.println("        movzbq (%rsi), %rbx     # move byte, and sign extend to qword");
		out.println("        cmpq $0x30, %rbx        # test if < '0'");
		out.println("        jl atoi_done            # character is not numeric");
		out.println("        cmpq $0x39, %rbx        # test if > '9'");
		out.println("        jg atoi_done            # character is not numeric");
		out.println("        imulq $10, %rdx         # multiply sum by 10");
		out.println("        subq $0x30, %rbx        # value of character");
		out.println("        addq %rbx, %rdx         # add to sum");
		out.println("        incq %rsi               # step to next char");
		out.println("        decq %rax               # nchar--");
		out.println("        jmp atoi_loop           # loop back");
		out.println("atoi_done:");
		out.println("        movq %rdx, %rax         # return value in RAX");
		out.println("        popq %rbp");
		out.println("        ret");
		out.println();
		out.println("# Procedure to print number to stdout");
		out.println("# C signature: void print(long int)");
		out.println("print:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        ### convert integer to string");
		out.println("        movq 16(%rbp), %rax     # parameter");
		out.println("        movq $(buf+1023), %rsi  # write ptr (start from end of buf)");
		out.println("        movb $0x0a, (%rsi)      # insert newline");
		out.println("        movq $1, %rcx           # string length");
		out.println("itoa_loop:                      # do.. while (at least one iteration)");
		out.println("        movq $10, %rbx");
		out.println("        movq $0, %rdx");
		out.println("        idivq %rbx              # divide rdx:rax by 10");
		out.println("        addb $0x30, %dl         # remainder + '0'");
		out.println("        decq %rsi               # move string pointer");
		out.println("        movb %dl, (%rsi)");
		out.println("        incq %rcx               # increment string length");
		out.println("        cmpq $0, %rax");
		out.println("        jg itoa_loop            # produce more digits");
		out.println("itoa_done:");
		out.println("        movq $1, %rdi");
		out.println("        movq %rcx, %rdx");
		out.println("        movq $1, %rax");
		out.println("        syscall");
		out.println("        popq %rbp");
		out.println("        ret");
		out.println();
		out.println("print_string:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        movq $1, %rdi");
		out.println("        movq 16(%rbp), %rsi");
		out.println("        movq 24(%rbp), %rdx");
		out.println("        movq $1, %rax");
		out.println("        syscall");
		out.println("        popq %rbp");
		out.println("        ret");
	}
  /**
   * @aspect Visitor
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Visitor.jrag:21
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
    PredefinedFunctions_reset();
    IntType_reset();
    BoolType_reset();
    unknownType_reset();
    unknownFunc_reset();
    unknownDecl_reset();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:38
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
   * @declaredat ASTNode:49
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:56
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
   * @declaredat ASTNode:75
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
   * @declaredat ASTNode:85
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
   * @declaredat ASTNode:105
   */
  public Program treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:112
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
  /**
   * @aspect <NoAspect>
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:26
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
  protected boolean localIndex_visited = false;
  @ASTNodeAnnotation.Attribute
  public int localIndex() {
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attr: localIndex in class: org.jastadd.ast.AST.SynDecl");
    }
    localIndex_visited = true;
    int localIndex_value = 0;

    localIndex_visited = false;
    return localIndex_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean PredefinedFunctions_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean PredefinedFunctions_computed = false;
  /**
   * @apilevel internal
   */
  protected List<ParamFunc> PredefinedFunctions_value;
  /**
   * @apilevel internal
   */
  private void PredefinedFunctions_reset() {
    PredefinedFunctions_computed = false;
    PredefinedFunctions_value = null;
    PredefinedFunctions_visited = false;
  }
  @ASTNodeAnnotation.Attribute
  public List<ParamFunc> PredefinedFunctions() {
    ASTNode$State state = state();
    if (PredefinedFunctions_computed) {
      return PredefinedFunctions_value;
    }
    if (PredefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attr: PredefinedFunctions in class: org.jastadd.ast.AST.SynDecl");
    }
    PredefinedFunctions_visited = true;
    boolean intermediate = state.INTERMEDIATE_VALUE;
    state.INTERMEDIATE_VALUE = false;
    PredefinedFunctions_value = PredefinedFunctions_compute();
    PredefinedFunctions_value.setParent(this);
    if (true) {
      PredefinedFunctions_computed = true;
    } else {
    }
    state.INTERMEDIATE_VALUE |= intermediate;

    PredefinedFunctions_visited = false;
    return PredefinedFunctions_value;
  }
  /**
   * @apilevel internal
   */
  private List<ParamFunc> PredefinedFunctions_compute() {
  	
  		List<ParamFunc> func = new List<ParamFunc>();
  	
  
  		ParamFunc read = new ParamFunc();
  		read.setName(new IdDecl("read"));
  		func.add(read);
  
  //Param                   ::= Type:TypeId IdDecl;
  	
  		ParamFunc print = new ParamFunc();
  		print.setName(new IdDecl("print"));
  		Param param = new Param(new IntType(), new IdDecl("param1"));
  		print.setParams(param,0);
  		func.add(print);
  		return func;
  	}
  /**
   * @apilevel internal
   */
  protected boolean IntType_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean IntType_computed = false;
  /**
   * @apilevel internal
   */
  protected IntType IntType_value;
  /**
   * @apilevel internal
   */
  private void IntType_reset() {
    IntType_computed = false;
    IntType_value = null;
    IntType_visited = false;
  }
  @ASTNodeAnnotation.Attribute
  public IntType IntType() {
    ASTNode$State state = state();
    if (IntType_computed) {
      return IntType_value;
    }
    if (IntType_visited) {
      throw new RuntimeException("Circular definition of attr: IntType in class: org.jastadd.ast.AST.SynDecl");
    }
    IntType_visited = true;
    boolean intermediate = state.INTERMEDIATE_VALUE;
    state.INTERMEDIATE_VALUE = false;
    IntType_value = new IntType("int");
    IntType_value.setParent(this);
    if (true) {
      IntType_computed = true;
    } else {
    }
    state.INTERMEDIATE_VALUE |= intermediate;

    IntType_visited = false;
    return IntType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean BoolType_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean BoolType_computed = false;
  /**
   * @apilevel internal
   */
  protected BoolType BoolType_value;
  /**
   * @apilevel internal
   */
  private void BoolType_reset() {
    BoolType_computed = false;
    BoolType_value = null;
    BoolType_visited = false;
  }
  @ASTNodeAnnotation.Attribute
  public BoolType BoolType() {
    ASTNode$State state = state();
    if (BoolType_computed) {
      return BoolType_value;
    }
    if (BoolType_visited) {
      throw new RuntimeException("Circular definition of attr: BoolType in class: org.jastadd.ast.AST.SynDecl");
    }
    BoolType_visited = true;
    boolean intermediate = state.INTERMEDIATE_VALUE;
    state.INTERMEDIATE_VALUE = false;
    BoolType_value = new BoolType("bool");
    BoolType_value.setParent(this);
    if (true) {
      BoolType_computed = true;
    } else {
    }
    state.INTERMEDIATE_VALUE |= intermediate;

    BoolType_visited = false;
    return BoolType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean unknownType_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean unknownType_computed = false;
  /**
   * @apilevel internal
   */
  protected UnknownType unknownType_value;
  /**
   * @apilevel internal
   */
  private void unknownType_reset() {
    unknownType_computed = false;
    unknownType_value = null;
    unknownType_visited = false;
  }
  @ASTNodeAnnotation.Attribute
  public UnknownType unknownType() {
    ASTNode$State state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attr: unknownType in class: org.jastadd.ast.AST.SynDecl");
    }
    unknownType_visited = true;
    boolean intermediate = state.INTERMEDIATE_VALUE;
    state.INTERMEDIATE_VALUE = false;
    unknownType_value = new UnknownType("<UnknownType>");
    unknownType_value.setParent(this);
    if (true) {
      unknownType_computed = true;
    } else {
    }
    state.INTERMEDIATE_VALUE |= intermediate;

    unknownType_visited = false;
    return unknownType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean unknownFunc_visited = false;
  /**
   * @apilevel internal
   */
  protected boolean unknownFunc_computed = false;
  /**
   * @apilevel internal
   */
  protected UnknownFunc unknownFunc_value;
  /**
   * @apilevel internal
   */
  private void unknownFunc_reset() {
    unknownFunc_computed = false;
    unknownFunc_value = null;
    unknownFunc_visited = false;
  }
  @ASTNodeAnnotation.Attribute
  public UnknownFunc unknownFunc() {
    ASTNode$State state = state();
    if (unknownFunc_computed) {
      return unknownFunc_value;
    }
    if (unknownFunc_visited) {
      throw new RuntimeException("Circular definition of attr: unknownFunc in class: org.jastadd.ast.AST.SynDecl");
    }
    unknownFunc_visited = true;
    boolean intermediate = state.INTERMEDIATE_VALUE;
    state.INTERMEDIATE_VALUE = false;
    unknownFunc_value = new UnknownFunc( unknownType(), new IdDecl("unknownFunc"), new List<Param>(),new List<Stmt>());
    unknownFunc_value.setParent(this);
    if (true) {
      unknownFunc_computed = true;
    } else {
    }
    state.INTERMEDIATE_VALUE |= intermediate;

    unknownFunc_visited = false;
    return unknownFunc_value;
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
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return this;
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/NameAnalysis.jrag:35
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode caller, ASTNode child, String name) {
    int childIndex = this.getIndexOfChild(caller);
    {
    		for(int i = 0; i<getNumParamFunc(); i++){
                            IdDecl decl = getParamFunc(i).getName();
                            if(decl.getID().equals(name)){
                                    return decl;
                            }
    		}
    		for(ParamFunc p : PredefinedFunctions()){
    			if(p.getName().getID().equals(name)){
    				return p.getName();
    			}
    		}
    		return unknownDecl();
    	}
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/NameAnalysis.jrag:149
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode caller, ASTNode child, IdDecl decl) {
    int childIndex = this.getIndexOfChild(caller);
    {
    		return false;
    	}
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/PredefinedFunctions.jrag:21
   * @apilevel internal
   */
  public List<ParamFunc> Define_PredefinedFunctions(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return PredefinedFunctions();
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:22
   * @apilevel internal
   */
  public IntType Define_IntType(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return IntType();
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:30
   * @apilevel internal
   */
  public UnknownType Define_unknownType(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return unknownType();
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:47
   * @apilevel internal
   */
  public BoolType Define_BoolType(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return BoolType();
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:59
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return false;
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:72
   * @apilevel internal
   */
  public UnknownFunc Define_unknownFunc(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return unknownFunc();
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:69
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return false;
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:70
   * @apilevel internal
   */
  public ParamFunc Define_function(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return unknownFunc();
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/TypeAnalysis.jrag:138
   * @apilevel internal
   */
  public TypeId Define_expectedType(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return new UnknownType();
  }
  /**
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode caller, ASTNode child) {
    int childIndex = this.getIndexOfChild(caller);
    return unknownDecl();
  }
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /h/dk/r/ada10dlu/edan65/simpc-6/src/jastadd/Errors.jrag:26
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
