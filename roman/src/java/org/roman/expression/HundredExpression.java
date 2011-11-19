package org.roman.expression;

import org.roman.Const;

/**
 * TerminatedExpression to interpret the Roman Numerals which's decimal value is from 100 to 900 
 * @author stallman wang
 */
public class HundredExpression extends Expression {

    @Override
    public String one() {
        return "C";
    }

    @Override
    public String four() {
        return "CD";
    }

    @Override
    public String five() {
        return "D";
    }

    @Override
    public String nine() {
        return "CM";
    }

    @Override
    public int multiplier() {
        return Const.HUNDRED;
    }
}
