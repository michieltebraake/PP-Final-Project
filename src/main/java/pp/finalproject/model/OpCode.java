package pp.finalproject.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pp.finalproject.model.Operand.Type.*;

public enum OpCode {
    /**
     * Framework for the different instructions and their arguments
     */

    //Local instructions
    CONST(NUM, REG),

    COMPUTE(OPERATOR, REG, REG, REG),

    LOAD(MEMADDR, REG),

    STORE(REG, MEMADDR),

    BRANCH(REG, TARGET),

    JUMP(TARGET),

    PUSH(REG),

    POP(REG),

    NOP(),

    ENDPROG("EndProg"),

    //System instructions
    READ(MEMADDR),

    RECEIVE(REG),

    WRITE(REG, MEMADDR),

    TESTANDSET("TestAndSet", MEMADDR);

    private List<Operand.Type> sig;
    private String alias;

    private OpCode(Operand.Type... sig) {
        this(null, sig);
    }

    private OpCode(String alias, Operand.Type... sig) {
        this.sig = new ArrayList<>(Arrays.asList(sig));
        this.alias = alias;
    }

    public List<Operand.Type> getSig() {
        return sig;
    }

    public String getAlias() {
        return alias;
    }
}
