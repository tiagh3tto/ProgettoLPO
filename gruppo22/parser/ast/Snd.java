package gruppo22.parser.ast;

import gruppo22.visitors.Visitor;

public class Snd extends UnaryOp {

	public Snd(Exp exp) {
		super(exp);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitSnd(exp);
	}
}
