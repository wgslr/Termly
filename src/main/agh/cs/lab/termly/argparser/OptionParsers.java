package agh.cs.lab.termly.argparser;

import java.util.function.Function;

/**
 * This class contains several functions providing parsers for command line
 * options.
 */
public class OptionParsers {
    static public Function<String, String> getBooleanParser() {
        return null;
    }

    static public Function<String, String> getStringParser() {
        return Function.identity();
    }

    static public Function<String, Double> getDoubleParser() {
        return Double::parseDouble;
    }
}
