package typecheck;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.finalproject.antlr.GrammarLexer;
import pp.finalproject.antlr.GrammarParser;
import pp.finalproject.typecheck.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TypeCheckTest {

    @Test
    public void test() {
        //Normal ways to initialize a type
        assertEquals(typeCheckOneError("integer a = 0;"), "");
        assertEquals(typeCheckOneError("integer a = 5 * 10;"), "");
        assertEquals(typeCheckOneError("boolean a = true;"), "");
        assertEquals(typeCheckOneError("boolean a = false;"), "");
        assertEquals(typeCheckOneError("boolean a = true && false;"), "");
        assertEquals(typeCheckOneError("integer[] a = {1, 2, 3};"), "");
        assertEquals(typeCheckOneError("boolean[] a = {true, true, false};"), "");

        //Now show they can't be initialized otherwise
        assertEquals(typeCheckOneError("integer a = true;"), "pp.finalproject.typecheck.TypeException: (1, 0) incompatible types: BOOL cannot be converted to NUM");
        assertEquals(typeCheckOneError("boolean a = 5;"), "pp.finalproject.typecheck.TypeException: (1, 0) incompatible types: NUM cannot be converted to BOOL");
        assertEquals(typeCheckOneError("boolean[] a = {1, 2, 3};"), "pp.finalproject.typecheck.TypeException: (1, 0) incompatible types: NUM cannot be converted to BOOL");
        assertEquals(typeCheckOneError("integer[] a = {true, true, false};"), "pp.finalproject.typecheck.TypeException: (1, 0) incompatible types: BOOL cannot be converted to NUM");
        assertEquals(typeCheckOneError("integer[] a = {1, 2, true};"), "pp.finalproject.typecheck.TypeException: (1, 14) incompatible types: BOOL cannot be converted to NUM");
        assertEquals(typeCheckOneError("boolean[] a = {true, 3, false};"), "pp.finalproject.typecheck.TypeException: (1, 14) incompatible types: NUM cannot be converted to BOOL");

        //Test all mathematical operands
        assertEquals(typeCheckOneError("integer a = 3 + 5;"), "");
        assertEquals(typeCheckOneError("integer a = 3 - 5;"), "");
        assertEquals(typeCheckOneError("integer a = 3 * 5;"), "");
        assertEquals(typeCheckOneError("integer a = 3 / 5;"), "");

        //Now show they won't work when used otherwise
        assertEquals(typeCheckOneError("integer a = 3 + true;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator ADD\n" +
                " \tFirst operand: 3\n" +
                " \tSecond operand: true");
        assertEquals(typeCheckOneError("integer a = false - 5;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator SUB\n" +
                " \tFirst operand: false\n" +
                " \tSecond operand: 5");
        assertEquals(typeCheckOneError("integer a = 3 * true;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator MUL\n" +
                " \tFirst operand: 3\n" +
                " \tSecond operand: true");
        assertEquals(typeCheckOneError("integer a = true / 5;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator DIV\n" +
                " \tFirst operand: true\n" +
                " \tSecond operand: 5");

        //Test all compare operators
        assertEquals(typeCheckOneError("boolean a = true && false;"), "");
        assertEquals(typeCheckOneError("boolean a = true || false;"), "");
        assertEquals(typeCheckOneError("boolean a = true == false;"), "");
        assertEquals(typeCheckOneError("boolean a = 3 == 5;"), "");
        assertEquals(typeCheckOneError("boolean a = 3 < 5;"), "");
        assertEquals(typeCheckOneError("boolean a = 3 <= 5;"), "");
        assertEquals(typeCheckOneError("boolean a = 3 > 5;"), "");
        assertEquals(typeCheckOneError("boolean a = 3 >= 5;"), "");

        //And show they won't work otherwise...
        assertEquals(typeCheckOneError("boolean a = 3 && false;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator AND\n" +
                " \tFirst operand: 3\n" +
                " \tSecond operand: false");
        assertEquals(typeCheckOneError("boolean a = true || 1;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator OR\n" +
                " \tFirst operand: true\n" +
                " \tSecond operand: 1");
        assertEquals(typeCheckOneError("boolean a = true == 2;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator EQUAL\n" +
                " \tFirst operand: true\n" +
                " \tSecond operand: 2");
        assertEquals(typeCheckOneError("boolean a = false == 5;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator EQUAL\n" +
                " \tFirst operand: false\n" +
                " \tSecond operand: 5");
        assertEquals(typeCheckOneError("boolean a = 3 < true;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator LT\n" +
                " \tFirst operand: 3\n" +
                " \tSecond operand: true");
        assertEquals(typeCheckOneError("boolean a = 3 <= false;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator LTE\n" +
                " \tFirst operand: 3\n" +
                " \tSecond operand: false");
        assertEquals(typeCheckOneError("boolean a = true > 5;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator GT\n" +
                " \tFirst operand: true\n" +
                " \tSecond operand: 5");
        assertEquals(typeCheckOneError("boolean a = 3 >= false;"), "pp.finalproject.typecheck.OperandException: (1, 12) bad operand types for operator GTE\n" +
                " \tFirst operand: 3\n" +
                " \tSecond operand: false");

        //Test if assigning a variable to an incompatible type fails
        assertEquals(typeCheckOneError("integer a = 0; boolean b = a;"), "pp.finalproject.typecheck.TypeException: (1, 15) incompatible types: NUM cannot be converted to BOOL");

        //Control flow statements
        assertEquals(typeCheckOneError("if (true) {}"), "");
        assertEquals(typeCheckOneError("while (true) {}"), "");
        assertEquals(typeCheckOneError("if (3) {}"), "pp.finalproject.typecheck.TypeException: (1, 0) incompatible types: NUM cannot be converted to BOOL");
        assertEquals(typeCheckOneError("while (3) {}"), "pp.finalproject.typecheck.TypeException: (1, 0) incompatible types: NUM cannot be converted to BOOL");
    }

    private String typeCheckOneError(String input) {
        List<String> errors = typeCheck(input);
        if (errors.isEmpty()) {
            return "";
        } else if (errors.size() == 1) {
            return errors.get(0);
        } else {
            return "Error";
        }
    }

    private List<String> typeCheck(String input) {
        CharStream chars = new ANTLRInputStream(input);
        Lexer lexer = new GrammarLexer(chars);
        lexer.removeErrorListeners();

        TokenStream tokens = new CommonTokenStream(lexer);

        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.program();
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.check(tree);

        List<String> errors = new ArrayList<>();
        for (Exception e : typeChecker.getErrors()) {
            errors.add(e.toString());
        }
        return errors;
    }
}
