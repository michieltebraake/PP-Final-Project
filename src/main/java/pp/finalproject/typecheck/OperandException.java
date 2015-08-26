package pp.finalproject.typecheck;

import pp.finalproject.antlr.GrammarParser;
import pp.finalproject.model.Operator;

public class OperandException extends Exception {


    public OperandException (Operator.OperatorType operator, GrammarParser.ExprContext expr, GrammarParser.ExprContext ctx) {
        super(String.format("(%s, %s) bad operand type %s for operator %s", expr.getStart().getLine(), expr.getStart().getCharPositionInLine(), ctx.getText(), operator));
        System.out.println("");
    }

    public OperandException (Operator.OperatorType operator, GrammarParser.ExprContext expr, GrammarParser.ExprContext ctx1, GrammarParser.ExprContext ctx2) {
        super(String.format("(%s, %s) bad operand types for operator %s\n \tFirst operand: %s\n \tSecond operand: %s", expr.getStart().getLine(), expr.getStart().getCharPositionInLine(), operator,
                ctx1.getText(), ctx2.getText()));
    }
}
