package pp.finalproject.model;

public class Reg extends Operand {
    private final String address;
    //id = 1 to 5, matching RegA to RegE
    private int id;

    public Reg(String address) {
        super(Type.REG);
        this.id = 0;
        this.address = address;
    }

    public Reg(String address, int id) {
        super(Type.REG);
        this.address = address;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return address;
    }
}
