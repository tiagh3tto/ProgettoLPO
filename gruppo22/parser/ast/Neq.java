package gruppo22.parser.ast;

import gruppo22.visitors.Visitor;

public class Neq extends BinaryOp {
	public Neq(Exp left, Exp right) {
		super(left, right);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitNeq(left, right);
	}
}
