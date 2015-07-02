package pp.finalproject;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.finalproject.model.Op;
import pp.finalproject.model.OpCode;
import pp.finalproject.model.Operand;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SprockelBuilderVisitorPittigKut extends GrammarBaseVisitor<Op> {
    private ParseTreeProperty<String> lines = new ParseTreeProperty<>();
    private ParseTreeProperty<Integer> numbers = new ParseTreeProperty<>();
    private ParseTreeProperty<Boolean> booleans = new ParseTreeProperty<>();

    public SprockelBuilderVisitorPittigKut() {

    }

    /**
     * Main method to build and print the CFG of a simple Java program.
     */
    public static void main(String[] args) {
        String filename;
        if (args.length == 0) {
            //System.err.println("Usage: [filename]+");
            filename = "E:\\michiel\\Documents\\GitHub\\PP-Final-Project\\src\\test\\java\\example";
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
            tree.accept(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done.");
    }

    @Override
    public Op visitProgram(@NotNull GrammarParser.ProgramContext ctx) {
        System.out.println("");
        return super.visitProgram(ctx);
    }

    @Override
    public Op visitSharedDeclStat(@NotNull GrammarParser.SharedDeclStatContext ctx) {
        return super.visitSharedDeclStat(ctx);
    }

    @Override
    public Op visitDeclStat(@NotNull GrammarParser.DeclStatContext ctx) {
        //Op op = new Op(OpCode.CONST, )
        visit(ctx.expr());
        return super.visitDeclStat(ctx);
    }

    @Override
    public Op visitAssignStat(@NotNull GrammarParser.AssignStatContext ctx) {
        return super.visitAssignStat(ctx);
    }

    @Override
    public Op visitIfStat(@NotNull GrammarParser.IfStatContext ctx) {
        return super.visitIfStat(ctx);
    }

    @Override
    public Op visitWhileStat(@NotNull GrammarParser.WhileStatContext ctx) {
        return super.visitWhileStat(ctx);
    }

    @Override
    public Op visitProcedureStat(@NotNull GrammarParser.ProcedureStatContext ctx) {
        return super.visitProcedureStat(ctx);
    }

    @Override
    public Op visitTarget(@NotNull GrammarParser.TargetContext ctx) {
        return super.visitTarget(ctx);
    }

    @Override
    public Op visitArraytype(@NotNull GrammarParser.ArraytypeContext ctx) {
        return super.visitArraytype(ctx);
    }

    @Override
    public Op visitNoParamProcedure(@NotNull GrammarParser.NoParamProcedureContext ctx) {
        return super.visitNoParamProcedure(ctx);
    }

    @Override
    public Op visitParamProcedure(@NotNull GrammarParser.ParamProcedureContext ctx) {
        return super.visitParamProcedure(ctx);
    }

    @Override
    public Op visitParExpr(@NotNull GrammarParser.ParExprContext ctx) {
        return super.visitParExpr(ctx);
    }

    @Override
    public Op visitArrayExpr(@NotNull GrammarParser.ArrayExprContext ctx) {
        return super.visitArrayExpr(ctx);
    }

    @Override
    public Op visitTimesDivideExpr(@NotNull GrammarParser.TimesDivideExprContext ctx) {
        return super.visitTimesDivideExpr(ctx);
    }

    @Override
    public Op visitPlusMinusExpr(@NotNull GrammarParser.PlusMinusExprContext ctx) {
        return super.visitPlusMinusExpr(ctx);
    }

    @Override
    public Op visitOrExpr(@NotNull GrammarParser.OrExprContext ctx) {
        return super.visitOrExpr(ctx);
    }

    @Override
    public Op visitMinusExpr(@NotNull GrammarParser.MinusExprContext ctx) {
        return super.visitMinusExpr(ctx);
    }

    @Override
    public Op visitConstExpr(@NotNull GrammarParser.ConstExprContext ctx) {
        int test = Integer.parseInt(ctx.NUM().getText());

        return super.visitConstExpr(ctx);
    }

    @Override
    public Op visitIdExpr(@NotNull GrammarParser.IdExprContext ctx) {
        return super.visitIdExpr(ctx);
    }

    @Override
    public Op visitCmpExpr(@NotNull GrammarParser.CmpExprContext ctx) {
        return super.visitCmpExpr(ctx);
    }

    @Override
    public Op visitAndExpr(@NotNull GrammarParser.AndExprContext ctx) {
        return super.visitAndExpr(ctx);
    }

    @Override
    public Op visitType(@NotNull GrammarParser.TypeContext ctx) {
        return super.visitType(ctx);
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

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    private Op emit(OpCode opCode, Operand... args) {
        Op result = new Op(opCode, args);
        //this.prog.addInstr(result);
        return result;
    }
}
