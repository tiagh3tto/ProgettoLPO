package gruppo22.parser.ast;

import gruppo22.visitors.Visitor;

public class AssignStmt extends AbstractAssignStmt {

	public AssignStmt(VarIdent ident, Exp exp) {
		super(ident, exp);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitAssignStmt(ident, exp);
	}
}
