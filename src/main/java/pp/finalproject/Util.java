package pp.finalproject;

import pp.finalproject.model.Program;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Util {

    public static void saveProgram(Program program) {
        try {
            PrintWriter writer = new PrintWriter("../sprockell/src/test.hs", "UTF-8");
            writer.println("import Sprockell.System\n" +
                    "loopCount = 10\n" +
                    "\n" +
                    "prog :: [Instruction]\n" +
                    "prog = [\n");

            writer.println(program.toString());

            writer.println("       ]\n" +
                    "\n" +
                    "\n" +
                    "main = run 4 prog >> putChar '\\n'\n" +
                    "\n");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
