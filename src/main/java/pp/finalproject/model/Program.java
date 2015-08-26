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

    /**
     * @return Number of instructions
     */
    public int opCount() {
        return opList.size();
    }

    /**
     * Fetches a operation
     *
     * @param i index to fetch
     * @return operation at index i
     */
    public Op getOp(int i) {
        return opList.get(i);
    }

    /**
     * Adds an operation to the list
     *
     * @param op to be added operation
     */
    public void addOp(Op op) {
        opList.add(op);
    }

    /**
     * @return the operations in a list separated by commas.
     */
    @Override
    public String toString() {
        System.out.println("Number of operations: " + opList.size());
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(StringUtils.join(opList, ",\n"));
        return strBuilder.toString();
    }
}
