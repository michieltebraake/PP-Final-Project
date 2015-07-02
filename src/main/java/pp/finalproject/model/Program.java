package pp.finalproject.model;

import java.util.ArrayList;
import java.util.List;

public class Program {
    /**
     * Indexed list of all operations in the program.
     * This is the flattened list of instructions.
     */
    private final List<Op> opList = new ArrayList<>();
    /** Mapping from labels defined in the program to corresponding
     * index locations.
     */

    public Program() {}

    public void addOp(Op op) {
        opList.add(op);
    }

    @Override
    public String toString() {
        System.out.println("Number of operations: " + opList.size());
        StringBuilder strBuilder = new StringBuilder();
        for (Op op : opList) {
            strBuilder.append(op.toString());
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }
}