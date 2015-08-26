package pp.finalproject;

import pp.finalproject.antlr.SprockelBuilder;

import java.io.File;

public class Compiler {

    public static final String SOURCE = "src\\test\\test-source\\programs\\petersons";
    public static final BuildType BUILD_TYPE = BuildType.DEBUG;
    public static final int SPROCKELL_INSTANCES = 2;

    /**
     * Main method to build and print the CFG of a simple Java program.
     */
    public static void main(String[] args) {
        File file = new File(SOURCE);
        System.out.println(String.format("Compiling file: %s, Mode: %s, Instances: %s", file.getName(), BUILD_TYPE
                .string(), SPROCKELL_INSTANCES));
        new SprockelBuilder().build(file, BUILD_TYPE, SPROCKELL_INSTANCES);
        System.out.println("Done.");
    }

    public enum BuildType{
        NORMAL("Normal"),
        DEBUG("Debug"),
        TEST("Test");

        private final String string;
        BuildType(String string) {
            this.string = string;
        }
        private String string() { return string; }

    }
}
