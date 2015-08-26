package pp.finalproject;

import pp.finalproject.antlr.SprockelBuilder;

import java.io.File;

public class Compiler {

    /**
     * file path to the source file
     */
    public static final String SOURCE = "src\\test\\test-source\\programs\\petersons";
    /**
     * Build type, please refer to the different types at the bottom of this file.
     */
    public static final BuildType BUILD_TYPE = BuildType.DEBUG;
    /**
     * Specify how many sprockell instances should be spawned for this particular source code.
     * This is also changeable after compilation in the haskell source file.
     */
    public static final int SPROCKELL_INSTANCES = 2;

    /**
     * Main method to compile and a program.
     * Note: removed the option to pass source through arguments, please use to constants in this file to change the
     * compilation options.
     * <p/>
     * The haskell source file is saved to ../sprockell/src. Relative to this java project should the sprockell
     * source be located.
     */
    public static void main(String[] args) {
        File file = new File(SOURCE);
        System.out.println(String.format("Compiling file: %s, Mode: %s, Instances: %s", file.getName(), BUILD_TYPE
                .string(), SPROCKELL_INSTANCES));
        new SprockelBuilder().build(file, BUILD_TYPE, SPROCKELL_INSTANCES);
        System.out.println("Done.");
    }

    public enum BuildType {
        //No debug output, only generates the source code.
        NORMAL("Normal"),
        //Adds debug output. Automatically loads first 4 variables and 1 shared variables into the registers, and
        // displays these at the end of execution.
        DEBUG("Debug"),
        //Please do not use, this type is used for automated testing.
        TEST("Test");

        private final String string;

        BuildType(String string) {
            this.string = string;
        }

        private String string() {
            return string;
        }

    }
}
