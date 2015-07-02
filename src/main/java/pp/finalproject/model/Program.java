package pp.finalproject.model;

import org.apache.commons.lang3.StringUtils;

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

    public int opCount() {
        return opList.size();
    }

    public Op getOp(int i) {
        return opList.get(i);
    }

    public void addOp(Op op) {
        opList.add(op);
    }

    @Override
    public String toString() {
        System.out.println("Number of operations: " + opList.size());
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(StringUtils.join(opList, ",\n"));
        return strBuilder.toString();
    }
}
