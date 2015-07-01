package pp.finalproject.model;

public class Reg extends Operand {
    private final String address;

    protected Reg(String address) {
        super(Type.REG);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Reg))
            return false;

        Reg other = (Reg) obj;
        return address.equals(other.getAddress());
    }
}
