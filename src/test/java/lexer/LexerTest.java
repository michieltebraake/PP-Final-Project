package lexer;

import org.junit.Test;
import pp.finalproject.antlr.GrammarLexer;

import static pp.finalproject.antlr.GrammarLexer.*;


public class LexerTest {
    private static final LexerTester lt = new LexerTester(GrammarLexer.class);


    /*
    Generic test
    Shows accepted and rejected characters

    It doesn't make sense to test the lexer with .correct and .wrong extensively, as most tokens can be accepted as
    ids, as shown in these tests.
     */
    @Test
    public void genericTest() {

        // Set of accepted characters
        lt.correct("abcdefghijklmnopqrstuvw");
        lt.correct("ABCDEFGHIJKLMNOPQRSTUVW");
        lt.correct(",<>[]{}+=-()*");

        // Denied as single characters, however accepted in combination with other operators as shown in
        // comparatorAndOperatorTest().
        lt.wrong("|&!");

        // Flat out rejected characters
        lt.wrong(":.\"'/\\?~@#$^");

        // Generic...
        lt.correct("The lexer will accept pretty much all of these tokens as IDs, - + * / = >=");
        lt.wrong("It will fail to tokenize this though, since it contains a period.");
        lt.yields("The lexer will accept pretty much all of these tokens as IDs, - + * / = >=", ID, ID, ID, ID, ID,
                ID, ID, ID, ID, ID, ID, ID, COMMA, MINUS, PLUS, TIMES, DIVIDE, ASSIGN, GTE);
    }

    /*
    keywords
    must be lowercase, otherwise they are recognized as IDs
     */
    @Test
    public void testKeywords() {
        lt.yields("if IF iF If", IF, ID, ID, ID);
        lt.yields("while WHILE While WhIlE", WHILE, ID, ID, ID);
        lt.yields("shared SHARED Shared ShArEd", SHARED, ID, ID, ID);
    }

    /*
    types
    must be lowercase, otherwise that are recognized as IDs
     */
    @Test
    public void testTypes() {
        lt.yields("integer INTEGER Integer InTeGeR", INT, ID, ID, ID);
        lt.yields("boolean BOOLEAN Boolean BoOlEaN", BOOL, ID, ID, ID);
    }


    /*
    Comparators and operators
    Shows rejected operator combinations by either tokenizing as 2 different tokens, or flat out rejecting it.
    Shows that combined operators have higher precedence than singles
     */
    @Test
    public void testComparatorsAndOperators() {
        lt.wrong("|&");
        lt.wrong("&|");

        lt.yields("/=", DIVIDE, ASSIGN);
        lt.yields("=>", ASSIGN, GT);
        lt.yields("=<", ASSIGN, LT);

        lt.yields("== < <= > >= = || && ; (", EQUAL, LT, LTE, GT, GTE, ASSIGN, OR, AND, SEMI, LPAR);
        lt.yields(") { } [ ] + - * / ,", RPAR, LCURLY, RCURLY, LSQ, RSQ, PLUS, MINUS, TIMES, DIVIDE, COMMA);
        lt.yields("");
    }

    /*
    IDs and Values
    shows that Ids cannot start with a digit, as it will tokenize as NUM, ID.
    shows that the literal values of booleans must be lowercase, otherwise they are recognized as IDs.
     */
    @Test
    public void testIDsAndValues() {
        //shows that 1id tokenizes as NUM, ID. This will not be accepted by the parser.
        lt.yields("1id id id1 i1d", NUM, ID, ID, ID, ID);

        lt.yields("1 11 111 1111 11111", NUM, NUM, NUM, NUM, NUM);
        lt.yields("true TRUE True TrUe", TRUE, ID, ID, ID);
        lt.yields("false FALSE False FaLsE", FALSE, ID, ID, ID);
    }
}
