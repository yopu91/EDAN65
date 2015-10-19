package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast interface
 * @aspect Visitor
 * @declaredat /h/dk/r/ada10dlu/edan65/simpc/src/jastadd/Visitor.jrag:6
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(ParamFunc node, Object data);

		 
		public Object visit(WhileStmt node, Object data);

		 
		public Object visit(IfStmt node, Object data);


		 

		public Object visit(Param node, Object data);

		 
		public Object visit(ReturnStmt node, Object data);

		 
		public Object visit(ElseStmt node, Object data);

		 
		public Object visit(FuncStmt node, Object data);

		 
		public Object visit(Assignment node, Object data);

		 
		public Object visit(Declare node, Object data);

		 
		public Object visit(Add node, Object data);

		 
		public Object visit(Div node, Object data);

		 
		public Object visit(Mul node, Object data);

		 
		public Object visit(Sub node, Object data);

		 
		public Object visit(Mod node, Object data);

		 
		public Object visit(Neq node, Object data);

		 
		public Object visit(Eq node, Object data);

		 
		public Object visit(Leq node, Object data);

		 
		public Object visit(Lthn node, Object data);

		 
		public Object visit(Geq node, Object data);

		 
		public Object visit(Gthn node, Object data);

		 
		public Object visit(Numeral node, Object data);


		 

		public Object visit(IdDecl node, Object data);

		 
		public Object visit(IdUse node, Object data);
}
