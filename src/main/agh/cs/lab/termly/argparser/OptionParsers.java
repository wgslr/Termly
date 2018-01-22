package agh.cs.lab.termly.argparser;

import agh.cs.actparser.ElementKind;
import agh.cs.actparser.Identifier;
import agh.cs.actparser.Range;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
