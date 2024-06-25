package gruppo22.parser.ast;

import gruppo22.visitors.Visitor;

public interface AST {
	<T> T accept(Visitor<T> visitor);
}
