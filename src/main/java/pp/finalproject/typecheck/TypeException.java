package pp.finalproject.typecheck;

import pp.finalproject.antlr.GrammarParser;
import pp.finalproject.model.Operand;

public class TypeException extends Exception {

    /*
     * Custom error messages that display the line and collumn of the type error.
     * Also displays the type it was given and what it expected.
     */
    public TypeException(GrammarParser.ExprContext expr, Operand.Type expected, Operand.Type actual) {
        super(String.format("(%s, %s) incompatible types: %s cannot be converted to %s", expr.getStart().getLine(), expr.getStart().getCharPositionInLine(), actual, expected));
    }

    public TypeException(GrammarParser.StatContext stat, Operand.Type expected, Operand.Type actual) {
        super(String.format("(%s, %s) incompatible types: %s cannot be converted to %s", stat.getStart().getLine(), stat.getStart().getCharPositionInLine(), actual, expected));
    }

    public TypeException(int line, int column, Operand.Type expected, Operand.Type actual) {
        super(String.format("(%s, %s) incompatible types: %s cannot be converted to %s", line, column, actual, expected));
    }
}
