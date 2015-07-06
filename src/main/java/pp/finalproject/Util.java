package pp.finalproject;

import pp.finalproject.model.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Util {

    public static void saveProgram(Program program) {
        try {
            PrintWriter writer = new PrintWriter("../sprockell/src/test.hs", "UTF-8");
            writer.println("{-# LANGUAGE RecordWildCards #-}\n" +
                    "import Sprockell.System\n" +
                    "\n" +
                    "prog :: [Instruction]\n" +
                    "prog = [\n");

            writer.println(program.toString());

            writer.println("        ]\n" +
                    "\n" +
                    "main :: IO()\n" +
                    "main = do\n" +
                    "  _ <- runDebug debug 1 prog\n" +
                    "  return ()\n" +
                    "\n" +
                    "\n" +
                    "debug :: SystemState -> IO()\n" +
                    "debug state = printregs $ map (getReg state) [SPID, PC, SP, RegA, RegB, RegC, RegD, RegE]\n" +
                    "\n" +
                    "printregs :: [String] -> IO()\n" +
                    "printregs (\"\":xs) = return()\n" +
                    "printregs [spid, pc, sp, a, b, c, d, e] = do\n" +
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
                    "printregs _ = do\n" +
                    "  putStr \"kek \\n\"\n" +
                    "  return()\n" +
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
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

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
