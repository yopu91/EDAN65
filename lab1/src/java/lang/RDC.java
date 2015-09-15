package lang;

import lang.ast.LangParser;
import lang.ast.LangScanner;
import static lang.ast.LangParser.Terminals.*;
public class RDC {
	private LangScanner scanner;
	private beaver.Symbol symbol;
	public void parse(LangScanner scanner) {
		this.scanner = scanner;
		nextToken();
		program();
	}
	private void program() {
		statement();
		accept(EOF);
	}
	private void accept(int expectedToken) {
		if (expectedToken != symbol.getId()) {
			error("expected token " + LangParser.Terminals.NAMES[expectedToken]
					+ " got token " + LangParser.Terminals.NAMES[symbol.getId()]);
		}
		nextToken();
	}
	private void nextToken() {
		try {
			symbol = scanner.nextToken();
			System.out.println("got " + NAMES[symbol.getId()]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	private void error(String message) {
		throw new RuntimeException(message);
	}

	private void statement(){	
		switch(symbol.getId()){
			case FOR:
				forStmt();
			break;
			case IF:
				ifStmt();
			break;
			case ID:
				assignment();
			break;
			default:
				error("Expected FOR,IF,ASSIGN got "+NAMES[symbol.getId()]);
			break;
		}	
	}

	private void forStmt(){
		accept(FOR);
		accept(ID);
		accept(ASSIGN);
		expr();
		accept(UNTIL);
		expr();
		accept(DO);
		statement();
		accept(OD);
	}



	private void ifStmt(){
		accept(IF);
		accept(ID);
		expr();
		accept(THEN);
		statement();
		accept(FI);
	}

	private void assignment(){
		accept(ID);
		accept(ASSIGN);
		expr();
	}

	private void expr(){
		switch(symbol.getId()){
			case ID:
				accept(ID);
			break;
			case NUMERAL:
				accept(NUMERAL);
			break;
			case NOT:
				accept(NOT);
				expr();
			break;
		}	
	}
}
