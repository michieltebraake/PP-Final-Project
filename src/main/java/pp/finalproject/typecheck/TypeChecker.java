package pp.finalproject.typecheck;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.finalproject.GrammarBaseListener;
import pp.finalproject.GrammarParser;
import pp.finalproject.model.Operand;
import pp.finalproject.model.Operator;

import java.util.ArrayList;
import java.util.List;

public class TypeChecker extends GrammarBaseListener {
    private ParseTreeProperty<Operand.Type> operands = new ParseTreeProperty<>();
    private ParseTreeProperty<String> variables = new ParseTreeProperty<>();

    private List<Exception> errors = new ArrayList<>();

    public void check(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);

        System.out.println("Found errors:");
        for (Exception error : errors) {
            System.out.println(error);
        }
    }

    @Override
    public void exitProgram(@NotNull GrammarParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    @Override
    public void exitDeclAssignStat(@NotNull GrammarParser.DeclAssignStatContext ctx) {
        super.exitDeclAssignStat(ctx);
    }

    @Override
    public void exitDeclStat(@NotNull GrammarParser.DeclStatContext ctx) {
        super.exitDeclStat(ctx);
    }

    @Override
    public void exitAssignStat(@NotNull GrammarParser.AssignStatContext ctx) {
        super.exitAssignStat(ctx);
    }

    @Override
    public void exitIfStat(@NotNull GrammarParser.IfStatContext ctx) {
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
    public void exitSynchronizedStat(@NotNull GrammarParser.SynchronizedStatContext ctx) {
        super.exitSynchronizedStat(ctx);
    }

    @Override
    public void exitArrayAssignStat(@NotNull GrammarParser.ArrayAssignStatContext ctx) {
        super.exitArrayAssignStat(ctx);
    }

    @Override
    public void exitIfcompare(@NotNull GrammarParser.IfcompareContext ctx) {
        super.exitIfcompare(ctx);
    }

    @Override
    public void exitIfbody(@NotNull GrammarParser.IfbodyContext ctx) {
        super.exitIfbody(ctx);
    }

    @Override
    public void exitWhilecompare(@NotNull GrammarParser.WhilecompareContext ctx) {
        super.exitWhilecompare(ctx);
    }

    @Override
    public void exitWhilebody(@NotNull GrammarParser.WhilebodyContext ctx) {
        super.exitWhilebody(ctx);
    }

    @Override
    public void exitSynchronizedbody(@NotNull GrammarParser.SynchronizedbodyContext ctx) {
        super.exitSynchronizedbody(ctx);
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
        if (operands.get(ctx.expr(0)) != Operand.Type.NUM || operands.get(ctx.expr(1)) != Operand.Type.NUM) {
            if (ctx.TIMES() != null) {
                errors.add(new OperandException(Operator.OperatorType.MUL, ctx, ctx.expr(0), ctx.expr(1)));
            } else {
                errors.add(new OperandException(Operator.OperatorType.DIV, ctx, ctx.expr(0), ctx.expr(1)));
            }
        }
        operands.put(ctx, Operand.Type.NUM);
        super.exitTimesDivideExpr(ctx);
    }

    @Override
    public void exitPlusMinusExpr(@NotNull GrammarParser.PlusMinusExprContext ctx) {
        if (operands.get(ctx.expr(0)) != Operand.Type.NUM || operands.get(ctx.expr(1)) != Operand.Type.NUM) {
            if (ctx.PLUS() != null) {
                errors.add(new OperandException(Operator.OperatorType.ADD, ctx, ctx.expr(0), ctx.expr(1)));
            } else {
                errors.add(new OperandException(Operator.OperatorType.SUB, ctx, ctx.expr(0), ctx.expr(1)));
            }
        }
        operands.put(ctx, Operand.Type.NUM);
        super.exitPlusMinusExpr(ctx);
    }

    @Override
    public void exitOrExpr(@NotNull GrammarParser.OrExprContext ctx) {
        if (operands.get(ctx.expr(0)) != Operand.Type.BOOL || operands.get(ctx.expr(1)) != Operand.Type.BOOL) {
            errors.add(new OperandException(Operator.OperatorType.OR, ctx, ctx.expr(0), ctx.expr(1)));
        }
        operands.put(ctx, Operand.Type.BOOL);
        super.exitOrExpr(ctx);
    }

    @Override
    public void exitMinusExpr(@NotNull GrammarParser.MinusExprContext ctx) {
        if (operands.get(ctx.expr()) != Operand.Type.NUM) {
            errors.add(new OperandException(Operator.OperatorType.SUB, ctx, ctx.expr()));
        }
        operands.put(ctx, Operand.Type.NUM);
        super.exitMinusExpr(ctx);
    }

    @Override
    public void exitSpidExpr(@NotNull GrammarParser.SpidExprContext ctx) {
        operands.put(ctx, Operand.Type.NUM);
        super.exitSpidExpr(ctx);
    }

    @Override
    public void exitArrayAssignExpr(@NotNull GrammarParser.ArrayAssignExprContext ctx) {
        super.exitArrayAssignExpr(ctx);
    }

    @Override
    public void exitConstExpr(@NotNull GrammarParser.ConstExprContext ctx) {
        if (ctx.NUM() != null) {
            operands.put(ctx, Operand.Type.NUM);
        } else {
            operands.put(ctx, Operand.Type.BOOL);
        }
        super.exitConstExpr(ctx);
    }

    @Override
    public void exitIdExpr(@NotNull GrammarParser.IdExprContext ctx) {
        super.exitIdExpr(ctx);
    }

    @Override
    public void exitCmpExpr(@NotNull GrammarParser.CmpExprContext ctx) {
        //Check the operators that only allow nums
        if (ctx.LT() != null || ctx.GT() != null || ctx.LTE() != null || ctx.GTE() != null) {
            if (operands.get(ctx.expr(0)) != Operand.Type.NUM || operands.get(ctx.expr(1)) != Operand.Type.NUM) {
                if (ctx.LT() != null) {
                    errors.add(new OperandException(Operator.OperatorType.LT, ctx, ctx.expr(0), ctx.expr(1)));
                } else if (ctx.GT() != null) {
                    errors.add(new OperandException(Operator.OperatorType.GT, ctx, ctx.expr(0), ctx.expr(1)));
                } else if (ctx.LTE() != null) {
                    errors.add(new OperandException(Operator.OperatorType.LTE, ctx, ctx.expr(0), ctx.expr(1)));
                } else if (ctx.GTE() != null) {
                    errors.add(new OperandException(Operator.OperatorType.GTE, ctx, ctx.expr(0), ctx.expr(1)));
                }
            }
        } else {
            //Then check the operators for which operands need to have the same type
            if (operands.get(ctx.expr(0)) != operands.get(ctx.expr(1))) {
                if (ctx.EQUAL() != null) {
                    errors.add(new OperandException(Operator.OperatorType.EQUAL, ctx, ctx.expr(0), ctx.expr(1)));
                } else if (ctx.NOTEQUAL() != null) {
                    errors.add(new OperandException(Operator.OperatorType.NEQ, ctx, ctx.expr(0), ctx.expr(1)));
                }
            }
        }
        operands.put(ctx, Operand.Type.BOOL);
        super.exitCmpExpr(ctx);
    }

    @Override
    public void exitAndExpr(@NotNull GrammarParser.AndExprContext ctx) {
        if (operands.get(ctx.expr(0)) != Operand.Type.BOOL || operands.get(ctx.expr(1)) != Operand.Type.BOOL) {
            errors.add(new OperandException(Operator.OperatorType.AND, ctx, ctx.expr(0), ctx.expr(1)));
        }
        operands.put(ctx, Operand.Type.BOOL);
        super.exitAndExpr(ctx);
    }

    @Override
    public void exitType(@NotNull GrammarParser.TypeContext ctx) {
        super.exitType(ctx);
    }
}
