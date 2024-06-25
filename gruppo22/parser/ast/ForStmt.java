package gruppo22.parser.ast;

import static java.util.Objects.requireNonNull;

import gruppo22.visitors.Visitor;

public class ForStmt implements Stmt {
	private final VarIdent id;
	private final Exp exp;
	private final Block block;

	public ForStmt(VarIdent id, Exp exp, Block block) {
		this.id = requireNonNull(id);
		this.exp = requireNonNull(exp);
		this.block = requireNonNull(block);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + id + "," + block + ")";
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitForStmt(id, exp, block);
	}

}
