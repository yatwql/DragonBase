package org.roman.expression;

import org.roman.Const;

/**
 * TerminatedExpression to interpret the Roman Numerals which's decimal value is from 10 to 90 
 * @author stallman wang
 */
public class TenExpression extends Expression {

    @Override
    public String one() {
        return "X";
    }

    @Override
    public String four() {
        return "XL";
    }

    @Override
    public String five() {
        return "L";
    }

    @Override
    public String nine() {
        return "XC";
    }

    @Override
    public int multiplier() {
        return Const.TEN;
    }
}
