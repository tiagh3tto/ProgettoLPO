package gruppo22.parser;

public enum TokenType {
	// symbols
	ASSIGN, MINUS, PLUS, TIMES, NOT, AND, EQ, NEQ, START_PAIR, END_PAIR, STMT_SEP, EXP_SEP, OPEN_PAR, CLOSE_PAR,
	OPEN_BLOCK, CLOSE_BLOCK, START_RANGE, BOUNDS_SEP, END_RANGE,
	// keywords
	PRINT, VAR, BOOL, IF, ELSE, FST, SND, BOUNDS, FOR, IN,
	// non singleton categories
	SKIP, IDENT, NUM,
	// end-of-file
	EOF,
}
