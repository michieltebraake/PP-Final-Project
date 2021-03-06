package pp.finalproject.model;

public class Target extends Operand {
    /**
     * Models the target types as defined on the sprockell wiki.
     */
    private final TargetType targetType;
    private final int value;

    public Target(TargetType targetType, int value) {
        super(Type.TARGET);
        this.targetType = targetType;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Target))
            return false;

        Target other = (Target) obj;
        return value == other.getValue();
    }

    @Override
    public String toString() {
        if (targetType == TargetType.REL) {
            return "(Rel (" + value + "))";
        } else if (targetType == TargetType.ABS) {
            return "(Abs (" + value + "))";
        } else {
            return "(Ind (" + value + "))";
        }
    }

    public enum TargetType {
        ABS, REL, IND
    }
}
