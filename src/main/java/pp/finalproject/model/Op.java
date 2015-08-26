package pp.finalproject.model;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.List;

public class Op {

    private final OpCode opCode;

    private List<Operand> args;

    public Op(OpCode opCode, Operand... args) {
        this.opCode = opCode;
        this.args = Arrays.asList(args);
    }

    public void setArgs(Operand... args) {
        this.args = Arrays.asList(args);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        //extra tabs to make sure indentation within the haskell file is not violated, thus resulting in
        // non-compiling haskell.
        if (opCode.getAlias() != null) {
            result.append("     ").append(opCode.getAlias());
        } else {
            result.append("     ").append(WordUtils.capitalizeFully(opCode.toString()));
        }
        for (Operand arg : args) {
            result.append(" ");
            result.append(arg.toString());
        }
        return result.toString();
    }
}
