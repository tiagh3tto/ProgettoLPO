package gruppo22.visitors.evaluation;

import gruppo22.range.Range;

public class RangeValue extends PrimValue<Range> {

	public RangeValue(Range value) {
		super(value);
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RangeValue))
			return false;
		return value.equals(((RangeValue) obj).value);
	}

	@Override
	public Range toRange() {
		return value;
	}

	@Override
	public String toString() {
		return "[" + value.start + ":" + value.end + "]";
	}

}
