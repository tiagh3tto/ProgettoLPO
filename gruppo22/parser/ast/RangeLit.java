package gruppo22.parser.ast;

import gruppo22.visitors.Visitor;

public class RangeLit extends BinaryOp {
	public RangeLit(Exp left, Exp right) {
		super(left, right);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitRangeLit(left, right);
	}
}
