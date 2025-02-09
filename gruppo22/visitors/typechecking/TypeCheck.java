package gruppo22.visitors.typechecking;

import static gruppo22.visitors.typechecking.PrimType.*;

import gruppo22.environments.EnvironmentException;
import gruppo22.environments.GenEnvironment;
import gruppo22.parser.ast.*;
import gruppo22.visitors.Visitor;

public class TypeCheck implements Visitor<Type> {

	private final GenEnvironment<Type> env = new GenEnvironment<>();

	// useful to typecheck binary operations where operands must have the same type
	private void checkBinOp(Exp left, Exp right, Type type) {
		type.checkEqual(left.accept(this));
		type.checkEqual(right.accept(this));
	}

	// static semantics for programs; no value returned by the visitor

	@Override
	public Type visitProg(StmtSeq stmtSeq) {
		try {
			stmtSeq.accept(this);
		} catch (EnvironmentException e) { // undeclared variable
			throw new TypecheckerException(e);
		}
		return null;
	}

	// static semantics for statements; no value returned by the visitor

	@Override
	public Type visitAssignStmt(VarIdent ident, Exp exp) {
		Type found = env.lookup(ident);
		found.checkEqual(exp.accept(this));
		return null;
	}

	@Override
	public Type visitPrintStmt(Exp exp) {
		exp.accept(this);
		return null;
	}

	@Override
	public Type visitVarStmt(VarIdent ident, Exp exp) {
		env.dec(ident, exp.accept(this));
		return null;
	}

	@Override
	public Type visitIfStmt(Exp exp, Block thenBlock, Block elseBlock) {
		BOOL.checkEqual(exp.accept(this));
		thenBlock.accept(this);
		if (elseBlock == null)
			return null;
		elseBlock.accept(this);
		return null;
	}

	@Override
	public Type visitBlock(StmtSeq stmtSeq) {
		env.enterScope();
		stmtSeq.accept(this);
		env.exitScope();
		return null;
	}

	@Override
	public Type visitForStmt(VarIdent id, Exp exp, Block block) {
		env.enterScope();
		env.dec(id, INT);
		RANGE.checkEqual(exp.accept(this));
		block.accept(this);
		env.exitScope();
		return null;
	}

	// static semantics for sequences of statements
	// no value returned by the visitor

	@Override
	public Type visitSingleStmt(Stmt stmt) {
		stmt.accept(this);
		return null;
	}

	@Override
	public Type visitMoreStmt(Stmt first, StmtSeq rest) {
		first.accept(this);
		rest.accept(this);
		return null;
	}

	// static semantics of expressions; a type is returned by the visitor

	@Override
	public PrimType visitAdd(Exp left, Exp right) {
		checkBinOp(left, right, INT);
		return INT;
	}

	@Override
	public PrimType visitIntLiteral(int value) {
		return INT;
	}

	@Override
	public PrimType visitMul(Exp left, Exp right) {
		checkBinOp(left, right, INT);
		return INT;
	}

	@Override
	public Type visitSign(Exp exp) {
		return INT.checkEqual(exp.accept(this));
	}

	@Override
	public Type visitVarIdent(VarIdent id) {
		return env.lookup(id);
	}

	@Override
	public Type visitNot(Exp exp) {
		return BOOL.checkEqual(exp.accept(this));
	}

	@Override
	public PrimType visitAnd(Exp left, Exp right) {
		checkBinOp(left, right, BOOL);
		return BOOL;
	}

	@Override
	public PrimType visitBoolLiteral(boolean value) {
		return BOOL;
	}

	@Override
	public PrimType visitEq(Exp left, Exp right) {
		left.accept(this).checkEqual(right.accept(this));
		return BOOL;
	}

	@Override
	public ProdType visitPairLit(Exp left, Exp right) {
		return new ProdType(left.accept(this), right.accept(this));
	}

	@Override
	public Type visitFst(Exp exp) {
		return exp.accept(this).getFstProdType();
	}

	@Override
	public Type visitSnd(Exp exp) {
		return exp.accept(this).getSndProdType();
	}

	@Override
	public PrimType visitNeq(Exp left, Exp right) {
		left.accept(this).checkEqual(right.accept(this));
		return BOOL;
	}

	@Override
	public Type visitRangeLit(Exp left, Exp right) {
		INT.checkEqual(left.accept(this));
		INT.checkEqual(right.accept(this));
		return RANGE;
	}

	@Override
	public ProdType visitBounds(Exp exp) {
		RANGE.checkEqual(exp.accept(this));
		return new ProdType(INT, INT);
	}
}
