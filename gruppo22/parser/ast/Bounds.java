package gruppo22.parser.ast;

import gruppo22.visitors.Visitor;

public class Bounds extends UnaryOp {

	public Bounds(Exp exp) {
		super(exp);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitBounds(exp);
	}
}
