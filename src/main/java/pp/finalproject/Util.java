package pp.finalproject;

import pp.finalproject.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Util {

    /**
     * Writes a program to a haskell source file
     *
     * @param program   The program to be written
     * @param filename  Filename of the to be generated haskell source
     * @param instances Ammount of sprockell instances should be spawned
     * @param buildType Determines if and the type of debug statements that should be added
     * @return haskell source file
     */
    public static File saveProgram(Program program, String filename, int instances, Compiler.BuildType buildType) {
        try {
            String location = "../sprockell/src/" + filename + ".hs";
            PrintWriter writer = new PrintWriter(location, "UTF-8");
            //writes header
            writer.println("{-# LANGUAGE RecordWildCards #-}\n" +
                    "import Sprockell.System\n" +
                    "\n" +
                    "prog :: [Instruction]\n" +
                    "prog = [\n");

            //writes instructions
            writer.println(program.toString());

            //writes footer
            if (buildType.equals(Compiler.BuildType.DEBUG)) {
                writer.println("        ]\n" +
                        "\n" +
                        "main :: IO()\n" +
                        "main = do\n" +
                        "  _ <- runDebug debug " + instances + " prog\n" +
                        "  return ()\n" +
                        "\n" +
                        "\n" +
                        "debug :: SystemState -> IO()\n" +
                        "debug state = printregs $ map (getReg state) [SPID, PC, SP, RegA, RegB, RegC, RegD, RegE]\n" +
                        "\n" +
                        "printregs :: [String] -> IO()\n" +
                        "printregs (\"\":xs) = return()\n" +
                        "printregs [spid, pc, sp, a, b, c, d, e] = do\n" +
                        "  putStr \"\\n\"\n" +
                        "  putStr $ \"SPID | \" ++ spid ++ \"\\n\"\n" +
                        "  putStr $ \"PC   | \" ++ pc ++ \"\\n\"\n" +
                        "  putStr $ \"SP   | \" ++ sp ++ \"\\n\"\n" +
                        "  putStr $ \"RegA | \" ++ a ++ \"\\n\"\n" +
                        "  putStr $ \"RegB | \" ++ b ++ \"\\n\"\n" +
                        "  putStr $ \"RegC | \" ++ c ++ \"\\n\"\n" +
                        "  putStr $ \"RegD | \" ++ d ++ \"\\n\"\n" +
                        "  putStr $ \"RegE | \" ++ e ++ \"\\n\"\n" +
                        "  putStr \"===================\\n\"\n" +
                        "  return()\n" +
                        "printregs _ = return ()" +
                        "\n" +
                        "getReg :: SystemState -> Reg -> String\n" +
                        "getReg SysState{..} reg = concatMap printrega sprs\n" +
                        "  where\n" +
                        "    printrega SprState{..}\n" +
                        "      | instrs!pc == Nop = show regvalue\n" +
                        "      | otherwise = \"\"\n" +
                        "        where\n" +
                        "          regvalue = regbank ! reg\n" +
                        "          pc = regbank ! PC");
            } else if (buildType.equals(Compiler.BuildType.NORMAL)) {
                writer.println("        ]\n" +
                        "\n" +
                        "main :: IO()\n" +
                        "main = do\n" +
                        "  _ <- run " + instances + " prog\n" +
                        "  return ()\n" +
                        "\n");
            } else {
                writer.println("        ]\n" +
                        "\n" +
                        "main :: IO()\n" +
                        "main = do\n" +
                        "  putStr \"###BEGIN###\"\n" +
                        "  _ <- run " + instances + " prog\n" +
                        "  putStr \"###END###\\n\"\n" +
                        "  return ()\n" +
                        "\n");
            }

            writer.close();

            return new File(location);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Adds special debug output to the program:
     * adds instructions to load the first 4 local variables and 1 shared variable in the registers A-E
     * Adds a Nop instruction to output the registers at the end of the program
     *
     * @param program source program excluding the debug instructions
     * @param memory  program memory holding the addresses of the variables
     */
    public static void addDebugOutput(Program program, HashMap<String, MemAddr> memory) {
        int i = 1;

        List<MemAddr> addresses = new ArrayList<>(memory.values());
        Comparator<MemAddr> comparator = new Comparator<MemAddr>() {
            public int compare(MemAddr c1, MemAddr c2) {
                return c1.getAddress() - c2.getAddress(); // use your logic
            }
        };

        Collections.sort(addresses, comparator);
        for (MemAddr variable : addresses) {
            Reg reg = new Reg("Reg" + Character.toString((char) (64 + i)));
            i++;
            Op result = new Op(OpCode.LOAD, variable, reg);

            program.addOp(result);

            if (i == 5)
                break;
        }

        program.addOp(new Op(OpCode.READ, new MemAddr(1)));
        program.addOp(new Op(OpCode.RECEIVE, new Reg("RegE")));
        program.addOp(new Op(OpCode.NOP));
        program.addOp(new Op(OpCode.ENDPROG));

    }
}
