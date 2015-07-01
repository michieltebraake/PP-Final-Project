package pp.finalproject;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SprockelBuilder extends GrammarBaseListener {
    private ParseTreeProperty<String> lines = new ParseTreeProperty<>();
    private ParseTreeProperty<Integer> numbers = new ParseTreeProperty<>();
    private ParseTreeProperty<Boolean> booleans = new ParseTreeProperty<>();

    public SprockelBuilder() {

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
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this, tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done.");
    }

    @Override
    public void enterProgram(@NotNull GrammarParser.ProgramContext ctx) {
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(@NotNull GrammarParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    @Override
    public void enterSharedDeclStat(@NotNull GrammarParser.SharedDeclStatContext ctx) {
        super.enterSharedDeclStat(ctx);
    }

    @Override
    public void exitSharedDeclStat(@NotNull GrammarParser.SharedDeclStatContext ctx) {
        super.exitSharedDeclStat(ctx);
    }

    @Override
    public void enterDeclStat(@NotNull GrammarParser.DeclStatContext ctx) {
        super.enterDeclStat(ctx);

    }

    @Override
    public void exitDeclStat(@NotNull GrammarParser.DeclStatContext ctx) {
        super.exitDeclStat(ctx);
    }

    @Override
    public void enterAssignStat(@NotNull GrammarParser.AssignStatContext ctx) {
        super.enterAssignStat(ctx);
    }

    @Override
    public void exitAssignStat(@NotNull GrammarParser.AssignStatContext ctx) {
        super.exitAssignStat(ctx);
    }

    @Override
    public void enterIfStat(@NotNull GrammarParser.IfStatContext ctx) {
        super.enterIfStat(ctx);
    }

    @Override
    public void exitIfStat(@NotNull GrammarParser.IfStatContext ctx) {
        super.exitIfStat(ctx);
    }

    @Override
    public void enterWhileStat(@NotNull GrammarParser.WhileStatContext ctx) {
        super.enterWhileStat(ctx);
    }

    @Override
    public void exitWhileStat(@NotNull GrammarParser.WhileStatContext ctx) {
        super.exitWhileStat(ctx);
    }

    @Override
    public void enterProcedureStat(@NotNull GrammarParser.ProcedureStatContext ctx) {
        super.enterProcedureStat(ctx);
    }

    @Override
    public void exitProcedureStat(@NotNull GrammarParser.ProcedureStatContext ctx) {
        super.exitProcedureStat(ctx);
    }

    @Override
    public void enterTarget(@NotNull GrammarParser.TargetContext ctx) {
        super.enterTarget(ctx);
    }

    @Override
    public void exitTarget(@NotNull GrammarParser.TargetContext ctx) {
        super.exitTarget(ctx);
    }

    @Override
    public void enterArraytype(@NotNull GrammarParser.ArraytypeContext ctx) {
        super.enterArraytype(ctx);
    }

    @Override
    public void exitArraytype(@NotNull GrammarParser.ArraytypeContext ctx) {
        super.exitArraytype(ctx);
    }

    @Override
    public void enterNoParamProcedure(@NotNull GrammarParser.NoParamProcedureContext ctx) {
        super.enterNoParamProcedure(ctx);
    }

    @Override
    public void exitNoParamProcedure(@NotNull GrammarParser.NoParamProcedureContext ctx) {
        super.exitNoParamProcedure(ctx);
    }

    @Override
    public void enterParamProcedure(@NotNull GrammarParser.ParamProcedureContext ctx) {
        super.enterParamProcedure(ctx);
    }

    @Override
    public void exitParamProcedure(@NotNull GrammarParser.ParamProcedureContext ctx) {
        super.exitParamProcedure(ctx);
    }

    @Override
    public void enterParExpr(@NotNull GrammarParser.ParExprContext ctx) {
        super.enterParExpr(ctx);
    }

    @Override
    public void exitParExpr(@NotNull GrammarParser.ParExprContext ctx) {
        super.exitParExpr(ctx);
    }

    @Override
    public void enterArrayExpr(@NotNull GrammarParser.ArrayExprContext ctx) {
        super.enterArrayExpr(ctx);
    }

    @Override
    public void exitArrayExpr(@NotNull GrammarParser.ArrayExprContext ctx) {
        super.exitArrayExpr(ctx);
    }

    @Override
    public void enterTimesDivideExpr(@NotNull GrammarParser.TimesDivideExprContext ctx) {
        super.enterTimesDivideExpr(ctx);
    }

    @Override
    public void exitTimesDivideExpr(@NotNull GrammarParser.TimesDivideExprContext ctx) {
        super.exitTimesDivideExpr(ctx);
        if (ctx.TIMES() != null) {
            numbers.put(ctx, numbers.get(ctx.expr(0)) * numbers.get(ctx.expr(1)));
        } else {
            numbers.put(ctx, numbers.get(ctx.expr(0)) / numbers.get(ctx.expr(1)));
        }
    }

    @Override
    public void enterPlusMinusExpr(@NotNull GrammarParser.PlusMinusExprContext ctx) {
        super.enterPlusMinusExpr(ctx);
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
    public void enterOrExpr(@NotNull GrammarParser.OrExprContext ctx) {
        super.enterOrExpr(ctx);
    }

    @Override
    public void exitOrExpr(@NotNull GrammarParser.OrExprContext ctx) {
        super.exitOrExpr(ctx);
        booleans.put(ctx, booleans.get(ctx.expr(0)) || booleans.get(ctx.expr(1)));
    }

    @Override
    public void enterMinusExpr(@NotNull GrammarParser.MinusExprContext ctx) {
        super.enterMinusExpr(ctx);
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
    public void exitConstExpr(@NotNull GrammarParser.ConstExprContext ctx) {
        super.exitConstExpr(ctx);
    }

    @Override
    public void enterIdExpr(@NotNull GrammarParser.IdExprContext ctx) {
        super.enterIdExpr(ctx);
    }

    @Override
    public void exitIdExpr(@NotNull GrammarParser.IdExprContext ctx) {
        super.exitIdExpr(ctx);
    }

    @Override
    public void enterAndExpr(@NotNull GrammarParser.AndExprContext ctx) {
        super.enterAndExpr(ctx);
    }

    @Override
    public void exitAndExpr(@NotNull GrammarParser.AndExprContext ctx) {
        super.exitAndExpr(ctx);
        booleans.put(ctx, booleans.get(ctx.expr(0)) && booleans.get(ctx.expr(1)));
        System.out.println("");
    }

    @Override
    public void enterCmpExpr(@NotNull GrammarParser.CmpExprContext ctx) {
        super.enterCmpExpr(ctx);

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
    }

    @Override
    public void enterType(@NotNull GrammarParser.TypeContext ctx) {
        super.enterType(ctx);
    }

    @Override
    public void exitType(@NotNull GrammarParser.TypeContext ctx) {
        super.exitType(ctx);
    }

    @Override
    public void enterEveryRule(@NotNull ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(@NotNull ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(@NotNull TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(@NotNull ErrorNode node) {
        super.visitErrorNode(node);
    }
}
