package pp.finalproject.model;

public class MemAddr extends Operand {
    private final int address;
    private final Reg reg;

    public MemAddr(int address) {
        super(Type.MEMADDR);
        this.address = address;
        this.reg = null;
    }

    public MemAddr(Reg reg) {
        super(Type.MEMADDR);
        this.address = -1;
        this.reg = reg;
    }

    public int getAddress() {
        return address;
    }

    public Reg getReg() {
        return reg;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof MemAddr))
            return false;

        MemAddr other = (MemAddr) obj;
        if (other.getReg() != null) {
            if (reg != null) {
                return reg.equals(other.getReg());
            } else {
                return false;
            }
        } else {
            if (reg != null) {
                return false;
            } else {
                return address == other.getAddress();
            }
        }
    }

    @Override
    public String toString() {
        if (address == -2){
            return "stdio";
        }
        if (address != -1)
            return "(Addr " + Integer.toString(address) + ")";
        else
            return "(Deref " + reg.toString() + ")";
    }
}
