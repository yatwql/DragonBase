/*
 * The rule to convert Decimals to Roman Numerial
 */
package org.roman.rule;

import org.roman.Const;
import org.roman.Context;
import org.roman.expression.Expression;

/**
 *
 * @author stallman wang
 */
public class DecimalsToRomansRuleImpl implements Rule {

    public void execute(Context ctx, Expression expr) {
        int decimalValue = ctx.getDecimals(); //It represents the part of the integer value that need to be converted to Romans
        String romans = ctx.getRomans(); //It represents the Roman Numeral

        if (decimalValue <= Const.ZERO && (ctx.isRomansEmpty())) {
            throw new NumberFormatException(" The value of Roman Numeral must be positive.");
        }

        if (decimalValue > Const.ROMANS_UPPER_LIMIT) {
            throw new NumberFormatException(" The value of Roman Numeral must be " + Const.ROMANS_UPPER_LIMIT + " or less.");
        }

        int multiplier = expr.multiplier();

        if (decimalValue < multiplier) {
            return;
        }

        int baseValue;

        //The following 2 arrays will be used to constructed the Roman Numeral Representation of the number
        int numbers[] = {Const.NINE * multiplier, Const.FIVE * multiplier, Const.FOUR * multiplier, Const.ONE * multiplier};
        String symbols[] = {expr.nine(), expr.five(), expr.four(), expr.one()};

        //loop from the biggest value to the smallest one, subtracting the decimal value and adding the Roman Numeral

        if (multiplier == Const.THOUSAND) {
            //The biggest Roman Numeral the program support is about 3999
            //Don't need to support the symbol for 4,5 and 9 when multiplier is 1000
            baseValue = multiplier;
            while (decimalValue >= baseValue) {
                //Subtract value
                romans += expr.one();
                //Add Roman equivalent.
                decimalValue = decimalValue - baseValue;
            }

        } else {
            //loop from the biggest value to the smallest one, subtracting the decimal value and adding the Roman  Numeral
            for (int index = 0; index < numbers.length; index++) {
                baseValue = numbers[index];
                while (decimalValue >= baseValue) {
                    //Subtract value
                    decimalValue = decimalValue - baseValue;
                    //Add Roman equivalent.
                    romans += symbols[index];
                }
            }
        }

        ctx.setDecimals(decimalValue);
        ctx.setRomans(romans);
    }

     public boolean isRomansBase(){
        return false;
    }
}
