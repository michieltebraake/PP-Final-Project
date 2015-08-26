package source;

import org.junit.Test;
import pp.finalproject.Compiler;
import pp.finalproject.antlr.SprockelBuilder;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class SourcesTester {
    /*
    Base directory that locates the source files
     */
    public static final String BASE = "src\\test\\test-source";


    @Test
    public void testArrayReverse() {
        File src = new File(BASE + "\\programs\\array-reverse");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        int[] chars = {1, 2, 3, 4, 4, 3, 2, 1};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testBanking() {
        File src = new File(BASE + "\\programs\\banking");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 3);
        String result = run(hs);
        int[] chars = {60};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testPetersons() {
        File src = new File(BASE + "\\programs\\petersons");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 2);
        String result = run(hs);
        int[] chars = {40};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testPrintAlphabet() {
        File src = new File(BASE + "\\programs\\print-alphabet");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertEquals(testable(chars), result);
    }

    @Test
    public void testArrayAccess() {
        File src = new File(BASE + "\\succeeds\\array-access");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        int[] chars = {2, 2, 3, 4, 4, 6, 1, 0};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testArrayDecleration() {
        File src = new File(BASE + "\\succeeds\\array-decleration");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        int[] chars = {0, 1, 5, 50};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testDecleration() {
        File src = new File(BASE + "\\succeeds\\decleration");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        int[] chars = {1, 62, 58, 120, 30, 5, 6, 1, 0, 1, 1};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testBooleanIf() {
        File src = new File(BASE + "\\succeeds\\boolean-if");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        int[] chars = {88, 88, 88, 88, 88};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testNestedDecleration() {
        File src = new File(BASE + "\\succeeds\\nested-decleration");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        int[] chars = {6, 20, 1, 0};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testOutput() {
        File src = new File(BASE + "\\succeeds\\output");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        int[] chars = {44, 88, 1, 0};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testVariableAccess() {
        File src = new File(BASE + "\\succeeds\\variable-access");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        int[] chars = {6, 5, 1, 0, 4, 1};
        assertEquals(testable(chars), result);
    }

    @Test
    public void testWhile() {
        File src = new File(BASE + "\\succeeds\\while");
        System.out.println("Running test on: " + src.getName());
        File hs = compile(src, 1);
        String result = run(hs);
        String chars = "ABCDEABCDEABCDE";
        assertEquals(testable(chars), result);
    }


    /**
     * Compiles the files as the Compiler.java would, returns the haskell source file
     *
     * @param source    source file
     * @param instances how many sprockell instances should be run
     * @return haskell source file
     */
    private File compile(File source, int instances) {
        SprockelBuilder builder = new SprockelBuilder();
        return builder.build(source, Compiler.BuildType.TEST, instances);
    }

    /**
     * Runs the compiles source file, due to the files being in Test BuildType, we added flags to capture the all the
     * out() statements
     *
     * @param hs haskell source file
     * @return the out statements including the testflags.
     */
    private String run(File hs) {
        Runtime runtime = Runtime.getRuntime();
        try {
            String cmd = String.format("ghci -i ../sprockell/src/%s " +
                    "../sprockell/src/Sprockell/System.hs " +
                    "../sprockell/src/Sprockell/Components.hs " +
                    "../sprockell/src/Sprockell/Sprockell.hs " +
                    "../sprockell/src/Sprockell/TypesEtc.hs", hs.getName());
            Process process = runtime.exec(cmd);

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            OutputStreamWriter out = new OutputStreamWriter(process.getOutputStream());

            String line;
            while (!(line = input.readLine()).equals("Ok, modules loaded: Sprockell.System, Sprockell.Components, Sprockell.TypesEtc, Sprockell.Sprockell, Main.")) {
                //spin till everything is loaded before issueing the 'main' command to launch the program.
            }
            out.write("main");
            out.flush();
            out.close();

            StringBuilder result = new StringBuilder();
            boolean grabbing = false;
            while (!(line = input.readLine()).contains("Leaving GHCi.")) {
                if (grabbing || line.contains("###BEGIN###")) {
                    grabbing = true;
                    result.append(line);
                }
                if (line.contains("###END###")) {
                    grabbing = false;
                }
            }

            input.close();
            process.destroy();

            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Adds the test flags to the test string
     *
     * @param string The expected test string
     * @return test string including test flags
     */
    private String testable(String string) {
        return "###BEGIN###" + string + "###END###";
    }

    /**
     * Converts the integers and adds the test flags to a teststring
     *
     * @param ints array that contains the out()-statement's predicted answers
     * @return test string including test flags
     */
    private String testable(int[] ints) {
        return testable(convert(ints));
    }

    /**
     * Converts an array of integers to their casted char variants.
     *
     * @param ints array that contains the out()-statement's predicted answers
     * @return test string excluding test flags
     */
    private String convert(int[] ints) {
        StringBuilder result = new StringBuilder();
        for (int i : ints) {
            result.append((char) i);
        }
        return result.toString();
    }
}