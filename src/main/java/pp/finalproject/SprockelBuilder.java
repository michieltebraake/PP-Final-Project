package pp.finalproject;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
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

    //HashMap of variable names and registers (cleared after every stat)
    private HashMap<String, String> registers = new HashMap<>();

    //Reset every stat? Exitstat isn't even a method to override :(
    private int usedRegisters;

    private List<String> variablesInMemory = new ArrayList<>();

    private Program program = new Program();

    public SprockelBuilder() {

    }

    /**
     * Main method to build and print the CFG of a simple Java program.
     */
    public static void main(String[] args) {
        String filename;
        if (args.length == 0) {
            //System.err.println("Usage: [filename]+");
            filename = "E:\\michiel\\Documents\\GitHub\\PP-Final-Project\\src\\test\\java\\example2";
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
    public void exitDeclStat(@NotNull GrammarParser.DeclStatContext ctx) {
        Reg reg = null;
        if (operands.get(ctx.expr()) != null) {
            reg = getEmptyRegister();
            saveToReg(operands.get(ctx.expr()), reg);
        } else if (resultRegisters.get(ctx.expr()) != null) {
            reg = resultRegisters.get(ctx.expr());
        }
        saveToMemory(ctx.ID().getText(), reg);
        super.exitDeclStat(ctx);
    }

    @Override
    public void exitAssignStat(@NotNull GrammarParser.AssignStatContext ctx) {
        //TODO Assigning a = b is not yet possible
        Reg reg = getEmptyRegister();
        if (operands.get(ctx.expr()) != null) {
            saveToReg(operands.get(ctx.expr()), reg);
        }
        int memoryLocation = variablesInMemory.indexOf(ctx.ID().getText());
        //TODO Override memory location?
        saveToMemory(ctx.ID().getText(), reg, new MemAddr(memoryLocation));
        super.exitAssignStat(ctx);
    }

    @Override
    public void enterIfStat(@NotNull GrammarParser.IfStatContext ctx) {
        super.enterIfStat(ctx);
    }

    @Override
    public void exitIfStat(@NotNull GrammarParser.IfStatContext ctx) {
        emit(OpCode.BRANCH, resultRegisters.get(ctx.expr()), new Target(Target.TargetType.REL, 1));
        super.exitIfStat(ctx);
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
        super.exitParExpr(ctx);
    }

    @Override
    public void exitArrayExpr(@NotNull GrammarParser.ArrayExprContext ctx) {
        super.exitArrayExpr(ctx);
    }

    @Override
    public void exitTimesDivideExpr(@NotNull GrammarParser.TimesDivideExprContext ctx) {
        super.exitTimesDivideExpr(ctx);
    }

    @Override
    public void exitPlusMinusExpr(@NotNull GrammarParser.PlusMinusExprContext ctx) {
        Reg reg1 = getEmptyRegister();
        Reg reg2 = getEmptyRegister();
        if (variables.get(ctx.expr(0)) != null) {
            loadFromMemory(variables.get(ctx.expr(0)), reg1);
        } else if (operands.get(ctx.expr(0)) != null) {
            saveToReg(operands.get(ctx.expr(0)), reg1);
        }
        if (variables.get(ctx.expr(1)) != null) {
            loadFromMemory(variables.get(ctx.expr(1)), reg2);
        } else if (operands.get(ctx.expr(1)) != null) {
            saveToReg(operands.get(ctx.expr(1)), reg2);
        }
        emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.ADD), reg1, reg2, reg1);
        resultRegisters.put(ctx, reg1);
        super.exitPlusMinusExpr(ctx);
    }

    @Override
    public void exitOrExpr(@NotNull GrammarParser.OrExprContext ctx) {
        Reg reg1 = getEmptyRegister();
        Reg reg2 = getEmptyRegister();
        loadOperandOrVariable(ctx.expr(0), reg1);
        loadOperandOrVariable(ctx.expr(1), reg2);
        emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.OR), reg1, reg2, reg1);
        resultRegisters.put(ctx, reg1);
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
        Reg reg1 = getEmptyRegister();
        Reg reg2 = getEmptyRegister();
        loadOperandOrVariable(ctx.expr(0), reg1);
        loadOperandOrVariable(ctx.expr(1), reg2);
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
        //else if (ctx.NOTEQUAL() != null) {
        //    emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.NOTEQUAL), reg1, reg2, reg1);
        //}

        //Store register that computed value is saved to
        resultRegisters.put(ctx, reg1);

        /*
        if (ctx.LT() != null) {
            booleans.put(ctx, numbers.get(ctx.expr(0)) < numbers.get(ctx.expr(2)));
        } else if (ctx.GT() != null) {
            System.out.println(ctx.expr(0));
            System.out.println(numbers.get(ctx.expr(0)));
            System.out.println(numbers.get(ctx.expr(1)));
            booleans.put(ctx, numbers.get(ctx.expr(0)) > numbers.get(ctx.expr(1)));
        } else if (ctx.LTE() != null) {
            booleans.put(ctx, numbers.get(ctx.expr(0)) <= numbers.get(ctx.expr(1)));
        } else if (ctx.GTE() != null) {
            booleans.put(ctx, numbers.get(ctx.expr(0)) >= numbers.get(ctx.expr(1)));
        } else if (ctx.EQUAL() != null) {
            if (numbers.get(ctx.expr(0)) != null) {
                booleans.put(ctx, numbers.get(ctx.expr(0)) == numbers.get(ctx.expr(1)));
            } else {
                booleans.put(ctx, booleans.get(ctx.expr(0)) == booleans.get(ctx.expr(1)));
            }
        } else {
            if (numbers.get(ctx.expr(0)) != null) {
                booleans.put(ctx, numbers.get(ctx.expr(0)) != numbers.get(ctx.expr(1)));
            } else {
                booleans.put(ctx, booleans.get(ctx.expr(0)) != booleans.get(ctx.expr(1)));
            }
        }*/
        super.exitCmpExpr(ctx);
    }

    @Override
    public void exitAndExpr(@NotNull GrammarParser.AndExprContext ctx) {
        Reg reg1 = getEmptyRegister();
        Reg reg2 = getEmptyRegister();
        loadOperandOrVariable(ctx.expr(0), reg1);
        loadOperandOrVariable(ctx.expr(1), reg2);
        emit(OpCode.COMPUTE, new Operator(Operator.OperatorType.AND), reg1, reg2, reg1);
        resultRegisters.put(ctx, reg1);
        super.exitAndExpr(ctx);
    }

    @Override
    public void exitType(@NotNull GrammarParser.TypeContext ctx) {
        super.exitType(ctx);
    }

    /*@Override
    public void exitTimesDivideExpr(@NotNull GrammarParser.TimesDivideExprContext ctx) {
        super.exitTimesDivideExpr(ctx);
        if (ctx.TIMES() != null) {
            numbers.put(ctx, numbers.get(ctx.expr(0)) * numbers.get(ctx.expr(1)));
        } else {
            numbers.put(ctx, numbers.get(ctx.expr(0)) / numbers.get(ctx.expr(1)));
        }
    }

    @Override
    public void exitPlusMinusExpr(@NotNull GrammarParser.PlusMinusExprContext ctx) {
        super.exitPlusMinusExpr(ctx);
        if (ctx.PLUS() != null) {
            numbers.put(ctx, numbers.get(ctx.expr(0)) + numbers.get(ctx.expr(1)));
        } else {
            numbers.put(ctx, numbers.get(ctx.expr(0)) - numbers.get(ctx.expr(1)));
        }
    }

    @Override
    public void exitOrExpr(@NotNull GrammarParser.OrExprContext ctx) {
        super.exitOrExpr(ctx);
        booleans.put(ctx, booleans.get(ctx.expr(0)) || booleans.get(ctx.expr(1)));
    }

    @Override
    public void exitMinusExpr(@NotNull GrammarParser.MinusExprContext ctx) {
        super.exitMinusExpr(ctx);
        numbers.put(ctx, -numbers.get(ctx.expr()));
    }

    @Override
    public void enterConstExpr(@NotNull GrammarParser.ConstExprContext ctx) {
        super.enterConstExpr(ctx);
        if (ctx.NUM() != null) {
            System.out.println("Number: " + ctx.NUM());
            numbers.put(ctx, Integer.parseInt(ctx.NUM().getText()));
        }
    }

    @Override
    public void exitAndExpr(@NotNull GrammarParser.AndExprContext ctx) {
        super.exitAndExpr(ctx);
        booleans.put(ctx, booleans.get(ctx.expr(0)) && booleans.get(ctx.expr(1)));
        System.out.println("");
    }

    @Override
    public void exitCmpExpr(@NotNull GrammarParser.CmpExprContext ctx) {
        super.exitCmpExpr(ctx);
        //LT | GT | LTE| | GTE | EQUAL | NOTEQUAL
        if (ctx.LT() != null) {
            booleans.put(ctx, numbers.get(ctx.expr(0)) < numbers.get(ctx.expr(2)));
        } else if (ctx.GT() != null) {
            System.out.println(ctx.expr(0));
            System.out.println(numbers.get(ctx.expr(0)));
            System.out.println(numbers.get(ctx.expr(1)));
            booleans.put(ctx, numbers.get(ctx.expr(0)) > numbers.get(ctx.expr(1)));
        } else if (ctx.LTE() != null) {
            booleans.put(ctx, numbers.get(ctx.expr(0)) <= numbers.get(ctx.expr(1)));
        } else if (ctx.GTE() != null) {
            booleans.put(ctx, numbers.get(ctx.expr(0)) >= numbers.get(ctx.expr(1)));
        } else if (ctx.EQUAL() != null) {
            if (numbers.get(ctx.expr(0)) != null) {
                booleans.put(ctx, numbers.get(ctx.expr(0)) == numbers.get(ctx.expr(1)));
            } else {
                booleans.put(ctx, booleans.get(ctx.expr(0)) == booleans.get(ctx.expr(1)));
            }
        } else {
            if (numbers.get(ctx.expr(0)) != null) {
                booleans.put(ctx, numbers.get(ctx.expr(0)) != numbers.get(ctx.expr(1)));
            } else {
                booleans.put(ctx, booleans.get(ctx.expr(0)) != booleans.get(ctx.expr(1)));
            }
        }
    }*/

    private void loadOperandOrVariable(GrammarParser.ExprContext expr, Reg reg) {
        if (variables.get(expr) != null) {
            loadFromMemory(variables.get(expr), reg);
        } else if (operands.get(expr) != null) {
            saveToReg(operands.get(expr), reg);
        }
    }

    private void saveToReg(Operand operand, Reg reg) {
        emit(OpCode.CONST, operand, reg);
    }

    private void saveToMemory(String name, Reg reg) {
        emit(OpCode.PUSH, reg);
        variablesInMemory.add(name);
    }

    private void saveToMemory(String name, Reg reg, MemAddr addr) {
        //Overwrite memory location, variable stays in memory so no need to add it again
        emit(OpCode.STORE, reg, addr);
    }

    private void loadFromMemory(String variable, Reg reg) {
        int index = variablesInMemory.indexOf(variable);
        //TODO Use index to calculate location of variable in memory
        emit(OpCode.LOAD, new MemAddr(new Reg("SP")), reg);
    }

    private Reg getEmptyRegister() {
        if (usedRegisters == 5)
            System.out.println("Warning: ran out of registers!");
        String register = new String("Reg" + Character.toString((char) (65 + usedRegisters)));
        usedRegisters++;
        return new Reg(register);
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
