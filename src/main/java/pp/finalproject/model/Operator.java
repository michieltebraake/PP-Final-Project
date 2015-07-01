package pp.finalproject.model;

public class Operator extends Operand {
    private final OperatorType operatorType;

    protected Operator(OperatorType operatorType) {
        super(Type.OPERATOR);
        this.operatorType = operatorType;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Operator))
            return false;

        Operator other = (Operator) obj;
        return operatorType == other.getOperatorType();
    }

    public enum OperatorType {
        ADD, SUB, MUL, DIV, MOD, EQUAL, NEQ, GT, GTE, LT, LTE, AND, OR, XOR, LSHIFT, RSHIFT
    }
}
