package pp.finalproject.model;

public class Num extends Operand {
    private final int value;

    public Num(int value) {
        super(Type.NUM);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Num))
            return false;

        Num other = (Num) obj;
        return value == other.getValue();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
