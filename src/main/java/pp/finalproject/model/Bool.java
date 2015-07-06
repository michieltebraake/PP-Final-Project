package pp.finalproject.model;

public class Bool extends Operand {
    private final boolean value;

    public Bool() {
        this(false);
    }

    public Bool(boolean value) {
        super(Type.BOOL);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Bool))
            return false;

        Bool other = (Bool) obj;
        return value == other.getValue();
    }

    @Override
    public String toString() {
        return Integer.toString((value) ? 1 : 0);
    }
}
