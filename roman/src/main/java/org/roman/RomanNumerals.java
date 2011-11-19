package org.roman;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.roman.expression.Expression;
import org.roman.expression.HundredExpression;
import org.roman.expression.OneExpression;
import org.roman.expression.TenExpression;
import org.roman.expression.ThousandExpression;
import org.roman.rule.Rule;

/**
 * Entry point of Roman Numerals
 * The full command-line invocation for the the program:
 * > mvn package
 * > java -cp target/roman-1.0-SNAPSHOT.jar org.roman.RomanNumerals <numeral to be converted>
 *
 * e.g.
 *
 * Following is to convert decimals 321 to Roman Numeral
 *
 * > mvn package
 * > java -cp target/roman-1.0-SNAPSHOT.jar org.roman.RomanNumerals 321 
 *
 * Following is to convert Roman Numeral MXIV to Decimals
 *
 * > mvn package
 * > java -cp target/roman-1.0-SNAPSHOT.jar org.roman.RomanNumerals MXIV
 * 
 * @author stallman wang
 */
public class RomanNumerals {

    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println(" The usage will be : java RomanNumerals <numeral to be converted>");
        }

        String value;
        int decimalValue =0;
        boolean isRomanBase = true;        
       
        value = args[0];

        try {            
            decimalValue = Integer.parseInt(value);
            isRomanBase = false;            
        } catch (NumberFormatException e) {            
            isRomanBase = true;
        }

       
        if (isRomanBase) {
            System.out.print("  Convert Romans Numeral to Decimals :  ");
            System.out.println(value);
            System.out.println("Result: "+RomanNumerals.asDecimals(value));
        } else {
            System.out.println("  Convert Decimals to Romans Numeral : ");
            System.out.println(decimalValue);
            System.out.println("Result: "+RomanNumerals.fromDecimals(decimalValue));
        }
    }

    /**
     * Convert the Roman Numeral to Decimals.
     * Accept both upper case and lower case letter
     * @param romanValue
     * @return
     */
    public static int asDecimals(String romanValue) {
        //Trim the space before interpret the Roman Numeral
        //And accept both upper case and lower case letter
        Context ctx = new Context(romanValue.trim().toUpperCase());
        interpret(ctx);
        return ctx.getDecimals();
    }

    /**
     * Convert the Roman Numeral to Decimals.
     * Accept both upper case and lower case letter
     * @param romanValue
     * @param rule The rule implementation  to convert the Numeral
     * @return
     */
    public static int asDecimals(String romanValue, Rule rule) {
        //Trim the space before interpret the Roman Numeral
        //And accept both upper case and lower case letter
        Context ctx = new Context(romanValue.trim().toUpperCase(), rule);
        interpret(ctx);
        return ctx.getDecimals();
    }

    /**
     * Convert the Decimals to Roman Numeral .
     * @param decimalValue
     * @return
     */
    public static String fromDecimals(int decimalValue) {

        Context ctx = new Context(decimalValue);
        interpret(ctx);
        return ctx.getRomans();
    }

    /**
     * Convert the Decimals to Roman Numeral .
     * @param decimalValue
     * @param rule The rule implementation  to convert the Numeral
     * @return
     */
    public static String fromDecimals(int decimalValue, Rule rule) {

        Context ctx = new Context(decimalValue, rule);
        interpret(ctx);
        return ctx.getRomans();
    }

    private static void interpret(Context ctx) {

        // Build the expression tree.
        List<Expression> expressions = new ArrayList<Expression>();
        expressions.add(new ThousandExpression());
        expressions.add(new HundredExpression());
        expressions.add(new TenExpression());
        expressions.add(new OneExpression());

        // Interpret
        for (Iterator<Expression> it = expressions.iterator(); it.hasNext();) {
            Expression expr = it.next();
            expr.interpret(ctx);
        }

        //If the scenario is to convert Roman Numeral to Decimals ( Roman Numeral Based )
        //then suppose all the Romans value been converted , otherwise there is illegal character in the Roman Numeral Representation
        if (ctx.isRomansBase() && !ctx.isRomansEmpty()) {
            throw new NumberFormatException(" Illegal Character \'" + ctx.getRomans().substring(0, 1) + "\' found in Roman Numerial! ");
        }


    }
}
