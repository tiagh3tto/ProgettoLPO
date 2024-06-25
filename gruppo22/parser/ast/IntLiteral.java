package gruppo22.parser.ast;

import gruppo22.visitors.Visitor;

public class IntLiteral extends PrimLiteral<Integer> {

	public IntLiteral(int n) {
		super(n);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitIntLiteral(value);
	}
}
