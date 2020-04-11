package com.alihooman;

/**
 * Parse incoming arguments from command line.
 */
public class ParseArgs {

    /**
     * Determines if program input exists and is of a valid form.
     * @param args The array of arguments passed from the command line.
     */
    static void isArgsValid(String[] args) {
        if(args.length <= 0) {
            throw new IllegalArgumentException("Enter a string of numbers to be sorted.");
        }

        if(args.length > 1) {
            throw new IllegalArgumentException("Enter no more than one string of numbers to be sorted.");
        }

        if(args[0].isEmpty()) {
            throw new IllegalArgumentException("String must contain numbers separated by spaces.");
        }

        if(stringHasNonIntegers(args[0])) {
            throw new IllegalArgumentException("String must contain only space separated numbers.");
        }
    }

    /**
     * Checks if a string has any non integer characters.
     * @param string The string to be checked for non digit characters.
     * @return True if non digit characters are found.
     */
    private static boolean stringHasNonIntegers(String string) {
        boolean hasNonIntegers = false;
        for(String number : string.split(" ")) {
            if(number.matches("[\\+-]{0,1}\\d+(\\.\\d+){0,1}")) {
            } else {
                hasNonIntegers = true;
            }
        }
        return hasNonIntegers;
    }

}
