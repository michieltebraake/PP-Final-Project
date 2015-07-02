package pp.finalproject;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import pp.finalproject.model.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SprockelBuilder extends GrammarBaseListener {
    //private ParseTreeProperty<String> lines = new ParseTreeProperty<>();
    //private ParseTreeProperty<Integer> numbers = new ParseTreeProperty<>();
    //private ParseTreeProperty<Boolean> booleans = new ParseTreeProperty<>();

    private ParseTreeProperty<Operand> operands = new ParseTreeProperty<>();

    //Use variable names to find the register associated with it?
    private ParseTreeProperty<String> variables = new ParseTreeProperty<>();

    private ParseTreeProperty<Reg> resultRegisters = new ParseTreeProperty<>();

    private HashMap<String, MemAddr> memory = new HashMap<>();

    //Saves the location of branch & jump instructions needed for if statements. The values for this need to be filled in after the if statement
    private ParseTreeProperty<ImmutableTriple<Op, Op, Integer>> branchLines = new ParseTreeProperty<>();

    //private ParseTreeProperty<>

    //HashMap of variable names and registers (cleared after every stat)
    private HashMap<String, String> registers = new HashMap<>();

    private List<String> variablesInMemory = new ArrayList<>();

    private Program program = new Program();

    private List<Integer> registersInUse = new ArrayList<>();

    public SprockelBuilder() {

    }

    /**
     * Main method to build and print the CFG of a simple Java program.
     */
    public static void main(String[] args) {
        String filename;
        if (args.length == 0) {
            //System.err.println("Usage: [filename]+");
            filename = "src\\test\\java\\example";
        } else {
            filename = args[0];
        }
        SprockelBuilder builder = new SprockelBuilder();
        File file = new File(filename);
        System.out.println(filename);
        builder.build(file);
    }

    public void build(File file) {
        try {
            CharStream chars = new ANTLRInputStream(new FileReader(file));
            Lexer lexer = new GrammarLexer(chars);
            lexer.removeErrorListeners();
            //lexer.addErrorListener(listener);
            TokenStream tokens = new CommonTokenStream(lexer);

            GrammarParser parser = new GrammarParser(tokens);
            ParseTree tree = parser.program();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this, tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Created program:");
        System.out.println(program.toString());
        System.out.println("Done.");
        Util.saveProgram(program);
        /*Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(String.format("ghc -i../Sprockel/src %s", "test"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void exitProgram(@NotNull GrammarParser.ProgramContext ctx) {
        emit(OpCode.ENDPROG);
        super.exitProgram(ctx);
    }

    @Override
    public void exitSharedDeclStat(@NotNull GrammarParser.SharedDeclStatContext ctx) {
        super.exitSharedDeclStat(ctx);
    }

    @Override
    public void exitDeclAssignStat(@NotNull GrammarParser.DeclAssignStatContext ctx) {
        Reg reg = null;
        if (operands.get(ctx.expr()) != null) {
            reg = getEmptyRegister();
            saveToReg(operands.get(ctx.expr()), reg);
        } else if (resultRegisters.get(ctx.expr()) != null) {
            reg = resultRegisters.get(ctx.expr());
        } else if (variables.get(ctx.expr()) != null) {
            reg = loadFromHeap(variables.get(ctx.expr()));
        }
        saveToHeap(ctx.ID().getText(), reg);
        super.exitDeclAssignStat(ctx);
    }

    @Override
    public void exitAssignStat(@NotNull GrammarParser.AssignStatContext ctx) {
        //TODO Assigning a = b is not yet possible, right side of assign has to be an operand right now
        //An assign statement always saves a value to a named variable, so save this to the heap
        Reg reg = getEmptyRegister();
        if (operands.get(ctx.expr()) != null) {
            saveToReg(operands.get(ctx.expr()), reg);
            saveToHeap(ctx.ID().getText(), reg);
        }
        //int memoryLocation = variablesInMemory.indexOf(ctx.ID().getText());
        //TODO Override memory location?
        //saveToHeap(ctx.ID().getText(), reg, new MemAddr(memoryLocation));
        super.exitAssignStat(ctx);
    }

    @Override
    public void exitWhileStat(@NotNull GrammarParser.WhileStatContext ctx) {
        super.exitWhileStat(ctx);
    }

    @Override
    public void exitProcedureStat(@NotNull GrammarParser.ProcedureStatContext ctx) {
        super.exitProcedureStat(ctx);
    }

    @Override
    public void exitTarget(@NotNull GrammarParser.TargetContext ctx) {
        super.exitTarget(ctx);
    }

    @Override
    public void exitArraytype(@NotNull GrammarParser.ArraytypeContext ctx) {
        super.exitArraytype(ctx);
    }

    @Override
    public void exitNoParamProcedure(@NotNull GrammarParser.NoParamProcedureContext ctx) {
        super.exitNoParamProcedure(ctx);
    }

    @Override
    public void exitParamProcedure(@NotNull GrammarParser.ParamProcedureContext ctx) {
        super.exitParamProcedure(ctx);
    }

    @Override
    public void exitParExpr(@NotNull GrammarParser.ParExprContext ctx) {
        if (operands.get(ctx.expr()) != null) {
            operands.put(ctx, operands.get(ctx.expr()));
        } else if (variables.get(ctx.expr()) != null) {
            variables.put(ctx, variables.get(ctx.expr()));
        } else if (resultRegisters.get(ctx.expr()) != null) {
            resultRegisters.put(ctx, resultRegisters.get(ctx.expr()));
        }
        super.exitParExpr(ctx);
    }

    @Override
    public void exitArrayExpr(@NotNull GrammarParser.ArrayExprContext ctx) {
        super.exitArrayExpr(ctx);
    }

    @Override
    public void enterIfbody(@NotNull GrammarParser.IfbodyContext ctx) {
        Op branch = emit(OpCode.BRANCH);
        Op jump = emit(OpCode.JUMP);
        branchLines.put(ctx, new ImmutableTriple<>(branch, jump, program.opCount()));

        super.enterIfbody(ctx);
    }

    @Override
    public void exitIfbody(@NotNull GrammarParser.IfbodyContext ctx) {
        super.exitIfbody(ctx);
    }

    @Override
    public void enterIfStat(@NotNull GrammarParser.IfStatContext ctx) {
        super.enterIfStat(ctx);
    }

    @Override
    public void exitIfStat(@NotNull GrammarParser.IfStatContext ctx) {
        Op branch = branchLines.get(ctx.ifbody()).getLeft();
        Op jump = branchLines.get(ctx.ifbody()).getMiddle();
        int opLines = branchLines.get(ctx.ifbody()).getRight();

        Reg reg = resultRegisters.get(ctx.expr());
        branch.setArgs(reg, new Target(Target.TargetType.REL, 1));
        int jumpLines = program.opCount() - opLines;
        jump.setArgs(new Target(Target.TargetType.REL, jumpLines));
        releaseReg(reg);
        super.exitIfStat(ctx);
    }

    @Override
    public void exitTimesDivideExpr(@NotNull GrammarParser.TimesDivideExprContext ctx) {
        Reg reg1 = popOrGetOperator(ctx.expr(0));
        Reg reg2 = popOrGetOperator(ctx.expr(1));
        if (ctx.TIMES() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.MUL), reg1, reg2, reg1);
        } else if (ctx.DIVIDE() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.DIV), reg1, reg2, reg1);
        }
        resultRegisters.put(ctx, reg1);
        releaseReg(reg2);
        super.exitTimesDivideExpr(ctx);
    }

    @Override
    public void exitPlusMinusExpr(@NotNull GrammarParser.PlusMinusExprContext ctx) {
        Reg reg1 = popOrGetOperator(ctx.expr(0));
        Reg reg2 = popOrGetOperator(ctx.expr(1));

        if (ctx.PLUS() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.ADD), reg1, reg2, reg1);
        } else if (ctx.MINUS() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.SUB), reg1, reg2, reg1);
        }
        resultRegisters.put(ctx, reg1);
        releaseReg(reg2);
        super.exitPlusMinusExpr(ctx);
    }

    @Override
    public void exitOrExpr(@NotNull GrammarParser.OrExprContext ctx) {
        Reg reg1 = popOrGetOperator(ctx.expr(0));
        Reg reg2 = popOrGetOperator(ctx.expr(1));
        emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.OR), reg1, reg2, reg1);
        resultRegisters.put(ctx, reg1);
        releaseReg(reg2);
        super.exitOrExpr(ctx);
    }

    @Override
    public void exitMinusExpr(@NotNull GrammarParser.MinusExprContext ctx) {
        super.exitMinusExpr(ctx);
    }

    @Override
    public void exitConstExpr(@NotNull GrammarParser.ConstExprContext ctx) {
        if (ctx.NUM() != null) {
            operands.put(ctx, new Num(Integer.parseInt(ctx.NUM().getText())));
        } else if (ctx.TRUE() != null) {
            operands.put(ctx, new Bool(true));
        } else if (ctx.FALSE() != null) {
            operands.put(ctx, new Bool(false));
        }
        super.exitConstExpr(ctx);
    }

    @Override
    public void exitIdExpr(@NotNull GrammarParser.IdExprContext ctx) {
        variables.put(ctx, ctx.getText());
        //registers.put(ctx.getText(), getEmptyRegister());
        super.exitIdExpr(ctx);
    }

    @Override
    public void exitCmpExpr(@NotNull GrammarParser.CmpExprContext ctx) {
        //LT | GT | LTE| | GTE | EQUAL | NOTEQUAL
        //TODO Also here, get proper regs
        Reg reg1 = popOrGetOperator(ctx.expr(0));
        Reg reg2 = popOrGetOperator(ctx.expr(1));
        if (ctx.LT() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.LT), reg1, reg2, reg1);
        } else if (ctx.GT() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.GT), reg1, reg2, reg1);
        } else if (ctx.LTE() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.LTE), reg1, reg2, reg1);
        } else if (ctx.GTE() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.GTE), reg1, reg2, reg1);
        } else if (ctx.EQUAL() != null) {
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.EQUAL), reg1, reg2, reg1);
        }
        //Reg1 is still used since it contains the return value. Reg2 can already be released
        releaseReg(reg2);
        //else if (ctx.NOTEQUAL() != null) {
        //    emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.NOTEQUAL), reg1, reg2, reg1);
        //}

        //Store register that computed value is saved to
        resultRegisters.put(ctx, reg1);
        super.exitCmpExpr(ctx);
    }

    @Override
    public void exitAndExpr(@NotNull GrammarParser.AndExprContext ctx) {
        Reg reg1 = popOrGetOperator(ctx.expr(0));
        Reg reg2 = popOrGetOperator(ctx.expr(1));
        emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.AND), reg1, reg2, reg1);
        resultRegisters.put(ctx, reg1);
        releaseReg(reg2);
        super.exitAndExpr(ctx);
    }

    @Override
    public void exitType(@NotNull GrammarParser.TypeContext ctx) {
        super.exitType(ctx);
    }

    //Because the heap is easier to access, we use to this for longer variable declarations
    //The stack is used to store temporary variables (TODO what the fuck does that even mean? reg is the same thing)
    //Example stack value: if (i > 3 && i < 6). Results from i > 3 and i < 6 are saved to the stack.
    //in the same example i is saved to the heap
    //and the 3 and 6 are only put into a register temporarily

    /* Methods to access the stack */
    //TODO Very misleading name, this is going to be an all-purpose access method for operands, the stack and the heap
    private Reg popOrGetOperator(GrammarParser.ExprContext expr) {
        if (resultRegisters.get(expr) != null) {
            return resultRegisters.get(expr);
        }
        //Create a register to return value in
        Reg reg = getEmptyRegister();
        //If it is a named variable, load value from heap
        if (expr instanceof GrammarParser.IdExprContext) {
            GrammarParser.IdExprContext ctx = (GrammarParser.IdExprContext) expr;
            MemAddr addr = memory.get(ctx.ID().getText());
            emit(OpCode.LOAD, addr, reg);
            return reg;
        } else if (operands.get(expr) != null) {
            saveToReg(operands.get(expr), reg);
            return reg;
            //TODO Should this be here like this? if yes, move all calls to that method to this method.
        } else {
            emit(OpCode.POP, reg);
            return reg;
        }
    }

    //TODO Why is this method never used?
    private void pushToStack(Reg reg) {
        emit(OpCode.PUSH, reg);
        releaseReg(reg);
    }

    private Reg loadOperandOrVariable(GrammarParser.ExprContext expr, Reg reg) {
        if (variables.get(expr) != null) {
            loadFromMemory(variables.get(expr), reg);
        } else if (operands.get(expr) != null) {
            saveToReg(operands.get(expr), reg);
        } else if (resultRegisters.get(expr) != null) {
            return resultRegisters.get(expr);
        }
        return reg;
    }

    private void saveToReg(Operand operand, Reg reg) {
        emit(OpCode.CONST, operand, reg);
    }

    /* Methods to access the heap (memaddr starts at 0, count up. stack counts down from 127) */
    private void saveToHeap(String name, Reg reg) {
        //Overwrite memory location, variable stays in memory so no need to add it again
        MemAddr addr;
        if (memory.containsKey(name)) {
            addr = memory.get(name);
        } else {
            addr = new MemAddr(memory.size());
            memory.put(name, addr);
        }
        emit(OpCode.STORE, reg, addr);
        releaseReg(reg);
    }

    private Reg loadFromHeap(String name) {
        MemAddr addr = memory.get(name);
        Reg reg = getEmptyRegister();
        emit(OpCode.LOAD, addr, reg);
        return reg;
    }

    /* Other (potentially outdated) methods */
    private void loadFromMemory(String variable, Reg reg) {
        int index = variablesInMemory.indexOf(variable);
        if (index != 0) {
            Reg tempReg = getEmptyRegister();
            emit(OpCode.CONST, new Num(index), tempReg);
            emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.ADD), new Reg("SP"), tempReg, tempReg);
            emit(OpCode.LOAD, new MemAddr(tempReg), reg);
        } else {
            emit(OpCode.LOAD, new MemAddr(new Reg("SP")), reg);
        }
    }

    /**
     * Creates a not yet in use register.
     * Only 2 registers should ever be needed, so as long as registers are released properly this should always return a valid register
     *
     * @return Empty register
     */
    private Reg getEmptyRegister() {
        for (int i = 1; i <= 5; i++) {
            if (!registersInUse.contains(i)) {
                registersInUse.add(i);
                String register = "Reg" + Character.toString((char) (64 + i));
                return new Reg(register, i);
            }
        }

        System.out.println("Warning: ran out of registers!");
        return new Reg("Invalidreg" + registersInUse.size());
    }

    private void releaseReg(Reg reg) {
        registersInUse.remove((Integer) reg.getId());
    }

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    private Op emit(OpCode opCode, Operand... args) {
        Op result = new Op(opCode, args);
        program.addOp(result);
        return result;
    }
}
