package pp.finalproject.model;

public class Target extends Operand {
    private final TargetType targetType;
    private final int value;

    public Target(TargetType targetType, int value) {
        super(Type.TARGET);
        this.targetType = targetType;
        this.value = value;
        //TODO Deze mist de optie Ind Reg en Rel Int, deze moeten nog toegevoegd worden (zie MemAddr, pittig lelijk)
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Target))
            return false;

        Target other = (Target) obj;
        return value == other.getValue();
    }

    public enum TargetType {
        ABS, REL, IND
    }

    @Override
    public String toString() {
        if (targetType == TargetType.REL)
            return "(Rel " + value + ")";
        //TODO This isn't finished
        return "" + value;
    }
}
