package pp.finalproject.model;

public class Str extends Operand {
    private final String text;

    protected Str(String text) {
        super(Type.STR);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Str))
            return false;

        Str other = (Str) obj;
        return text.equals(other.getText());
    }
}
