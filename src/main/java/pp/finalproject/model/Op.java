package pp.finalproject.model;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.List;

public class Op {

    private final OpCode opCode;

    private final List<Operand> args;

    public Op(OpCode opCode, Operand... args) {
        this.opCode = opCode;
        this.args = Arrays.asList(args);
    }

    public OpCode getOpCode() {
        return opCode;
    }

    public Num num(int i) {
        return (Num) args.get(i);
    }

    public Reg reg(int i) {
        return (Reg) args.get(i);
    }

    public Target target(int i) {
        return (Target) args.get(i);
    }

    public Str str(int i) {
        return (Str) args.get(i);
    }

    public Operator operator(int i) {
        return (Operator) args.get(i);
    }

    public MemAddr memAddr(int i) {
        return (MemAddr) args.get(i);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(WordUtils.capitalizeFully(opCode.toString()));
        result.append(" ");
        for (Operand arg : args) {
            result.append(arg.toString());
            result.append(" ");
        }
        return result.toString();
    }
}
