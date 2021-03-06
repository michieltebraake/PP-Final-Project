package pp.finalproject.model;

public class Operator extends Operand {
    /**
     * Models the different operators available in the sprockell instruction set.
     */
    private final OperatorType operatorType;

    public Operator(OperatorType operatorType) {
        super(Type.OPERATOR);
        this.operatorType = operatorType;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Operator))
            return false;

        Operator other = (Operator) obj;
        return operatorType == other.getOperatorType();
    }

    public enum OperatorType {
        ADD("Add"),
        SUB("Sub"),
        MUL("Mul"),
        DIV("Div"),
        EQUAL("Equal"),
        GT("Gt"),
        GTE("GtE"),
        LT("Lt"),
        LTE("LtE"),
        AND("And"),
        OR("Or");

        private String alias;

        OperatorType(String alias) {
            this.alias = alias;
        }

        public String getAlias() {
            return alias;
        }

        }

    @Override
    public String toString() {
        return operatorType.getAlias();
    }
}
