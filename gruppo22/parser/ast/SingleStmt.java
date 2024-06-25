package gruppo22.parser.ast;

import gruppo22.visitors.Visitor;

public class SingleStmt extends Single<Stmt> implements StmtSeq {

	public SingleStmt(Stmt single) {
		super(single);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitSingleStmt(single);
	}
}
