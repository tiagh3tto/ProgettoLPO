package gruppo22.visitors.evaluation;

import gruppo22.range.Range;

public interface Value {
	/* default conversion methods */
	default int toInt() {
		throw new EvaluatorException("Expecting an integer");
	}

	default boolean toBool() {
		throw new EvaluatorException("Expecting a boolean");
	}

	default Range toRange() {
		throw new EvaluatorException("Expecting a range");
	}

	default PairValue toProd() {
		throw new EvaluatorException("Expecting a pair");
	}
}
