package org.roman.expression;

import org.roman.Const;

/**
 * TerminatedExpression to interpret the Roman Numerals which's decimal value is from 1 to 9 
 * @author stallman wang
 */
public class OneExpression extends Expression {

    @Override
    public String one() {
        return "I";
    }

    @Override
    public String four() {
        return "IV";
    }

    @Override
    public String five() {
        return "V";
    }

    @Override
    public String nine() {
        return "IX";
    }

    @Override
    public int multiplier() {
        return Const.ONE;
    }
}
