package pp.finalproject.model;

public class Target extends Operand {
    private final int value;

    protected Target(int value) {
        super(Type.TARGET);
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
}
